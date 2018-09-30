package com.zzidc.manage.service.impl;

import java.util.List;

import javax.imageio.spi.RegisterableService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzidc.dao.EurekaDataTransformationProtocolDao;
import com.zzidc.dao.EurekaDataTransformationProtocolDetailDao;
import com.zzidc.entity.EurekaApi;
import com.zzidc.entity.EurekaDataTransformationProtocol;
import com.zzidc.entity.EurekaDataTransformationProtocolDetail;
import com.zzidc.entity.EurekaServiceProvider;
import com.zzidc.manage.service.DataMappingManagerService;
import com.zzidc.manage.service.ManagerService;
import com.zzidc.manage.service.RegisterService;
import com.zzidc.util.ResultInfo;
@Service
public class DataMappingManagerServiceImpl implements DataMappingManagerService {

	@Autowired
	private RegisterService apiService;
	
	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private EurekaDataTransformationProtocolDao protocolDao;
	
	@Autowired
	private EurekaDataTransformationProtocolDetailDao pDetailDao;
	
	
	/**
	 * 获取所有映射协议
	 */
	@Override
	public List<EurekaDataTransformationProtocol> findAllProtocol() {
		return protocolDao.findAll();
	}

	/**
	 * 根据api获取当前api的所有映射协议
	 */
	@Override
	public List<EurekaDataTransformationProtocol> findProtocolByApi(EurekaApi api) {
		return protocolDao.findByApi(api);
	}

	/**
	 * 保存实体
	 */
	@Override
	public <T> T saveOrUpdate(T t) {
		if(t instanceof EurekaDataTransformationProtocol) {
			EurekaDataTransformationProtocol protocol = (EurekaDataTransformationProtocol) t;
			protocol = protocolDao.save(protocol);
			return (T) protocol;
		}
		if(t instanceof EurekaDataTransformationProtocolDetail) {
			EurekaDataTransformationProtocolDetail protocol = (EurekaDataTransformationProtocolDetail) t;
			protocol = pDetailDao.save(protocol);
			return (T) protocol;
		}
		return null;
	}

	/**
	 * 根据apiId获取对应的映射列表
	 */
	@Override
	public ResultInfo findProtocolByApi(int apiId) {
		EurekaApi api = apiService.findByapiId(apiId);
		if(api == null) {
			return new ResultInfo(1, "接口信息不存在");
		}
		List<EurekaDataTransformationProtocol> protocols = this.findProtocolByApi(api);
		
		return new ResultInfo(0, protocols);
	}

	@Override
	public List<EurekaApi> findAllApi() {
		return apiService.findAll();
	}

	@Override
	public List<EurekaApi> findApiByServiceId(int serviceId) {
		return apiService.findApiByServiceId(serviceId);
	}

	@Override
	public List<EurekaServiceProvider> findAllService() {
		return managerService.findAllService();
	}

	@Override
	public EurekaServiceProvider findServiceById(int serviceId) {
		return managerService.findServiceById(serviceId);
	}

	@Override
	public EurekaApi findApiById(int apiId) {
		return apiService.findByapiId(apiId);
	}
	
	

}
