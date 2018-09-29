package com.zzidc.manage.service;

import java.util.List;

import com.zzidc.entity.EurekaApi;
import com.zzidc.entity.EurekaRequestrarameter;
import com.zzidc.entity.EurekaReturnparameter;

public interface RegisterService {
	/**
	 * 注册服务接口
	 * @param services
	 * @return
	 */
	EurekaApi addInformation(EurekaApi services);
	/**
	 * 根据id修改服务接口
	 * @param services
	 * @return
	 */
	EurekaApi modifyInformation(EurekaApi services);
	/**
	 * 根据apiId查询接口信息
	 * @param apiId
	 * @return
	 */
	EurekaApi findByapiId(int apiId);
	
	/**
	 * 修改接口状态
	 * @param sId
	 * @return
	 */
	EurekaApi modifyState(EurekaApi services);
	/**
	 * 查询接口信息
	 * @param sId
	 */
	List<EurekaApi> queryInformation(Integer sId);
	/**
	 * 查询所有接口
	 * @return
	 */
	List<EurekaApi> findAll();
	/**
	 * 保存请求参数
	 * @param sr
	 * @return
	 */
	EurekaRequestrarameter addParnames(EurekaRequestrarameter srp);
	/**
	 * 修改请求参数
	 * @param sp
	 * @return
	 */
	EurekaRequestrarameter afterParnames(EurekaRequestrarameter sp);
	/**
	 * 保存返回参数
	 * @param srd
	 * @return
	 */
	EurekaReturnparameter addrParnames(EurekaReturnparameter srd);
	/**
	 * 修改请求参数
	 * @param sps
	 * @return
	 */
	EurekaReturnparameter afterrParnames(EurekaReturnparameter sps);
	List<EurekaApi> findApiByServiceId(int serviceId);
}
