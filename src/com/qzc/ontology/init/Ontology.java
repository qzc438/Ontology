package com.qzc.ontology.init;

import edu.stanford.smi.protegex.owl.model.OWLDatatypeProperty;
import edu.stanford.smi.protegex.owl.model.OWLEnumeratedClass;
import edu.stanford.smi.protegex.owl.model.OWLIndividual;
import edu.stanford.smi.protegex.owl.model.OWLNamedClass;
import edu.stanford.smi.protegex.owl.model.OWLObjectProperty;
import edu.stanford.smi.protegex.owl.model.OWLSomeValuesFrom;
import edu.stanford.smi.protegex.owl.model.RDFIndividual;


import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;

import edu.stanford.smi.protege.exception.OntologyLoadException;
import edu.stanford.smi.protegex.owl.ProtegeOWL;
import edu.stanford.smi.protegex.owl.jena.Jena;
import edu.stanford.smi.protegex.owl.jena.JenaOWLModel;

public class Ontology {
	
	public static void main(String[] args) {
		Ontology createOntology = new Ontology();
		try {
			createOntology.createOntology();
		} catch (OntologyLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createOntology() throws OntologyLoadException {
		
		/**
		// model
		OWLNamedClass modelClass = owlModel.createOWLNamedClass(Naming.CLASS_MODEL);		
		// model layer
		OWLNamedClass modelLayerClass = owlModel.createOWLNamedSubclass(Naming.CLASS_MODEL_LAYER, modelClass);
		// model has layer
		OWLObjectProperty hasLayerProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_LAYER);
		hasLayerProperty.setDomain(modelClass);
		hasLayerProperty.setRange(modelLayerClass);
		OWLObjectProperty isLayerOfProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_LAYER_OF);
		isLayerOfProperty.setDomain(modelLayerClass);
		isLayerOfProperty.setRange(modelClass);
		hasLayerProperty.setInverseProperty(isLayerOfProperty);
		**/
		
		JenaOWLModel owlModel = ProtegeOWL.createJenaOWLModel();
		owlModel.getNamespaceManager().setDefaultNamespace(Naming.DEFAULT_NAME_SPACE);
		
		// application
		OWLNamedClass applicationClass = owlModel.createOWLNamedClass(Naming.CLASS_APPLICATION);
		// application name
		OWLDatatypeProperty applicationNameProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_APPLICATION_NAME);
		applicationNameProperty.setRange(owlModel.getXSDstring());
		applicationNameProperty.setDomain(applicationClass);
		
		// has application domain
		// OWLNamedClass applicationDomainClass = owlModel.createOWLNamedSubclass(Naming.CLASS_APPLICATION_DOMAIN, applicationClass);
		// OWLObjectProperty hasApplicationDomainProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_APPLICATION_DOMAIN);
		// hasApplicationDomainProperty.setDomain(applicationClass);
		// hasApplicationDomainProperty.setRange(applicationDomainClass);
		// OWLObjectProperty isApplicationDomainOfProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_APPLICATION_DOMAIN_OF);
		// isApplicationDomainOfProperty.setDomain(applicationDomainClass);
		// isApplicationDomainOfProperty.setRange(applicationClass);
		// hasApplicationDomainProperty.setInverseProperty(isApplicationDomainOfProperty);
		
		// healthcare application
		OWLNamedClass applicationHealthcareClass = owlModel.createOWLNamedSubclass(Naming.CLASS_APPLICATION_DOMAIN_HEALTHCARE,applicationClass);
		// healthcare application name
		OWLDatatypeProperty healthcareNameProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_DOMAIN_HEALTHCARE_NAME);
		healthcareNameProperty.setRange(owlModel.getXSDstring());
		healthcareNameProperty.setDomain(applicationHealthcareClass);
		// has healthcare application
		OWLObjectProperty hasHealthcareApplicationProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_HEALTHCARE_APPLICATION);
		hasHealthcareApplicationProperty.setDomain(applicationClass);
		hasHealthcareApplicationProperty.setRange(applicationHealthcareClass);
		OWLObjectProperty isHealthcareApplicationOfProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_HEALTHCARE_APPLICATION_OF);
		isHealthcareApplicationOfProperty.setDomain(applicationHealthcareClass);
		isHealthcareApplicationOfProperty.setRange(applicationClass);
		hasHealthcareApplicationProperty.setInverseProperty(isHealthcareApplicationOfProperty);
		
		// skin cancer
		OWLNamedClass skinCancerClass = owlModel.createOWLNamedSubclass(Naming.CLASS_SKIN_CANCER,applicationHealthcareClass);
		// skin cancer application name
		OWLDatatypeProperty skinCancerNameProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_SKIN_CANCER_NAME);
		skinCancerNameProperty.setRange(owlModel.getXSDstring());
		skinCancerNameProperty.setDomain(skinCancerClass);
		// has skin cancer
		OWLObjectProperty hasSkinCancerProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_SKIN_CANCER);
		hasSkinCancerProperty.setDomain(applicationHealthcareClass);
		hasSkinCancerProperty.setRange(skinCancerClass);
		OWLObjectProperty isSkinCancerOfProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_SKIN_CANCER_OF);
		isSkinCancerOfProperty.setDomain(skinCancerClass);
		isSkinCancerOfProperty.setRange(applicationHealthcareClass);
		hasSkinCancerProperty.setInverseProperty(isSkinCancerOfProperty);
		
		// musculoskeletal disorder
		OWLNamedClass musculoskeletalDisorderClass = owlModel.createOWLNamedSubclass(Naming.CLASS_MUSCULOSKELETAL_DISORDER,applicationHealthcareClass);
		// musculoskeletal disorder application name
		OWLDatatypeProperty musculoskeletalDisorderNameProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_MUSCULOSKELETAL_DISORDER_NAME);
		musculoskeletalDisorderNameProperty.setRange(owlModel.getXSDstring());
		musculoskeletalDisorderNameProperty.setDomain(musculoskeletalDisorderClass);
		// has musculoskeletal disorder
		OWLObjectProperty hasMusculoskeletalDisorderProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_MUSCULOSKELETAL_DISORDER);
		hasMusculoskeletalDisorderProperty.setDomain(applicationHealthcareClass);
		hasMusculoskeletalDisorderProperty.setRange(musculoskeletalDisorderClass);
		OWLObjectProperty isMusculoskeletalDisorderOfProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_MUSCULOSKELETAL_DISORDER_OF);
		isMusculoskeletalDisorderOfProperty.setDomain(musculoskeletalDisorderClass);
		isMusculoskeletalDisorderOfProperty.setRange(applicationHealthcareClass);
		
		// data
		OWLNamedClass dataClass = owlModel.createOWLNamedClass(Naming.CLASS_DATA);
		// data name
		OWLDatatypeProperty dataNameProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_DATA_NAME);
		dataNameProperty.setRange(owlModel.getXSDstring());
		dataNameProperty.setDomain(dataClass);
		// data feature
		OWLDatatypeProperty dataFeatureProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_DATA_FEATURE);
		dataFeatureProperty.setRange(owlModel.getXSDstring());
		dataFeatureProperty.setDomain(dataClass);
		// data description
		OWLDatatypeProperty dataDescriptionProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_DATA_DESCRIPTION);
		dataDescriptionProperty.setRange(owlModel.getXSDstring());
		dataDescriptionProperty.setDomain(dataClass);
		// data resource
		OWLDatatypeProperty dataResourceProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_DATA_RESOURCE);
		dataResourceProperty.setRange(owlModel.getXSDstring());
		dataResourceProperty.setDomain(dataClass);
		// has data source type
		OWLNamedClass dataSourceTypeClass = owlModel.createOWLNamedSubclass(Naming.CLASS_DATA_SOURCE_TYPE,dataClass);
		OWLObjectProperty hasDataSourceTypeProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_DATA_SOURCE_TYPE);
		hasDataSourceTypeProperty.setDomain(dataClass);
		hasDataSourceTypeProperty.setRange(dataSourceTypeClass);
		OWLObjectProperty isDataSourceTypeOfProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_DATA_SOURCE_TYPE_OF);
		isDataSourceTypeOfProperty.setDomain(dataSourceTypeClass);
		isDataSourceTypeOfProperty.setRange(dataClass);
		hasDataSourceTypeProperty.setInverseProperty(isDataSourceTypeOfProperty);
		// has accelerometer data
		OWLNamedClass dataSourceTypeAccelerometerClass = owlModel.createOWLNamedSubclass(Naming.CLASS_DATA_SOURCE_TYPE_ACCELEROMETER,dataSourceTypeClass);
		OWLDatatypeProperty accelerometerNameProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_ACCELEROMETER_NAME);
		accelerometerNameProperty.setRange(owlModel.getXSDstring());
		accelerometerNameProperty.setDomain(dataSourceTypeAccelerometerClass);
		OWLObjectProperty hasAccelerometerProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_ACCELEROMETER);
		hasAccelerometerProperty.setDomain(dataSourceTypeClass);
		hasAccelerometerProperty.setRange(dataSourceTypeAccelerometerClass);
		OWLObjectProperty isAccelerometerOfProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_ACCELEROMETER_OF);
		isAccelerometerOfProperty.setDomain(dataSourceTypeAccelerometerClass);
		isAccelerometerOfProperty.setRange(dataSourceTypeClass);
		hasAccelerometerProperty.setInverseProperty(isAccelerometerOfProperty);
		// has gyroscope data
		OWLNamedClass dataSourceTypeGyroscopeClass = owlModel.createOWLNamedSubclass(Naming.CLASS_DATA_SOURCE_TYPE_GYROSCOPE,dataSourceTypeClass);
		OWLDatatypeProperty gyroscopeNameProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_GYROSCOPE_NAME);
		gyroscopeNameProperty.setRange(owlModel.getXSDstring());
		gyroscopeNameProperty.setDomain(dataSourceTypeGyroscopeClass);
		OWLObjectProperty hasGyroscopeProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_GYROSCOPE);
		hasGyroscopeProperty.setDomain(dataSourceTypeClass);
		hasGyroscopeProperty.setRange(dataSourceTypeGyroscopeClass);
		OWLObjectProperty isGyroscopeOfProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_GYROSCOPE_OF);
		isGyroscopeOfProperty.setDomain(dataSourceTypeGyroscopeClass);
		isGyroscopeOfProperty.setRange(dataSourceTypeClass);
		hasGyroscopeProperty.setInverseProperty(isGyroscopeOfProperty);
		// has medical imaging device data
		OWLNamedClass dataSourceTypeMedicalImagingDeviceClass = owlModel.createOWLNamedSubclass(Naming.CLASS_DATA_SOURCE_TYPE_MEDICALIMAGINGDEVICE,dataSourceTypeClass);
		OWLDatatypeProperty medicalImagingDeviceNameProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_MEDICALIMAGINGDEVICE_NAME);
		medicalImagingDeviceNameProperty.setRange(owlModel.getXSDstring());
		medicalImagingDeviceNameProperty.setDomain(dataSourceTypeMedicalImagingDeviceClass);
		OWLObjectProperty hasMedicalImagingProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_MEDICALIMAGINGDEVICE);
		hasMedicalImagingProperty.setDomain(dataSourceTypeClass);
		hasMedicalImagingProperty.setRange(dataSourceTypeMedicalImagingDeviceClass);
		OWLObjectProperty isMedicalImagingDeviceOfProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_MEDICALIMAGINGDEVICE_OF);
		isMedicalImagingDeviceOfProperty.setDomain(dataSourceTypeMedicalImagingDeviceClass);
		isMedicalImagingDeviceOfProperty.setRange(dataSourceTypeClass);
		hasMedicalImagingProperty.setInverseProperty(isMedicalImagingDeviceOfProperty);
		
		
		// model
		OWLNamedClass modelClass = owlModel.createOWLNamedClass(Naming.CLASS_MODEL);
		// model name
		OWLDatatypeProperty modelNameProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_MODEL_NAME);
		modelNameProperty.setRange(owlModel.getXSDstring());
		modelNameProperty.setDomain(modelClass);
		// model description
		OWLDatatypeProperty modelDescriptionProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_MODEL_DESCRIPTION);
		modelDescriptionProperty.setRange(owlModel.getXSDstring());
		modelDescriptionProperty.setDomain(modelClass);
		// model resource
		OWLDatatypeProperty modelResourceProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_MODEL_RESOURCE);
		modelDescriptionProperty.setRange(owlModel.getXSDstring());
		modelResourceProperty.setDomain(modelClass);
		
		// relationship: application
		// application has data
		OWLObjectProperty hasDataProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_DATA);
		hasDataProperty.setDomain(applicationClass);
		hasDataProperty.setRange(dataClass);
		OWLObjectProperty isDataOfProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_DATA_OF);
		isDataOfProperty.setDomain(dataClass);
		isDataOfProperty.setRange(applicationClass);
		hasDataProperty.setInverseProperty(isDataOfProperty);
		// application has model
		OWLObjectProperty hasModelProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_MODEL);
		hasModelProperty.setDomain(applicationClass);
		hasModelProperty.setRange(modelClass);
		OWLObjectProperty isModelOfProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_MODEL_OF);
		isModelOfProperty.setDomain(modelClass);
		isModelOfProperty.setRange(applicationClass);
		hasModelProperty.setInverseProperty(isModelOfProperty);
		// application has some data, some model
		OWLSomeValuesFrom hasSomeData = owlModel.createOWLSomeValuesFrom(hasDataProperty, dataClass);
		applicationClass.addEquivalentClass(hasSomeData);
		OWLSomeValuesFrom hasSomeModel = owlModel.createOWLSomeValuesFrom(hasModelProperty, modelClass);
		applicationClass.addEquivalentClass(hasSomeModel);

		// subclass of model
		
		// performance
		OWLNamedClass performanceClass = owlModel.createOWLNamedSubclass(Naming.CLASS_PERFORMANCE, modelClass);
		// performance accuracy
		OWLDatatypeProperty performanceAccuracyProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_PERFORMANCE_ACCURACY);
		performanceAccuracyProperty.setRange(owlModel.getXSDfloat());
		performanceAccuracyProperty.setDomain(performanceClass);
		OWLDatatypeProperty performancePrecisionProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_PERFORMANCE_PRECISION);
		performancePrecisionProperty.setRange(owlModel.getXSDfloat());
		performancePrecisionProperty.setDomain(performanceClass);
		OWLDatatypeProperty performanceRecallProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_PERFORMANCE_RECALL);
		performanceRecallProperty.setRange(owlModel.getXSDfloat());
		performanceRecallProperty.setDomain(performanceClass);
		OWLDatatypeProperty performanceF1ScoreProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_PERFORMANCE_F1SCORE);
		performanceF1ScoreProperty.setRange(owlModel.getXSDfloat());
		performanceF1ScoreProperty.setDomain(performanceClass);
		// model has performance
		OWLObjectProperty hasPerformanceProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_PERFORMANCE);
		hasPerformanceProperty.setDomain(performanceClass);
		hasPerformanceProperty.setRange(modelClass);
		OWLObjectProperty isPerformanceOfProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_PERFORMANCE_OF);
		isPerformanceOfProperty.setDomain(performanceClass);
		isPerformanceOfProperty.setRange(modelClass);
		isPerformanceOfProperty.setInverseProperty(isPerformanceOfProperty);
		
		// model has model type
		OWLNamedClass modelTypeClass = owlModel.createOWLNamedSubclass(Naming.CLASS_MODEL_TYPE, modelClass);
		OWLObjectProperty hasModelTypeProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_MODEL_TYPE);
		hasModelTypeProperty.setDomain(modelClass);
		hasModelTypeProperty.setRange(modelTypeClass);
		OWLObjectProperty isModelTypeOfProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_MODEL_TYPE_OF);
		isModelTypeOfProperty.setDomain(modelTypeClass);
		isModelTypeOfProperty.setRange(modelClass);
		hasModelTypeProperty.setInverseProperty(isModelTypeOfProperty);
		// has CNN type
		OWLNamedClass modelTypeCNNClass = owlModel.createOWLNamedSubclass(Naming.CLASS_MODEL_TYPE_CNN, modelTypeClass);
		OWLDatatypeProperty modelTypeCNNNameProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_CNN_TYPE_NAME);
		modelTypeCNNNameProperty.setRange(owlModel.getXSDstring());
		modelTypeCNNNameProperty.setDomain(modelTypeCNNClass);
		OWLObjectProperty hasCNNTypeProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_CNN_TYPE);
		hasCNNTypeProperty.setDomain(modelTypeClass);
		hasCNNTypeProperty.setRange(modelTypeCNNClass);
		OWLObjectProperty isCNNTypeOfProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_CNN_TYPE_OF);
		isCNNTypeOfProperty.setDomain(modelTypeClass);
		isCNNTypeOfProperty.setRange(modelTypeCNNClass);
		hasCNNTypeProperty.setInverseProperty(isCNNTypeOfProperty);
		// has RNN type
		OWLNamedClass modelTypeRNNClass = owlModel.createOWLNamedSubclass(Naming.CLASS_MODEL_TYPE_RNN, modelTypeClass);
		OWLDatatypeProperty modelTypeRNNNameProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_RNN_TYPE_NAME);
		modelTypeRNNNameProperty.setRange(owlModel.getXSDstring());
		modelTypeRNNNameProperty.setDomain(modelTypeRNNClass);
		OWLObjectProperty hasRNNTypeProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_RNN_TYPE);
		hasRNNTypeProperty.setDomain(modelTypeClass);
		hasRNNTypeProperty.setRange(modelTypeRNNClass);
		OWLObjectProperty isRNNTypeOfProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_RNN_TYPE_OF);
		isRNNTypeOfProperty.setDomain(modelTypeClass);
		isRNNTypeOfProperty.setRange(modelTypeRNNClass);
		hasRNNTypeProperty.setInverseProperty(isRNNTypeOfProperty);
		
		// model layer
		OWLNamedClass modelLayerClass = owlModel.createOWLNamedSubclass(Naming.CLASS_MODEL_LAYER, modelClass);
		// layer name
		OWLDatatypeProperty layerNameProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_MODEL_LAYER_NAME);
		layerNameProperty.setRange(owlModel.getXSDstring());
		layerNameProperty.setDomain(modelLayerClass);
		// model has layer
		OWLObjectProperty hasLayerProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_LAYER);
		hasLayerProperty.setDomain(modelClass);
		hasLayerProperty.setRange(modelLayerClass);
		OWLObjectProperty isLayerOfProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_LAYER_OF);
		isLayerOfProperty.setDomain(modelLayerClass);
		isLayerOfProperty.setRange(modelClass);
		hasLayerProperty.setInverseProperty(isLayerOfProperty);
		// layer has previous layer
		OWLObjectProperty hasPreviousLayerProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_PREVIOUS_LAYER);
		hasPreviousLayerProperty.setDomain(modelLayerClass);
		hasPreviousLayerProperty.setRange(modelLayerClass);
		OWLObjectProperty isPreviousLayerOfProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_PREVIOUS_LAYER_OF);
		isPreviousLayerOfProperty.setDomain(modelLayerClass);
		isPreviousLayerOfProperty.setRange(modelLayerClass);
		hasPreviousLayerProperty.setInverseProperty(isPreviousLayerOfProperty);
		
		// subclass of model layer
		
		// functional layer
		OWLNamedClass functionalLayerClass = owlModel.createOWLNamedSubclass(Naming.CLASS_FUNCTIONAL_LAYER, modelLayerClass);
		// has functional layer
		OWLObjectProperty hasFunctionalLayerProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_FUNCTIONAL_LAYER);
		hasFunctionalLayerProperty.setDomain(modelLayerClass);
		hasFunctionalLayerProperty.setRange(functionalLayerClass);
		OWLObjectProperty isFunctionalLayerOfProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_FUNCTIONAL_LAYER_OF);
		isFunctionalLayerOfProperty.setDomain(functionalLayerClass);
		isFunctionalLayerOfProperty.setRange(modelLayerClass);
		hasFunctionalLayerProperty.setInverseProperty(isFunctionalLayerOfProperty);
		
		// pooling layer
		OWLNamedClass poolingLayerClass = owlModel.createOWLNamedSubclass(Naming.CLASS_POOLING_LAYER, functionalLayerClass);
		// pooling rank
		OWLDatatypeProperty poolingRankProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_POOLING_RANK);
		poolingRankProperty.setRange(owlModel.getXSDint());
		poolingRankProperty.setDomain(poolingLayerClass);
		// pooling type
		OWLDatatypeProperty poolingTypeProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_POOLING_TYPE);
		poolingTypeProperty.setRange(owlModel.getXSDstring());
		poolingTypeProperty.setDomain(poolingLayerClass);
		// pooling kernel size = pool size
		OWLDatatypeProperty poolingKernelSizeProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_POOLING_KERNEL_SIZE);
		poolingKernelSizeProperty.setRange(owlModel.getXSDstring());
		poolingKernelSizeProperty.setDomain(poolingLayerClass);
		OWLDatatypeProperty poolingPoolSizeProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_POOLING_POOL_SIZE);
		poolingPoolSizeProperty.setRange(owlModel.getXSDstring());
		poolingPoolSizeProperty.setDomain(poolingLayerClass);
		poolingKernelSizeProperty.addEquivalentProperty(poolingPoolSizeProperty);
		// pooling strides
		OWLDatatypeProperty poolingStridesProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_POOLING_STRIDES);
		poolingStridesProperty.setRange(owlModel.getXSDstring());
		poolingStridesProperty.setDomain(poolingLayerClass);
		// pooling padding
		OWLDatatypeProperty poolingPaddingProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_POOLING_PADDING);
		poolingPaddingProperty.setRange(owlModel.getXSDstring());
		poolingPaddingProperty.setDomain(poolingLayerClass);
		// pooling dilation
		OWLDatatypeProperty poolingDilationProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_POOLING_DILATION);
		poolingDilationProperty.setRange(owlModel.getXSDstring());
		poolingDilationProperty.setDomain(poolingLayerClass);
		// has pooling layer
		OWLObjectProperty hasPoolingLayerProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_POOLING_LAYER);
		hasPoolingLayerProperty.setDomain(functionalLayerClass);
		hasPoolingLayerProperty.setRange(poolingLayerClass);
		OWLObjectProperty isPoolingLayerOfProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_POOLING_LAYER_OF);
		isPoolingLayerOfProperty.setDomain(poolingLayerClass);
		isPoolingLayerOfProperty.setRange(functionalLayerClass);
		hasPoolingLayerProperty.setInverseProperty(isPoolingLayerOfProperty);
		
		// reshaping layer
		OWLNamedClass reshapingLayerClass = owlModel.createOWLNamedSubclass(Naming.CLASS_RESHAPING_LAYER, functionalLayerClass);
		// reshaping rank
		OWLDatatypeProperty reshapingRankProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_RESHAPING_RANK);
		reshapingRankProperty.setRange(owlModel.getXSDint());
		reshapingRankProperty.setDomain(reshapingLayerClass);
		// reshaping type
		OWLDatatypeProperty reshapingTypeProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_RESHAPING_TYPE);
		reshapingTypeProperty.setRange(owlModel.getXSDstring());
		reshapingTypeProperty.setDomain(reshapingLayerClass);
		// reshaping target shape
		OWLDatatypeProperty reshapingTargetShapeProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_RESHAPING_TARGET_SHAPE);
		reshapingTargetShapeProperty.setRange(owlModel.getXSDstring());
		reshapingTargetShapeProperty.setDomain(reshapingLayerClass);
		// has reshaping layer
		OWLObjectProperty hasReshapingLayerProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_RESHAPING_LAYER);
		hasReshapingLayerProperty.setDomain(functionalLayerClass);
		hasReshapingLayerProperty.setRange(reshapingLayerClass);
		OWLObjectProperty isReshapingLayerOfProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_RESHAPING_LAYER_OF);
		isReshapingLayerOfProperty.setDomain(reshapingLayerClass);
		isReshapingLayerOfProperty.setRange(functionalLayerClass);
		hasReshapingLayerProperty.setInverseProperty(isReshapingLayerOfProperty);
		
		// dropout layer
		OWLNamedClass dropoutLayerClass = owlModel.createOWLNamedSubclass(Naming.CLASS_DROPOUT_LAYER, functionalLayerClass);
		// dropout rank
		OWLDatatypeProperty dropoutRankProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_DROPOUT_RANK);
		dropoutRankProperty.setRange(owlModel.getXSDint());
		dropoutRankProperty.setDomain(dropoutLayerClass);
		// dropout rate
		OWLDatatypeProperty dropoutRateProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_DROPOUT_RATE);
		dropoutRateProperty.setRange(owlModel.getXSDfloat());
		dropoutRateProperty.setDomain(dropoutLayerClass);
		// dropout noise shape
		OWLDatatypeProperty dropoutNoiseShapeProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_DROPOUT_NOISE_SHAPE);
		dropoutNoiseShapeProperty.setRange(owlModel.getXSDinteger());
		dropoutNoiseShapeProperty.setDomain(dropoutLayerClass);
		// dropout seed
		OWLDatatypeProperty dropoutSeedProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_DROPOUT_SEED);
		dropoutSeedProperty.setRange(owlModel.getXSDinteger());
		dropoutSeedProperty.setDomain(dropoutLayerClass);
		// has dropout layer
		OWLObjectProperty hasDropoutLayerProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_DROPOUT_LAYER);
		hasDropoutLayerProperty.setDomain(functionalLayerClass);
		hasDropoutLayerProperty.setRange(dropoutLayerClass);
		OWLObjectProperty isDropoutLayerOfProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_DROPOUT_LAYER_OF);
		isDropoutLayerOfProperty.setDomain(dropoutLayerClass);
		isDropoutLayerOfProperty.setRange(functionalLayerClass);
		hasDropoutLayerProperty.setInverseProperty(isDropoutLayerOfProperty);
		
		// subclass of model layer
		
		// core layer
		OWLNamedClass coreLayerClass = owlModel.createOWLNamedSubclass(Naming.CLASS_CORE_LAYER, modelLayerClass);
		// has core layer
		OWLObjectProperty hasCoreLayerProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_CORE_LAYER);
		hasCoreLayerProperty.setDomain(modelLayerClass);
		hasCoreLayerProperty.setRange(coreLayerClass);
		OWLObjectProperty isCoreLayerOfProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_CORE_LAYER_OF);
		isCoreLayerOfProperty.setDomain(coreLayerClass);
		isCoreLayerOfProperty.setRange(modelLayerClass);
		hasCoreLayerProperty.setInverseProperty(isCoreLayerOfProperty);
		
		// subclass of core layer
		
		// core layer type
		OWLNamedClass coreLayerTypeClass = owlModel.createOWLNamedSubclass(Naming.CLASS_CORE_LAYER_TYPE, coreLayerClass);
		OWLObjectProperty hasCoreLayerTypeProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_CORE_LAYER_TYPE);
		hasCoreLayerTypeProperty.setDomain(coreLayerClass);
		hasCoreLayerTypeProperty.setRange(coreLayerTypeClass);
		OWLObjectProperty isCoreLayerTypeOfProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_CORE_LAYER_TYPE_OF);
		isCoreLayerTypeOfProperty.setDomain(coreLayerTypeClass);
		isCoreLayerTypeOfProperty.setRange(coreLayerClass);
		hasCoreLayerTypeProperty.setInverseProperty(isCoreLayerTypeOfProperty);
		
		// subclass of core layer type
		
		// dense layer
		OWLNamedClass denseLayerClass = owlModel.createOWLNamedSubclass(Naming.CLASS_DENSE_LAYER, coreLayerTypeClass);
		// same as fully connected layer
		// OWLNamedClass fullyConnectedClass = owlModel.createOWLNamedSubclass(Naming.CLASS_FULLY_CONNECTED_LAYER, coreLayerTypeClass);
		// denseLayerClass.addEquivalentClass(fullyConnectedClass);
		// dense out features
		OWLDatatypeProperty denseOutFeaturesProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_DENSE_OUT_FEATURES);
		denseOutFeaturesProperty.setRange(owlModel.getXSDinteger());
		denseOutFeaturesProperty.setDomain(denseLayerClass);
		// same as dense units
		OWLDatatypeProperty denseUnitsProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_DENSE_UNITS);
		denseUnitsProperty.setRange(owlModel.getXSDinteger());
		denseUnitsProperty.setDomain(denseLayerClass);
		denseOutFeaturesProperty.addEquivalentProperty(denseUnitsProperty);
		// has dense layer
		OWLObjectProperty hasDenseLayerProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_DENSE_LAYER);
		hasDenseLayerProperty.setDomain(coreLayerTypeClass);
		hasDenseLayerProperty.setRange(denseLayerClass);
		OWLObjectProperty isDenseLayerOfProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_DENSE_LAYER_OF);
		isDenseLayerOfProperty.setDomain(denseLayerClass);
		isDenseLayerOfProperty.setRange(coreLayerTypeClass);
		hasDenseLayerProperty.setInverseProperty(isDenseLayerOfProperty);
		
		// convolution layer
		OWLNamedClass convolutionLayerClass = owlModel.createOWLNamedSubclass(Naming.CLASS_CONVOLUTION_LAYER, coreLayerTypeClass);
		// convolution rank
		OWLDatatypeProperty convolutionRankProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_CONVOLUTION_RANK);
		convolutionRankProperty.setRange(owlModel.getXSDint());
		convolutionRankProperty.setDomain(convolutionLayerClass);
		// convolution in channel
		// OWLDatatypeProperty convolutionInChannelsProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_CONVOLUTION_IN_CHANNELS);
		// convolutionInChannelsProperty.setRange(owlModel.getXSDint());
		// convolutionInChannelsProperty.setDomain(convolutionLayerClass);
		// convolution out channel = filters
		OWLDatatypeProperty convolutionOutputChannelsProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_CONVOLUTION_OUT_CHANNELS);
		convolutionOutputChannelsProperty.setRange(owlModel.getXSDint());
		convolutionOutputChannelsProperty.setDomain(convolutionLayerClass);
		OWLDatatypeProperty convolutionFiltersProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_CONVOLUTION_FILTERS);
		convolutionFiltersProperty.setRange(owlModel.getXSDint());
		convolutionFiltersProperty.setDomain(convolutionLayerClass);
		convolutionOutputChannelsProperty.addEquivalentProperty(convolutionFiltersProperty);
		// convolution kernel size
		OWLDatatypeProperty convolutionKernelSizeProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_CONVOLUTION_KERNEL_SIZE);
		convolutionKernelSizeProperty.setRange(owlModel.getXSDstring());
		convolutionKernelSizeProperty.setDomain(convolutionLayerClass);
		// convolution strides
		OWLDatatypeProperty convolutionStridesProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_CONVOLUTION_STRIDES);
		convolutionStridesProperty.setRange(owlModel.getXSDstring());
		convolutionStridesProperty.setDomain(convolutionLayerClass);
		// convolution padding
		OWLDatatypeProperty convolutionPaddingProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_CONVOLUTION_PADDING);
		convolutionPaddingProperty.setRange(owlModel.getXSDstring());
		convolutionPaddingProperty.setDomain(convolutionLayerClass);
		// convolution dilation
		OWLDatatypeProperty convolutionDilationProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_CONVOLUTION_DILATION);
		convolutionDilationProperty.setRange(owlModel.getXSDstring());
		convolutionDilationProperty.setDomain(convolutionLayerClass);
		// convolution groups
		OWLDatatypeProperty convolutionGroupsProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_CONVOLUTION_GROUPS);
		convolutionGroupsProperty.setRange(owlModel.getXSDint());
		convolutionGroupsProperty.setDomain(convolutionLayerClass);
		// has convolution layer
		OWLObjectProperty hasConvolutionLayerProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_CONVOLUTION_LAYER);
		hasConvolutionLayerProperty.setDomain(coreLayerTypeClass);
		hasConvolutionLayerProperty.setRange(convolutionLayerClass);
		OWLObjectProperty isConvolutionLayerOfProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_CONVOLUTION_LAYER_OF);
		isConvolutionLayerOfProperty.setDomain(convolutionLayerClass);
		isConvolutionLayerOfProperty.setRange(coreLayerTypeClass);
		hasConvolutionLayerProperty.setInverseProperty(isConvolutionLayerOfProperty);
		
		// recurrent layer
		OWLNamedClass recurrentLayerClass = owlModel.createOWLNamedSubclass(Naming.CLASS_RECURRENT_LAYER, coreLayerTypeClass);
		// recurrent return sequence
		OWLDatatypeProperty recurrentReturnSequenceProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_RECURRENT_RETURN_SEQUENCE);
		recurrentReturnSequenceProperty.setRange(owlModel.getXSDboolean());
		recurrentReturnSequenceProperty.setDomain(recurrentLayerClass);
		// recurrent return state
		OWLDatatypeProperty recurrentReturnStateProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_RECURRENT_RETURN_STATE);
		recurrentReturnStateProperty.setRange(owlModel.getXSDboolean());
		recurrentReturnStateProperty.setDomain(recurrentLayerClass);
		// recurrent go backwards
		OWLDatatypeProperty recurrentGoBackwardsProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_RECURRENT_GOBACKWARDS);
		recurrentGoBackwardsProperty.setRange(owlModel.getXSDboolean());
		recurrentGoBackwardsProperty.setDomain(recurrentLayerClass);
		// recurrent stateful
		OWLDatatypeProperty recurrentStatefulProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_RECURRENT_STATEFUL);
		recurrentStatefulProperty.setRange(owlModel.getXSDboolean());
		recurrentStatefulProperty.setDomain(recurrentLayerClass);
		// recurrent time major
		OWLDatatypeProperty recurrentTimeMajorProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_RECURRENT_TIME_MAJOR);
		recurrentTimeMajorProperty.setRange(owlModel.getXSDboolean());
		recurrentTimeMajorProperty.setDomain(recurrentLayerClass);
		// recurrent unroll
		OWLDatatypeProperty recurrentUnrollProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_RECURRENT_UNROLL);
		recurrentUnrollProperty.setRange(owlModel.getXSDboolean());
		recurrentUnrollProperty.setDomain(recurrentLayerClass);
		// recurrent unit forget bias
		OWLDatatypeProperty recurrentUnitForgetBiasProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_RECURRENT_UNIT_FORGET_BIAS);
		recurrentUnitForgetBiasProperty.setRange(owlModel.getXSDboolean());
		recurrentUnitForgetBiasProperty.setDomain(recurrentLayerClass);
		// recurrent units
		OWLDatatypeProperty recurrentUnitsProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_RECURRENT_UNITS);
		recurrentUnitsProperty.setRange(owlModel.getXSDinteger());
		recurrentUnitsProperty.setDomain(recurrentLayerClass);
		// recurrent implementation
		OWLDatatypeProperty recurrentImplementationProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_RECURRENT_IMPLEMENTTATION);
		recurrentImplementationProperty.setRange(owlModel.getXSDinteger());
		recurrentImplementationProperty.setDomain(recurrentLayerClass);
		// recurrent dropout
		OWLDatatypeProperty recurrentDropoutProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_RECURRENT_DROPOUT);
		recurrentDropoutProperty.setRange(owlModel.getXSDfloat());
		recurrentDropoutProperty.setDomain(recurrentLayerClass);
		// recurrent recurrent dropout
		OWLDatatypeProperty recurrentRecurrentDropoutProperty = owlModel.createOWLDatatypeProperty(Naming.DATA_PROPERTY_RECURRENT_RECURRENT_DROPOUT);
		recurrentRecurrentDropoutProperty.setRange(owlModel.getXSDfloat());
		recurrentRecurrentDropoutProperty.setDomain(recurrentLayerClass);
		// has recurrent layer
		OWLObjectProperty hasRecurrentLayerProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_RECURRENT_LAYER);
		hasRecurrentLayerProperty.setDomain(coreLayerTypeClass);
		hasRecurrentLayerProperty.setRange(recurrentLayerClass);
		OWLObjectProperty isRecurrentLayerOfProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_RECURRENT_LAYER_OF);
		isRecurrentLayerOfProperty.setDomain(recurrentLayerClass);
		isRecurrentLayerOfProperty.setRange(coreLayerTypeClass);
		hasRecurrentLayerProperty.setInverseProperty(isRecurrentLayerOfProperty);
		
		// activation function: class
		OWLNamedClass activationFunctionClass = owlModel.createOWLNamedSubclass(Naming.CLASS_ACTIVATION_FUNCTION, coreLayerClass);
		// activation function: individual
		RDFIndividual reluIndividual = activationFunctionClass.createRDFIndividual("relu");
		RDFIndividual sigmoidIndividual = activationFunctionClass.createRDFIndividual("sigmoid");
		RDFIndividual softmaxIndividual = activationFunctionClass.createRDFIndividual("softmax");
		RDFIndividual softplusIndividual = activationFunctionClass.createRDFIndividual("softplus");
		RDFIndividual softsignIndividual = activationFunctionClass.createRDFIndividual("softsign");
		RDFIndividual tanhIndividual = activationFunctionClass.createRDFIndividual("tanh");
		RDFIndividual seluIndividual = activationFunctionClass.createRDFIndividual("selu");
		RDFIndividual eluIndividual = activationFunctionClass.createRDFIndividual("elu");
		RDFIndividual exponentialIndividual = activationFunctionClass.createRDFIndividual("exponential");
		// Set as enumerated classes
		OWLEnumeratedClass enActivationFunction = owlModel.createOWLEnumeratedClass();
		enActivationFunction.addOneOf(reluIndividual); 
		enActivationFunction.addOneOf(sigmoidIndividual);
		enActivationFunction.addOneOf(softmaxIndividual); 
		enActivationFunction.addOneOf(softplusIndividual);
		enActivationFunction.addOneOf(softsignIndividual); 
		enActivationFunction.addOneOf(tanhIndividual);
		enActivationFunction.addOneOf(seluIndividual); 
		enActivationFunction.addOneOf(eluIndividual);
		enActivationFunction.addOneOf(exponentialIndividual);
		activationFunctionClass.setDefinition(enActivationFunction);
		
		// bias
		OWLNamedClass biasClass = owlModel.createOWLNamedSubclass(Naming.CLASS_BIAS, coreLayerClass);
		// weight
		OWLNamedClass weightClass = owlModel.createOWLNamedSubclass(Naming.CLASS_WEIGHT, coreLayerClass);
		// recurrent
		OWLNamedClass recurrentClass = owlModel.createOWLNamedSubclass(Naming.CLASS_RECURRENT, recurrentLayerClass);
		// processing argument
		OWLNamedClass processingArgumentClass = owlModel.createOWLNamedClass(Naming.CLASS_PROCESSING_ARGUMENT);
		processingArgumentClass.removeSuperclass(owlModel.getOWLThingClass());
		processingArgumentClass.addSuperclass(biasClass);
		processingArgumentClass.addSuperclass(weightClass);
		processingArgumentClass.addSuperclass(recurrentClass);
		
		// initializer
		OWLNamedClass initializerClass = owlModel.createOWLNamedSubclass(Naming.CLASS_INITIALIZER, processingArgumentClass);
		// initializer: individual
		RDFIndividual randomNormalIndividual = initializerClass.createRDFIndividual("RandomNormal");
		RDFIndividual randomUniformIndividual = initializerClass.createRDFIndividual("RandomUniform");
		RDFIndividual truncatedNormalIndividual = initializerClass.createRDFIndividual("TruncatedNormal");
		RDFIndividual zerosIndividual = initializerClass.createRDFIndividual("Zeros");
		RDFIndividual onesIndividual = initializerClass.createRDFIndividual("Ones");
		RDFIndividual glorotNormalIndividual = initializerClass.createRDFIndividual("GlorotNormal");
		RDFIndividual glorotUniformIndividual = initializerClass.createRDFIndividual("GlorotUniform");
		RDFIndividual identityIndividual = initializerClass.createRDFIndividual("Identity");
		RDFIndividual orthogonalIndividual = initializerClass.createRDFIndividual("Orthogonal");
		RDFIndividual constantIndividual = initializerClass.createRDFIndividual("Constant");
		RDFIndividual varianceScalingIndividual = initializerClass.createRDFIndividual("VarianceScaling");
		// Set as enumerated classes
		OWLEnumeratedClass enInitializer = owlModel.createOWLEnumeratedClass();
		enInitializer.addOneOf(randomNormalIndividual); 
		enInitializer.addOneOf(randomUniformIndividual);
		enInitializer.addOneOf(truncatedNormalIndividual); 
		enInitializer.addOneOf(zerosIndividual);
		enInitializer.addOneOf(onesIndividual); 
		enInitializer.addOneOf(glorotNormalIndividual);
		enInitializer.addOneOf(glorotUniformIndividual); 
		enInitializer.addOneOf(identityIndividual);
		enInitializer.addOneOf(orthogonalIndividual);
		enInitializer.addOneOf(constantIndividual);
		enInitializer.addOneOf(varianceScalingIndividual);
		initializerClass.setDefinition(enInitializer);
		
		// constraint
		OWLNamedClass constraintClass = owlModel.createOWLNamedSubclass(Naming.CLASS_CONSTRAINT, processingArgumentClass);
		// constraint: individual
		RDFIndividual maxNormIndividual = constraintClass.createRDFIndividual("MaxNorm");
		RDFIndividual minMaxNormIndividual = constraintClass.createRDFIndividual("MinMaxNorm");
		RDFIndividual nonNegIndividual = constraintClass.createRDFIndividual("NonNeg");
		RDFIndividual unitNormIndividual = constraintClass.createRDFIndividual("UnitNorm");
		RDFIndividual radialConstraintIndividual = constraintClass.createRDFIndividual("RadialConstraint");
		// Set as enumerated classes
		OWLEnumeratedClass enConstraint = owlModel.createOWLEnumeratedClass();
		enConstraint.addOneOf(maxNormIndividual); 
		enConstraint.addOneOf(minMaxNormIndividual);
		enConstraint.addOneOf(nonNegIndividual); 
		enConstraint.addOneOf(unitNormIndividual);
		enConstraint.addOneOf(radialConstraintIndividual); 
		constraintClass.setDefinition(enConstraint);
		
		// regularizer
		OWLNamedClass regularizerClass = owlModel.createOWLNamedSubclass(Naming.CLASS_REGULARIZER, processingArgumentClass);
		// regularizer: individual
		RDFIndividual l1Individual = regularizerClass.createRDFIndividual("L1");
		RDFIndividual l2Individual = regularizerClass.createRDFIndividual("L2");
		RDFIndividual l1_l2Individual = regularizerClass.createRDFIndividual("L1_L2");
		// Set as enumerated classes
		OWLEnumeratedClass enRegularizer = owlModel.createOWLEnumeratedClass();
		enRegularizer.addOneOf(l1Individual); 
		enRegularizer.addOneOf(l2Individual);
		enRegularizer.addOneOf(l1_l2Individual);  
		regularizerClass.setDefinition(enRegularizer);
		
		// core layer has activation function
		OWLObjectProperty hasActivationFunctionProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_ACTIVATION_FUNCTION);
		hasActivationFunctionProperty.setDomain(coreLayerClass);
		hasActivationFunctionProperty.setRange(activationFunctionClass);
		OWLObjectProperty isActivationFunctionOfProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_ACTIVATION_FUNCTION_OF);
		isActivationFunctionOfProperty.setDomain(activationFunctionClass);
		isActivationFunctionOfProperty.setRange(coreLayerClass);
		hasActivationFunctionProperty.setInverseProperty(isActivationFunctionOfProperty);
		// core layer has weight
		OWLObjectProperty hasWeightProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_WEIGHT);
		hasWeightProperty.setDomain(coreLayerClass);
		hasWeightProperty.setRange(weightClass);
		OWLObjectProperty isWeightOfProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_WEIGHT_OF);
		isWeightOfProperty.setDomain(weightClass);
		isWeightOfProperty.setRange(coreLayerClass);
		hasWeightProperty.setInverseProperty(isWeightOfProperty);
		// core layer has bias
		OWLObjectProperty hasBiasProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_BIAS);
		hasBiasProperty.setDomain(coreLayerClass);
		hasBiasProperty.setRange(biasClass);
		OWLObjectProperty isBiasOfProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_BIAS_OF);
		isBiasOfProperty.setDomain(biasClass);
		isBiasOfProperty.setRange(coreLayerClass);
		hasBiasProperty.setInverseProperty(isBiasOfProperty);
		// recurrent layer has recurrent
		OWLObjectProperty hasRecurrentProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_RECURRENT);
		hasRecurrentProperty.setDomain(recurrentLayerClass);
		hasRecurrentProperty.setRange(recurrentClass);
		OWLObjectProperty isRecurrentOfProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_RECURRENT_OF);
		isRecurrentOfProperty.setDomain(recurrentClass);
		isRecurrentOfProperty.setRange(recurrentLayerClass);
		hasRecurrentProperty.setInverseProperty(isRecurrentOfProperty);
		// recurrent has recurrent activation function
		OWLObjectProperty hasRecurrentActivationFunctionProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_RECURRENT_ACTIVATION_FUNCTION);
		hasRecurrentActivationFunctionProperty.setDomain(recurrentClass);
		hasRecurrentActivationFunctionProperty.setRange(activationFunctionClass);
		OWLObjectProperty isRecurrentActivationFunctionOfProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_RECURRENT_ACTIVATION_FUNCTION_OF);
		isRecurrentActivationFunctionOfProperty.setDomain(activationFunctionClass);
		isRecurrentActivationFunctionOfProperty.setRange(recurrentClass);
		hasRecurrentActivationFunctionProperty.setInverseProperty(isRecurrentActivationFunctionOfProperty);
		
		// weight,bias,recurrent argument has processing argument
		OWLObjectProperty hasProcessingArgumentProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_PROCESSING_ARGUMENT);
		hasProcessingArgumentProperty.addUnionDomainClass(weightClass);
		hasProcessingArgumentProperty.addUnionDomainClass(biasClass);
		hasProcessingArgumentProperty.addUnionDomainClass(recurrentClass);
		hasProcessingArgumentProperty.setRange(processingArgumentClass);
		OWLObjectProperty isProcessingArgumentOfProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_PROCESSING_ARGUMENT_OF);
		isProcessingArgumentOfProperty.addUnionRangeClass(weightClass);
		isProcessingArgumentOfProperty.addUnionRangeClass(biasClass);
		isProcessingArgumentOfProperty.addUnionRangeClass(recurrentClass);
		isProcessingArgumentOfProperty.setDomain(processingArgumentClass);
		
		// processing argument argument has initializer
		OWLObjectProperty hasInitializerProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_INITIALIZER);
		hasInitializerProperty.setDomain(processingArgumentClass);
		hasInitializerProperty.setRange(initializerClass);
		OWLObjectProperty isInitializerOfProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_INITIALIZER_OF);
		isInitializerOfProperty.setRange(processingArgumentClass);
		isInitializerOfProperty.setDomain(initializerClass);
		
		// processing argument has constraint
		OWLObjectProperty hasConstraintProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_CONSTRAINT);
		hasConstraintProperty.setDomain(processingArgumentClass);
		hasInitializerProperty.setRange(constraintClass);
		OWLObjectProperty isConstraintOfProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_CONSTRAINT_OF);
		isConstraintOfProperty.setRange(processingArgumentClass);
		isConstraintOfProperty.setDomain(constraintClass);
		
		// processing argument has regularizer
		OWLObjectProperty hasRegularizerProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_REGULARIZER);
		hasRegularizerProperty.setDomain(processingArgumentClass);
		hasRegularizerProperty.setRange(regularizerClass);
		OWLObjectProperty isRegularizerOfProperty = owlModel.createOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_REGULARIZER_OF);
		isRegularizerOfProperty.setRange(processingArgumentClass);
		isRegularizerOfProperty.setDomain(constraintClass);
		
		// store to file
		try {
			File file = new File(Naming.CREATE_OWL_PATH);
			file.createNewFile();
			OutputStream out = new FileOutputStream(file);
			Jena.dumpRDF(((JenaOWLModel) owlModel).getOntModel(), out);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// print class hierarchy 
		Collection classes = owlModel.getUserDefinedOWLNamedClasses();
		for (Iterator it = classes.iterator(); it.hasNext();) {
		    OWLNamedClass cls = (OWLNamedClass) it.next();
		    Collection instances = cls.getInstances(false);
		    System.out.println("Class " + cls.getBrowserText() + " (" + instances.size() + ")");
		    for (Iterator jt = instances.iterator(); jt.hasNext();) {
		        OWLIndividual individual = (OWLIndividual) jt.next();
		        System.out.println(" - " + individual.getBrowserText());
		    }
		}
	}
	
	
}