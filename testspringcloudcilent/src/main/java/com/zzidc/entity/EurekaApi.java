package com.zzidc.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="eureka_api")
public class EurekaApi implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -564773228229949921L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int apiId;
	
	@ManyToOne(cascade = {CascadeType.REMOVE})
	private EurekaServiceProvider service;
	
	@Column(length=225,nullable=false)
	private String apiUrl;
	
	@Column(length=225,nullable=false)
	private String consumes;
	
	@Column(length=225,nullable=false)
	private String produces;
	
	@Column(length = 15)
	private String charset = "utf-8";
	
	@OneToMany(mappedBy = "api")
	private List<EurekaParameter> parameters ;
	
	@Column
	private int status = 1;

	public int getApiId() {
		return apiId;
	}

	public void setApiId(int apiId) {
		this.apiId = apiId;
	}

	public EurekaServiceProvider getService() {
		return service;
	}

	public void setService(EurekaServiceProvider service) {
		this.service = service;
	}

	public String getApiUrl() {
		return apiUrl;
	}

	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

	public String getConsumes() {
		return consumes;
	}

	public void setConsumes(String consumes) {
		this.consumes = consumes;
	}

	public String getProduces() {
		return produces;
	}

	public void setProduces(String produces) {
		this.produces = produces;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public List<EurekaParameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<EurekaParameter> parameters) {
		this.parameters = parameters;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "EurekaApi [apiId=" + apiId + ", service=" + service + ", apiUrl=" + apiUrl + ", consumes=" + consumes
				+ ", produces=" + produces + ", charset=" + charset + ", parameters=" + parameters + ", status="
				+ status + "]";
	}

	public EurekaApi(EurekaServiceProvider service, String apiUrl, String consumes, String produces, String charset,
			List<EurekaParameter> parameters, int status) {
		super();
		this.service = service;
		this.apiUrl = apiUrl;
		this.consumes = consumes;
		this.produces = produces;
		this.charset = charset;
		this.parameters = parameters;
		this.status = status;
	}
	
	
}
