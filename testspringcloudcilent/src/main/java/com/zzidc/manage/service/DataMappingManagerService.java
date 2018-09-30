package com.zzidc.manage.service;

import java.util.List;

import com.zzidc.entity.EurekaApi;
import com.zzidc.entity.EurekaDataTransformationProtocol;
import com.zzidc.entity.EurekaServiceProvider;
import com.zzidc.util.ResultInfo;

public interface DataMappingManagerService {
	List<EurekaDataTransformationProtocol> findAllProtocol();
	List<EurekaDataTransformationProtocol> findProtocolByApi(EurekaApi api);
	ResultInfo findProtocolByApi(int apiId);
	List<EurekaApi> findAllApi();
	List<EurekaApi> findApiByServiceId(int serviceId);
	List<EurekaServiceProvider> findAllService();
	<T> T saveOrUpdate(T t);
	EurekaServiceProvider findServiceById(int serviceId);
	EurekaApi findApiById(int apiId);
}
