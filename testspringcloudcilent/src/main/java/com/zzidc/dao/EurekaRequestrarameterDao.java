package com.zzidc.dao;

import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.JpaRepository;

import com.zzidc.entity.EurekaRequestrarameter;

public interface EurekaRequestrarameterDao extends JpaRepository<EurekaRequestrarameter, Integer>{
	
	EurekaRequestrarameter save(EurekaRequestrarameter service);
	
	
	
}
