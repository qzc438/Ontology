package com.qzc.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.el.ELContext;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.qzc.ontology.mbean.OntologyManagedBean;
import com.qzc.util.UUIDUtil;
import com.qzc.view.ApplicationOverview;
import com.qzc.view.LayerDescription;
import com.qzc.view.ModelStructure;

import javax.faces.annotation.FacesConfig;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

@FacesConfig
@Named("layerDetailController")
@RequestScoped

public class LayerDetailController {

	private OntologyManagedBean ontologyManagedBean;
	
	public LayerDetailController() throws Exception {
		ontologyManagedBean = new OntologyManagedBean();
		ID = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("ID");
		layerDescriptionList = ontologyManagedBean.searchLayerDescripitionByLayerID(ID);
	}
	
	List<LayerDescription> layerDescriptionList;
	
	String ID;
	

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public List<LayerDescription> getLayerDescriptionList() {
		return layerDescriptionList;
	}

	public void setLayerDescriptionList(List<LayerDescription> layerDescriptionList) {
		this.layerDescriptionList = layerDescriptionList;
	}

	// the parameter is from argument
	public void findSPO(String SID) {
		// find SPO
		layerDescriptionList = ontologyManagedBean.searchLayerDescripitionByLayerID(SID);
	}

}
