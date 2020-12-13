package com.qzc.controller;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.qzc.ontology.mbean.OntologyManagedBean;
import com.qzc.view.ApplicationDomain;
import com.qzc.view.ApplicationOverview;
import com.qzc.view.ApplicationSummary;
import com.qzc.view.CoreLayerType;
import com.qzc.view.SensoryType;
import com.qzc.view.Filters;
import com.qzc.view.FunctionalLayerType;
import com.qzc.view.LayerType;
import com.qzc.view.ModelType;

import javax.faces.annotation.FacesConfig;
import javax.faces.context.FacesContext;

@FacesConfig
@Named("indexController")
@ApplicationScoped

public class IndexController {

	OntologyManagedBean ontologyManagedBean;
	
	public IndexController() throws Exception {
		ontologyManagedBean = new OntologyManagedBean();
		// find all filters
		applicationDomainList = ontologyManagedBean.findAllApplicationDomains();
		sensoryTypeList = ontologyManagedBean.findAllSensoryTypes();
		modelTypeList = ontologyManagedBean.findAllModelTypes();
		layerTypeList = ontologyManagedBean.findAllLayerTypes();
		coreLayerTypeList = ontologyManagedBean.findAllCoreLayerTypes();
		functionalLayerTypeList = ontologyManagedBean.findAllFunctionalLayerTypes();
		// find applications
		applicationSummaryList = ontologyManagedBean.searchApplicationSummaries(null,null);
	}

	private List<ApplicationSummary> applicationSummaryList;
	private List<ApplicationDomain> applicationDomainList;
	private List<SensoryType> sensoryTypeList;
	private List<ModelType> modelTypeList;
	private List<LayerType> layerTypeList;
	private List<CoreLayerType> coreLayerTypeList;
	private List<FunctionalLayerType> functionalLayerTypeList;
	
	private String keyword;
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public List<ApplicationSummary> getApplicationSummaryList() {
		return applicationSummaryList;
	}

	public void setApplicationSummaryList(List<ApplicationSummary> applicationSummaryList) {
		this.applicationSummaryList = applicationSummaryList;
	}

	public List<ApplicationDomain> getApplicationDomainList() {
		return applicationDomainList;
	}

	public void setApplicationDomainList(List<ApplicationDomain> applicationDomainList) {
		this.applicationDomainList = applicationDomainList;
	}

	public List<SensoryType> getSensoryTypeList() {
		return sensoryTypeList;
	}

	public void setSensoryTypeList(List<SensoryType> sensoryTypeList) {
		this.sensoryTypeList = sensoryTypeList;
	}

	public List<ModelType> getModelTypeList() {
		return modelTypeList;
	}

	public void setModelTypeList(List<ModelType> modelTypeList) {
		this.modelTypeList = modelTypeList;
	}

	public List<LayerType> getLayerTypeList() {
		return layerTypeList;
	}

	public void setLayerTypeList(List<LayerType> layerTypeList) {
		this.layerTypeList = layerTypeList;
	}

	public List<CoreLayerType> getCoreLayerTypeList() {
		return coreLayerTypeList;
	}

	public void setCoreLayerTypeList(List<CoreLayerType> coreLayerTypeList) {
		this.coreLayerTypeList = coreLayerTypeList;
	}

	public List<FunctionalLayerType> getFunctionalLayerTypeList() {
		return functionalLayerTypeList;
	}

	public void setFunctionalLayerTypeList(List<FunctionalLayerType> functionalLayerTypeList) {
		this.functionalLayerTypeList = functionalLayerTypeList;
	}
	
	// filters is from named entity
	public void searchByKeywordAndFilters(Filters filters)
	{
		// keyword is from h:form, the name/id of h:inputText
		keyword = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("keyword");
		applicationSummaryList = ontologyManagedBean.searchApplicationSummaries(filters,keyword);
	}
	
}
