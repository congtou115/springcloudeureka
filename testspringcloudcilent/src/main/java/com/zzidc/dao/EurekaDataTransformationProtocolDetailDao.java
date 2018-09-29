package com.zzidc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zzidc.entity.EurekaDataTransformationProtocolDetail;

public interface EurekaDataTransformationProtocolDetailDao extends JpaRepository<EurekaDataTransformationProtocolDetail, Integer> {

	@SuppressWarnings("unchecked")
	EurekaDataTransformationProtocolDetail save(EurekaDataTransformationProtocolDetail protocolDetail);
	
}
