package com.zzidc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zzidc.entity.EurekaServiceIpAssociate;
import com.zzidc.entity.EurekaServiceProvider;
import java.util.List;
import com.zzidc.entity.EurekaIp;

public interface EurekaServiceIpAssociateDao extends JpaRepository<EurekaServiceIpAssociate, Integer> {
	@SuppressWarnings("unchecked")
	EurekaServiceIpAssociate save(EurekaServiceIpAssociate assciate);
	
	List<EurekaServiceIpAssociate> findByService(EurekaServiceProvider service);
	
	List<EurekaServiceIpAssociate> findByIp(EurekaIp ip);
	
	List<EurekaServiceIpAssociate> findByStatus(int status);
	
}
