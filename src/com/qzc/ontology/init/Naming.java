package com.qzc.ontology.init;

public class Naming {
	/**
	 * persistence
	 */
	public static String OWL_NAME = "DeepLearningModel.owl";
	
	
	public static String CREATE_OWL_PATH = "C:\\Users\\qzc438\\Desktop\\OWL\\" + OWL_NAME;
	public static String LOAD_OWL_PATH = "file:///C:/Users/qzc438/Desktop/OWL/" + OWL_NAME;
	public static String TDB_DATABASE = "C:\\Users\\qzc438\\Desktop\\DataBase";
	
	/**
	public static String CREATE_OWL_PATH = "C:\\Users\\Administrator\\Desktop\\OWL\\" + OWL_NAME;
	public static String LOAD_OWL_PATH = "file:///C:/Users/Administrator/Desktop/OWL/" + OWL_NAME;
	public static String TDB_DATABASE = "C:\\Users\\Administrator\\Desktop\\DataBase";
	**/

	public static String TDB_MODEL = "DeepLearningModel";
	
	/**
	 * Ontology
	 */
	
	/**
	// model
	public static String CLASS_MODEL = "DeepLearningModel";
	// model layer
	public static String CLASS_MODEL_LAYER = "ModelLayer";
	// model has layer
	public static String OBJECT_PROPERTY_HAS_LAYER = "hasLayer";
	public static String OBJECT_PROPERTY_IS_LAYER_OF = "isLayerOf";
	**/

	
	public static String DEFAULT_NAME_SPACE = "http://www.ontology.com#";

	// application
	public static String CLASS_APPLICATION = "DeepLearningApplication";
	public static String DATA_PROPERTY_APPLICATION_NAME = "applicationName";
	
	// has application domain
	// public static String CLASS_APPLICATION_DOMAIN = "ApplicationDomain";
	// public static String OBJECT_PROPERTY_HAS_APPLICATION_DOMAIN = "hasApplicationDomain";
	// public static String OBJECT_PROPERTY_IS_APPLICATION_DOMAIN_OF = "isApplicationDomainOf";
	
	// has healthcare domain
	public static String CLASS_APPLICATION_DOMAIN_HEALTHCARE = "Healthcare";
	public static String DATA_PROPERTY_DOMAIN_HEALTHCARE_NAME = "healthcareName";
	public static String OBJECT_PROPERTY_HAS_HEALTHCARE_APPLICATION = "hasHealthcareApplication";
	public static String OBJECT_PROPERTY_IS_HEALTHCARE_APPLICATION_OF = "isHealthcareApplicationOf";
	// skin cancer
	public static String CLASS_SKIN_CANCER = "SkinCancer";
	public static String DATA_PROPERTY_SKIN_CANCER_NAME = "skinCancerName";
	public static String OBJECT_PROPERTY_HAS_SKIN_CANCER = "hasSkinCancer";
	public static String OBJECT_PROPERTY_IS_SKIN_CANCER_OF = "isSkinCancerOf";
	// musculoskeletal disorder
	public static String CLASS_MUSCULOSKELETAL_DISORDER = "MusculoskeletalDisorder";
	public static String DATA_PROPERTY_MUSCULOSKELETAL_DISORDER_NAME = "musculoskeletalDisorderName";
	public static String OBJECT_PROPERTY_HAS_MUSCULOSKELETAL_DISORDER = "hasMusculoskeletalDisorder";
	public static String OBJECT_PROPERTY_IS_MUSCULOSKELETAL_DISORDER_OF = "isMusculoskeletalDisorderOf";
	// application has data and model
	public static String OBJECT_PROPERTY_HAS_DATA = "hasData";
	public static String OBJECT_PROPERTY_IS_DATA_OF = "isDataOf";
	public static String OBJECT_PROPERTY_HAS_MODEL = "hasModel";
	public static String OBJECT_PROPERTY_IS_MODEL_OF = "isModelOf";
	
