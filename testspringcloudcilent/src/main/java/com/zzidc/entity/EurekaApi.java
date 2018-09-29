package com.zzidc.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="eureka_api")
public class EurekaApi implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -7466587222355040955L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int apiId;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	private EurekaServiceProvider service;
	@Column(name="acompany",length = 225 ,nullable = false)
	private String affiliatedCompany;
	
	@Column(name="entryName",length = 225 ,nullable = false)
	private String entryName;
	
	@Column(name="interfaceName",length = 225 ,nullable = false)
	private String interFaceName;
	
	@Column(length=225,nullable=false)
	private String apiUrl;
	
	@Column(name="requestMethod",length = 225 ,nullable = false)
	private String requestMethod;
	
	@Column(length=225,nullable=false)
	private String consumes;
	
	@Column(name="returnExample",length = 225 ,nullable = false)
	private String returnExample;	
	
	@Column(length=225,nullable=false)
	private String produces;
	
	@Column(length = 15)
	private String charset = "utf-8";
	
	@Column
	private int status = 1;
	
	@OneToMany(mappedBy = "api",cascade= CascadeType.ALL)
	private List<EurekaRequestrarameter> apr;
	
	@OneToMany(mappedBy = "api",cascade = CascadeType.ALL)
	private List<EurekaReturnparameter> returnParameter;
	
	@Column(name="creationTime")
	@Temporal(TemporalType.TIME)
	private Date creationTime;
	
	@Column(name="modifiedTime")
	@Temporal(TemporalType.TIME)
	private Date modifiedTime;
	
	@OneToMany(mappedBy = "api",cascade = CascadeType.ALL)
	private List<EurekaDataTransformationProtocol> protocols;
	
	@OneToMany(mappedBy = "protocolApi",cascade = { CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.LAZY)
	private List<EurekaDataTransformationProtocolDetail> protocolDetails;
	

	public EurekaApi() {
		super();
	}

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

	public String getAffiliatedCompany() {
		return affiliatedCompany;
	}

	public void setAffiliatedCompany(String affiliatedCompany) {
		this.affiliatedCompany = affiliatedCompany;
	}

	public String getEntryName() {
		return entryName;
	}

	public void setEntryName(String entryName) {
		this.entryName = entryName;
	}

	public String getInterFaceName() {
		return interFaceName;
	}

	public void setInterFaceName(String interFaceName) {
		this.interFaceName = interFaceName;
	}

	public String getApiUrl() {
		return apiUrl;
	}

	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

	public String getRequestMethod() {
		return requestMethod;
	}

	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}

	public String getConsumes() {
		return consumes;
	}

	public void setConsumes(String consumes) {
		this.consumes = consumes;
	}

	public String getReturnExample() {
		return returnExample;
	}

	public void setReturnExample(String returnExample) {
		this.returnExample = returnExample;
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


	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<EurekaRequestrarameter> getApr() {
		return apr;
	}

	public void setApr(List<EurekaRequestrarameter> apr) {
		this.apr = apr;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public List<EurekaReturnparameter> getReturnParameter() {
		return returnParameter;
	}

	public void setReturnParameter(List<EurekaReturnparameter> returnParameter) {
		this.returnParameter = returnParameter;
	}

	public List<EurekaDataTransformationProtocol> getProtocols() {
		return protocols;
	}

	public void setProtocols(List<EurekaDataTransformationProtocol> protocols) {
		this.protocols = protocols;
	}

	public List<EurekaDataTransformationProtocolDetail> getProtocolDetails() {
		return protocolDetails;
	}

	public void setProtocolDetails(List<EurekaDataTransformationProtocolDetail> protocolDetails) {
		this.protocolDetails = protocolDetails;
	}

	@Override
	public String toString() {
		return "EurekaApi [apiId=" + apiId + ", service=" + service + ", affiliatedCompany=" + affiliatedCompany
				+ ", entryName=" + entryName + ", interFaceName=" + interFaceName + ", apiUrl=" + apiUrl
				+ ", requestMethod=" + requestMethod + ", consumes=" + consumes + ", returnExample=" + returnExample
				+ ", produces=" + produces + ", charset=" + charset + ", status=" + status + ", apr=" + apr
				+ ", returnParameter=" + returnParameter + ", creationTime=" + creationTime + ", modifiedTime="
				+ modifiedTime + ", protocols=" + protocols + ", protocolDetails=" + protocolDetails + "]";
	}

	public EurekaApi(EurekaServiceProvider service, String affiliatedCompany, String entryName, String interFaceName,
			String apiUrl, String requestMethod, String consumes, String returnExample, String produces, String charset,
			int status, List<EurekaRequestrarameter> apr, List<EurekaReturnparameter> returnParameter,
			Date creationTime, Date modifiedTime, List<EurekaDataTransformationProtocol> protocols,
			List<EurekaDataTransformationProtocolDetail> protocolDetails) {
		super();
		this.service = service;
		this.affiliatedCompany = affiliatedCompany;
		this.entryName = entryName;
		this.interFaceName = interFaceName;
		this.apiUrl = apiUrl;
		this.requestMethod = requestMethod;
		this.consumes = consumes;
		this.returnExample = returnExample;
		this.produces = produces;
		this.charset = charset;
		this.status = status;
		this.apr = apr;
		this.returnParameter = returnParameter;
		this.creationTime = creationTime;
		this.modifiedTime = modifiedTime;
		this.protocols = protocols;
		this.protocolDetails = protocolDetails;
	}



	
	
	
}
