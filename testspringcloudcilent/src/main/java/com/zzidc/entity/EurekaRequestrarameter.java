package com.zzidc.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="eureka_requestrarameter")
public class EurekaRequestrarameter implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rpID;
	
	@Column(name="rpName",length = 225 ,nullable = false)
	private String rpName;
	
	@Column(name="rMandatory",length = 225 ,nullable = false)
	private Integer rMandatory;
	
	@Column(name="rpType",length = 225 ,nullable = false)
	private String rpType;
	
	@Column(name="rExplain",length = 225 ,nullable = false)
	private String rExplain;
	
	@ManyToOne(cascade = {CascadeType.REMOVE})
	private EurekaApi api;

	public Integer getRpID() {
		return rpID;
	}

	public void setRpID(Integer rpID) {
		this.rpID = rpID;
	}

	public String getRpName() {
		return rpName;
	}

	public void setRpName(String rpName) {
		this.rpName = rpName;
	}

	public Integer getrMandatory() {
		return rMandatory;
	}

	public void setrMandatory(Integer rMandatory) {
		this.rMandatory = rMandatory;
	}

	public String getRpType() {
		return rpType;
	}

	public void setRpType(String rpType) {
		this.rpType = rpType;
	}

	public String getrExplain() {
		return rExplain;
	}

	public void setrExplain(String rExplain) {
		this.rExplain = rExplain;
	}

	public EurekaApi getApi() {
		return api;
	}

	public void setApi(EurekaApi api) {
		this.api = api;
	}

	@Override
	public String toString() {
		return "EurekaRequestrarameter [rpID=" + rpID + ", rpName=" + rpName + ", rMandatory=" + rMandatory
				+ ", rpType=" + rpType + ", rExplain=" + rExplain + ", api=" + api + "]";
	}

	public EurekaRequestrarameter(Integer rpID, String rpName, Integer rMandatory, String rpType, String rExplain,
			EurekaApi api) {
		super();
		this.rpID = rpID;
		this.rpName = rpName;
		this.rMandatory = rMandatory;
		this.rpType = rpType;
		this.rExplain = rExplain;
		this.api = api;
	}
	
	
	
}
