package com.qzc.view;

import java.io.Serializable;

public class ModelStructure implements Serializable{
	
	private String layerID;
	private String layerName;
	private String previousLayerID;
	private String previousLayerName;
	
	public ModelStructure() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ModelStructure(String layerID, String layerName, String previousLayerID,
			String previousLayerName) {
		super();
		this.layerID = layerID;
		this.layerName = layerName;
		this.previousLayerID = previousLayerID;
		this.previousLayerName = previousLayerName;
	}
	
	public String getLayerID() {
		return layerID;
	}
	
	public void setLayerID(String layerID) {
		this.layerID = layerID;
	}
	
	public String getLayerName() {
		return layerName;
	}
	
	public void setLayerName(String layerName) {
		this.layerName = layerName;
	}
	
	public String getPreviousLayerID() {
		return previousLayerID;
	}
	
	public void setPreviousLayerID(String previousLayerID) {
		this.previousLayerID = previousLayerID;
	}
	
	public String getPreviousLayerName() {
		return previousLayerName;
	}
	
	public void setPreviousLayerName(String previousLayerName) {
		this.previousLayerName = previousLayerName;
	}
	
	@Override
	public String toString() {
		return "DeepLeanrningModelStructure [layerID=" + layerID + ", layerName=" + layerName + ", previousLayerID="
				+ previousLayerID + ", previousLayerName=" + previousLayerName + "]";
	}
	
}
