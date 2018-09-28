package com.zzidc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zzidc.entity.EurekaReturnparameter;

public interface EurekaReturnparameterDao extends JpaRepository<EurekaReturnparameter, Integer>{
	
	EurekaReturnparameter save(EurekaReturnparameter service);
	
	
}
