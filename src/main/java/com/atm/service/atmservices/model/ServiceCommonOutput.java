package com.atm.service.atmservices.model;

import java.io.Serializable;

public class ServiceCommonOutput implements Serializable{

	private static final long serialVersionUID = 1413364857227038063L;
	
	private String name;
	private Status status;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ServiceCommonOutput [name=" + name + ", status=" + status + "]";
	}
}
