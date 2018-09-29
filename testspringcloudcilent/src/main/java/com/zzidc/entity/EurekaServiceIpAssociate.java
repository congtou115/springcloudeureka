package com.zzidc.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="eureka_service_ip_associate")
public class EurekaServiceIpAssociate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1292016128520253563L;

	@Id
	@Column(name = "associate_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int associateId;
	
	@ManyToOne(targetEntity = EurekaIp.class,cascade = CascadeType.DETACH)
	@JoinColumn(name = "ip_id",referencedColumnName = "ip_id")
	private EurekaIp ip;
	
	@ManyToOne(targetEntity = EurekaServiceProvider.class,fetch = FetchType.LAZY,cascade = CascadeType.DETACH)
	@JoinColumn(name = "service_id",referencedColumnName = "service_id")
	private EurekaServiceProvider service;
	//0无效 1有效
	@Column(columnDefinition = "INT default 1")
	private int status = 1;

	public int getAssociateId() {
		return associateId;
	}

	public void setAssociateId(int associateId) {
		this.associateId = associateId;
	}


	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}


	public EurekaServiceIpAssociate() {
		super();
	}

	public EurekaIp getIp() {
		return ip;
	}

	public void setIp(EurekaIp ip) {
		this.ip = ip;
	}

	public EurekaServiceProvider getService() {
		return service;
	}

	public void setService(EurekaServiceProvider service) {
		this.service = service;
	}

	@Override
	public String toString() {
		return "EurekaServiceIpAssociate [associateId=" + associateId + ", ip=" + ip + ", service=" + service
				+ ", status=" + status + "]";
	}

	/**
	 * 
	 * @param ip       ip地址
	 * @param service  服务端对象
	 * @param status   0无效 1有效
	 */
	public EurekaServiceIpAssociate(EurekaIp ip, EurekaServiceProvider service, int status) {
		super();
		this.ip = ip;
		this.service = service;
		this.status = status;
	}

	public EurekaServiceIpAssociate(EurekaIp ip, EurekaServiceProvider service) {
		super();
		this.ip = ip;
		this.service = service;
	}
	
	
	
}
