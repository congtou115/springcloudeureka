package com.zzidc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zzidc.entity.EurekaServiceProvider;
import java.lang.String;
import java.util.List;

public interface EurekaServiceProviderDao extends JpaRepository<EurekaServiceProvider, Integer> {

	@SuppressWarnings("unchecked")
	EurekaServiceProvider save(EurekaServiceProvider service);
	
	EurekaServiceProvider findByServiceName(String servicename);
	
}
