package com.zzidc.manage.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzidc.dao.EurekaIpDao;
import com.zzidc.dao.EurekaServiceIpAssociateDao;
import com.zzidc.dao.EurekaServiceProviderDao;
import com.zzidc.entity.EurekaIp;
import com.zzidc.entity.EurekaServiceIpAssociate;
import com.zzidc.entity.EurekaServiceProvider;
import com.zzidc.manage.service.ManagerService;
import com.zzidc.util.ObjectUtils;
import com.zzidc.util.ResultInfo;

@Service("managerService")
public class ManagerServiceImpl implements ManagerService{
	
	@Autowired
	private EurekaServiceProviderDao serviceDao;
	
	@Autowired
	private EurekaServiceIpAssociateDao associateDao;
	
	@Autowired
	private EurekaIpDao ipDao;
	@Override
	public List<EurekaServiceProvider> findAllService() {
		
		return serviceDao.findAll();
	}

	@Override
	public EurekaServiceProvider findServiceById(int id) {
		return serviceDao.getOne(id);
	}

	@Override
	public List<EurekaServiceIpAssociate> findIpAssociateByService(EurekaServiceProvider service) {
		return associateDao.findByService(service);
	}

	@Override
	public EurekaServiceIpAssociate findIpAssociateById(int associateId) {
		return associateDao.getOne(associateId);
	}


	@Override
	public EurekaIp findIpByIpAddress(String ipAddress) {
		return ipDao.findByIpAddress(ipAddress);
	}

	@Override
	public List<EurekaServiceIpAssociate> findIpAssociateListByIp(String ipAddress) {
		EurekaIp  ip = findIpByIpAddress(ipAddress);
		if(ip == null) {
			return null;
		}
		return associateDao.findByIp(ip);
	}

	public <T> T saveOrUpdate(T t) {
		if(t instanceof EurekaIp) {
			EurekaIp ip = (EurekaIp) t;
			ip =  ipDao.save(ip);
			return (T) ip;
		}
		if(t instanceof EurekaServiceIpAssociate) {
			EurekaServiceIpAssociate associate = associateDao.save((EurekaServiceIpAssociate)t);
			return (T) associate;
		}
		
		if(t instanceof EurekaServiceProvider) {
			EurekaServiceProvider service = serviceDao.save((EurekaServiceProvider)t);
			return (T) service;
		}
		return null;
	}

	/**
	 *添加白名单
	 */
	public ResultInfo createIp(int serviceId, String ip) {
		EurekaServiceProvider service = findServiceById(serviceId);
		if(service == null) {
			return new ResultInfo(1, "参数错误，找不到对应的服务信息");
		}
		//校验IP是否合法
		if(!ObjectUtils.isIp(ip)) {
			return new ResultInfo(1, "请传入合法的IP地址");
		}
		//查下这个ip是否已经在ip表里面
		EurekaIp eurekaIp = findIpByIpAddress(ip);
		if(eurekaIp != null) {
			//检查下这个服务是否已经添加过这个IP了
			List<EurekaServiceIpAssociate> associate = findIpAssociateListByIp(eurekaIp.getIpAddress());
			if(!ObjectUtils.isEmpty(associate)) {
				for (EurekaServiceIpAssociate eurekaServiceIpAssociate : associate) {
					if(service.getServiceId()==eurekaServiceIpAssociate.getService().getServiceId()) {//已经添加过
						return new ResultInfo(0, "此IP已经在白名单之中了");
					}
				}
			}
		}else {
			//没有添加过
			eurekaIp = new EurekaIp(ip, null);
			eurekaIp = ipDao.save(eurekaIp);
		}
		//先创建IP对象
		EurekaServiceIpAssociate ipAssociate = new EurekaServiceIpAssociate(eurekaIp, service);
		associateDao.save(ipAssociate);
		return new ResultInfo(0, "添加成功");
	}

	/**
	 * 修改ip白名单
	 */
	public ResultInfo updateIp(int serviceId, String ip, int associateId) {
		EurekaServiceProvider service = findServiceById(serviceId);
		if(service == null) {
			return new ResultInfo(1, "参数错误，找不到对应的服务信息");
		}
		//校验IP是否合法
		if(!ObjectUtils.isIp(ip)) {
			return new ResultInfo(1, "请传入合法的IP地址");
		}
		EurekaServiceIpAssociate ipAssociate = associateDao.findOne(associateId);
		if(ipAssociate == null) {
			return new ResultInfo(1, "参数错误，找不到要修改的IP白名单记录");
		}
		if(ip.equals(ipAssociate.getIp().getIpAddress())) {//已经添加过
			return new ResultInfo(1, "IP地址与要修改的IP地址一致，此次修改无效");
		}
		//查下这个ip是否已经在ip表里面
		EurekaIp eurekaIp = ipDao.findByIpAddress(ip);
		if(eurekaIp != null) {
			//检查下这个服务是否已经添加过这个IP了
			List<EurekaServiceIpAssociate> associate = findIpAssociateListByIp(eurekaIp.getIpAddress());
			if(!ObjectUtils.isEmpty(associate)) {
				for (EurekaServiceIpAssociate eurekaServiceIpAssociate : associate) {
					if(ip.equals(eurekaServiceIpAssociate.getIp().getIpAddress())) {//已经添加过
						return new ResultInfo(1, "此IP已经在白名单之中了");
					}
				}
			}
		}else {
			//没有添加过
			//先创建IP对象
			eurekaIp = new EurekaIp(ip, null);
			eurekaIp = ipDao.save(eurekaIp);
		}
		ipAssociate.setIp(eurekaIp);
		associateDao.save(ipAssociate);
		return new ResultInfo(0, "修改成功");
	}

