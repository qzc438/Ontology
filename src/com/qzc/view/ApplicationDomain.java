package com.qzc.view;

import java.io.Serializable;

public class ApplicationDomain implements Serializable{
	
	private String applicationDomainName;

	public ApplicationDomain() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApplicationDomain(String applicationDomainName) {
		super();
		this.applicationDomainName = applicationDomainName;
	}

	public String getApplicationDomainName() {
		return applicationDomainName;
	}

	public void setApplicationDomainName(String applicationDomainName) {
		this.applicationDomainName = applicationDomainName;
	}

	@Override
	public String toString() {
		return "ApplicationDomain [applicationDomainName=" + applicationDomainName + "]";
	}
}