	// data
	public static String CLASS_DATA = "Data";
	public static String DATA_PROPERTY_DATA_NAME = "dataName";
	public static String DATA_PROPERTY_DATA_FEATURE = "dataFeature";
	public static String DATA_PROPERTY_DATA_DESCRIPTION = "dataDescription";
	public static String DATA_PROPERTY_DATA_RESOURCE = "dataResource";
	// has sensory type
	public static String CLASS_SENSORY_TYPE = "SensoryType";
	public static String OBJECT_PROPERTY_HAS_SENSORY_TYPE = "hasSensoryType";
	public static String OBJECT_PROPERTY_IS_SENSORY_TYPE_OF = "isSensoryTypeOf";
	// has accelerometer data
	public static String CLASS_SENSORY_TYPE_ACCELEROMETER = "Accelerometer";
	public static String DATA_PROPERTY_ACCELEROMETER_NAME = "accelerometerName";
	public static String OBJECT_PROPERTY_HAS_ACCELEROMETER = "hasAccelerometer";
	public static String OBJECT_PROPERTY_IS_ACCELEROMETER_OF = "isAccelerometerOf";
	// has gyroscope data
	public static String CLASS_DATA_TYPE_GYROSCOPE = "Gyroscope";
	public static String DATA_PROPERTY_GYROSCOPE_NAME = "gyroscopeName";
	public static String OBJECT_PROPERTY_HAS_GYROSCOPE = "hasGyroscope";
	public static String OBJECT_PROPERTY_IS_GYROSCOPE_OF = "isGyroscopeOf";

	// model
	public static String CLASS_MODEL = "DeepLearningModel";
	public static String DATA_PROPERTY_MODEL_NAME = "modelName";
	public static String DATA_PROPERTY_MODEL_DESCRIPTION = "modelDescription";
	public static String DATA_PROPERTY_MODEL_RESOURCE = "modelResource";
	
	// subclass of model
	
	// performance
	public static String CLASS_PERFORMANCE = "Performance";
	public static String DATA_PROPERTY_PERFORMANCE_ACCURACY = "performanceAccuracy";
	public static String DATA_PROPERTY_PERFORMANCE_PRECISION = "performancePrecision";
	public static String DATA_PROPERTY_PERFORMANCE_RECALL = "performanceRecall";
	public static String DATA_PROPERTY_PERFORMANCE_F1SCORE = "performanceF1Score";
	// has performance
	public static String OBJECT_PROPERTY_HAS_PERFORMANCE = "hasPerformance";
	public static String OBJECT_PROPERTY_IS_PERFORMANCE_OF = "isPerformanceOf";
	
	// has model type
	public static String CLASS_MODEL_TYPE = "ModelType";
	public static String OBJECT_PROPERTY_HAS_MODEL_TYPE = "hasModelType";
	public static String OBJECT_PROPERTY_IS_MODEL_TYPE_OF = "isModelTypeOf";
	// has CNN type
	public static String CLASS_MODEL_TYPE_CNN = "CNN";
	public static String DATA_PROPERTY_CNN_TYPE_NAME = "CNNTypeName";
	public static String OBJECT_PROPERTY_HAS_CNN_TYPE = "hasCNNType";
	public static String OBJECT_PROPERTY_IS_CNN_TYPE_OF = "isCNNTypeOf";
	// has RNN type
	public static String CLASS_MODEL_TYPE_RNN = "RNN";
	public static String DATA_PROPERTY_RNN_TYPE_NAME = "RNNTypeName";
	public static String OBJECT_PROPERTY_HAS_RNN_TYPE = "hasRNNType";
	public static String OBJECT_PROPERTY_IS_RNN_TYPE_OF = "isRNNTypeOf";
	
	// model layer
	public static String CLASS_MODEL_LAYER = "ModelLayer";
	public static String DATA_PROPERTY_MODEL_LAYER_NAME = "layerName";
	// has layer
	public static String OBJECT_PROPERTY_HAS_LAYER = "hasLayer";
	public static String OBJECT_PROPERTY_IS_LAYER_OF = "isLayerOf";
	// has previous layer
	public static String OBJECT_PROPERTY_HAS_PREVIOUS_LAYER = "hasPreviousLayer";
	public static String OBJECT_PROPERTY_IS_PREVIOUS_LAYER_OF = "isPreviousLayerOf";
	
	// subclass of layer
	
	// functional layer
	public static String CLASS_FUNCTIONAL_LAYER = "FunctionalLayer";
	public static String OBJECT_PROPERTY_HAS_FUNCTIONAL_LAYER = "hasFunctionalLayer";
	public static String OBJECT_PROPERTY_IS_FUNCTIONAL_LAYER_OF = "isFunctionalLayerOf";
	
