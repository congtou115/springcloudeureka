package com.zzidc.test;

import java.util.ArrayList;
import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zzidc.dao.EurekaApiDao;
import com.zzidc.dao.EurekaDataTransformationProtocolDao;
import com.zzidc.dao.EurekaDataTransformationProtocolDetailDao;
import com.zzidc.dao.EurekaIpDao;
import com.zzidc.dao.EurekaReturnparameterDao;
import com.zzidc.dao.EurekaServiceIpAssociateDao;
import com.zzidc.dao.EurekaServiceProviderDao;
import com.zzidc.entity.EurekaApi;
import com.zzidc.entity.EurekaIp;
import com.zzidc.entity.EurekaReturnparameter;
import com.zzidc.entity.EurekaServiceIpAssociate;
import com.zzidc.entity.EurekaServiceProvider;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DaoTest {

	@Autowired
	private EurekaApiDao apiDao;
	
	@Autowired
	private EurekaIpDao ipDao;
	
	@Autowired
	private EurekaReturnparameterDao parameterDao;
	
	@Autowired
	private EurekaServiceProviderDao serviceDao;
	
	@Autowired
	private EurekaServiceIpAssociateDao associateDao;
	
	@Autowired
	private EurekaDataTransformationProtocolDao protocolDao; 
	
	@Autowired
	private EurekaDataTransformationProtocolDetailDao protocolDetailDao; 
	
//	@Test
	public void testIpDao() {
		EurekaIp ip = new EurekaIp();
		ip.setIpAddress("192.168.101.70");
		ip.setIpDescr("test");
		ip = ipDao.save(ip);
		System.out.println(ip);
	}
	
	
//	@Test
	public void testServiceDao() {
		EurekaServiceProvider service = new EurekaServiceProvider("oa", "OA项目");
		service = serviceDao.save(service);
		System.out.println(service);
	}
	@Test
	public void testapi() {
//		 apiDao.delete(2);
		 apiDao.delete(9);
//		parameterDao.delete(2);
	}
	
//	@Test
	public void testassociateDao() {
		EurekaApi api = new EurekaApi();
		api.setAffiliatedCompany("jingan");
		api.setApiUrl("/emp/getInfo");
		api.setConsumes("json");
		api.setProduces("json");
		api.setService(serviceDao.getOne(8));
		api.setRequestMethod("get");
		api.setEntryName("asdfasfas");
		api.setInterFaceName("asdfsdf");
//		api.setReturnExample("asdfasfsadf");
		apiDao.save(api);
		EurekaReturnparameter parmeter = new EurekaReturnparameter();
		parmeter.setApi(api);
		parmeter.setrExplain("what is this");
		parmeter.setRparameterName("province");
		parmeter.setRparameterType("String");
		parameterDao.save(parmeter);
	}
	
//	@Test
	public void testdelete() {
		associateDao.delete(associateDao.findOne(2));
//		ipDao.delete(ipDao.findOne(9));
	}
	
//	@Test
	public void testSaveList() {
		EurekaServiceProvider service = serviceDao.findByServiceName("oa");
//		EurekaServiceProvider service = new EurekaServiceProvider("zzidc", "景安主站项目");
		EurekaIp ip = new EurekaIp("192.168.101.73", "local");
		
		ip = ipDao.save(ip);
		List<EurekaServiceIpAssociate> list = new ArrayList<>();
		EurekaServiceIpAssociate associate = new EurekaServiceIpAssociate(ip, service, 0);
		list.add(associate);
		ip = new EurekaIp("192.168.101.72", "local");
		ip = ipDao.save(ip);
		associate = new EurekaServiceIpAssociate(ip, service, 0);
		list.add(associate);
		associateDao.save(list);
	}
}
