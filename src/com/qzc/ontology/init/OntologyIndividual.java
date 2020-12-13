package com.qzc.ontology.init;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.qzc.util.UUIDUtil;

import edu.stanford.smi.protegex.owl.ProtegeOWL;
import edu.stanford.smi.protegex.owl.jena.Jena;
import edu.stanford.smi.protegex.owl.jena.JenaOWLModel;
import edu.stanford.smi.protegex.owl.model.OWLDatatypeProperty;
import edu.stanford.smi.protegex.owl.model.OWLNamedClass;
import edu.stanford.smi.protegex.owl.model.OWLObjectProperty;
import edu.stanford.smi.protegex.owl.model.RDFIndividual;

public class OntologyIndividual {
	
	JenaOWLModel owlModel;
	
	// application
	OWLNamedClass applicationClass;
	// application name
	OWLDatatypeProperty applicationNameProperty;
	// has application domain
	// OWLNamedClass applicationDomainClass;
	// OWLObjectProperty hasApplicationDomainProperty;
	// OWLObjectProperty isApplicationDomainOfProperty;
	// healthcare application
	OWLNamedClass applicationHealthcareClass;
	// healthcare application name
	OWLDatatypeProperty applicationHealthcareNameProperty;
	// has healthcare application
	OWLObjectProperty hasHealthcareApplicationProperty;
	OWLObjectProperty isHealthcareApplicationOfProperty;
	
	// skin cancer
	OWLNamedClass skinCancerClass;
	OWLDatatypeProperty skinCancerNameProperty;
	// has skin cancer
	OWLObjectProperty hasSkinCancerProperty;
	OWLObjectProperty isSkinCancerOfProperty;
	
	// musculoskeletal disorder
	OWLNamedClass musculoskeletalDisorderClass;
	OWLDatatypeProperty musculoskeletalDisorderNameProperty;
	// has musculoskeletal disorder
	OWLObjectProperty hasMusculoskeletalDisorderProperty;
	OWLObjectProperty isMusculoskeletalDisorderOfProperty;

	// data
	OWLNamedClass dataClass;
	// data name
	OWLDatatypeProperty dataNameProperty;
	// data feature
	OWLDatatypeProperty dataFeatureProperty;
	// data description
	OWLDatatypeProperty dataDescriptionProperty;
	// data resource
	OWLDatatypeProperty dataResourceProperty;
	// has data type
	OWLObjectProperty hasSensoryTypeProperty;
	OWLObjectProperty isSensoryTypeOfProperty;
	OWLNamedClass sensoryTypeClass;
	// accelerometer
	OWLNamedClass sensoryTypeAccelerometerClass;
	// accelerometer data name
	OWLDatatypeProperty accelerometerNameProperty;
	// has accelerometer data
	OWLObjectProperty hasAccelerometerProperty;
	OWLObjectProperty isAccelerometerOfProperty;
	// gyroscope data
	OWLNamedClass sensoryTypeGyroscopeClass;
	// gyroscope data name
	OWLDatatypeProperty gyroscopeNameProperty;
	// has gyroscope data
	OWLObjectProperty hasGyroscopeProperty;
	OWLObjectProperty isGyroscopeOfProperty;
	
	
	// model
	OWLNamedClass modelClass;
	// model name
	OWLDatatypeProperty modelNameProperty;
	// model description
	OWLDatatypeProperty modelDescriptionProperty;
	// model resource
	OWLDatatypeProperty modelResourceProperty;
	
	// application has data
	OWLObjectProperty hasDataProperty;
	OWLObjectProperty isDataOfProperty;
	// application has model
	OWLObjectProperty hasModelProperty;
	OWLObjectProperty isModelOfProperty;
	
	// subclass of model
	
	// performance
	OWLNamedClass performanceClass;
	// performance accuracy
	OWLDatatypeProperty performanceAccuracyProperty;
	// performance precision
	OWLDatatypeProperty performancePrecisionProperty;
	// performance recall
	OWLDatatypeProperty performanceRecallProperty;
	//performance F1score
	OWLDatatypeProperty performanceF1ScoreProperty;
	// model has performance
	OWLObjectProperty hasPerformanceProperty;
	OWLObjectProperty isPerformanceOfProperty;
	
	// model type
	OWLNamedClass modelTypeClass;
	// model has model type
	OWLObjectProperty hasModelTypeProperty;
	OWLObjectProperty isModelTypeOfProperty;
	// CNN type
	OWLNamedClass modelTypeCNNClass;
	// CNN type name
	OWLDatatypeProperty modelTypeCNNNameProperty;
	// model type has CNN
	OWLObjectProperty hasCNNTypeProperty;
	OWLObjectProperty isCNNTypeOfProperty;
	// RNN type
	OWLNamedClass modelTypeRNNClass;
	// RNN type name
	OWLDatatypeProperty modelTypeRNNNameProperty;
	// model type has RNN
	OWLObjectProperty hasRNNTypeProperty;
	OWLObjectProperty isRNNTypeOfProperty;
	
	// model layer
	OWLNamedClass modelLayerClass;
	// layer name
	OWLDatatypeProperty layerNameProperty;
	// model has model layer
	OWLObjectProperty hasLayerProperty;
	OWLObjectProperty isLayerOfProperty;
	// layer has previous layer
	OWLObjectProperty hasPreviousLayerProperty;
	OWLObjectProperty isPreviousLayerOfProperty;
	
	// functional layer
	OWLNamedClass functionalLayerClass;
	// model layer has functional layer
	OWLObjectProperty hasFunctionalLayerProperty;
	OWLObjectProperty isFunctionalLayerOfProperty;
	
	// pooling layer
	OWLNamedClass poolingLayerClass;
	// pooling rank
	OWLDatatypeProperty poolingRankProperty;
	// pooling data format
	OWLDatatypeProperty poolingTypeProperty;
	// pooling pool size
	OWLDatatypeProperty poolingKernelSizeProperty;
	OWLDatatypeProperty poolingPoolSizeProperty;
	// pooling strides
	OWLDatatypeProperty poolingStridesProperty;
	// pooling padding
	OWLDatatypeProperty poolingPaddingProperty;
	// pooling padding
	OWLDatatypeProperty poolingDilationProperty;
	// has pooling layer
	OWLObjectProperty hasPoolingLayerProperty;
	OWLObjectProperty isPoolingLayerOfProperty;
	
	// reshaping layer
	OWLNamedClass reshapingLayerClass;
	// reshaping rank
	OWLDatatypeProperty reshapingRankProperty;
	// reshaping type
	OWLDatatypeProperty reshapingTypeProperty;
	// reshaping target shape
	OWLDatatypeProperty reshapingTargetShapeProperty;
	// has reshaping layer
	OWLObjectProperty hasReshapingLayerProperty;
	OWLObjectProperty isReshapingLayerOfProperty;
	
	// dropout layer
	OWLNamedClass dropoutLayerClass;
	// dropout layer: data property
	// dropout rank
	OWLDatatypeProperty dropoutRankProperty;
	// dropout rate
	OWLDatatypeProperty dropoutRateProperty;
	// dropout noise shape
	OWLDatatypeProperty dropoutNoiseShapeProperty;
	// dropout seed
	OWLDatatypeProperty dropoutSeedProperty;
	// has dropout layer
	OWLObjectProperty hasDropoutLayerProperty;
	OWLObjectProperty isDropoutLayerOfProperty;
	
	// core layer
	OWLNamedClass coreLayerClass;
	// model layer has core layer
	OWLObjectProperty hasCoreLayerProperty;
	OWLObjectProperty isCoreLayerOfProperty;
	
	// core layer type
	OWLNamedClass coreLayerTypeClass;
	// has core layer type
	OWLObjectProperty hasCoreLayerTypeProperty;
	OWLObjectProperty isCoreLayerTypeOfProperty;
	
	// dense layer
	OWLNamedClass denseLayerClass;
	// dense out features = units
	OWLDatatypeProperty denseOutFeaturesProperty;
	// dense units
	OWLDatatypeProperty denseUnitsProperty;
	// has dense layer
	OWLObjectProperty hasDenseLayerProperty;
	OWLObjectProperty isDenseLayerOfProperty;
	
	// convolution layer
	OWLNamedClass convolutionLayerClass;
	// convolution rank
	OWLDatatypeProperty convolutionRankProperty;
	// convolution out channel = filters
	OWLDatatypeProperty convolutionOutputChannelsProperty;
	// convolution filters
	OWLDatatypeProperty convolutionFiltersProperty;
	// convolution kernel size
	OWLDatatypeProperty convolutionKernelSizeProperty;
	// convolution strides
	OWLDatatypeProperty convolutionStridesProperty;
	// convolution padding
	OWLDatatypeProperty convolutionPaddingProperty;
	// convolution dilation
	OWLDatatypeProperty convolutionDilationProperty;
	// convolution groups
	OWLDatatypeProperty convolutionGroupsProperty;
	// has convolution layer
	OWLObjectProperty hasConvolutionLayerProperty;
	OWLObjectProperty isConvolutionLayerOfProperty;
	
	// recurrent layer
	OWLNamedClass recurrentLayerClass;
	// recurrent return sequence
	OWLDatatypeProperty recurrentReturnSequenceProperty;
	// recurrent return state
	OWLDatatypeProperty recurrentReturnStateProperty;
	// recurrent go backwards
	OWLDatatypeProperty recurrentGoBackwardsProperty;
	// recurrent stateful
	OWLDatatypeProperty recurrentStatefulProperty;
	// recurrent time major
	OWLDatatypeProperty recurrentTimeMajorProperty;
	// recurrent unroll
	OWLDatatypeProperty recurrentUnrollProperty;
	// recurrent unit forget bias
	OWLDatatypeProperty recurrentUnitForgetBiasProperty;
	// recurrent units
	OWLDatatypeProperty recurrentUnitsProperty;
	// recurrent implementation
	OWLDatatypeProperty recurrentImplementationProperty;
	// recurrent dropout
	OWLDatatypeProperty recurrentDropoutProperty;
	// recurrent recurrent dropout
	OWLDatatypeProperty recurrentRecurrentDropoutProperty;
	// has recurrent layer
	OWLObjectProperty hasRecurrentLayerProperty;
	OWLObjectProperty isRecurrentLayerOfProperty;
	
	
	// bias
	OWLNamedClass biasClass;
	// core layer has bias
	OWLObjectProperty hasBiasProperty;
	OWLObjectProperty isBiasOfProperty;
	
