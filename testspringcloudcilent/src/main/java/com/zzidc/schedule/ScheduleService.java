package com.zzidc.schedule;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zzidc.dao.EurekaServiceInstanceDao;
import com.zzidc.dao.EurekaServiceProviderDao;
import com.zzidc.entity.EurekaServiceInstance;
import com.zzidc.entity.EurekaServiceProvider;
import com.zzidc.util.GsonUtil;
import com.zzidc.util.ObjectUtils;

import lombok.extern.slf4j.Slf4j;



@Component
@Slf4j
public class ScheduleService {
	@Autowired
	private DiscoveryClient client;
	
	@Autowired
	private EurekaServiceProviderDao serviceDao;
	
	@Autowired
	private EurekaServiceInstanceDao instanceDao;
	/**
	 * 
	 * [定时任务去注册中心获取已注册服务，并更新到数据库中]
	 *
	 * @author ZhangBinbin <br>
	 * @date   2018年9月12日  下午3:21:28 <br> <br>
	 */
	@Scheduled(fixedDelay=60000)
	@Transactional
	public void refreshServiceInfo() {
		log.debug("启动定时任务【获取已注册服务，并更新到数据库中】,执行方法refreshServiceInfo()");
		List<String> services = client.getServices();
		if(ObjectUtils.isEmpty(services)) {
			log.debug("定时任务【获取已注册服务，并更新到数据库中】,执行方法refreshServiceInfo()执行完毕，未发现已注册服务");
			return;
		}
		//用于记录从注册中心获取到的所有实例名称
		final List<EurekaServiceInstance> serverdInstances = new ArrayList<>();
		for (String serviceName : services) {
			//从数据库查看有没有这个service，没有就插进去
			EurekaServiceProvider serviceProvider = serviceDao.findByServiceName(serviceName);
			if(serviceProvider == null) {
				serviceProvider = new EurekaServiceProvider(serviceName, null);
				serviceProvider = serviceDao.save(serviceProvider);
			}
			List<ServiceInstance> instances = client.getInstances(serviceName);
			//把instances转化成json能获取到很多数据
			String jsonStr = GsonUtil.gsonString(instances);
			//再把json字符串转成listmap
			List<Map<String,Object>> list = GsonUtil.gsonToListMaps(jsonStr);
			for (Map<String,Object> map : list) {
				saveOrUpdateInstance(serviceProvider, map,serverdInstances);
			}
		}
		services = null;
		//从数据库获取所有up的实例列表并与注册中心当前的实例列表对比，如果注册中心不存在而数据库中存在，则设置该实例为down状态
		List<EurekaServiceInstance> instances = instanceDao.findByRegisterStatus("UP");
		instances.removeAll(serverdInstances);
		for (EurekaServiceInstance instance : instances) {
			instance.setRegisterStatus("DOWN");
			instanceDao.saveAndFlush(instance);
		}
	}
	/**
	 * 
	 * [保存或更新服务实例信息]
	 *
	 * @author ZhangBinbin <br>
	 * @date   2018年9月13日  下午2:18:36 <br>
	 * @param serviceProvider
	 * @param map <br>
	 * @param serverdInstances 
	 */
	private void saveOrUpdateInstance(EurekaServiceProvider serviceProvider, Map<String, Object> map,final List<EurekaServiceInstance> serverdInstances) {
		Map<String, Object> instanceMap =  (Map<String, Object>) map.get("instance");
		String instanceId = ObjectUtils.getVal(instanceMap, "instanceId");
		//将实例名保存到list中，用于检测数据库中是否存在已下线实例，但是表中状态为up的
		String ipAddr = ObjectUtils.getVal(instanceMap, "ipAddr");
		String status = ObjectUtils.getVal(instanceMap, "status");
		String port = ObjectUtils.stringOf(instanceMap.get("port"));
		String url = ObjectUtils.stringOf(instanceMap.get("statusPageUrl"));
		if(port.endsWith(".0")) {
			port = port.replaceAll(".0", "");
		}
		Map<String, Object> dataCenter = ObjectUtils.getVal(instanceMap, "dataCenterInfo");
		Map<String, Object> metadata = ObjectUtils.getVal(instanceMap, "metadata");
		Map<String, Object> leaseInfo = ObjectUtils.getVal(instanceMap, "leaseInfo");
		double timeMills = ObjectUtils.getVal(leaseInfo, "registrationTimestamp");
		long registerTimeMills = ObjectUtils.longOf(String.valueOf(timeMills), System.currentTimeMillis());
		EurekaServiceInstance instance = instanceDao.findByInstanceName(instanceId);
		if(instance == null) {
			instance = new EurekaServiceInstance();
			instance.setInstanceHost(ipAddr);
			instance.setInstanceName(instanceId);
			instance.setInstancePort(port);
			instance.setRegisterStatus(status);
			instance.setRegisterTime(new Timestamp(registerTimeMills));
			instance.setMetaData(GsonUtil.gsonString(metadata));
			instance.setUpdateTime(instance.getRegisterTime());
			instance.setStatusPageUrl(url);
			instance.setService(serviceProvider);
			instanceDao.saveAndFlush(instance);
		}else {//不为空
			//判断是否一致，不一致就更新，一致就不管
			boolean isSameWithBefore = true;
			if(!ipAddr.equals(instance.getInstanceHost())) {
				isSameWithBefore = false;
				instance.setInstanceHost(ipAddr);
			}
			if(!port.equals(instance.getInstancePort())) {
				isSameWithBefore = false;
				instance.setInstancePort(port);
			}
			if(!status.equals(instance.getRegisterStatus())) {
				isSameWithBefore = false;
				instance.setRegisterStatus(status);
			}
			
			if(!url.equals(instance.getStatusPageUrl())) {
				isSameWithBefore = false;
				instance.setStatusPageUrl(url);
			}
			
			if(!isSameWithBefore) {
				instance.setMetaData(GsonUtil.gsonString(metadata));
				instance.setUpdateTime(new Timestamp(System.currentTimeMillis()));
				instanceDao.saveAndFlush(instance);
			}
		}
		serverdInstances.add(instance);
	}
}
