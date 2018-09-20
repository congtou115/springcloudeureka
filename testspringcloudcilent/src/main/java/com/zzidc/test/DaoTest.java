package com.zzidc.test;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zzidc.dao.EurekaIpDao;
import com.zzidc.dao.EurekaServiceIpAssociateDao;
import com.zzidc.dao.EurekaServiceProviderDao;
import com.zzidc.entity.EurekaIp;
import com.zzidc.entity.EurekaServiceIpAssociate;
import com.zzidc.entity.EurekaServiceProvider;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DaoTest {

	@Autowired
	private EurekaIpDao ipDao;
	
	@Autowired
	private EurekaServiceProviderDao serviceDao;
	
	@Autowired
	private EurekaServiceIpAssociateDao associateDao;
	
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
	public void testassociateDao() {
		EurekaServiceProvider service = serviceDao.findByServiceName("oa");
		List<EurekaServiceIpAssociate> aaa = associateDao.findByService(service);
//		EurekaServiceProvider service = new EurekaServiceProvider("zzidc", "景安主站项目");
		EurekaIp ip = new EurekaIp("192.168.101.77", "local");
		ip = ipDao.save(ip);
		EurekaServiceIpAssociate associate = new EurekaServiceIpAssociate(ip, service);
		associateDao.save(associate);
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
