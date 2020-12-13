package com.qzc.view;

public class LayerType {
	
	private String layerTypeName;
	
	public LayerType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LayerType(String layerTypeName) {
		super();
		this.layerTypeName = layerTypeName;
	}

	public String getLayerTypeName() {
		return layerTypeName;
	}

	public void setLayerTypeName(String layerTypeName) {
		this.layerTypeName = layerTypeName;
	}

	@Override
	public String toString() {
		return "LayerType [layerTypeName=" + layerTypeName + "]";
	}
	
}
