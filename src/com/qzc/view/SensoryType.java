package com.qzc.view;

import java.io.Serializable;

public class SensoryType implements Serializable{
	
	private String sensoryTypeName;

	public SensoryType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSensoryTypeName() {
		return sensoryTypeName;
	}

	public void setSensoryTypeName(String sensoryTypeName) {
		this.sensoryTypeName = sensoryTypeName;
	}

	@Override
	public String toString() {
		return "SensoryType [sensoryTypeName=" + sensoryTypeName + "]";
	}

}
