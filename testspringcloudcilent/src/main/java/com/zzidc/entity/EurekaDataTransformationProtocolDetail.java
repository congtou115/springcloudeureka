package com.zzidc.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zzidc.entity.jsonserializer.EurekaApiSerializer;
import com.zzidc.entity.jsonserializer.EurekaDataTransformationProtocolSerializer;
import com.zzidc.entity.jsonserializer.EurekaReturnparameterSerializer;


@Entity
@Table(name = "eureka_datatransformation_protocol_detail")
public class EurekaDataTransformationProtocolDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7396868600965844355L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonSerialize(using = EurekaDataTransformationProtocolSerializer.class)
	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
	private EurekaDataTransformationProtocol protocol;
	
	@JsonSerialize(using = EurekaReturnparameterSerializer.class)
	@OneToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
	private EurekaReturnparameter parameter;
	
	@Column(length = 50)
	private String newname;
	
	@JsonSerialize(using = EurekaApiSerializer.class)
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	private EurekaApi protocolApi;
	
	@Column(length = 50)
	private String newname4value;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EurekaDataTransformationProtocol getProtocol() {
		return protocol;
	}

	public void setProtocol(EurekaDataTransformationProtocol protocol) {
		this.protocol = protocol;
	}

	public EurekaReturnparameter getParameter() {
		return parameter;
	}

	public void setParameter(EurekaReturnparameter parameter) {
		this.parameter = parameter;
	}

	public String getNewname() {
		return newname;
	}

	public void setNewname(String newname) {
		this.newname = newname;
	}

	public EurekaApi getProtocolApi() {
		return protocolApi;
	}

	public void setProtocolApi(EurekaApi protocolApi) {
		this.protocolApi = protocolApi;
	}

	public String getNewname4value() {
		return newname4value;
	}

	public void setNewname4value(String newname4value) {
		this.newname4value = newname4value;
	}

	public EurekaDataTransformationProtocolDetail(EurekaDataTransformationProtocol protocol,
			EurekaReturnparameter parameter, String newname, EurekaApi protocolApi, String newname4value) {
		super();
		this.protocol = protocol;
		this.parameter = parameter;
		this.newname = newname;
		this.protocolApi = protocolApi;
		this.newname4value = newname4value;
	}

	public EurekaDataTransformationProtocolDetail() {
		super();
	}

	@Override
	public String toString() {
		return "EurekaDataTransformationProtocolDetail [id=" + id + ", protocol=" + protocol + ", parameter="
				+ parameter + ", newname=" + newname + ", protocolApi=" + protocolApi + ", newname4value="
				+ newname4value + "]";
	}
	
	
	
}
