package com.zzidc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zzidc.entity.EurekaDataTransformationProtocol;
import com.zzidc.entity.EurekaApi;
import java.util.List;

public interface EurekaDataTransformationProtocolDao extends JpaRepository<EurekaDataTransformationProtocol,Integer>{
	@SuppressWarnings("unchecked")
	EurekaDataTransformationProtocol save(EurekaDataTransformationProtocol protocol);
	
	List<EurekaDataTransformationProtocol> findByApi(EurekaApi api);
	
	List<EurekaDataTransformationProtocol> findByStatus(int status);
}
