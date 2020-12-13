package com.qzc.view;

import java.io.Serializable;

public class LayerDescription implements Serializable{
	
	private String subject;
	private String property;
	private String object;
	// identify literal or uri
	private String type;
	// used for link
	private String objectID;
	
	public LayerDescription() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LayerDescription(String subject, String property, String object, String type, String objectID) {
		super();
		this.subject = subject;
		this.property = property;
		this.object = object;
		this.type = type;
		this.objectID = objectID;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getObjectID() {
		return objectID;
	}

	public void setObjectID(String objectID) {
		this.objectID = objectID;
	}

	@Override
	public String toString() {
		return "LayerDescription [subject=" + subject + ", property=" + property + ", object=" + object + ", type="
				+ type + ", objectID=" + objectID + "]";
	}
	
}
