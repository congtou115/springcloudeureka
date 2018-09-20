package com.zzidc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zzidc.entity.EurekaIp;
import java.lang.String;

public interface EurekaIpDao extends JpaRepository<EurekaIp,Integer>{
	@SuppressWarnings("unchecked")
	EurekaIp save(EurekaIp ip);
	
	EurekaIp findByIpAddress(String ipAddress);
}
