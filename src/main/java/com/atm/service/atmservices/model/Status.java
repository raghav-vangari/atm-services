package com.atm.service.atmservices.model;

import java.io.Serializable;

public class Status implements Serializable{

	private static final long serialVersionUID = 6402983489086600407L;

	private String code;
	private String message;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Status [code=" + code + ", message=" + message + "]";
	}
}
