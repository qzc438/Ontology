package com.qzc.view;

import java.io.Serializable;

public class ApplicationOverview implements Serializable {
	
	private String application;
	private String applicationName;
	
	private String healthcareApplicationName;
	
	private String skinCancerName;
	private String musculoskeletalDisorderName;
	
	private String data;
	private String dataName;
	private String dataFeature;
	private String dataDescription;
	private String dataResource;
	
	private String accelerometerName;
	private String gyroscopeName;
	
	private String model;
	private String modelName;
	private String modelDescription;
	private String modelResource;
	
	private String CNNTypeName;
	private String RNNTypeName;
	
	private String modelPerformance;
	private String performanceAccuracy;
	private String performancePrecision;
	private String performanceRecall;
	private String performanceF1Score;
	
	public ApplicationOverview() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApplicationOverview(String application, String applicationName, String healthcareApplicationName,
			String skinCancerName, String musculoskeletalDisorderName, String data, String dataName, String dataFeature,
			String dataDescription, String dataResource, String accelerometerName, String gyroscopeName, String model,
			String modelName, String modelDescription, String modelResource, String cNNTypeName, String rNNTypeName,
			String modelPerformance, String performanceAccuracy, String performancePrecision, String performanceRecall,
			String performanceF1Score) {
		super();
		this.application = application;
		this.applicationName = applicationName;
		this.healthcareApplicationName = healthcareApplicationName;
		this.skinCancerName = skinCancerName;
		this.musculoskeletalDisorderName = musculoskeletalDisorderName;
		this.data = data;
		this.dataName = dataName;
		this.dataFeature = dataFeature;
		this.dataDescription = dataDescription;
		this.dataResource = dataResource;
		this.accelerometerName = accelerometerName;
		this.gyroscopeName = gyroscopeName;
		this.model = model;
		this.modelName = modelName;
		this.modelDescription = modelDescription;
		this.modelResource = modelResource;
		CNNTypeName = cNNTypeName;
		RNNTypeName = rNNTypeName;
		this.modelPerformance = modelPerformance;
		this.performanceAccuracy = performanceAccuracy;
		this.performancePrecision = performancePrecision;
		this.performanceRecall = performanceRecall;
		this.performanceF1Score = performanceF1Score;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getHealthcareApplicationName() {
		return healthcareApplicationName;
	}

	public void setHealthcareApplicationName(String healthcareApplicationName) {
		this.healthcareApplicationName = healthcareApplicationName;
	}

	public String getSkinCancerName() {
		return skinCancerName;
	}

	public void setSkinCancerName(String skinCancerName) {
		this.skinCancerName = skinCancerName;
	}

	public String getMusculoskeletalDisorderName() {
		return musculoskeletalDisorderName;
	}

	public void setMusculoskeletalDisorderName(String musculoskeletalDisorderName) {
		this.musculoskeletalDisorderName = musculoskeletalDisorderName;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDataName() {
		return dataName;
	}

	public void setDataName(String dataName) {
		this.dataName = dataName;
	}

	public String getDataFeature() {
		return dataFeature;
	}

	public void setDataFeature(String dataFeature) {
		this.dataFeature = dataFeature;
	}

	public String getDataDescription() {
		return dataDescription;
	}

	public void setDataDescription(String dataDescription) {
		this.dataDescription = dataDescription;
	}

	public String getDataResource() {
		return dataResource;
	}

	public void setDataResource(String dataResource) {
		this.dataResource = dataResource;
	}

	public String getAccelerometerName() {
		return accelerometerName;
	}

	public void setAccelerometerName(String accelerometerName) {
		this.accelerometerName = accelerometerName;
	}

	public String getGyroscopeName() {
		return gyroscopeName;
	}

	public void setGyroscopeName(String gyroscopeName) {
		this.gyroscopeName = gyroscopeName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getModelDescription() {
		return modelDescription;
	}

	public void setModelDescription(String modelDescription) {
		this.modelDescription = modelDescription;
	}

	public String getModelResource() {
		return modelResource;
	}

	public void setModelResource(String modelResource) {
		this.modelResource = modelResource;
	}

	public String getCNNTypeName() {
		return CNNTypeName;
	}

	public void setCNNTypeName(String cNNTypeName) {
		CNNTypeName = cNNTypeName;
	}

	public String getRNNTypeName() {
		return RNNTypeName;
	}

	public void setRNNTypeName(String rNNTypeName) {
		RNNTypeName = rNNTypeName;
	}

	public String getModelPerformance() {
		return modelPerformance;
	}

	public void setModelPerformance(String modelPerformance) {
		this.modelPerformance = modelPerformance;
	}

	public String getPerformanceAccuracy() {
		return performanceAccuracy;
	}

	public void setPerformanceAccuracy(String performanceAccuracy) {
		this.performanceAccuracy = performanceAccuracy;
	}

	public String getPerformancePrecision() {
		return performancePrecision;
	}

	public void setPerformancePrecision(String performancePrecision) {
		this.performancePrecision = performancePrecision;
	}

	public String getPerformanceRecall() {
		return performanceRecall;
	}

	public void setPerformanceRecall(String performanceRecall) {
		this.performanceRecall = performanceRecall;
	}

	public String getPerformanceF1Score() {
		return performanceF1Score;
	}

	public void setPerformanceF1Score(String performanceF1Score) {
		this.performanceF1Score = performanceF1Score;
	}

	@Override
	public String toString() {
		return "ApplicationOverview [application=" + application + ", applicationName=" + applicationName
				+ ", healthcareApplicationName=" + healthcareApplicationName + ", skinCancerName=" + skinCancerName
				+ ", musculoskeletalDisorderName=" + musculoskeletalDisorderName + ", data=" + data + ", dataName="
				+ dataName + ", dataFeature=" + dataFeature + ", dataDescription=" + dataDescription + ", dataResource="
				+ dataResource + ", accelerometerName=" + accelerometerName + ", gyroscopeName=" + gyroscopeName
				+ ", model=" + model + ", modelName=" + modelName + ", modelDescription=" + modelDescription
				+ ", modelResource=" + modelResource + ", CNNTypeName=" + CNNTypeName + ", RNNTypeName=" + RNNTypeName
				+ ", modelPerformance=" + modelPerformance + ", performanceAccuracy=" + performanceAccuracy
				+ ", performancePrecision=" + performancePrecision + ", performanceRecall=" + performanceRecall
				+ ", performanceF1Score=" + performanceF1Score + "]";
	}
	
}
