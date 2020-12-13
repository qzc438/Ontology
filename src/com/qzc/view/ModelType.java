package com.qzc.view;

import java.io.Serializable;

public class ModelType implements Serializable{
	
	private String modelTypeName;

	public ModelType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModelType(String modelTypeName) {
		super();
		this.modelTypeName = modelTypeName;
	}

	public String getModelTypeName() {
		return modelTypeName;
	}

	public void setModelTypeName(String modelTypeName) {
		this.modelTypeName = modelTypeName;
	}

	@Override
	public String toString() {
		return "ModelType [modelTypeName=" + modelTypeName + "]";
	}
	
}