	// weight
	OWLNamedClass weightClass;
	// core layer has weight
	OWLObjectProperty hasWeightProperty;
	OWLObjectProperty isWeightOfProperty;
	
	// recurrent
	OWLNamedClass recurrentClass;
	// recurrent layer has recurrent
	OWLObjectProperty hasRecurrentProperty;
	OWLObjectProperty isRecurrentOfProperty;
	
	// processing argument
	OWLNamedClass processingArgumentClass;
	OWLObjectProperty hasProcessingArgumentProperty;
	OWLObjectProperty isProcessingArgumentOfProperty;
	
	// activation function
	OWLNamedClass activationFunctionClass;
	// core layer has activation function
	OWLObjectProperty hasActivationFunctionProperty;
	OWLObjectProperty isActivationFunctionOfProperty;
	// recurrent has recurrent activation function
	OWLObjectProperty hasRecurrentActivationFunctionProperty;
	OWLObjectProperty isRecurrentActivationFunctionOfProperty;
	
	// initializer
	OWLNamedClass initializerClass;
	// processing argument has initializer
	OWLObjectProperty hasInitializerProperty;
	OWLObjectProperty isInitializerOfProperty;
	
	// constraint
	OWLNamedClass constraintClass;
	// processing argument has constraint
	OWLObjectProperty hasConstraintProperty;
	OWLObjectProperty isConstraintOfProperty;
	
	// regularizer
	OWLNamedClass regularizerClass;
	// processing argument has regularizer
	OWLObjectProperty hasRegularizerProperty;
	OWLObjectProperty isRegularizerOfProperty;
	
	
	public OntologyIndividual() {
		
		/**
		 * load owl
		 */
		
		owlModel = loadOWL();
		
		/**
		 * get naming
		 */
		
		// application
		applicationClass = owlModel.getOWLNamedClass(Naming.CLASS_APPLICATION);
		// application name
		applicationNameProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_APPLICATION_NAME);
		
		// application has application domain
		// hasApplicationDomainProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_APPLICATION_DOMAIN);
		// isApplicationDomainOfProperty = owlModel.getOWLObjectProperty (Naming.OBJECT_PROPERTY_IS_APPLICATION_DOMAIN_OF);
		// applicationDomainClass = owlModel.getOWLNamedClass(Naming.CLASS_APPLICATION_DOMAIN);
		
