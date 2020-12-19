package com.qzc.view;

import java.io.Serializable;

public class ApplicationSummary implements Serializable{
	
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
	private String medicalImagingDeviceName;
	
	private Integer modelNumber;
	
	private Integer numberOfLayers;
	private String maxAccuracy;
	private String maxPrecision;
	private String maxRecall;
	private String maxF1Score;
	
	public ApplicationSummary() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApplicationSummary(String application, String applicationName, String healthcareApplicationName,
			String skinCancerName, String musculoskeletalDisorderName, String data, String dataName, String dataFeature,
			String dataDescription, String dataResource, String accelerometerName, String gyroscopeName,
			String medicalImagingDeviceName, Integer modelNumber, Integer numberOfLayers, String maxAccuracy,
			String maxPrecision, String maxRecall, String maxF1Score) {
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
		this.medicalImagingDeviceName = medicalImagingDeviceName;
		this.modelNumber = modelNumber;
		this.numberOfLayers = numberOfLayers;
		this.maxAccuracy = maxAccuracy;
		this.maxPrecision = maxPrecision;
		this.maxRecall = maxRecall;
		this.maxF1Score = maxF1Score;
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

	public String getMedicalImagingDeviceName() {
		return medicalImagingDeviceName;
	}

	public void setMedicalImagingDeviceName(String medicalImagingDeviceName) {
		this.medicalImagingDeviceName = medicalImagingDeviceName;
	}

	public Integer getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(Integer modelNumber) {
		this.modelNumber = modelNumber;
	}

	public Integer getNumberOfLayers() {
		return numberOfLayers;
	}

	public void setNumberOfLayers(Integer numberOfLayers) {
		this.numberOfLayers = numberOfLayers;
	}

	public String getMaxAccuracy() {
		return maxAccuracy;
	}

	public void setMaxAccuracy(String maxAccuracy) {
		this.maxAccuracy = maxAccuracy;
	}

	public String getMaxPrecision() {
		return maxPrecision;
	}

	public void setMaxPrecision(String maxPrecision) {
		this.maxPrecision = maxPrecision;
	}

	public String getMaxRecall() {
		return maxRecall;
	}

	public void setMaxRecall(String maxRecall) {
		this.maxRecall = maxRecall;
	}

	public String getMaxF1Score() {
		return maxF1Score;
	}

	public void setMaxF1Score(String maxF1Score) {
		this.maxF1Score = maxF1Score;
	}

	@Override
	public String toString() {
		return "ApplicationSummary [application=" + application + ", applicationName=" + applicationName
				+ ", healthcareApplicationName=" + healthcareApplicationName + ", skinCancerName=" + skinCancerName
				+ ", musculoskeletalDisorderName=" + musculoskeletalDisorderName + ", data=" + data + ", dataName="
				+ dataName + ", dataFeature=" + dataFeature + ", dataDescription=" + dataDescription + ", dataResource="
				+ dataResource + ", accelerometerName=" + accelerometerName + ", gyroscopeName=" + gyroscopeName
				+ ", medicalImagingDeviceName=" + medicalImagingDeviceName + ", modelNumber=" + modelNumber
				+ ", numberOfLayers=" + numberOfLayers + ", maxAccuracy=" + maxAccuracy + ", maxPrecision="
				+ maxPrecision + ", maxRecall=" + maxRecall + ", maxF1Score=" + maxF1Score + "]";
	}
	
}