	/**
	 * 删除白名单
	 */
	public ResultInfo deleteIp(int serviceId, int associateId) {
		EurekaServiceProvider service = findServiceById(serviceId);
		if(service == null) {
			return new ResultInfo(1, "参数错误，找不到对应的服务信息");
		}
		EurekaServiceIpAssociate associate = findIpAssociateById(associateId);
		if(associate == null) {
			return new ResultInfo(1, "参数错误，IP信息与服务信息不对应");
		}
		if(associate.getStatus() == 0) {//无效
			return new ResultInfo(1, "此IP已经从IP白名单中删除");
		}
		associate.setStatus(0);
		try {
			associateDao.saveAndFlush(associate);
			return new ResultInfo(0, "操作成功。");
		} catch (Exception e) {
			return new ResultInfo(1, "删除失败，保存数据库操作异常。");
		}
	}

	/**
	 * 获取所有Ip白名单信息
	 */
	@Override
	public List<EurekaServiceIpAssociate> findAllAssociate() {
		return associateDao.findAll();
	}

	/**
	 * 添加白名单
	 */
	@Override
	@Transactional
	public ResultInfo createIp(int[] serviceIds, String ip,int status) {
		if(!ObjectUtils.isIp(ip)) {
			return new ResultInfo(1, "请输入正确的IP地址");
		}
		if(status <0 || status > 1) {
			return new ResultInfo(1, "状态值错误");
		}
		if(serviceIds == null || serviceIds.length == 0) {
			return new ResultInfo(1, "请选择服务");
		}
		for (int serviceId : serviceIds) {
			ResultInfo result = createIp(serviceId, ip);
			if(result.getCode()!=0) {
				return result;
			}
		}
		return new ResultInfo(0, "操作成功");
	}

	
	/**
	 * 根据ip获取所有具有此ip白名单的服务
	 */
	public List<String> findServiceByIp(EurekaServiceIpAssociate associate) {
		EurekaIp eurekaIp = associate.getIp();
		if(eurekaIp == null) {
			return null;
		}
		List<EurekaServiceIpAssociate> list = eurekaIp.getAssociate();
		if(list == null || list.isEmpty()) {
			return null;
		}
		List<String> serviceNames = new ArrayList<>();
		for (EurekaServiceIpAssociate ipAssociate : list) {
			serviceNames.add(ipAssociate.getService().getServiceName());
		}
		return serviceNames;
	}

	/**
	 * 修改IP白名单
	 */
	@Override
	@Transactional
	public ResultInfo updateIp(int associateId, int[] serviceIds, String ip, int status) {
		if(!ObjectUtils.isIp(ip)) {
			return new ResultInfo(1, "请输入正确的IP地址");
		}
		if(status <0 || status > 1) {
			return new ResultInfo(1, "状态值错误");
		}
		if(serviceIds == null || serviceIds.length == 0) {
			return new ResultInfo(1, "请选择服务");
		}
		
		EurekaServiceIpAssociate associate = findIpAssociateById(associateId);
		if(associate == null) {
			return new ResultInfo(1, "非法操作，请刷新后再尝试操作");
		}
		boolean isChoosedTheOne = false;
		List<EurekaServiceProvider> serviceIdList = new ArrayList<>();
		for (int serviceId : serviceIds) {
			EurekaServiceProvider service = findServiceById(serviceId);
			if(service == null) {
				return new ResultInfo(1, "参数错误，查不到对应的服务信息");
			}
			serviceIdList.add(service);
			if(serviceId == associate.getService().getServiceId()) {
				isChoosedTheOne = true;
			}
		}
		if(!isChoosedTheOne) {//如果没有选中当前associate关联的service，就帮他选中
			serviceIdList.add(associate.getService());
		}
		//检查当前ip有没有添加过实体
		EurekaIp eurekaIp = findIpByIpAddress(ip);
		if(eurekaIp == null) {
			eurekaIp = new EurekaIp(ip, "");
			eurekaIp = ipDao.save(eurekaIp);
		}
		//查看所选服务与原ip有无关联关系，如果没有就创建新关联关系，如果已有，则修改
		List<EurekaServiceIpAssociate> associateList = findIpAssociateListByIp(associate.getIp().getIpAddress());
		boolean isDeal = false;
		for (EurekaServiceProvider service : serviceIdList) {
			isDeal = false;
			for (EurekaServiceIpAssociate ipAssociate : associateList) {
				if(ipAssociate.getService().getServiceId() == service.getServiceId()) {//有关联关系
					ipAssociate.setIp(eurekaIp);//更改为新ip
					isDeal = true;
					break;
				}
			}
			if(!isDeal) {//没有关联关系则新建一个
				EurekaServiceIpAssociate ipAssociate = new EurekaServiceIpAssociate(eurekaIp, service);
				associateDao.save(ipAssociate);
			}
		}
		return new ResultInfo(0, "操作成功");
	}
	
	
	
	

}
