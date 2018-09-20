package com.zzidc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.zzidc.entity.EurekaOperationLog;
import java.lang.String;
import java.util.List;

/**
 * 日志持久层
 * JpaSpecificationExecutor 用来多条件查询
 * @author Administrator
 *
 */
public interface EurekaOperationLogDao extends JpaRepository<EurekaOperationLog, Long>,JpaSpecificationExecutor<EurekaOperationLog> {

	@SuppressWarnings("unchecked")
	EurekaOperationLog save(EurekaOperationLog operationLog);
	
	List<EurekaOperationLog> findByOperationIp(String operationip);

	List<EurekaOperationLog> findByOperationUserId(int  operationUserId);
}

