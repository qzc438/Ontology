package com.qzc.view;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "filters")
@RequestScoped
public class Filters implements Serializable{
	
	private List<String> applicationDomains;

	private List<String> sensoryTypes;
	
	private List<String> modelTypes;
	
	private List<String> layerTypes;
	
	private List<String> coreLayerTypes;
	
	private List<String> functionalLayerTypes;
	
	private Integer numberOfLayers;
	
	private Float performanceAccuracy;
	private Float performancePrecision;
	private Float performanceRecall;
	private Float performanceF1Score;
	
	public Filters() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Filters(List<String> applicationDomains, List<String> sensoryTypes, List<String> modelTypes,
			List<String> layerTypes, List<String> coreLayerTypes, List<String> functionalLayerTypes,
			Integer numberOfLayers, Float performanceAccuracy, Float performancePrecision, Float performanceRecall,
			Float performanceF1Score) {
		super();
		this.applicationDomains = applicationDomains;
		this.sensoryTypes = sensoryTypes;
		this.modelTypes = modelTypes;
		this.layerTypes = layerTypes;
		this.coreLayerTypes = coreLayerTypes;
		this.functionalLayerTypes = functionalLayerTypes;
		this.numberOfLayers = numberOfLayers;
		this.performanceAccuracy = performanceAccuracy;
		this.performancePrecision = performancePrecision;
		this.performanceRecall = performanceRecall;
		this.performanceF1Score = performanceF1Score;
	}

	public List<String> getApplicationDomains() {
		return applicationDomains;
	}

	public void setApplicationDomains(List<String> applicationDomains) {
		this.applicationDomains = applicationDomains;
	}

	public List<String> getSensoryTypes() {
		return sensoryTypes;
	}

	public void setSensoryTypes(List<String> sensoryTypes) {
		this.sensoryTypes = sensoryTypes;
	}

	public List<String> getModelTypes() {
		return modelTypes;
	}

	public void setModelTypes(List<String> modelTypes) {
		this.modelTypes = modelTypes;
	}

	public List<String> getLayerTypes() {
		return layerTypes;
	}

	public void setLayerTypes(List<String> layerTypes) {
		this.layerTypes = layerTypes;
	}

	public List<String> getCoreLayerTypes() {
		return coreLayerTypes;
	}

	public void setCoreLayerTypes(List<String> coreLayerTypes) {
		this.coreLayerTypes = coreLayerTypes;
	}

	public List<String> getFunctionalLayerTypes() {
		return functionalLayerTypes;
	}

	public void setFunctionalLayerTypes(List<String> functionalLayerTypes) {
		this.functionalLayerTypes = functionalLayerTypes;
	}

	public Integer getNumberOfLayers() {
		return numberOfLayers;
	}

	public void setNumberOfLayers(Integer numberOfLayers) {
		this.numberOfLayers = numberOfLayers;
	}

	public Float getPerformanceAccuracy() {
		return performanceAccuracy;
	}

	public void setPerformanceAccuracy(Float performanceAccuracy) {
		this.performanceAccuracy = performanceAccuracy;
	}

	public Float getPerformancePrecision() {
		return performancePrecision;
	}

	public void setPerformancePrecision(Float performancePrecision) {
		this.performancePrecision = performancePrecision;
	}

	public Float getPerformanceRecall() {
		return performanceRecall;
	}

	public void setPerformanceRecall(Float performanceRecall) {
		this.performanceRecall = performanceRecall;
	}

	public Float getPerformanceF1Score() {
		return performanceF1Score;
	}

	public void setPerformanceF1Score(Float performanceF1Score) {
		this.performanceF1Score = performanceF1Score;
	}

	@Override
	public String toString() {
		return "Filters [applicationDomains=" + applicationDomains + ", sensoryTypes=" + sensoryTypes + ", modelTypes="
				+ modelTypes + ", layerTypes=" + layerTypes + ", coreLayerTypes=" + coreLayerTypes
				+ ", functionalLayerTypes=" + functionalLayerTypes + ", numberOfLayers=" + numberOfLayers
				+ ", performanceAccuracy=" + performanceAccuracy + ", performancePrecision=" + performancePrecision
				+ ", performanceRecall=" + performanceRecall + ", performanceF1Score=" + performanceF1Score + "]";
	}

}
