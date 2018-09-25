package com.zzidc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zzidc.entity.EurekaApi;
import com.zzidc.entity.EurekaParameter;


public interface EurekaParameterDao extends JpaRepository<EurekaParameter,Integer>{
	@SuppressWarnings("unchecked")
	EurekaParameter save(EurekaParameter parameter);

	List<EurekaParameter> findByApi(EurekaApi api);
}