	// pooling layer
	public static String CLASS_POOLING_LAYER = "PoolingLayer";
	public static String DATA_PROPERTY_POOLING_RANK = "poolingRank";
	public static String DATA_PROPERTY_POOLING_TYPE = "poolingType";
	public static String DATA_PROPERTY_POOLING_KERNEL_SIZE = "poolingKernelSize";
	public static String DATA_PROPERTY_POOLING_POOL_SIZE = "poolingPoolSize";
	public static String DATA_PROPERTY_POOLING_STRIDES = "poolingStrides";
	public static String DATA_PROPERTY_POOLING_PADDING = "poolingPadding";
	public static String DATA_PROPERTY_POOLING_DILATION = "poolingDilation";
	// has pooling layer
	public static String OBJECT_PROPERTY_HAS_POOLING_LAYER = "hasPoolingLayer";
	public static String OBJECT_PROPERTY_IS_POOLING_LAYER_OF = "isPoolingLayerOf";
	
	// reshaping layer
	public static String CLASS_RESHAPING_LAYER = "ReshapingLayer";
	public static String DATA_PROPERTY_RESHAPING_RANK = "reshapingRank";
	public static String DATA_PROPERTY_RESHAPING_TYPE = "reshapingType";
	public static String DATA_PROPERTY_RESHAPING_TARGET_SHAPE = "reshapingTargetShape";
	// has reshaping layer
	public static String OBJECT_PROPERTY_HAS_RESHAPING_LAYER = "hasReshapingLayer";
	public static String OBJECT_PROPERTY_IS_RESHAPING_LAYER_OF = "isReshapingLayerOf";
	
	// dropout layer
	public static String CLASS_DROPOUT_LAYER = "DropoutLayer";
	public static String DATA_PROPERTY_DROPOUT_RANK = "dropoutRank";
	public static String DATA_PROPERTY_DROPOUT_RATE = "dropoutRate";
	public static String DATA_PROPERTY_DROPOUT_NOISE_SHAPE = "dropoutNoiseShape";
	public static String DATA_PROPERTY_DROPOUT_SEED = "dropoutSeed";
	// has dropout layer
	public static String OBJECT_PROPERTY_HAS_DROPOUT_LAYER = "hasDropoutLayer";
	public static String OBJECT_PROPERTY_IS_DROPOUT_LAYER_OF = "isDropoutLayerOf";
	
	// subclass of layer
	
	// core layer
	public static String CLASS_CORE_LAYER = "CoreLayer";
	// has core layer
	public static String OBJECT_PROPERTY_HAS_CORE_LAYER = "hasCoreLayer";
	public static String OBJECT_PROPERTY_IS_CORE_LAYER_OF = "isCoreLayerOf";
	// has layer type
	public static String CLASS_CORE_LAYER_TYPE = "CoreLayerType";
	public static String OBJECT_PROPERTY_HAS_CORE_LAYER_TYPE = "hasCoreLayerType";
	public static String OBJECT_PROPERTY_IS_CORE_LAYER_TYPE_OF = "isCoreLayerTypeOf";
	
	// dense layer
	public static String CLASS_DENSE_LAYER = "DenseLayer";
	public static String CLASS_FULLY_CONNECTED_LAYER = "FullyConnectedLayer";
	public static String DATA_PROPERTY_DENSE_OUT_FEATURES= "denseOutFeatures";
	public static String DATA_PROPERTY_DENSE_UNITS = "denseUnits";
	// has dense layer
	public static String OBJECT_PROPERTY_HAS_DENSE_LAYER = "hasDenseLayer";
	public static String OBJECT_PROPERTY_IS_DENSE_LAYER_OF = "isDenseLayerOf";
	
	// convolution layer
	public static String CLASS_CONVOLUTION_LAYER = "ConvolutionLayer";
	public static String DATA_PROPERTY_CONVOLUTION_RANK = "convolutionRank";
	// public static String DATA_PROPERTY_CONVOLUTION_IN_CHANNELS = "convolutionInChannels";
	public static String DATA_PROPERTY_CONVOLUTION_OUT_CHANNELS = "convolutionOutChannels";
	public static String DATA_PROPERTY_CONVOLUTION_FILTERS = "convolutionFilters";
	public static String DATA_PROPERTY_CONVOLUTION_KERNEL_SIZE = "convolutionKernelSize";
	public static String DATA_PROPERTY_CONVOLUTION_STRIDES = "convolutionStrides";
	public static String DATA_PROPERTY_CONVOLUTION_PADDING = "convolutionPadding";
	public static String DATA_PROPERTY_CONVOLUTION_DILATION = "convolutionDilation";
	public static String DATA_PROPERTY_CONVOLUTION_GROUPS = "convolutionGroups";
	// has convolution layer
	public static String OBJECT_PROPERTY_HAS_CONVOLUTION_LAYER = "hasConvolutionLayer";
	public static String OBJECT_PROPERTY_IS_CONVOLUTION_LAYER_OF = "isConvolutionLayerOf";
	
