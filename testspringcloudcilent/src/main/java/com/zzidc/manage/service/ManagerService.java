package com.zzidc.manage.service;

import java.util.List;

import com.zzidc.entity.EurekaIp;
import com.zzidc.entity.EurekaServiceIpAssociate;
import com.zzidc.entity.EurekaServiceProvider;
import com.zzidc.util.ResultInfo;

public interface ManagerService {
	List<EurekaServiceProvider> findAllService();
	
	EurekaServiceProvider findServiceById(int id);
	
	List<EurekaServiceIpAssociate> findIpAssociateByService(EurekaServiceProvider service);
	
	List<EurekaServiceIpAssociate> findAllAssociate(); 
	
	EurekaServiceIpAssociate findIpAssociateById(int associateId);
	
	<T> T saveOrUpdate(T t);
	
	EurekaIp findIpByIpAddress(String ipAddress);
	
	List<EurekaServiceIpAssociate> findIpAssociateListByIp(String ipAddress);

	ResultInfo createIp(int serviceId, String ip);

	ResultInfo updateIp(int serviceId, String ip, int associateId);

	ResultInfo deleteIp(int serviceId, int associateId);

	ResultInfo createIp(int[] serviceIds, String ip, int status);

	List<String> findServiceByIp(EurekaServiceIpAssociate associate);

	ResultInfo updateIp(int associateId, int[] serviceIds, String ip, int status);
}
