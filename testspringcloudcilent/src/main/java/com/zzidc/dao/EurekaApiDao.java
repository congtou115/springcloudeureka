package com.zzidc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zzidc.entity.EurekaApi;
import com.zzidc.entity.EurekaServiceProvider;
import java.util.List;
import java.lang.String;


public interface EurekaApiDao extends JpaRepository<EurekaApi,Integer>{
	@SuppressWarnings("unchecked")
	EurekaApi save(EurekaApi api);
	
	EurekaApi findByapiId(int apiId);
	
	List<EurekaApi> findByService(EurekaServiceProvider service);
	
	List<EurekaApi> findByApiUrl(String apiurl);
	
	List<EurekaApi> findAll();
}
