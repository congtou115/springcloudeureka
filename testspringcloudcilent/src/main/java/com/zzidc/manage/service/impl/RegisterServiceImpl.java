package com.zzidc.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzidc.dao.EurekaApiDao;
import com.zzidc.dao.EurekaRequestrarameterDao;
import com.zzidc.dao.EurekaReturnparameterDao;
import com.zzidc.entity.EurekaApi;
import com.zzidc.entity.EurekaRequestrarameter;
import com.zzidc.entity.EurekaReturnparameter;
import com.zzidc.manage.service.RegisterService;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService{
	
	@Autowired
	private EurekaApiDao api;
	@Autowired
	private EurekaRequestrarameterDao apirqs;
	@Autowired
	private EurekaReturnparameterDao apirts;
	
	@Override
	public EurekaApi addInformation(EurekaApi services) {
		return api.save(services);
	}
	@Override
	public EurekaApi modifyInformation(EurekaApi services) {
		return api.save(services);
	}
	@Override
	public EurekaApi modifyState(EurekaApi services) {
		return api.save(services);
	}
	@Override
	public EurekaApi findByapiId(int apiId) {
		return api.findByapiId(apiId);
	}
	@Override
	public List<EurekaApi> queryInformation(Integer sId) {
		return api.findAll();
	}
	@Override
	public List<EurekaApi> findAll() {
		return api.findAll();
	}
	@Override
	public EurekaRequestrarameter addParnames(EurekaRequestrarameter srp) {
		return apirqs.save(srp);
	}
	@Override
	public EurekaRequestrarameter afterParnames(EurekaRequestrarameter sp) {
		return apirqs.save(sp);
	}
	@Override
	public EurekaReturnparameter addrParnames(EurekaReturnparameter srd) {
		return apirts.save(srd);
	}
	@Override
	public EurekaReturnparameter afterrParnames(EurekaReturnparameter sps) {
		return apirts.save(sps);
	}
	

}
