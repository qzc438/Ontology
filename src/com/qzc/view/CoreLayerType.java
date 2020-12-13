package com.qzc.view;

import java.io.Serializable;

public class CoreLayerType implements Serializable{
	
	private String coreLayerTypeName;

	public CoreLayerType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CoreLayerType(String coreLayerTypeName) {
		super();
		this.coreLayerTypeName = coreLayerTypeName;
	}

	public String getCoreLayerTypeName() {
		return coreLayerTypeName;
	}

	public void setCoreLayerTypeName(String coreLayerTypeName) {
		this.coreLayerTypeName = coreLayerTypeName;
	}

	@Override
	public String toString() {
		return "CoreLayerType [coreLayerTypeName=" + coreLayerTypeName + "]";
	}
	
}