		// application has healthcare application
		hasHealthcareApplicationProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_HEALTHCARE_APPLICATION);
		isHealthcareApplicationOfProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_HEALTHCARE_APPLICATION_OF);
		applicationHealthcareClass = owlModel.getOWLNamedClass(Naming.CLASS_APPLICATION_DOMAIN_HEALTHCARE);
		applicationHealthcareNameProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_DOMAIN_HEALTHCARE_NAME);
		
		// skin cancer
		skinCancerClass = owlModel.getOWLNamedClass(Naming.CLASS_SKIN_CANCER);
		skinCancerNameProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_SKIN_CANCER_NAME);
		// has skin cancer
		hasSkinCancerProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_SKIN_CANCER);
		isSkinCancerOfProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_SKIN_CANCER_OF);
		
		// musculoskeletal disorder
		musculoskeletalDisorderClass = owlModel.getOWLNamedClass(Naming.CLASS_MUSCULOSKELETAL_DISORDER);
		musculoskeletalDisorderNameProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_MUSCULOSKELETAL_DISORDER_NAME);
		// has musculoskeletal disorder
		hasMusculoskeletalDisorderProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_MUSCULOSKELETAL_DISORDER);
		isMusculoskeletalDisorderOfProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_MUSCULOSKELETAL_DISORDER_OF);
		
		// data
		dataClass = owlModel.getOWLNamedClass(Naming.CLASS_DATA);
		// data name
		dataNameProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_DATA_NAME);
		// data feature
		dataFeatureProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_DATA_FEATURE);
		// data description
		dataDescriptionProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_DATA_DESCRIPTION);
		// data resource
		dataResourceProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_DATA_RESOURCE);
		// has sensory type
		hasSensoryTypeProperty = owlModel.getOWLObjectProperty (Naming.OBJECT_PROPERTY_HAS_SENSORY_TYPE);
		isSensoryTypeOfProperty = owlModel.getOWLObjectProperty (Naming.OBJECT_PROPERTY_HAS_SENSORY_TYPE);
		sensoryTypeClass = owlModel.getOWLNamedClass(Naming.CLASS_SENSORY_TYPE);
		// has accelerometer
		sensoryTypeAccelerometerClass = owlModel.getOWLNamedClass(Naming.CLASS_SENSORY_TYPE_ACCELEROMETER);
		accelerometerNameProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_ACCELEROMETER_NAME);
		hasAccelerometerProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_ACCELEROMETER);
		isAccelerometerOfProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_ACCELEROMETER_OF);
		// has gyroscope
		sensoryTypeGyroscopeClass = owlModel.getOWLNamedClass(Naming.CLASS_DATA_TYPE_GYROSCOPE);
		gyroscopeNameProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_GYROSCOPE_NAME);
		hasGyroscopeProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_GYROSCOPE);
		isGyroscopeOfProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_GYROSCOPE_OF);
		
		// model
		modelClass = owlModel.getOWLNamedClass(Naming.CLASS_MODEL);
		// model name
		modelNameProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_MODEL_NAME);
		// model description
		modelDescriptionProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_MODEL_DESCRIPTION);
		// model resource
		modelResourceProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_MODEL_RESOURCE);
		
		// application has data
		hasDataProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_DATA);
		isDataOfProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_DATA_OF);
		// application has model
		hasModelProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_MODEL);
		isModelOfProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_MODEL_OF);
		
		// subclass of model
		
		// performance
		performanceClass = owlModel.getOWLNamedClass(Naming.CLASS_PERFORMANCE);
		// performance accuracy
		performanceAccuracyProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_PERFORMANCE_ACCURACY);
		// performance precision
		performancePrecisionProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_PERFORMANCE_PRECISION);
		// performance recall
		performanceRecallProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_PERFORMANCE_RECALL);
		// performance F1Score
		performanceF1ScoreProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_PERFORMANCE_F1SCORE);
		// model has performance
		hasPerformanceProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_PERFORMANCE);
		isPerformanceOfProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_PERFORMANCE_OF);
		
		// model type
		modelTypeClass = owlModel.getOWLNamedClass(Naming.CLASS_MODEL_TYPE);
		// model has model type
		hasModelTypeProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_MODEL_TYPE);
		isModelTypeOfProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_MODEL_TYPE_OF);
		// has CNN type
		modelTypeCNNClass = owlModel.getOWLNamedClass(Naming.CLASS_MODEL_TYPE_CNN);
		modelTypeCNNNameProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_CNN_TYPE_NAME);
		hasCNNTypeProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_CNN_TYPE);
		isCNNTypeOfProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_CNN_TYPE_OF);
		// has RNN type
		modelTypeRNNClass = owlModel.getOWLNamedClass(Naming.CLASS_MODEL_TYPE_RNN);
		modelTypeRNNNameProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_RNN_TYPE_NAME);
		hasRNNTypeProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_RNN_TYPE);
		isRNNTypeOfProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_RNN_TYPE_OF);
		
		// model layer
		modelLayerClass = owlModel.getOWLNamedClass(Naming.CLASS_MODEL_LAYER);
		// layer name
		layerNameProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_MODEL_LAYER_NAME);
		// model has layer
		hasLayerProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_LAYER);
		isLayerOfProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_LAYER_OF);
		// layer has previous layer
		hasPreviousLayerProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_PREVIOUS_LAYER);
		isPreviousLayerOfProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_PREVIOUS_LAYER_OF);

		// subclass of model layer
		
		// functional layer
		functionalLayerClass = owlModel.getOWLNamedClass(Naming.CLASS_FUNCTIONAL_LAYER);
		// has functional layer
		hasFunctionalLayerProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_FUNCTIONAL_LAYER);
		isFunctionalLayerOfProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_FUNCTIONAL_LAYER_OF);
		
		// pooling layer
		poolingLayerClass = owlModel.getOWLNamedClass(Naming.CLASS_POOLING_LAYER);
		// pooling layer: data property
		// pooling rank
		poolingRankProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_POOLING_RANK);
		// pooling data format
		poolingTypeProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_POOLING_TYPE);
		// pooling pool size
		poolingKernelSizeProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_POOLING_KERNEL_SIZE);
		poolingPoolSizeProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_POOLING_POOL_SIZE);
		// pooling strides
		poolingStridesProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_POOLING_STRIDES);
		// pooling padding
		poolingPaddingProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_POOLING_PADDING);
		// pooling padding
		poolingDilationProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_POOLING_DILATION);
		// has pooling layer
		hasPoolingLayerProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_POOLING_LAYER);
		isPoolingLayerOfProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_POOLING_LAYER_OF);
		
		// reshaping layer
		reshapingLayerClass = owlModel.getOWLNamedClass(Naming.CLASS_RESHAPING_LAYER);
		// reshaping rank
		reshapingRankProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_RESHAPING_RANK);
		// reshaping type
		reshapingTypeProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_RESHAPING_TYPE);
		// reshaping target shape
		reshapingTargetShapeProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_RESHAPING_TARGET_SHAPE);
		// has reshaping layer
		hasReshapingLayerProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_RESHAPING_LAYER);
		isReshapingLayerOfProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_RESHAPING_LAYER_OF);

		// dropout layer
		dropoutLayerClass = owlModel.getOWLNamedClass(Naming.CLASS_DROPOUT_LAYER);
		// dropout layer: data property
		// dropout rank
		dropoutRankProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_DROPOUT_RANK);
		// dropout rate
		dropoutRateProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_DROPOUT_RATE);
		// dropout noise shape
		dropoutNoiseShapeProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_DROPOUT_NOISE_SHAPE);
		// dropout seed
		dropoutSeedProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_DROPOUT_SEED);
		// has dropout layer
		hasDropoutLayerProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_DROPOUT_LAYER);
		isDropoutLayerOfProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_DROPOUT_LAYER_OF);
		
		// subclass of model layer
		
		// core layer
		coreLayerClass = owlModel.getOWLNamedClass(Naming.CLASS_CORE_LAYER);
		// has core layer
		hasCoreLayerProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_CORE_LAYER);
		isCoreLayerOfProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_CORE_LAYER_OF);
		
		// subclass of core layer
		
		// core layer type
		coreLayerTypeClass = owlModel.getOWLNamedClass(Naming.CLASS_CORE_LAYER_TYPE);
		// has core layer type
		hasCoreLayerTypeProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_CORE_LAYER_TYPE);
		isCoreLayerTypeOfProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_CORE_LAYER_TYPE_OF);

		// dense layer
		denseLayerClass = owlModel.getOWLNamedClass(Naming.CLASS_DENSE_LAYER);
		// dense out features
		denseOutFeaturesProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_DENSE_OUT_FEATURES);
		// dense units
		denseUnitsProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_DENSE_UNITS);
		// has dense layer
		hasDenseLayerProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_DENSE_LAYER);
		isDenseLayerOfProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_DENSE_LAYER_OF);
		
		// convolution layer
		convolutionLayerClass = owlModel.getOWLNamedClass(Naming.CLASS_CONVOLUTION_LAYER);
		// convolution rank
		convolutionRankProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_CONVOLUTION_RANK);
		// convolution in channel
		// OWLDatatypeProperty convolutionInChannelsProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_CONVOLUTION_IN_CHANNELS);
		// convolution out channel = filters
		convolutionOutputChannelsProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_CONVOLUTION_OUT_CHANNELS);
		convolutionFiltersProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_CONVOLUTION_FILTERS);
		// convolution kernel size
		convolutionKernelSizeProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_CONVOLUTION_KERNEL_SIZE);
		// convolution strides
		convolutionStridesProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_CONVOLUTION_STRIDES);
		// convolution padding
		convolutionPaddingProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_CONVOLUTION_PADDING);
		// convolution dilation
		convolutionDilationProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_CONVOLUTION_DILATION);
		// convolution groups
		convolutionGroupsProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_CONVOLUTION_GROUPS);
		// has convolution layer
		hasConvolutionLayerProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_CONVOLUTION_LAYER);
		isConvolutionLayerOfProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_CONVOLUTION_LAYER_OF);
		
		// recurrent layer
		recurrentLayerClass = owlModel.getOWLNamedClass(Naming.CLASS_RECURRENT_LAYER);
		// recurrent return sequence
		recurrentReturnSequenceProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_RECURRENT_RETURN_SEQUENCE);
		// recurrent return state
		recurrentReturnStateProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_RECURRENT_RETURN_STATE);
		// recurrent go backwards
		recurrentGoBackwardsProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_RECURRENT_GOBACKWARDS);
		// recurrent stateful
		recurrentStatefulProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_RECURRENT_STATEFUL);
		// recurrent time major
		recurrentTimeMajorProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_RECURRENT_TIME_MAJOR);
		// recurrent unroll
		recurrentUnrollProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_RECURRENT_UNROLL);
		// recurrent unit forget bias
		recurrentUnitForgetBiasProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_RECURRENT_UNIT_FORGET_BIAS);
		// recurrent units
		recurrentUnitsProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_RECURRENT_UNITS);
		// recurrent implementation
		recurrentImplementationProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_RECURRENT_IMPLEMENTTATION);
		// recurrent dropout
		recurrentDropoutProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_RECURRENT_DROPOUT);
		// recurrent recurrent dropout
		recurrentRecurrentDropoutProperty = owlModel.getOWLDatatypeProperty(Naming.DATA_PROPERTY_RECURRENT_RECURRENT_DROPOUT);
		// has recurrent layer
		hasRecurrentLayerProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_RECURRENT_LAYER);
		isRecurrentLayerOfProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_RECURRENT_LAYER_OF);
		
		// bias
		biasClass = owlModel.getOWLNamedClass(Naming.CLASS_BIAS);
		// core layer has bias
		hasBiasProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_BIAS);
		isBiasOfProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_BIAS_OF);
		
		// weight
		weightClass = owlModel.getOWLNamedClass(Naming.CLASS_WEIGHT);
		// core layer has weight
		hasWeightProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_WEIGHT);
		isWeightOfProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_WEIGHT_OF);
		
		// recurrent
		recurrentClass = owlModel.getOWLNamedClass(Naming.CLASS_RECURRENT);
		// recurrent layer has recurrent
		hasRecurrentProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_RECURRENT);
		isRecurrentOfProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_RECURRENT_OF);

		// activation function
		activationFunctionClass = owlModel.getOWLNamedClass(Naming.CLASS_ACTIVATION_FUNCTION);
		// core layer has activation function
		hasActivationFunctionProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_ACTIVATION_FUNCTION);
		isActivationFunctionOfProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_ACTIVATION_FUNCTION_OF);
		// recurrent has recurrent activation function
		hasRecurrentActivationFunctionProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_RECURRENT_ACTIVATION_FUNCTION);
		isRecurrentActivationFunctionOfProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_RECURRENT_ACTIVATION_FUNCTION_OF);

		// processing argument
		processingArgumentClass = owlModel.getOWLNamedClass(Naming.CLASS_PROCESSING_ARGUMENT);
		// weight,bias,recurrent argument has processing argument
		hasProcessingArgumentProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_PROCESSING_ARGUMENT);
		isProcessingArgumentOfProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_PROCESSING_ARGUMENT_OF);
		
		// initializer
		initializerClass = owlModel.getOWLNamedClass(Naming.CLASS_INITIALIZER);
		// processing argument has initializer
		hasInitializerProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_INITIALIZER);
		isInitializerOfProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_INITIALIZER_OF);
		
		// constraint
		constraintClass = owlModel.getOWLNamedClass(Naming.CLASS_CONSTRAINT);
		// processing argument has constraint
		hasConstraintProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_CONSTRAINT);
		isConstraintOfProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_CONSTRAINT_OF);
		
		// regularizer
		regularizerClass = owlModel.getOWLNamedClass(Naming.CLASS_REGULARIZER);
		// processing argument has regularizer
		hasRegularizerProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_HAS_REGULARIZER);
		isRegularizerOfProperty = owlModel.getOWLObjectProperty(Naming.OBJECT_PROPERTY_IS_REGULARIZER_OF);
		
	}
	
	// load owl
	public static JenaOWLModel loadOWL() {
		String uri = Naming.LOAD_OWL_PATH;
		JenaOWLModel owlModel = null;
		try {
			owlModel = ProtegeOWL.createJenaOWLModelFromURI(uri);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return owlModel;
	}

	// save owl
	public static void saveOWL(JenaOWLModel owlModel) {
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
	}
	
	public static void main(String[] args) {
		OntologyIndividual individual = new OntologyIndividual();
		individual.createIndividualOne();
	}
	
	public void createIndividualOne() {
		/**
		 * application scope
		 */
		// data
		RDFIndividual dataIndividual = dataClass.createOWLIndividual("data" + "-" + UUIDUtil.creatUUID());
		dataIndividual.addPropertyValue(dataNameProperty, "Human Activity Recognition Using Smartphones Data Set");
		dataIndividual.addPropertyValue(dataFeatureProperty, "walking, walking_upstairs, walking_downstairs, sitting, standing, laying");
		String dataDescription = "The experiments have been carried out with a group of 30 volunteers within an age bracket of 19-48 years. Each person performed six activities (WALKING, WALKING_UPSTAIRS, WALKING_DOWNSTAIRS, SITTING, STANDING, LAYING) wearing a smartphone (Samsung Galaxy S II) on the waist. Using its embedded accelerometer and gyroscope, we captured 3-axial linear acceleration and 3-axial angular velocity at a constant rate of 50Hz. The experiments have been video-recorded to label the data manually. The obtained dataset has been randomly partitioned into two sets, where 70% of the volunteers was selected for generating the training data and 30% the test data.\r\n" + 
				"\r\n" + 
				"The sensor signals (accelerometer and gyroscope) were pre-processed by applying noise filters and then sampled in fixed-width sliding windows of 2.56 sec and 50% overlap (128 readings/window). The sensor acceleration signal, which has gravitational and body motion components, was separated using a Butterworth low-pass filter into body acceleration and gravity. The gravitational force is assumed to have only low frequency components, therefore a filter with 0.3 Hz cutoff frequency was used. From each window, a vector of features was obtained by calculating variables from the time and frequency domain.\r\n";
		dataIndividual.addPropertyValue(dataDescriptionProperty, dataDescription);
		dataIndividual.addPropertyValue(dataResourceProperty,"http://archive.ics.uci.edu/ml/machine-learning-databases/00240/UCI HAR Dataset.zip");
		// data has data type
		RDFIndividual sensoryTypeIndividual = sensoryTypeClass.createOWLIndividual("senoryType" + "-" + UUIDUtil.creatUUID());
		dataIndividual.addPropertyValue (hasSensoryTypeProperty,sensoryTypeIndividual);
		sensoryTypeIndividual.addPropertyValue(isSensoryTypeOfProperty, dataIndividual);
		// data type has accelerometer data
		RDFIndividual accelerometerIndividual = sensoryTypeAccelerometerClass.createOWLIndividual("accelerometer" + "-" + UUIDUtil.creatUUID());
		accelerometerIndividual.addPropertyValue(accelerometerNameProperty, "Accelerometer");
		sensoryTypeIndividual.addPropertyValue(hasAccelerometerProperty,accelerometerIndividual);
		accelerometerIndividual.addPropertyValue(isAccelerometerOfProperty,sensoryTypeIndividual);
		// data type has gyroscope data
		RDFIndividual gyroscopeIndividual = sensoryTypeGyroscopeClass.createOWLIndividual("gyroscope" + "-" + UUIDUtil.creatUUID());
		gyroscopeIndividual.addPropertyValue(gyroscopeNameProperty,"Gyroscope");
		sensoryTypeIndividual.addPropertyValue(hasGyroscopeProperty,gyroscopeIndividual);
		gyroscopeIndividual.addPropertyValue(isGyroscopeOfProperty,sensoryTypeIndividual);
		
		
		// application
		RDFIndividual applicationIndividual = applicationClass.createOWLIndividual("application" + "-" + UUIDUtil.creatUUID());
		applicationIndividual.addPropertyValue(applicationNameProperty, "Classification of Human Activities Using CNN");
		// RDFIndividual applicationDomainIndividual = applicationDomainClass.createOWLIndividual("applicationDomain"+"-"+ UUIDUtil.creatUUID());
		// applicationIndividual.addPropertyValue(hasApplicationDomainProperty, applicationDomainIndividual);
		// applicationDomainIndividual.addPropertyValue(isApplicationDomainOfProperty, applicationIndividual);
		RDFIndividual applicationHealthcareIndividual = applicationHealthcareClass.createOWLIndividual("applicationHealthcare"+"-"+ UUIDUtil.creatUUID());
		applicationHealthcareIndividual.addPropertyValue(applicationHealthcareNameProperty, "Healthcare Application 1");
		applicationIndividual.addPropertyValue(hasHealthcareApplicationProperty, applicationHealthcareIndividual);
		applicationHealthcareIndividual.addPropertyValue(isHealthcareApplicationOfProperty, applicationIndividual);
//		RDFIndividual applicationSkinCancerIndividual = skinCancerClass.createOWLIndividual("applicationSkinCancer"+"-"+ UUIDUtil.creatUUID());
//		applicationSkinCancerIndividual.addPropertyValue(skinCancerNameProperty, "Skin Cancer");
//		applicationHealthcareIndividual.addPropertyValue(hasSkinCancerProperty, applicationSkinCancerIndividual);
//		applicationSkinCancerIndividual.addPropertyValue(isSkinCancerOfProperty, applicationHealthcareIndividual);
		RDFIndividual applicationMusculoskeletalDisorderIndividual = musculoskeletalDisorderClass.createOWLIndividual("applicationMusculoskeletalDisorder"+"-"+ UUIDUtil.creatUUID());
		applicationMusculoskeletalDisorderIndividual.addPropertyValue(musculoskeletalDisorderNameProperty, "Musculoskeletal Disorder");
		applicationHealthcareIndividual.addPropertyValue(hasMusculoskeletalDisorderProperty, applicationMusculoskeletalDisorderIndividual);
		applicationMusculoskeletalDisorderIndividual.addPropertyValue(isMusculoskeletalDisorderOfProperty, applicationHealthcareIndividual);
		
		// application has data
		applicationIndividual.addPropertyValue(hasDataProperty, dataIndividual);
		dataIndividual.addPropertyValue(isDataOfProperty, applicationIndividual);
		
		for (int i = 0; i<10;i++) {
			// model
			RDFIndividual modelIndividual = modelClass.createOWLIndividual("model" + "-" + UUIDUtil.creatUUID());
			modelIndividual.addPropertyValue(modelNameProperty, "CNN");
			modelIndividual.addPropertyValue(modelDescriptionProperty, "Keras backend");
			modelIndividual.addPropertyValue(modelResourceProperty, "http://www.deep-learning-ontology.com:8080/model1"+ i +".json");
			// application has many models
			applicationIndividual.addPropertyValue(hasModelProperty, modelIndividual);
			modelIndividual.addPropertyValue(isModelOfProperty, applicationIndividual);
		
		
			/**
			 *  model scope
			 */
			// model has performance
			// RDFIndividual performanceIndividual = performanceClass.createOWLIndividual("performance" + "-" + UUIDUtil.creatUUID());
			// performanceIndividual.addPropertyValue(performanceAccuracyProperty, new Float(0.8) + new Float (i)/100);
			// performanceIndividual.addPropertyValue(performancePrecisionProperty, new Float(0.7) + new Float (i)/100);
			// performanceIndividual.addPropertyValue(performanceRecallProperty, new Float(0.6) + new Float (i)/100);
			// performanceIndividual.addPropertyValue(performanceF1ScoreProperty, new Float(0.8) + new Float (i)/100);
			// modelIndividual.addPropertyValue(hasPerformanceProperty, performanceIndividual);
			// performanceIndividual.addPropertyValue(isPerformanceOfProperty, modelIndividual);
			
			if (i == 0) {
				// model has performance
				RDFIndividual performanceIndividual = performanceClass.createOWLIndividual("performance" + "-" + UUIDUtil.creatUUID());
				performanceIndividual.addPropertyValue(performanceAccuracyProperty, new Float(0.9026));
				performanceIndividual.addPropertyValue(performancePrecisionProperty, new Float(0.9029));
				performanceIndividual.addPropertyValue(performanceRecallProperty, new Float(0.9044));
				performanceIndividual.addPropertyValue(performanceF1ScoreProperty, new Float(0.9019));
				modelIndividual.addPropertyValue(hasPerformanceProperty, performanceIndividual);
				performanceIndividual.addPropertyValue(isPerformanceOfProperty, modelIndividual);
			}
			
			if (i == 1) {
				// model has performance
				RDFIndividual performanceIndividual = performanceClass.createOWLIndividual("performance" + "-" + UUIDUtil.creatUUID());
				performanceIndividual.addPropertyValue(performanceAccuracyProperty, new Float(0.9172));
				performanceIndividual.addPropertyValue(performancePrecisionProperty, new Float(0.9166));
				performanceIndividual.addPropertyValue(performanceRecallProperty, new Float(0.9189));
				performanceIndividual.addPropertyValue(performanceF1ScoreProperty, new Float(0.9173));
				modelIndividual.addPropertyValue(hasPerformanceProperty, performanceIndividual);
				performanceIndividual.addPropertyValue(isPerformanceOfProperty, modelIndividual);
			}
			
			if (i == 2) {
				// model has performance
				RDFIndividual performanceIndividual = performanceClass.createOWLIndividual("performance" + "-" + UUIDUtil.creatUUID());
				performanceIndividual.addPropertyValue(performanceAccuracyProperty, new Float(0.9022));
				performanceIndividual.addPropertyValue(performancePrecisionProperty, new Float(0.9043));
				performanceIndividual.addPropertyValue(performanceRecallProperty, new Float(0.9053));
				performanceIndividual.addPropertyValue(performanceF1ScoreProperty, new Float(0.9027));
				modelIndividual.addPropertyValue(hasPerformanceProperty, performanceIndividual);
				performanceIndividual.addPropertyValue(isPerformanceOfProperty, modelIndividual);
			}
			
			if (i == 3) {
				// model has performance
				RDFIndividual performanceIndividual = performanceClass.createOWLIndividual("performance" + "-" + UUIDUtil.creatUUID());
				performanceIndividual.addPropertyValue(performanceAccuracyProperty, new Float(0.9104));
				performanceIndividual.addPropertyValue(performancePrecisionProperty, new Float(0.9102));
				performanceIndividual.addPropertyValue(performanceRecallProperty, new Float(0.9129));
				performanceIndividual.addPropertyValue(performanceF1ScoreProperty, new Float(0.9104));
				modelIndividual.addPropertyValue(hasPerformanceProperty, performanceIndividual);
				performanceIndividual.addPropertyValue(isPerformanceOfProperty, modelIndividual);
			}
			
			if (i == 4) {
				// model has performance
				RDFIndividual performanceIndividual = performanceClass.createOWLIndividual("performance" + "-" + UUIDUtil.creatUUID());
				performanceIndividual.addPropertyValue(performanceAccuracyProperty, new Float(0.8873));
				performanceIndividual.addPropertyValue(performancePrecisionProperty, new Float(0.8916));
				performanceIndividual.addPropertyValue(performanceRecallProperty, new Float(0.8907));
				performanceIndividual.addPropertyValue(performanceF1ScoreProperty, new Float(0.8873));
				modelIndividual.addPropertyValue(hasPerformanceProperty, performanceIndividual);
				performanceIndividual.addPropertyValue(isPerformanceOfProperty, modelIndividual);
			}
			
			if (i == 5) {
				// model has performance
				RDFIndividual performanceIndividual = performanceClass.createOWLIndividual("performance" + "-" + UUIDUtil.creatUUID());
				performanceIndividual.addPropertyValue(performanceAccuracyProperty, new Float(0.9226));
				performanceIndividual.addPropertyValue(performancePrecisionProperty, new Float(0.9232));
				performanceIndividual.addPropertyValue(performanceRecallProperty, new Float(0.9241));
				performanceIndividual.addPropertyValue(performanceF1ScoreProperty, new Float(0.9229));
				modelIndividual.addPropertyValue(hasPerformanceProperty, performanceIndividual);
				performanceIndividual.addPropertyValue(isPerformanceOfProperty, modelIndividual);
			}
			
			if (i == 6) {
				// model has performance
				RDFIndividual performanceIndividual = performanceClass.createOWLIndividual("performance" + "-" + UUIDUtil.creatUUID());
				performanceIndividual.addPropertyValue(performanceAccuracyProperty, new Float(0.9131));
				performanceIndividual.addPropertyValue(performancePrecisionProperty, new Float(0.9135));
				performanceIndividual.addPropertyValue(performanceRecallProperty, new Float(0.9141));
				performanceIndividual.addPropertyValue(performanceF1ScoreProperty, new Float(0.9132));
				modelIndividual.addPropertyValue(hasPerformanceProperty, performanceIndividual);
				performanceIndividual.addPropertyValue(isPerformanceOfProperty, modelIndividual);
			}
			
			if (i == 7) {
				// model has performance
				RDFIndividual performanceIndividual = performanceClass.createOWLIndividual("performance" + "-" + UUIDUtil.creatUUID());
				performanceIndividual.addPropertyValue(performanceAccuracyProperty, new Float(0.8978));
				performanceIndividual.addPropertyValue(performancePrecisionProperty, new Float(0.9015));
				performanceIndividual.addPropertyValue(performanceRecallProperty, new Float(0.9016));
				performanceIndividual.addPropertyValue(performanceF1ScoreProperty, new Float(0.8986));
				modelIndividual.addPropertyValue(hasPerformanceProperty, performanceIndividual);
				performanceIndividual.addPropertyValue(isPerformanceOfProperty, modelIndividual);
			}
			
			if (i == 8) {
				// model has performance
				RDFIndividual performanceIndividual = performanceClass.createOWLIndividual("performance" + "-" + UUIDUtil.creatUUID());
				performanceIndividual.addPropertyValue(performanceAccuracyProperty, new Float(0.8985));
				performanceIndividual.addPropertyValue(performancePrecisionProperty, new Float(0.9004));
				performanceIndividual.addPropertyValue(performanceRecallProperty, new Float(0.8988));
				performanceIndividual.addPropertyValue(performanceF1ScoreProperty, new Float(0.8968));
				modelIndividual.addPropertyValue(hasPerformanceProperty, performanceIndividual);
				performanceIndividual.addPropertyValue(isPerformanceOfProperty, modelIndividual);
			}
			
			if (i == 9) {
				// model has performance
				RDFIndividual performanceIndividual = performanceClass.createOWLIndividual("performance" + "-" + UUIDUtil.creatUUID());
				performanceIndividual.addPropertyValue(performanceAccuracyProperty, new Float(0.9039));
				performanceIndividual.addPropertyValue(performancePrecisionProperty, new Float(0.9041));
				performanceIndividual.addPropertyValue(performanceRecallProperty, new Float(0.9064));
				performanceIndividual.addPropertyValue(performanceF1ScoreProperty, new Float(0.9044));
				modelIndividual.addPropertyValue(hasPerformanceProperty, performanceIndividual);
				performanceIndividual.addPropertyValue(isPerformanceOfProperty, modelIndividual);
			}
			
			// model has model type
			RDFIndividual modelTypeIndividual = modelTypeClass.createOWLIndividual("modelType" + "-" + UUIDUtil.creatUUID());
			modelIndividual.addPropertyValue(hasModelTypeProperty, modelTypeIndividual);
			modelTypeIndividual.addPropertyValue(isModelTypeOfProperty, modelIndividual);
			// model type has CNN
			RDFIndividual modelTypeCNNIndividual = modelTypeCNNClass.createOWLIndividual("CNNType" + "-" + UUIDUtil.creatUUID());
			modelTypeCNNIndividual.addPropertyValue(modelTypeCNNNameProperty, "CNN");
			modelTypeIndividual.addPropertyValue(hasCNNTypeProperty, modelTypeCNNIndividual);
			modelTypeCNNIndividual.addPropertyValue(isCNNTypeOfProperty, modelTypeIndividual);
			
			/**
			 *  model layer
			 */
			
			// layer 1 is convolution layer
			
			// model has model layer
			RDFIndividual modelLayerIndividual1 = modelLayerClass.createOWLIndividual("modelLayer1" + "-" + UUIDUtil.creatUUID());
			modelLayerIndividual1.addPropertyValue(layerNameProperty, "layer1-convolution");
			modelIndividual.addPropertyValue(hasLayerProperty, modelLayerIndividual1);
			modelLayerIndividual1.addPropertyValue(isLayerOfProperty, modelIndividual);
			
			// model layer has core layer
			RDFIndividual coreLayerIndividual1 = coreLayerClass.createOWLIndividual("coreLayer1" + "-" + UUIDUtil.creatUUID());
			modelLayerIndividual1.addPropertyValue(hasCoreLayerProperty, coreLayerIndividual1);
			coreLayerIndividual1.addPropertyValue(isCoreLayerOfProperty, modelLayerIndividual1);
			
			// core layer has core layer type
			RDFIndividual coreLayerTypeIndividual1 = coreLayerTypeClass.createOWLIndividual("coreLayerType1" + "-" + UUIDUtil.creatUUID());
			coreLayerIndividual1.addPropertyValue(hasCoreLayerTypeProperty, coreLayerTypeIndividual1);
			coreLayerTypeIndividual1.addPropertyValue(isCoreLayerTypeOfProperty, coreLayerIndividual1);
			
			// core layer type has layer1
			RDFIndividual layerIndividual1 = convolutionLayerClass.createOWLIndividual("layer1" + "-" + UUIDUtil.creatUUID());
			layerIndividual1.addPropertyValue(convolutionRankProperty, 1);
			layerIndividual1.addPropertyValue(convolutionOutputChannelsProperty, 64);
			layerIndividual1.addPropertyValue(convolutionKernelSizeProperty, "3");
			layerIndividual1.addPropertyValue(convolutionStridesProperty, "1");
			layerIndividual1.addPropertyValue(convolutionPaddingProperty, "valid");
			// layerIndividual1.addPropertyValue(convolutionDilationProperty, null);
			layerIndividual1.addPropertyValue(convolutionGroupsProperty, 1);
			coreLayerTypeIndividual1.addPropertyValue(hasConvolutionLayerProperty, layerIndividual1);
			layerIndividual1.addPropertyValue(isConvolutionLayerOfProperty, coreLayerTypeIndividual1);
			
			// core layer has activation function
			RDFIndividual activationFunctionIndividual1 = owlModel.getOWLIndividual("relu");	
			coreLayerIndividual1.addPropertyValue(hasActivationFunctionProperty, activationFunctionIndividual1);
			activationFunctionIndividual1.addPropertyValue(isActivationFunctionOfProperty, coreLayerIndividual1);
			
			// core layer has weight
			RDFIndividual weightIndividual1 = weightClass.createOWLIndividual("weight1" + "-" + UUIDUtil.creatUUID());
			coreLayerIndividual1.addPropertyValue(hasWeightProperty, weightIndividual1);
			weightIndividual1.addPropertyValue(isWeightOfProperty, coreLayerIndividual1);
			// weight has initializer
			RDFIndividual initializerIndividual1 = owlModel.getOWLIndividual("GlorotUniform");
			weightIndividual1.addPropertyValue(hasInitializerProperty, initializerIndividual1);
			initializerIndividual1.addPropertyValue(isInitializerOfProperty, weightIndividual1);
			
			// core layer has bias
			RDFIndividual biasIndividual1 = biasClass.createOWLIndividual("bias1" + "-" + UUIDUtil.creatUUID());
			coreLayerIndividual1.addPropertyValue(hasBiasProperty, biasIndividual1);
			biasIndividual1.addPropertyValue(isBiasOfProperty, coreLayerIndividual1);
			// bias has initializer
			RDFIndividual initializerIndividual2 = owlModel.getOWLIndividual("Zeros");
			biasIndividual1.addPropertyValue(hasInitializerProperty, initializerIndividual2);
			initializerIndividual2.addPropertyValue(isInitializerOfProperty, biasIndividual1);

			
			// layer 2 is convolution layer
			
			// model has model layer
			RDFIndividual modelLayerIndividual2 = modelLayerClass.createOWLIndividual("modelLayer2" + "-" + UUIDUtil.creatUUID());
			modelLayerIndividual2.addPropertyValue(layerNameProperty, "layer2-convolution");
			modelIndividual.addPropertyValue(hasLayerProperty, modelLayerIndividual2);
			modelLayerIndividual2.addPropertyValue(isLayerOfProperty, modelIndividual);
			
			// model layer has core layer
			RDFIndividual coreLayerIndividual2 = coreLayerClass.createOWLIndividual("coreLayer2" + "-" + UUIDUtil.creatUUID());
			modelLayerIndividual2.addPropertyValue(hasCoreLayerProperty, coreLayerIndividual2);
			coreLayerIndividual2.addPropertyValue(isCoreLayerOfProperty, modelLayerIndividual2);
			
			// core layer has core layer type
			RDFIndividual coreLayerTypeIndividual2 = coreLayerTypeClass.createOWLIndividual("coreLayerType2" + "-" + UUIDUtil.creatUUID());
			coreLayerIndividual2.addPropertyValue(hasCoreLayerTypeProperty, coreLayerTypeIndividual2);
			coreLayerTypeIndividual2.addPropertyValue(isCoreLayerTypeOfProperty, coreLayerIndividual2);
			
			// core layer type has layer2
			RDFIndividual layerIndividual2 = convolutionLayerClass.createOWLIndividual("layer2" + "-" + UUIDUtil.creatUUID());
			layerIndividual2.addPropertyValue(convolutionRankProperty, 1);
			// layerIndividual2.addPropertyValue(convolutionInChannelsProperty, 1);
			layerIndividual2.addPropertyValue(convolutionOutputChannelsProperty, 64);
			layerIndividual2.addPropertyValue(convolutionKernelSizeProperty, "3");
			layerIndividual2.addPropertyValue(convolutionStridesProperty, "1");
			layerIndividual2.addPropertyValue(convolutionPaddingProperty, "valid");
			// layerIndividual1.addPropertyValue(convolutionDilationProperty, null);
			layerIndividual2.addPropertyValue(convolutionGroupsProperty, 1);
			coreLayerTypeIndividual2.addPropertyValue(hasConvolutionLayerProperty, layerIndividual2);
			layerIndividual2.addPropertyValue(isConvolutionLayerOfProperty, coreLayerTypeIndividual2);
			
			// core layer has activation function
			RDFIndividual activationFunctionIndividual2 = owlModel.getOWLIndividual("relu");
			coreLayerIndividual2.addPropertyValue(hasActivationFunctionProperty, activationFunctionIndividual2);
			activationFunctionIndividual2.addPropertyValue(isActivationFunctionOfProperty, coreLayerIndividual2);
			
			// core layer has weight
			RDFIndividual weightIndividual2 = weightClass.createOWLIndividual("weight2" + "-" + UUIDUtil.creatUUID());
			coreLayerIndividual2.addPropertyValue(hasWeightProperty, weightIndividual2);
			weightIndividual2.addPropertyValue(isWeightOfProperty, coreLayerIndividual2);
			// weight argument has initializer
			RDFIndividual initializerIndividual3 = owlModel.getOWLIndividual("GlorotUniform");
			weightIndividual2.addPropertyValue(hasInitializerProperty, initializerIndividual3);
			initializerIndividual3.addPropertyValue(isInitializerOfProperty, weightIndividual2);
			
			// core layer has bias
			RDFIndividual biasIndividual2 = biasClass.createOWLIndividual("bias2" + "-" + UUIDUtil.creatUUID());
			coreLayerIndividual2.addPropertyValue(hasBiasProperty, biasIndividual2);
			biasIndividual2.addPropertyValue(isBiasOfProperty, coreLayerIndividual2);
			// bias argument has initializer
			RDFIndividual initializerIndividual4 = owlModel.getOWLIndividual("Zeros");
			biasIndividual2.addPropertyValue(hasInitializerProperty, initializerIndividual4);
			initializerIndividual4.addPropertyValue(isInitializerOfProperty, biasIndividual2);
			
			
			// layer 3 is dropout layer
			
			// model has model layer
			RDFIndividual modelLayerIndividual3= modelLayerClass.createOWLIndividual("modelLayer3" + "-" + UUIDUtil.creatUUID());
			modelLayerIndividual3.addPropertyValue(layerNameProperty, "layer3-dropout");
			modelIndividual.addPropertyValue(hasLayerProperty, modelLayerIndividual3);
			modelLayerIndividual3.addPropertyValue(isLayerOfProperty, modelIndividual);
			
			// model layer has functional layer
			RDFIndividual functionalLayerIndividual3 = functionalLayerClass.createOWLIndividual("functionalLayer3" + "-" + UUIDUtil.creatUUID());
			modelLayerIndividual3.addPropertyValue(hasFunctionalLayerProperty, functionalLayerIndividual3);
			functionalLayerIndividual3.addPropertyValue(isFunctionalLayerOfProperty, modelLayerIndividual3);
			
			// functional layer has dropout layer
			RDFIndividual layerIndividual3 = dropoutLayerClass.createOWLIndividual("layer3" + "-" + UUIDUtil.creatUUID());
			
			layerIndividual3.addPropertyValue(dropoutRankProperty, 1);
			layerIndividual3.addPropertyValue(dropoutRateProperty, new Float(0.5));
			functionalLayerIndividual3.addPropertyValue(hasDropoutLayerProperty, layerIndividual3);
			layerIndividual3.addPropertyValue(isDropoutLayerOfProperty, functionalLayerIndividual3);
			
			
			// layer 4 is pooling layer
			
			// model has model layer
			RDFIndividual modelLayerIndividual4= modelLayerClass.createOWLIndividual("modelLayer4" + "-" + UUIDUtil.creatUUID());
			modelLayerIndividual4.addPropertyValue(layerNameProperty, "layer4-pooling");
			modelIndividual.addPropertyValue(hasLayerProperty, modelLayerIndividual4);
			modelLayerIndividual4.addPropertyValue(isLayerOfProperty, modelIndividual);
			
			// model layer has functional layer
			RDFIndividual functionalLayerIndividual4 = functionalLayerClass.createOWLIndividual("functionalLayer4" + "-" + UUIDUtil.creatUUID());
			modelLayerIndividual4.addPropertyValue(hasFunctionalLayerProperty, functionalLayerIndividual4);
			functionalLayerIndividual4.addPropertyValue(isFunctionalLayerOfProperty, modelLayerIndividual4);
			
			// function layer has pooling layer
			RDFIndividual layerIndividual4 = poolingLayerClass.createOWLIndividual("layer4" + "-" + UUIDUtil.creatUUID());
			layerIndividual4.addPropertyValue(poolingRankProperty, 1);
			layerIndividual4.addPropertyValue(poolingTypeProperty, "MaxPooling1D");
			layerIndividual4.addPropertyValue(poolingKernelSizeProperty, "2");
			layerIndividual4.addPropertyValue(poolingStridesProperty, "2");
			layerIndividual4.addPropertyValue(poolingPaddingProperty, "valid");
			functionalLayerIndividual4.addPropertyValue(hasPoolingLayerProperty, layerIndividual4);
			layerIndividual4.addPropertyValue(isPoolingLayerOfProperty, functionalLayerIndividual4);
			
			
			// layer 5 is reshaping layer
			
			// model has model layer
			RDFIndividual modelLayerIndividual5= modelLayerClass.createOWLIndividual("modelLayer5" + "-" + UUIDUtil.creatUUID());
			modelLayerIndividual5.addPropertyValue(layerNameProperty, "layer5-reshaping");
			modelIndividual.addPropertyValue(hasLayerProperty, modelLayerIndividual5);
			modelLayerIndividual5.addPropertyValue(isLayerOfProperty, modelIndividual);
			
			// model layer has functional layer
			RDFIndividual functionalLayerIndividual5 = functionalLayerClass.createOWLIndividual("functionalLayer5" + "-" + UUIDUtil.creatUUID());
			modelLayerIndividual5.addPropertyValue(hasFunctionalLayerProperty, functionalLayerIndividual5);
			functionalLayerIndividual5.addPropertyValue(isFunctionalLayerOfProperty, modelLayerIndividual5);
			
			// functional layer has reshaping layer
			RDFIndividual layerIndividual5 = reshapingLayerClass.createOWLIndividual("layer5" + "-" + UUIDUtil.creatUUID());
			layerIndividual5.addPropertyValue(reshapingTypeProperty, "Flatten");
			functionalLayerIndividual5.addPropertyValue(hasReshapingLayerProperty, layerIndividual5);
			layerIndividual5.addPropertyValue(isReshapingLayerOfProperty, functionalLayerIndividual5);
			
			
			// layer 6 is dense layer
			
			// model has model layer
			RDFIndividual modelLayerIndividual6 = modelLayerClass.createOWLIndividual("modelLayer6" + "-" + UUIDUtil.creatUUID());
			modelLayerIndividual6.addPropertyValue(layerNameProperty, "layer6-dense");
			modelIndividual.addPropertyValue(hasLayerProperty, modelLayerIndividual6);
			modelLayerIndividual6.addPropertyValue(isLayerOfProperty, modelIndividual);
			
			// model layer has core layer
			RDFIndividual coreLayerIndividual6 = coreLayerClass.createOWLIndividual("coreLayer6" + "-" + UUIDUtil.creatUUID());
			modelLayerIndividual6.addPropertyValue(hasCoreLayerProperty, coreLayerIndividual6);
			coreLayerIndividual6.addPropertyValue(isCoreLayerOfProperty, modelLayerIndividual6);
			
			// core layer has core layer type
			RDFIndividual coreLayerTypeIndividual6 = coreLayerTypeClass.createOWLIndividual("coreLayerType6" + "-" + UUIDUtil.creatUUID());
			coreLayerIndividual6.addPropertyValue(hasCoreLayerTypeProperty, coreLayerTypeIndividual6);
			coreLayerTypeIndividual6.addPropertyValue(isCoreLayerTypeOfProperty, coreLayerIndividual6);
			
			// core layer type has layer 6
			RDFIndividual layerIndividual6 = denseLayerClass.createOWLIndividual("layer6" + "-" + UUIDUtil.creatUUID());
			layerIndividual6.addPropertyValue(denseOutFeaturesProperty, 100);
			coreLayerTypeIndividual6.addPropertyValue(hasDenseLayerProperty, layerIndividual6);
			layerIndividual6.addPropertyValue(isDenseLayerOfProperty, coreLayerTypeIndividual6);

			// core layer has activation function
			RDFIndividual activationFunctionIndividual3 = owlModel.getOWLIndividual("relu");
			coreLayerIndividual6.addPropertyValue(hasActivationFunctionProperty, activationFunctionIndividual3);
			activationFunctionIndividual3.addPropertyValue(isActivationFunctionOfProperty, coreLayerIndividual6);
			
			// core layer has weight
			RDFIndividual weightIndividual3 = weightClass.createOWLIndividual("weight6" + "-" + UUIDUtil.creatUUID());
			coreLayerIndividual6.addPropertyValue(hasWeightProperty, weightIndividual3);
			weightIndividual3.addPropertyValue(isWeightOfProperty, coreLayerIndividual6);
			// weight has initializer
			RDFIndividual initializerIndividual5 = owlModel.getOWLIndividual("GlorotUniform");
			weightIndividual3.addPropertyValue(hasInitializerProperty, initializerIndividual5);
			initializerIndividual5.addPropertyValue(isInitializerOfProperty, weightIndividual3);
			
			// core layer has bias
			RDFIndividual biasIndividual3 = biasClass.createOWLIndividual("bias6" + "-" + UUIDUtil.creatUUID());
			coreLayerIndividual6.addPropertyValue(hasBiasProperty, biasIndividual3);
			biasIndividual3.addPropertyValue(isBiasOfProperty, coreLayerIndividual6);	
			// bias has initializer
			RDFIndividual initializerIndividual6 = owlModel.getOWLIndividual("Zeros");
			biasIndividual3.addPropertyValue(hasInitializerProperty, initializerIndividual6);
			initializerIndividual6.addPropertyValue(isInitializerOfProperty, biasIndividual3);
			
			// layer 7 is dense layer
			// model has model layer
			RDFIndividual modelLayerIndividual7 = modelLayerClass.createOWLIndividual("modelLayer7" + "-" + UUIDUtil.creatUUID());
			modelLayerIndividual7.addPropertyValue(layerNameProperty, "layer7-dense");
			modelIndividual.addPropertyValue(hasLayerProperty, modelLayerIndividual7);
			modelLayerIndividual7.addPropertyValue(isLayerOfProperty, modelIndividual);
			
			// model layer has core layer
			RDFIndividual coreLayerIndividual7 = coreLayerClass.createOWLIndividual("coreLayer7" + "-" + UUIDUtil.creatUUID());
			modelLayerIndividual7.addPropertyValue(hasCoreLayerProperty, coreLayerIndividual7);
			coreLayerIndividual7.addPropertyValue(isCoreLayerOfProperty, modelLayerIndividual7);
			
			// core layer has core layer type
			RDFIndividual coreLayerTypeIndividual7 = coreLayerTypeClass.createOWLIndividual("coreLayerType7" + "-" + UUIDUtil.creatUUID());
			coreLayerIndividual7.addPropertyValue(hasCoreLayerTypeProperty, coreLayerTypeIndividual7);
			coreLayerTypeIndividual7.addPropertyValue(isCoreLayerTypeOfProperty, coreLayerIndividual7);
			
			// core layer type has layer 7
			RDFIndividual layerIndividual7 = denseLayerClass.createOWLIndividual("layer7" + "-" + UUIDUtil.creatUUID());
			layerIndividual7.addPropertyValue(denseOutFeaturesProperty, 100);
			coreLayerTypeIndividual7.addPropertyValue(hasDenseLayerProperty, layerIndividual7);
			layerIndividual7.addPropertyValue(isDenseLayerOfProperty, coreLayerTypeIndividual7);
					
			// core layer has activation function
			RDFIndividual activationFunctionIndividual4 = owlModel.getOWLIndividual("softmax");
			coreLayerIndividual7.addPropertyValue(hasActivationFunctionProperty, activationFunctionIndividual4);
			activationFunctionIndividual4.addPropertyValue(isActivationFunctionOfProperty, coreLayerIndividual7);
			
			// core layer has weight
			RDFIndividual weightIndividual4 = weightClass.createOWLIndividual("weight7" + "-" + UUIDUtil.creatUUID());
			coreLayerIndividual7.addPropertyValue(hasWeightProperty, weightIndividual4);
			weightIndividual4.addPropertyValue(isWeightOfProperty, coreLayerIndividual7);
			// weight has initializer
			RDFIndividual initializerIndividual7 = owlModel.getOWLIndividual("GlorotUniform");
			weightIndividual4.addPropertyValue(hasInitializerProperty, initializerIndividual7);
			initializerIndividual7.addPropertyValue(isInitializerOfProperty, weightIndividual4);
					
			//  core layer has bias
			RDFIndividual biasIndividual4 = biasClass.createOWLIndividual("bias7" + "-" + UUIDUtil.creatUUID());
			coreLayerIndividual7.addPropertyValue(hasBiasProperty, biasIndividual4);
			biasIndividual4.addPropertyValue(isBiasOfProperty, coreLayerIndividual7);
			// bias has initializer
			RDFIndividual initializerIndividual8 = owlModel.getOWLIndividual("Zeros");
			biasIndividual4.addPropertyValue(hasInitializerProperty, initializerIndividual8);
			initializerIndividual8.addPropertyValue(isInitializerOfProperty, biasIndividual4);
			
			// layer has previous layer
			modelLayerIndividual2.addPropertyValue(hasPreviousLayerProperty, modelLayerIndividual1);
			modelLayerIndividual1.addPropertyValue(isPreviousLayerOfProperty, modelLayerIndividual2);
			modelLayerIndividual3.addPropertyValue(hasPreviousLayerProperty, modelLayerIndividual2);
			modelLayerIndividual2.addPropertyValue(isPreviousLayerOfProperty, modelLayerIndividual3);
			modelLayerIndividual4.addPropertyValue(hasPreviousLayerProperty, modelLayerIndividual3);
			modelLayerIndividual3.addPropertyValue(isPreviousLayerOfProperty, modelLayerIndividual4);
			modelLayerIndividual5.addPropertyValue(hasPreviousLayerProperty, modelLayerIndividual4);
			modelLayerIndividual4.addPropertyValue(isPreviousLayerOfProperty, modelLayerIndividual5);
			modelLayerIndividual6.addPropertyValue(hasPreviousLayerProperty, modelLayerIndividual5);
			modelLayerIndividual5.addPropertyValue(isPreviousLayerOfProperty, modelLayerIndividual6);
			modelLayerIndividual7.addPropertyValue(hasPreviousLayerProperty, modelLayerIndividual6);
			modelLayerIndividual6.addPropertyValue(isPreviousLayerOfProperty, modelLayerIndividual7);
		}
		
		// application
		RDFIndividual applicationIndividual2 = applicationClass.createOWLIndividual("application" + "-" + UUIDUtil.creatUUID());
		applicationIndividual2.addPropertyValue(applicationNameProperty, "Classification of Human Activities Using RNN");
		// RDFIndividual applicationDomainIndividual2 = applicationDomainClass.createOWLIndividual("applicationDomain"+"-"+ UUIDUtil.creatUUID());
		// applicationIndividual2.addPropertyValue(hasApplicationDomainProperty, applicationDomainIndividual2);
		// applicationDomainIndividual2.addPropertyValue(isApplicationDomainOfProperty, applicationIndividual2);
		RDFIndividual applicationHealthcareIndividual2 = applicationHealthcareClass.createOWLIndividual("applicationHealthcare"+"-"+ UUIDUtil.creatUUID());
		applicationHealthcareIndividual2.addPropertyValue(applicationHealthcareNameProperty, "Healthcare Application 2");
		applicationIndividual2.addPropertyValue(hasHealthcareApplicationProperty, applicationHealthcareIndividual2);
		applicationHealthcareIndividual2.addPropertyValue(isHealthcareApplicationOfProperty, applicationIndividual2);
		RDFIndividual applicationMusculoskeletalDisorderIndividual2 = musculoskeletalDisorderClass.createOWLIndividual("applicationMusculoskeletalDisorder"+"-"+ UUIDUtil.creatUUID());
		applicationMusculoskeletalDisorderIndividual2.addPropertyValue(musculoskeletalDisorderNameProperty, "Musculoskeletal Disorder");
		applicationHealthcareIndividual2.addPropertyValue(hasMusculoskeletalDisorderProperty, applicationMusculoskeletalDisorderIndividual2);
		applicationMusculoskeletalDisorderIndividual2.addPropertyValue(isMusculoskeletalDisorderOfProperty, applicationHealthcareIndividual2);
		
		// application has data
		applicationIndividual2.addPropertyValue(hasDataProperty, dataIndividual);
		dataIndividual.addPropertyValue(isDataOfProperty, applicationIndividual2);
		
		for (int i = 0; i<10;i++) {
			// model
			RDFIndividual modelIndividual = modelClass.createOWLIndividual("model" + "-" + UUIDUtil.creatUUID());
			modelIndividual.addPropertyValue(modelNameProperty, "RNN");
			modelIndividual.addPropertyValue(modelDescriptionProperty, "Keras backend");
			modelIndividual.addPropertyValue(modelResourceProperty, "http://www.deep-learning-ontology.com:8080/model2"+ i +".json");
			// application has many models
			applicationIndividual2.addPropertyValue(hasModelProperty, modelIndividual);
			modelIndividual.addPropertyValue(isModelOfProperty, applicationIndividual2);
		
		
			/**
			 *  model scope
			 */
			// model has performance
			// RDFIndividual performanceIndividual = performanceClass.createOWLIndividual("performance" + "-" + UUIDUtil.creatUUID());
			// performanceIndividual.addPropertyValue(performanceAccuracyProperty, new Float(0.8) + new Float (i)/100);
			// performanceIndividual.addPropertyValue(performancePrecisionProperty, new Float(0.7) + new Float (i)/100);
			// performanceIndividual.addPropertyValue(performanceRecallProperty, new Float(0.6) + new Float (i)/100);
			// performanceIndividual.addPropertyValue(performanceF1ScoreProperty, new Float(0.8) + new Float (i)/100);
			// modelIndividual.addPropertyValue(hasPerformanceProperty, performanceIndividual);
			// performanceIndividual.addPropertyValue(isPerformanceOfProperty, modelIndividual);
			
			if(i==0) {
				// model has performance
				RDFIndividual performanceIndividual = performanceClass.createOWLIndividual("performance" + "-" + UUIDUtil.creatUUID());
				performanceIndividual.addPropertyValue(performanceAccuracyProperty, new Float(0.9019));
				performanceIndividual.addPropertyValue(performancePrecisionProperty, new Float(0.9034));
				performanceIndividual.addPropertyValue(performanceRecallProperty, new Float(0.9032));
				performanceIndividual.addPropertyValue(performanceF1ScoreProperty, new Float(0.9023));
				modelIndividual.addPropertyValue(hasPerformanceProperty, performanceIndividual);
				performanceIndividual.addPropertyValue(isPerformanceOfProperty, modelIndividual);
			}
			
			if(i==1) {
				// model has performance
				RDFIndividual performanceIndividual = performanceClass.createOWLIndividual("performance" + "-" + UUIDUtil.creatUUID());
				performanceIndividual.addPropertyValue(performanceAccuracyProperty, new Float(0.8686));
				performanceIndividual.addPropertyValue(performancePrecisionProperty, new Float(0.8769));
				performanceIndividual.addPropertyValue(performanceRecallProperty, new Float(0.8706));
				performanceIndividual.addPropertyValue(performanceF1ScoreProperty, new Float(0.8681));
				modelIndividual.addPropertyValue(hasPerformanceProperty, performanceIndividual);
				performanceIndividual.addPropertyValue(isPerformanceOfProperty, modelIndividual);
			}
			
			if(i==2) {
				// model has performance
				RDFIndividual performanceIndividual = performanceClass.createOWLIndividual("performance" + "-" + UUIDUtil.creatUUID());
				performanceIndividual.addPropertyValue(performanceAccuracyProperty, new Float(0.9077));
				performanceIndividual.addPropertyValue(performancePrecisionProperty, new Float(0.9083));
				performanceIndividual.addPropertyValue(performanceRecallProperty, new Float(0.9099));
				performanceIndividual.addPropertyValue(performanceF1ScoreProperty, new Float(0.9081));
				modelIndividual.addPropertyValue(hasPerformanceProperty, performanceIndividual);
				performanceIndividual.addPropertyValue(isPerformanceOfProperty, modelIndividual);
			}
			
			if(i==3) {
				// model has performance
				RDFIndividual performanceIndividual = performanceClass.createOWLIndividual("performance" + "-" + UUIDUtil.creatUUID());
				performanceIndividual.addPropertyValue(performanceAccuracyProperty, new Float(0.8985));
				performanceIndividual.addPropertyValue(performancePrecisionProperty, new Float(0.9005));
				performanceIndividual.addPropertyValue(performanceRecallProperty, new Float(0.8998));
				performanceIndividual.addPropertyValue(performanceF1ScoreProperty, new Float(0.8982));
				modelIndividual.addPropertyValue(hasPerformanceProperty, performanceIndividual);
				performanceIndividual.addPropertyValue(isPerformanceOfProperty, modelIndividual);
			}
			
			if(i==4) {
				// model has performance
				RDFIndividual performanceIndividual = performanceClass.createOWLIndividual("performance" + "-" + UUIDUtil.creatUUID());
				performanceIndividual.addPropertyValue(performanceAccuracyProperty, new Float(0.8873));
				performanceIndividual.addPropertyValue(performancePrecisionProperty, new Float(0.8899));
				performanceIndividual.addPropertyValue(performanceRecallProperty, new Float(0.8882));
				performanceIndividual.addPropertyValue(performanceF1ScoreProperty, new Float(0.8866));
				modelIndividual.addPropertyValue(hasPerformanceProperty, performanceIndividual);
				performanceIndividual.addPropertyValue(isPerformanceOfProperty, modelIndividual);
			}
			
			if(i==5) {
				// model has performance
				RDFIndividual performanceIndividual = performanceClass.createOWLIndividual("performance" + "-" + UUIDUtil.creatUUID());
				performanceIndividual.addPropertyValue(performanceAccuracyProperty, new Float(0.9066));
				performanceIndividual.addPropertyValue(performancePrecisionProperty, new Float(0.9096));
				performanceIndividual.addPropertyValue(performanceRecallProperty, new Float(0.9093));
				performanceIndividual.addPropertyValue(performanceF1ScoreProperty, new Float(0.9085));
				modelIndividual.addPropertyValue(hasPerformanceProperty, performanceIndividual);
				performanceIndividual.addPropertyValue(isPerformanceOfProperty, modelIndividual);
			}
			
			if(i==6) {
				// model has performance
				RDFIndividual performanceIndividual = performanceClass.createOWLIndividual("performance" + "-" + UUIDUtil.creatUUID());
				performanceIndividual.addPropertyValue(performanceAccuracyProperty, new Float(0.8408));
				performanceIndividual.addPropertyValue(performancePrecisionProperty, new Float(0.8474));
				performanceIndividual.addPropertyValue(performanceRecallProperty, new Float(0.8434));
				performanceIndividual.addPropertyValue(performanceF1ScoreProperty, new Float(0.8422));
				modelIndividual.addPropertyValue(hasPerformanceProperty, performanceIndividual);
				performanceIndividual.addPropertyValue(isPerformanceOfProperty, modelIndividual);
			}
			
			if(i==7) {
				// model has performance
				RDFIndividual performanceIndividual = performanceClass.createOWLIndividual("performance" + "-" + UUIDUtil.creatUUID());
				performanceIndividual.addPropertyValue(performanceAccuracyProperty, new Float(0.9107));
				performanceIndividual.addPropertyValue(performancePrecisionProperty, new Float(0.9123));
				performanceIndividual.addPropertyValue(performanceRecallProperty, new Float(0.9126));
				performanceIndividual.addPropertyValue(performanceF1ScoreProperty, new Float(0.9121));
				modelIndividual.addPropertyValue(hasPerformanceProperty, performanceIndividual);
				performanceIndividual.addPropertyValue(isPerformanceOfProperty, modelIndividual);
			}
			
			if(i==8) {
				// model has performance
				RDFIndividual performanceIndividual = performanceClass.createOWLIndividual("performance" + "-" + UUIDUtil.creatUUID());
				performanceIndividual.addPropertyValue(performanceAccuracyProperty, new Float(0.9087));
				performanceIndividual.addPropertyValue(performancePrecisionProperty, new Float(0.9111));
				performanceIndividual.addPropertyValue(performanceRecallProperty, new Float(0.9091));
				performanceIndividual.addPropertyValue(performanceF1ScoreProperty, new Float(0.9089));
				modelIndividual.addPropertyValue(hasPerformanceProperty, performanceIndividual);
				performanceIndividual.addPropertyValue(isPerformanceOfProperty, modelIndividual);
			}
			
			if(i==9) {
				// model has performance
				RDFIndividual performanceIndividual = performanceClass.createOWLIndividual("performance" + "-" + UUIDUtil.creatUUID());
				performanceIndividual.addPropertyValue(performanceAccuracyProperty, new Float(0.9039));
				performanceIndividual.addPropertyValue(performancePrecisionProperty, new Float(0.9047));
				performanceIndividual.addPropertyValue(performanceRecallProperty, new Float(0.9054));
				performanceIndividual.addPropertyValue(performanceF1ScoreProperty, new Float(0.9047));
				modelIndividual.addPropertyValue(hasPerformanceProperty, performanceIndividual);
				performanceIndividual.addPropertyValue(isPerformanceOfProperty, modelIndividual);
			}
			
			// model has model type
			RDFIndividual modelTypeIndividual = modelTypeClass.createOWLIndividual("modelType" + "-" + UUIDUtil.creatUUID());
			modelIndividual.addPropertyValue(hasModelTypeProperty, modelTypeIndividual);
			modelTypeIndividual.addPropertyValue(isModelTypeOfProperty, modelIndividual);
			// model type has RNN
			RDFIndividual modelTypeRNNIndividual = modelTypeRNNClass.createOWLIndividual("RNNType" + "-" + UUIDUtil.creatUUID());
			modelTypeRNNIndividual.addPropertyValue(modelTypeRNNNameProperty, "RNN");
			modelTypeIndividual.addPropertyValue(hasRNNTypeProperty, modelTypeRNNIndividual);
			modelTypeRNNIndividual.addPropertyValue(isRNNTypeOfProperty, modelTypeIndividual);
			
			/**
			 *  model layer
			 */
			
			// layer 1 is recurrent layer
			
			// model has model layer
			RDFIndividual modelLayerIndividual1 = modelLayerClass.createOWLIndividual("modelLayer1" + "-" + UUIDUtil.creatUUID());
			modelLayerIndividual1.addPropertyValue(layerNameProperty, "layer1-lstm");
			modelIndividual.addPropertyValue(hasLayerProperty, modelLayerIndividual1);
			modelLayerIndividual1.addPropertyValue(isLayerOfProperty, modelIndividual);
			
			// model layer has core layer
			RDFIndividual coreLayerIndividual1 = coreLayerClass.createOWLIndividual("coreLayer1" + "-" + UUIDUtil.creatUUID());
			modelLayerIndividual1.addPropertyValue(hasCoreLayerProperty, coreLayerIndividual1);
			coreLayerIndividual1.addPropertyValue(isCoreLayerOfProperty, modelLayerIndividual1);
			
			// core layer has core layer type
			RDFIndividual coreLayerTypeIndividual1 = coreLayerTypeClass.createOWLIndividual("coreLayerType1" + "-" + UUIDUtil.creatUUID());
			coreLayerIndividual1.addPropertyValue(hasCoreLayerTypeProperty, coreLayerTypeIndividual1);
			coreLayerTypeIndividual1.addPropertyValue(isCoreLayerTypeOfProperty, coreLayerIndividual1);
			
			// core layer type has layer1
			RDFIndividual layerIndividual1 = recurrentLayerClass.createOWLIndividual("layer1" + "-" + UUIDUtil.creatUUID());
			layerIndividual1.addPropertyValue(recurrentUnitsProperty, 100);
			
			// layer 2 is dropout layer
			
			// model has model layer
			RDFIndividual modelLayerIndividual2= modelLayerClass.createOWLIndividual("modelLayer2" + "-" + UUIDUtil.creatUUID());
			modelLayerIndividual2.addPropertyValue(layerNameProperty, "layer2-dropout");
			modelIndividual.addPropertyValue(hasLayerProperty, modelLayerIndividual2);
			modelLayerIndividual2.addPropertyValue(isLayerOfProperty, modelIndividual);
			
			// model layer has functional layer
			RDFIndividual functionalLayerIndividual2 = functionalLayerClass.createOWLIndividual("functionalLayer2" + "-" + UUIDUtil.creatUUID());
			modelLayerIndividual2.addPropertyValue(hasFunctionalLayerProperty, functionalLayerIndividual2);
			functionalLayerIndividual2.addPropertyValue(isFunctionalLayerOfProperty, modelLayerIndividual2);
			
			// functional layer has dropout layer
			RDFIndividual layerIndividual2 = dropoutLayerClass.createOWLIndividual("layer2" + "-" + UUIDUtil.creatUUID());
			
			layerIndividual2.addPropertyValue(dropoutRankProperty, 1);
			layerIndividual2.addPropertyValue(dropoutRateProperty, new Float(0.5));
			functionalLayerIndividual2.addPropertyValue(hasDropoutLayerProperty, layerIndividual2);
			layerIndividual2.addPropertyValue(isDropoutLayerOfProperty, functionalLayerIndividual2);
			
			
			// layer 3 is dense layer
			
			// model has model layer
			RDFIndividual modelLayerIndividual3 = modelLayerClass.createOWLIndividual("modelLayer3" + "-" + UUIDUtil.creatUUID());
			modelLayerIndividual3.addPropertyValue(layerNameProperty, "layer3-dense");
			modelIndividual.addPropertyValue(hasLayerProperty, modelLayerIndividual3);
			modelLayerIndividual3.addPropertyValue(isLayerOfProperty, modelIndividual);
			
			// model layer has core layer
			RDFIndividual coreLayerIndividual3 = coreLayerClass.createOWLIndividual("coreLayer3" + "-" + UUIDUtil.creatUUID());
			modelLayerIndividual3.addPropertyValue(hasCoreLayerProperty, coreLayerIndividual3);
			coreLayerIndividual3.addPropertyValue(isCoreLayerOfProperty, modelLayerIndividual3);
			
			// core layer has core layer type
			RDFIndividual coreLayerTypeIndividual3 = coreLayerTypeClass.createOWLIndividual("coreLayerType3" + "-" + UUIDUtil.creatUUID());
			coreLayerIndividual3.addPropertyValue(hasCoreLayerTypeProperty, coreLayerTypeIndividual3);
			coreLayerTypeIndividual3.addPropertyValue(isCoreLayerTypeOfProperty, coreLayerIndividual3);
			
			// core layer type has layer 3
			RDFIndividual layerIndividual3 = denseLayerClass.createOWLIndividual("layer3" + "-" + UUIDUtil.creatUUID());
			layerIndividual3.addPropertyValue(denseOutFeaturesProperty, 100);
			coreLayerTypeIndividual3.addPropertyValue(hasDenseLayerProperty, layerIndividual3);
			layerIndividual3.addPropertyValue(isDenseLayerOfProperty, coreLayerTypeIndividual3);

			// core layer has activation function
			RDFIndividual activationFunctionIndividual3 = owlModel.getOWLIndividual("relu");
			coreLayerIndividual3.addPropertyValue(hasActivationFunctionProperty, activationFunctionIndividual3);
			activationFunctionIndividual3.addPropertyValue(isActivationFunctionOfProperty, coreLayerIndividual3);
			
			// core layer has weight
			RDFIndividual weightIndividual3 = weightClass.createOWLIndividual("weight3" + "-" + UUIDUtil.creatUUID());
			coreLayerIndividual3.addPropertyValue(hasWeightProperty, weightIndividual3);
			weightIndividual3.addPropertyValue(isWeightOfProperty, coreLayerIndividual3);
			// weight has initializer
			RDFIndividual initializerIndividual3 = owlModel.getOWLIndividual("GlorotUniform");
			weightIndividual3.addPropertyValue(hasInitializerProperty, initializerIndividual3);
			initializerIndividual3.addPropertyValue(isInitializerOfProperty, weightIndividual3);
			
			// core layer has bias
			RDFIndividual biasIndividual3 = biasClass.createOWLIndividual("bias3" + "-" + UUIDUtil.creatUUID());
			coreLayerIndividual3.addPropertyValue(hasBiasProperty, biasIndividual3);
			biasIndividual3.addPropertyValue(isBiasOfProperty, coreLayerIndividual3);	
			// bias has initializer
			RDFIndividual initializerIndividual4 = owlModel.getOWLIndividual("Zeros");
			biasIndividual3.addPropertyValue(hasInitializerProperty, initializerIndividual4);
			initializerIndividual4.addPropertyValue(isInitializerOfProperty, biasIndividual3);
			
			// layer has previous layer
			modelLayerIndividual2.addPropertyValue(hasPreviousLayerProperty, modelLayerIndividual1);
			modelLayerIndividual1.addPropertyValue(isPreviousLayerOfProperty, modelLayerIndividual2);
			modelLayerIndividual3.addPropertyValue(hasPreviousLayerProperty, modelLayerIndividual2);
			modelLayerIndividual2.addPropertyValue(isPreviousLayerOfProperty, modelLayerIndividual3);

		}
		
		/**
		 * save owl
		 */
		saveOWL(owlModel);
	}
	
}
