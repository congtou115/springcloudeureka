package com.zzidc.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "eureka_ip")
public class EurekaIp implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7660793260897380072L;

	@Id
	@Column(name = "ip_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ipId;
	
	@Column(name = "ip_address",nullable = false,length = 16 ,unique = true)
	private String ipAddress;
	
	@Column(name = "ip_descr",nullable = false,length = 100)
	private String ipDescr;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "ip",cascade = CascadeType.ALL)
	private List<EurekaServiceIpAssociate> associate;

	public int getIpId() {
		return ipId;
	}

	public void setIpId(int ipId) {
		this.ipId = ipId;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getIpDescr() {
		return ipDescr;
	}

	public void setIpDescr(String ipDescr) {
		this.ipDescr = ipDescr;
	}

	@Override
	public String toString() {
		return "EurekaIp [ipId=" + ipId + ", ipAddress=" + ipAddress + ", ipDescr=" + ipDescr + "]";
	}

	public EurekaIp(String ipAddress, String ipDescr) {
		super();
		this.ipAddress = ipAddress;
		this.ipDescr = ipDescr;
	}

	public EurekaIp() {
		super();
	}

	public List<EurekaServiceIpAssociate> getAssociate() {
		return associate;
	}

	public void setAssociate(List<EurekaServiceIpAssociate> associate) {
		this.associate = associate;
	}
	
	
}
