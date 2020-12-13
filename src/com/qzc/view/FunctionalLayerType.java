package com.qzc.view;

import java.io.Serializable;

public class FunctionalLayerType implements Serializable{
	
	private String functionalLayerTypeName;
	
	public FunctionalLayerType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FunctionalLayerType(String functionalLayerTypeName) {
		super();
		this.functionalLayerTypeName = functionalLayerTypeName;
	}

	public String getFunctionalLayerTypeName() {
		return functionalLayerTypeName;
	}

	public void setFunctionalLayerTypeName(String functionalLayerTypeName) {
		this.functionalLayerTypeName = functionalLayerTypeName;
	}

	@Override
	public String toString() {
		return "FunctionalLayerType [functionalLayerTypeName=" + functionalLayerTypeName + "]";
	}
	
}
