package com.zzidc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zzidc.entity.EurekaServiceInstance;
import com.zzidc.entity.EurekaServiceProvider;
import java.lang.String;

public interface EurekaServiceInstanceDao extends JpaRepository<EurekaServiceInstance, Integer> {

	@SuppressWarnings("unchecked")
	EurekaServiceInstance save(EurekaServiceInstance instance);
	
	List<EurekaServiceInstance> findByService(EurekaServiceProvider service);

	EurekaServiceInstance findByInstanceName(String instanceName);
	
	List<EurekaServiceInstance> findByRegisterStatus(String registerstatus);
	
	
}
