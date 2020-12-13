package com.qzc.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
import com.qzc.view.ApplicationSummary;
import com.qzc.view.LayerDescription;
import com.qzc.view.ModelStructure;

import javax.faces.annotation.FacesConfig;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

@FacesConfig
@Named("detailController")
@RequestScoped

public class DetailController {

	static @ManagedProperty("#{indexController}")

	IndexController indexController;

	public DetailController() throws Exception {
		// index
		// applicationIndex = Integer.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("applicationIndex"));

		// overview list
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		indexController = (IndexController) FacesContext.getCurrentInstance().getApplication().getELResolver()
				.getValue(elContext, null, "indexController");
		
		// application ID
		applicationID = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("applicationID");
		
		// model ID
		modelID = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("modelID");

		// application view object
		// applicationOverview = indexController.getApplicationOverviewList().get(applicationIndex);

		// get ontologyManagedBean
		ontologyManagedBean = new OntologyManagedBean();
		
		applicationOverview = ontologyManagedBean.searchApplicaionOverviewByApplicationID(applicationID,modelID);

		// find model structure
		modelStructureList = ontologyManagedBean.searchModelStuctureModelID(applicationOverview.getModel());
		// sorted model structure
		sortedModelStructureList = ontologyManagedBean.sortModelStructure(modelStructureList);
		
		// find cross validation models
		sameApplicationOverviewList = ontologyManagedBean.searchApplicationOverviewsUseSameApplication(applicationOverview.getModel(), applicationID);
		
		// find application use the same data
		sameDataApplicationOverviewList = ontologyManagedBean.searchApplicationOverviewsUseSameData(applicationOverview.getData(),applicationID);
		sameDataApplicationSummaryList = ontologyManagedBean.searchApplicationSummariesUseSameData(applicationOverview.getData(),applicationID);
	}

	private Integer applicationIndex;
	
	private String applicationID;
	
	private String modelID;

	private ApplicationOverview applicationOverview;

	private OntologyManagedBean ontologyManagedBean;

	private List<ModelStructure> modelStructureList;
	
	private List<ModelStructure> sortedModelStructureList;

	private List<ApplicationOverview> sameApplicationOverviewList;
	
	private List<ApplicationOverview> sameDataApplicationOverviewList;
	
	private List<ApplicationSummary> sameDataApplicationSummaryList;
	
	public List<ModelStructure> getSortedModelStructureList() {
		return sortedModelStructureList;
	}

	public void setSortedModelStructureList(List<ModelStructure> sortedModelStructureList) {
		this.sortedModelStructureList = sortedModelStructureList;
	}

	public List<ApplicationSummary> getSameDataApplicationSummaryList() {
		return sameDataApplicationSummaryList;
	}

	public void setSameDataApplicationSummaryList(List<ApplicationSummary> sameDataApplicationSummaryList) {
		this.sameDataApplicationSummaryList = sameDataApplicationSummaryList;
	}

	public String getModelID() {
		return modelID;
	}

	public void setModelID(String modelID) {
		this.modelID = modelID;
	}

	public List<ApplicationOverview> getSameApplicationOverviewList() {
		return sameApplicationOverviewList;
	}

	public void setSameApplicationOverviewList(List<ApplicationOverview> sameApplicationOverviewList) {
		this.sameApplicationOverviewList = sameApplicationOverviewList;
	}

	// layer index
	private Integer layerIndex;

	// 0: layer 1: previous layer
	private Integer layerFlag;

	private List<LayerDescription> layerDescriptionList;

	public Integer getApplicationIndex() {
		return applicationIndex;
	}

	public void setApplicationIndex(Integer applicationIndex) {
		this.applicationIndex = applicationIndex;
	}
	
	public String getApplicationID() {
		return applicationID;
	}

	public void setApplicationID(String applicationID) {
		this.applicationID = applicationID;
	}

	public ApplicationOverview getApplicationOverview() {
		return applicationOverview;
	}

	public void setApplicationOverview(ApplicationOverview applicationOverview) {
		this.applicationOverview = applicationOverview;
	}

	public List<ModelStructure> getModelStructureList() {
		return modelStructureList;
	}

	public void setModelStructureList(List<ModelStructure> modelStructureList) {
		this.modelStructureList = modelStructureList;
	}

	public Integer getLayerIndex() {
		return layerIndex;
	}

	public void setLayerIndex(Integer layerIndex) {
		this.layerIndex = layerIndex;
	}

	public Integer getLayerFlag() {
		return layerFlag;
	}

	public void setLayerFlag(Integer layerFlag) {
		this.layerFlag = layerFlag;
	}

	public List<LayerDescription> getLayerDescriptionList() {
		return layerDescriptionList;
	}

	public void setLayerDescriptionList(List<LayerDescription> layerDescriptionList) {
		this.layerDescriptionList = layerDescriptionList;
	}
	
	public List<ApplicationOverview> getSameDataApplicationOverviewList() {
		return sameDataApplicationOverviewList;
	}

	public void setSameDataApplicationOverviewList(List<ApplicationOverview> sameDataApplicationOverviewList) {
		this.sameDataApplicationOverviewList = sameDataApplicationOverviewList;
	}
	
}