	// recurrent layer
	public static String CLASS_RECURRENT_LAYER = "RecurrentLayer";
	public static String DATA_PROPERTY_RECURRENT_RETURN_SEQUENCE =  "recurrentReturnSequence";
	public static String DATA_PROPERTY_RECURRENT_RETURN_STATE =  "recurrentReturnState";
	public static String DATA_PROPERTY_RECURRENT_GOBACKWARDS = "recurrentGoBackwards";
	public static String DATA_PROPERTY_RECURRENT_STATEFUL = "recurrentStateful";
	public static String DATA_PROPERTY_RECURRENT_TIME_MAJOR = "recurrentTimeMajor";
	public static String DATA_PROPERTY_RECURRENT_UNROLL = "recurrentUnroll";
	public static String DATA_PROPERTY_RECURRENT_UNIT_FORGET_BIAS = "recurrentUnitForgetBias";
	public static String DATA_PROPERTY_RECURRENT_UNITS =  "recurrentUnits";
	public static String DATA_PROPERTY_RECURRENT_IMPLEMENTTATION = "recurrentImplementation";
	public static String DATA_PROPERTY_RECURRENT_DROPOUT = "recurrentDropout";
	public static String DATA_PROPERTY_RECURRENT_RECURRENT_DROPOUT = "recurrentRecurrentDropout";
	// has recurrent layer
	public static String OBJECT_PROPERTY_HAS_RECURRENT_LAYER = "hasRecurrentLayer";
	public static String OBJECT_PROPERTY_IS_RECURRENT_LAYER_OF = "isRecurrentLayerOf";
	
	// core layer has weight,bias and activation
	public static String CLASS_ACTIVATION_FUNCTION = "ActivationFunction";
	public static String OBJECT_PROPERTY_HAS_ACTIVATION_FUNCTION = "hasActivationFunction";
	public static String OBJECT_PROPERTY_IS_ACTIVATION_FUNCTION_OF = "isActivationFunctionOf";
	public static String CLASS_WEIGHT = "Weight";
	public static String OBJECT_PROPERTY_HAS_WEIGHT = "hasWeight";
	public static String OBJECT_PROPERTY_IS_WEIGHT_OF = "isWeightOf";
	public static String CLASS_BIAS = "Bias";
	public static String OBJECT_PROPERTY_HAS_BIAS = "hasBias";
	public static String OBJECT_PROPERTY_IS_BIAS_OF = "isBiasOf";
	
	// recurrent layer has recurrent
	public static String CLASS_RECURRENT = "Recurrent";
	public static String OBJECT_PROPERTY_HAS_RECURRENT = "hasRecurrent";
	public static String OBJECT_PROPERTY_IS_RECURRENT_OF = "isRecurrentOf";
	public static String OBJECT_PROPERTY_HAS_RECURRENT_ACTIVATION_FUNCTION = "hasRecurrentActivationFunction";
	public static String OBJECT_PROPERTY_IS_RECURRENT_ACTIVATION_FUNCTION_OF = "isRecurrentActivationFunctionOf";
	
	// weight, bias and recurrent has processing argument
	public static String CLASS_PROCESSING_ARGUMENT = "ProcessingArgument";
	public static String OBJECT_PROPERTY_HAS_PROCESSING_ARGUMENT = "hasProcessingArgument";
	public static String OBJECT_PROPERTY_IS_PROCESSING_ARGUMENT_OF = "isProcessingArgumentOf";

	// processing argument has Initializer, constraint and regularizer
	public static String CLASS_INITIALIZER = "Initializer";
	public static String OBJECT_PROPERTY_HAS_INITIALIZER = "hasInitializer";
	public static String OBJECT_PROPERTY_IS_INITIALIZER_OF = "isInitializerOf";
	public static String CLASS_CONSTRAINT = "Constraint";
	public static String OBJECT_PROPERTY_HAS_CONSTRAINT = "hasConstraint";
	public static String OBJECT_PROPERTY_IS_CONSTRAINT_OF = "isConstraintOf";
	public static String CLASS_REGULARIZER = "Regularizer";
	public static String OBJECT_PROPERTY_HAS_REGULARIZER = "hasRegularizer";
	public static String OBJECT_PROPERTY_IS_REGULARIZER_OF = "isRegularizerOf";

}
