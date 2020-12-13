package com.qzc.ontology.mbean;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.jena.query.Dataset;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ReadWrite;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.vocabulary.OWL;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;
import org.apache.jena.vocabulary.XSD;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.qzc.ontology.init.Naming;
import com.qzc.util.TDBDatabase;
import com.qzc.view.ApplicationDomain;
import com.qzc.view.ApplicationOverview;
import com.qzc.view.ApplicationSummary;
import com.qzc.view.CoreLayerType;
import com.qzc.view.SensoryType;
import com.qzc.view.Filters;
import com.qzc.view.FunctionalLayerType;
import com.qzc.view.LayerDescription;
import com.qzc.view.LayerType;
import com.qzc.view.ModelStructure;
import com.qzc.view.ModelType;

public class OntologyManagedBean implements Serializable {

	Dataset dataset;

	StringBuffer prefix;

	public OntologyManagedBean() {
		// init dataset
		dataset = TDBDatabase.getTDBDatabase().getDataset();
		// init prefix
		prefix = new StringBuffer();
		prefix.append("prefix onto: <" + Naming.DEFAULT_NAME_SPACE + ">\n");
		prefix.append("prefix xsd: <" + XSD.getURI() + ">\n");
		prefix.append("prefix owl: <" + OWL.getURI() + ">\n");
		prefix.append("prefix rdf: <" + RDF.getURI() + ">\n");
		prefix.append("prefix rdfs: <" + RDFS.getURI() + ">\n");
	}

	// test
	public static void main(String[] args) {
		OntologyManagedBean ontologyManagedBean = new OntologyManagedBean();
		// System.out.println(ontologyManagedBean.findAllApplicationDomains());
		//System.out.println(ontologyManagedBean.findAllSensoryTypes());
		// System.out.println(ontologyManagedBean.findAllModelTypes());
		// System.out.println(ontologyManagedBean.findAllLayerTypes());
		// System.out.println(ontologyManagedBean.findAllCoreLayerTypes());
		// System.out.println(ontologyManagedBean.findAllFunctionalLayerTypes());
		// System.out.println(ontologyManagedBean.searchApplicationSummaries(null,null));
		// List<ModelStructure> li = ontologyManagedBean.searchModelStuctureModelID("model-18993ad361964463bd80e5bdaecfa4ae");
		// List<ModelStructure> sortli = ontologyManagedBean.sortModelStructure(li);
		// System.out.println(sortli);
		// System.out.println(ontologyManagedBean.findApplicationSummaryByApplicationID("application-b456597c22c74f689c945a00592a7ac8"));
		System.out.println(ontologyManagedBean.searchApplicationSummariesUseSameData("data-541e2f1a25fd46339a8b5ae094cde79b", "application-b456597c22c74f689c945a00592a7ac8"));
		// System.out.println(ontologyManagedBean.searchLayerDescripitionByLayerID("modelLayer1-a300d7036fb047d38331ddf8cf7aced4"));
	}

	// find json result
	public String findJsonResult(String sparql) {
		// query
		String SPARQL = prefix.toString() + sparql.toString();
		// query model
		dataset.begin(ReadWrite.READ);
		Model model = dataset.getNamedModel(Naming.TDB_MODEL);
		Query query = QueryFactory.create(SPARQL);
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		ResultSet rs = qe.execSelect();
		// write to a ByteArrayOutputStream
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ResultSetFormatter.outputAsJSON(outputStream, rs);
		// turn that into a String
		String str = new String(outputStream.toByteArray());
		qe.close();
		dataset.commit();
		dataset.end();
		return str;
	}

	// find all application domains
	public List<ApplicationDomain> findAllApplicationDomains() {
		// sparql
		String sparql = "SELECT ?applicationDomain WHERE {?applicationDomain rdfs:subClassOf onto:Healthcare.}";
		// test
		String jsonString = findJsonResult(sparql);
		System.out.println("findAllApplicationDomains:" + jsonString);
		// result
		JSONObject json;
		try {
			json = new JSONObject(jsonString);
			JSONArray jsonArray = json.getJSONObject("results").getJSONArray("bindings");
			List<ApplicationDomain> list = new ArrayList<ApplicationDomain>();
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
				ApplicationDomain applicationDomain = new ApplicationDomain();
				if (jsonObject.has("applicationDomain")) {
					applicationDomain.setApplicationDomainName(
							jsonObject.getJSONObject("applicationDomain").getString("value").split("#")[1]);
				}
				list.add(applicationDomain);
			}
			return list;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	// find all sensory types
	public List<SensoryType> findAllSensoryTypes() {
		// sparql
		String sparql = "SELECT ?sensoryType WHERE {?sensoryType rdfs:subClassOf onto:SensoryType.}";
		// test
		String jsonString = findJsonResult(sparql);
		System.out.println("findAllSensoryTypes:" + jsonString);
		// result
		JSONObject json;
		try {
			json = new JSONObject(jsonString);
			JSONArray jsonArray = json.getJSONObject("results").getJSONArray("bindings");
			List<SensoryType> list = new ArrayList<SensoryType>();
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
				SensoryType sensoryType = new SensoryType();
				if (jsonObject.has("sensoryType")) {
					sensoryType.setSensoryTypeName(jsonObject.getJSONObject("sensoryType").getString("value").split("#")[1]);
				}
				list.add(sensoryType);
			}
			return list;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// find all model types
	public List<ModelType> findAllModelTypes() {
		// sparql
		String sparql = "SELECT ?modelType WHERE {?modelType rdfs:subClassOf onto:ModelType.}";
		// test
		String jsonString = findJsonResult(sparql);
		System.out.println("findAllModelTypes:" + jsonString);
		// result
		JSONObject json;
		try {
			json = new JSONObject(jsonString);
			JSONArray jsonArray = json.getJSONObject("results").getJSONArray("bindings");
			List<ModelType> list = new ArrayList<ModelType>();
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
				ModelType modelType = new ModelType();
				if (jsonObject.has("modelType")) {
					modelType.setModelTypeName(jsonObject.getJSONObject("modelType").getString("value").split("#")[1]);
				}
				list.add(modelType);
			}
			return list;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// find all layer types
	public List<LayerType> findAllLayerTypes() {
		// sparql
		String sparql = "SELECT ?layerType WHERE {?layerType rdfs:subClassOf onto:ModelLayer.}";
		// test
		String jsonString = findJsonResult(sparql);
		System.out.println("findAllLayerTypes:" + jsonString);
		// result
		JSONObject json;
		try {
			json = new JSONObject(jsonString);
			JSONArray jsonArray = json.getJSONObject("results").getJSONArray("bindings");
			List<LayerType> list = new ArrayList<LayerType>();
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
				LayerType layerType = new LayerType();
				if (jsonObject.has("layerType")) {
					layerType.setLayerTypeName(jsonObject.getJSONObject("layerType").getString("value").split("#")[1]);
				}
				list.add(layerType);
			}
			return list;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// find all core layer types
	public List<CoreLayerType> findAllCoreLayerTypes() {
		// sparql
		String sparql = "SELECT ?coreLayerType WHERE {?coreLayerType rdfs:subClassOf onto:CoreLayerType.}";
		// test
		String jsonString = findJsonResult(sparql);
		System.out.println("findAllCoreLayerTypes:" + jsonString);
		// result
		JSONObject json;
		try {
			json = new JSONObject(jsonString);
			JSONArray jsonArray = json.getJSONObject("results").getJSONArray("bindings");
			List<CoreLayerType> list = new ArrayList<CoreLayerType>();
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
				CoreLayerType coreLayerType = new CoreLayerType();
				if (jsonObject.has("coreLayerType")) {
					coreLayerType.setCoreLayerTypeName(
							jsonObject.getJSONObject("coreLayerType").getString("value").split("#")[1]);
				}
				list.add(coreLayerType);
			}
			return list;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// find all functional layer types
	public List<FunctionalLayerType> findAllFunctionalLayerTypes() {
		// sparql
		String sparql = "SELECT ?functionalLayerType WHERE {?functionalLayerType rdfs:subClassOf onto:FunctionalLayer.}";
		// test
		String jsonString = findJsonResult(sparql);
		System.out.println("findAllFunctionalLayerTypes:" + jsonString);
		// result
		JSONObject json;
		try {
			json = new JSONObject(jsonString);
			JSONArray jsonArray = json.getJSONObject("results").getJSONArray("bindings");
			List<FunctionalLayerType> list = new ArrayList<FunctionalLayerType>();
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
				FunctionalLayerType functinalLayerType = new FunctionalLayerType();
				if (jsonObject.has("functionalLayerType")) {
					functinalLayerType.setFunctionalLayerTypeName(
							jsonObject.getJSONObject("functionalLayerType").getString("value").split("#")[1]);
				}
				list.add(functinalLayerType);
			}
			return list;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// find application overview by filter
	public List<ApplicationSummary> searchApplicationSummaries(Filters filters, String keyword) {

		// sparql
//		String sparql = "SELECT Distinct ?application ?applicationName ?healthcareApplication ?healthcareApplicationName \r\n"
//				+ "?data ?dataName ?dataFeature ?dataDescription ?dataResource ?acceleratorName ?gyroscopeName \r\n"
//				+ "?model ?modelName ?modelDescription ?modelResource ?CNNTypeName ?RNNTypeName\r\n"
//				+ "?modelPerformance ?performanceAccuracy ?performancePrecision ?performanceRecall ?performanceF1Score\r\n"
//				+ "WHERE {\r\n" + "	?application rdf:type onto:DeepLearningApplication.\r\n"
//				+ "  	?application onto:applicationName ?applicationName.\r\n"
//				+ "  	?application onto:hasApplicationDomain ?applicationDomain.\r\n"
//				+ " 	OPTIONAL{?applicationDomain onto:hasHealthcareApplication ?healthcareApplication.\r\n"
//				+ "  		?healthcareApplication onto:healthcareName ?healthcareApplicationName.}\r\n"
//				+ "    	?application onto:hasData ?data.\r\n"
//				+ "  	?data onto:dataName ?dataName.\r\n"
//				+ "		?data onto:dataFeature ?dataFeature.\r\n"
//				+ "  	?data onto:dataDescription ?dataDescription.\r\n"
//				+ "  	?data onto:dataResource ?dataResource.\r\n"
//				+ "     ?data onto:hasSensoryType ?sensoryType.\r\n"
//				+ "     OPTIONAL{?sensoryType onto:hasAccelerator ?accelerator.\r\n"
//				+ "     	?accelerator onto:acceleratorName ?acceleratorName.}\r\n"
//				+ "     OPTIONAL{?sensoryType onto:hasGyroscope ?gyroscope.\r\n"
//				+ "     	?gyroscope onto:gyroscopeName ?gyroscopeName.}\r\n"
//				+ "	    ?application onto:hasModel ?model.\r\n" + "  	?model onto:modelName ?modelName.\r\n"
//				+ "  	?model onto:modelDescription ?modelDescription.\r\n"
//				+ "  	?model onto:modelResource ?modelResource.\r\n"
//				+ "     OPTIONAL{?model onto:hasPerformance ?modelPerformance.}\r\n"
//				+ "     OPTIONAL{?modelPerformance onto:performanceAccuracy ?performanceAccuracy.}\r\n"
//				+ "     OPTIONAL{?modelPerformance onto:performancePrecision ?performancePrecision.}\r\n"
//				+ "     OPTIONAL{?modelPerformance onto:performanceRecall ?performanceRecall.}\r\n"
//				+ "     OPTIONAL{?modelPerformance onto:performanceF1Score ?performanceF1Score.}\r\n"
//				+ "     ?model onto:hasModelType ?modelType.\r\n"
//				+ "     OPTIONAL{?modelType onto:hasCNNType ?CNNType.\r\n"
//				+ "     	?CNNType onto:CNNTypeName ?CNNTypeName.}\r\n"
//				+ "     OPTIONAL{?modelType onto:hasRNNType ?RNNType.\r\n"
//				+ "     	?RNNType onto:RNNTypeName ?RNNTypeName.}\r\n"
//				+ "		?model onto:hasLayer ?modelLayer."
//				+ "     ?modelLayer ?a ?b.\r\n"
//				+ "  	?b ?c ?d.\r\n" 
//				+ "  	?d ?e ?f.\r\n";
		
		String sparql = "SELECT Distinct ?application ?applicationName ?healthcareApplication ?healthcareApplicationName \r\n"
				+ "?skinCancerName ?musculoskeletalDisorderName \r\n"
				+ "?data ?dataName ?dataFeature ?dataDescription ?dataResource ?accelerometerName ?gyroscopeName \r\n"
				+ "(COUNT(Distinct ?model) as ?modelNumber)\r\n"
				+ "(COUNT(Distinct ?modelLayer)/COUNT(Distinct ?model) as ?numberOfLayers)\r\n"
				+ "(MAX(?performanceAccuracy) as ?maxAccuracy) (MAX(?performancePrecision) as ?maxPrecision) (MAX(?performanceRecall) as ?maxRecall) (MAX(?performanceF1Score) as ?maxF1Score)\r\n"
				+ "WHERE {\r\n" 
				+ "		?application rdf:type onto:DeepLearningApplication.\r\n"
				+ "  	?application onto:applicationName ?applicationName.\r\n"
				+ "  	?application onto:hasHealthcareApplication ?healthcareApplication.\r\n"
				+ " 	OPTIONAL{?healthcareApplication onto:healthcareName ?healthcareApplicationName.}\r\n"
			  	+ "     OPTIONAL{?healthcareApplication onto:hasSkinCancer ?skinCancerApplication.\r\n"
			  	+ "		?skinCancerApplication onto:skinCancerName ?skinCancerName.}\r\n"
			  	+ "		OPTIONAL{?healthcareApplication onto:hasMusculoskeletalDisorder ?musculoskeletalDisorderApplication.\r\n"
			  	+ " 	?musculoskeletalDisorderApplication onto:musculoskeletalDisorderName ?musculoskeletalDisorderName.}\r\n"
				+ "    	?application onto:hasData ?data.\r\n"
				+ "  	?data onto:dataName ?dataName.\r\n"
				+ "		?data onto:dataFeature ?dataFeature.\r\n"
				+ "  	?data onto:dataDescription ?dataDescription.\r\n"
				+ "  	?data onto:dataResource ?dataResource.\r\n"
				+ "     ?data onto:hasSensoryType ?sensoryType.\r\n"
				+ "     OPTIONAL{?sensoryType onto:hasAccelerometer ?accelerometer. ?accelerometer onto:accelerometerName ?accelerometerName.}\r\n"
				+ "     OPTIONAL{?sensoryType onto:hasGyroscope ?gyroscope. ?gyroscope onto:gyroscopeName ?gyroscopeName.}\r\n"
				+ "	    ?application onto:hasModel ?model.\r\n" 
				+ "  	?model onto:modelName ?modelName.\r\n"
				+ "  	?model onto:modelDescription ?modelDescription.\r\n"
				+ "  	?model onto:modelResource ?modelResource.\r\n"
				+ "     OPTIONAL{?model onto:hasPerformance ?modelPerformance.}\r\n"
				+ "     OPTIONAL{?modelPerformance onto:performanceAccuracy ?performanceAccuracy.}\r\n"
				+ "     OPTIONAL{?modelPerformance onto:performancePrecision ?performancePrecision.}\r\n"
				+ "     OPTIONAL{?modelPerformance onto:performanceRecall ?performanceRecall.}\r\n"
				+ "     OPTIONAL{?modelPerformance onto:performanceF1Score ?performanceF1Score.}\r\n"
				+ "     ?model onto:hasModelType ?modelType.\r\n"
				+ "     OPTIONAL{?modelType onto:hasCNNType ?CNNType. ?CNNType onto:CNNTypeName ?CNNTypeName.}\r\n"
				+ "     OPTIONAL{?modelType onto:hasRNNType ?RNNType. ?RNNType onto:RNNTypeName ?RNNTypeName.}\r\n"
				+ "		?model onto:hasLayer ?modelLayer.\r\n"
//				+ "     ?modelLayer ?modelLayerhasSublayer ?coreOrFunctionalLayer.\r\n"
//				+ "  	?coreOrFunctionalLayer ?coreFunctionalhasSublayer ?coreLayerType.\r\n" 
//				+ "  	?corelayerType ?coreLayerTypehasSublayer ?corelayerSublayer.\r\n";
				+ "     ?modelLayer ?a ?b.\r\n"
				+ "  	?b ?c ?d.\r\n" 
				+ "  	?d ?e ?f.\r\n";
		if (filters != null) {
			// find all filters
			List<String> applicationDomains = filters.getApplicationDomains();
			List<String> sensoryTypes = filters.getSensoryTypes();
			List<String> modelTypes = filters.getModelTypes();
			List<String> layerTypes = filters.getLayerTypes();
			List<String> coreLayerTypes = filters.getCoreLayerTypes();
			List<String> functionalLayerTypes = filters.getFunctionalLayerTypes();
			// find all performance, /100 because of the percentage
			// Float performanceAccurcay = filters.getPerformanceAccuracy()/100;
			// Float performancePrecision = filters.getPerformancePrecision()/100;
			// Float performanceRecall = filters.getPerformanceRecall()/100;
			// Float performanceF1Score = filters.getPerformanceF1Score()/100;

			// filter by application domain
			if (applicationDomains != null) {
				for (String str : applicationDomains) {
					if (str.equals("SkinCancer")) {
						sparql += "FILTER (?skinCancerName != \"\")\r\n";
					}
					if (str.equals("MusculoskeletalDisorder")) {
						sparql += "FILTER (?musculoskeletalDisorderName != \"\")\r\n";
					}
				}
			}
			// filter by sensory type
			if (sensoryTypes != null) {
				for (String str : sensoryTypes) {
					if (str.equals("Accelerometer")) {
						sparql += "FILTER (?accelerometerName != \"\")\r\n";
					}
					if (str.equals("Gyroscope")) {
						sparql += "FILTER (?gyroscopeName != \"\")\r\n";
					}
				}
			}
			// filter model type
			if (modelTypes != null) {
				for (String str : modelTypes) {
					if (str.equals("CNN")) {
						sparql += "FILTER (?CNNTypeName != \"\")\r\n";
					}
					if (str.equals("RNN")) {
						sparql += "FILTER (?RNNTypeName != \"\")\r\n";
					}
				}
			}
			// filter by layer type
			String layerTypeFilter = "";
			if (layerTypes != null) {
				for (String str : layerTypes) {
//					if (str.equals("FunctionalLayer")) {
//						layerTypeFilter += "?modelLayerhasSublayer = onto:hasFunctionalLayer ||";
//					}
//					if (str.equals("CoreLayer")) {
//						layerTypeFilter += "?modelLayerhasSublayer = onto:hasCoreLayer ||";
//					}
					if (str.equals("FunctionalLayer")) {
						layerTypeFilter += "?a = onto:hasFunctionalLayer ||";
					}
					if (str.equals("CoreLayer")) {
						layerTypeFilter += "?a = onto:hasCoreLayer ||";
					}
				}
				if (layerTypeFilter.length() - 2 > 0) {
					layerTypeFilter = layerTypeFilter.substring(0, layerTypeFilter.length() - 2);
					sparql += "FILTER (" + layerTypeFilter + ")\r\n";
				}
			}
//			// filter by functional layer
//			String functionalLayerFilter = "";
//			if (functionalLayerTypes != null) {
//				for (String str : functionalLayerTypes) {
//					if (str.equals("ReshapingLayer")) {
//						functionalLayerFilter += "?c = onto:hasReshapingLayer ||";
//					}
//					if (str.equals("PoolingLayer")) {
//						functionalLayerFilter += "?c = onto:hasPoolingLayer ||";
//					}
//					if (str.equals("DropoutLayer")) {
//						functionalLayerFilter += "?c = onto:hasDropoutLayer ||";
//					}
//				}
//				if (functionalLayerFilter.length() - 2 > 0) {
//					functionalLayerFilter = functionalLayerFilter.substring(0, functionalLayerFilter.length() - 2);
//					sparql += "    	FILTER (" + functionalLayerFilter + ")\r\n";
//				}
//			}
//			// filter by core layer
//			String coreLayerFilter = "";
//			if (coreLayerTypes != null) {
//				for (String str : coreLayerTypes) {
//					if (str.equals("ConvolutionLayer")) {
//						coreLayerFilter += "?e = onto:hasConvolutionLayer ||";
//					}
//					if (str.equals("RecurrentLayer")) {
//						coreLayerFilter += "?e = onto:hasRecurrentLayer ||";
//					}
//					if (str.equals("DenseLayer")) {
//						coreLayerFilter += "?e = onto:hasDenseLayer ||";
//					}
//				}
//				if (coreLayerFilter.length() - 2 > 0) {
//					coreLayerFilter = coreLayerFilter.substring(0, coreLayerFilter.length() - 2);
//					sparql += "    	FILTER (" + coreLayerFilter + ")\r\n";
//				}
//			}
			
			// filter by functional layer
			String functionalLayerFilter = "";
			if (functionalLayerTypes != null) {
				for (String str : functionalLayerTypes) {
//					if (str.equals("ReshapingLayer")) {
//						functionalLayerFilter += "?coreFunctionalhasSublayer = onto:hasReshapingLayer ||";
//					}
//					if (str.equals("PoolingLayer")) {
//						functionalLayerFilter += "?coreFunctionalhasSublayer = onto:hasPoolingLayer ||";
//					}
//					if (str.equals("DropoutLayer")) {
//						functionalLayerFilter += "?coreFunctionalhasSublayer = onto:hasDropoutLayer ||";
//					}
					if (str.equals("ReshapingLayer")) {
						functionalLayerFilter += "?c = onto:hasReshapingLayer ||";
					}
					if (str.equals("PoolingLayer")) {
						functionalLayerFilter += "?c = onto:hasPoolingLayer ||";
					}
					if (str.equals("DropoutLayer")) {
						functionalLayerFilter += "?c = onto:hasDropoutLayer ||";
					}
				}
			}
			// filter by core layer
			String coreLayerFilter = "";
			if (coreLayerTypes != null) {
				for (String str : coreLayerTypes) {
//					if (str.equals("ConvolutionLayer")) {
//						coreLayerFilter += "?coreLayerTypehasSublayer = onto:hasConvolutionLayer ||";
//					}
//					if (str.equals("RecurrentLayer")) {
//						coreLayerFilter += "?coreLayerTypehasSublayer = onto:hasRecurrentLayer ||";
//					}
//					if (str.equals("DenseLayer")) {
//						coreLayerFilter += "?coreLayerTypehasSublayer = onto:hasDenseLayer ||";
//					}
					if (str.equals("ConvolutionLayer")) {
						coreLayerFilter += "?e = onto:hasConvolutionLayer ||";
					}
					if (str.equals("RecurrentLayer")) {
						coreLayerFilter += "?e = onto:hasRecurrentLayer ||";
					}
					if (str.equals("DenseLayer")) {
						coreLayerFilter += "?e = onto:hasDenseLayer ||";
					}
				}
			}
			
			// summarize
			String detailLayerFilter = "";
			if (functionalLayerFilter.length() + coreLayerFilter.length()- 2 > 0) {
				detailLayerFilter = (functionalLayerFilter+ coreLayerFilter).substring(0, functionalLayerFilter.length()+ coreLayerFilter.length() - 2);
				sparql += "FILTER (" + detailLayerFilter + ")\r\n";
			}
			
			
			// filter by performance
			if (filters.getPerformanceAccuracy() != null) {
				sparql += "FILTER (?performanceAccuracy > " + filters.getPerformanceAccuracy() + ")\r\n";
			}
			if (filters.getPerformancePrecision() != null) {
				sparql += "FILTER (?performancePrecision > " + filters.getPerformancePrecision() + ")\r\n";
			}
			if (filters.getPerformanceRecall() != null) {
				sparql += "FILTER (?performanceRecall > " + filters.getPerformanceRecall() + ")\r\n";
			}
			if (filters.getPerformanceF1Score() != null) {
				sparql += "FILTER (?performanceF1Score > " + filters.getPerformanceF1Score() + ")\r\n";
			}
		}
		
		// filter by keyword
		if (keyword != null) {
			sparql += "FILTER (";
			sparql += "regex(?applicationName,\"" + keyword + "\",\"i\") || ";
			sparql += "regex(?dataName,\"" + keyword + "\",\"i\") || ";
			sparql += "regex(?modelName,\"" + keyword + "\",\"i\")";
			sparql += ")\r\n";
		}

		// end where
		sparql += "}";
		sparql += "GROUP BY\r\n";
		sparql += "?application ?applicationName ?healthcareApplication ?healthcareApplicationName\r\n";
		sparql += "?data ?dataName ?dataFeature ?dataDescription ?dataResource ?accelerometerName ?gyroscopeName\r\n";
		sparql += "?skinCancerName ?musculoskeletalDisorderName\r\n";
		
		if(filters != null && filters.getNumberOfLayers()!=null) {
			//filter by number of layers
			sparql += "Having (COUNT(Distinct ?modelLayer)/COUNT(Distinct ?model)>=" + filters.getNumberOfLayers() + ")";
		}
		
		// test
		String jsonString = findJsonResult(sparql);
		System.out.println("searchApplications:" + jsonString);
		// result
//		JSONObject json;
//		try {
//			json = new JSONObject(jsonString);
//			JSONArray jsonArray = json.getJSONObject("results").getJSONArray("bindings");
//			List<ApplicationOverview> list = new ArrayList<ApplicationOverview>();
//			for (int i = 0; i < jsonArray.length(); i++) {
//				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
//				ApplicationOverview applicationOverview = new ApplicationOverview();
//				if (jsonObject.has("application")) {
//					applicationOverview
//							.setApplication(jsonObject.getJSONObject("application").getString("value").split("#")[1]);
//				}
//				if (jsonObject.has("applicationName")) {
//					applicationOverview
//							.setApplicationName(jsonObject.getJSONObject("applicationName").getString("value"));
//				}
//				if (jsonObject.has("healthcareApplicationName")) {
//					applicationOverview
//							.setHealthcareApplicationName(jsonObject.getJSONObject("healthcareApplicationName").getString("value"));
//				}
//				if (jsonObject.has("data")) {
//					applicationOverview.setData(jsonObject.getJSONObject("data").getString("value").split("#")[1]);
//				}
//				if (jsonObject.has("dataName")) {
//					applicationOverview.setDataName(jsonObject.getJSONObject("dataName").getString("value"));
//				}
//				if (jsonObject.has("dataFeature")) {
//					applicationOverview.setDataFeature(jsonObject.getJSONObject("dataFeature").getString("value"));
//				}
//				if (jsonObject.has("dataDescription")) {
//					applicationOverview
//							.setDataDescription(jsonObject.getJSONObject("dataDescription").getString("value"));
//				}
//				if (jsonObject.has("dataResource")) {
//					applicationOverview.setDataResource(jsonObject.getJSONObject("dataResource").getString("value"));
//				}
//				if (jsonObject.has("acceleratorName")) {
//					applicationOverview
//							.setAcceleratorName(jsonObject.getJSONObject("acceleratorName").getString("value"));
//				}
//				if (jsonObject.has("gyroscopeName")) {
//					applicationOverview
//							.setGyroscopeName(jsonObject.getJSONObject("gyroscopeName").getString("value"));
//				}
//				if (jsonObject.has("model")) {
//					applicationOverview.setModel(jsonObject.getJSONObject("model").getString("value").split("#")[1]);
//				}
//				if (jsonObject.has("modelName")) {
//					applicationOverview.setModelName(jsonObject.getJSONObject("modelName").getString("value"));
//				}
//				if (jsonObject.has("modelDescription")) {
//					applicationOverview
//							.setModelDescription(jsonObject.getJSONObject("modelDescription").getString("value"));
//				}
//				if (jsonObject.has("modelResource")) {
//					applicationOverview.setModelResource(jsonObject.getJSONObject("modelResource").getString("value"));
//				}
//				if (jsonObject.has("CNNTypeName")) {
//					applicationOverview.setCNNTypeName(jsonObject.getJSONObject("CNNTypeName").getString("value"));
//				}
//				if (jsonObject.has("RNNTypeName")) {
//					applicationOverview.setRNNTypeName(jsonObject.getJSONObject("RNNTypeName").getString("value"));
//				}
//				if (jsonObject.has("modelPerformance")) {
//					applicationOverview.setModelPerformance(
//							jsonObject.getJSONObject("modelPerformance").getString("value").split("#")[1]);
//				}
//				if (jsonObject.has("performanceAccuracy")) {
//					applicationOverview
//							.setPerformanceAccuracy(jsonObject.getJSONObject("performanceAccuracy").getString("value"));
//				}
//				if (jsonObject.has("performancePrecision")) {
//					applicationOverview.setPerformancePrecision(
//							jsonObject.getJSONObject("performancePrecision").getString("value"));
//				}
//				if (jsonObject.has("performanceRecall")) {
//					applicationOverview
//							.setPerformanceRecall(jsonObject.getJSONObject("performanceRecall").getString("value"));
//				}
//				if (jsonObject.has("performanceF1Score")) {
//					applicationOverview
//							.setPerformanceF1Score(jsonObject.getJSONObject("performanceF1Score").getString("value"));
//				}
//				list.add(applicationOverview);
//			}
//			return list;
//
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
		
		// result
		JSONObject json;
		try {
			json = new JSONObject(jsonString);
			JSONArray jsonArray = json.getJSONObject("results").getJSONArray("bindings");
			List<ApplicationSummary> list = new ArrayList<ApplicationSummary>();
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
				ApplicationSummary applicationSummary = new ApplicationSummary();
				if (jsonObject.has("application")) {
					applicationSummary.setApplication(jsonObject.getJSONObject("application").getString("value").split("#")[1]);
				}
				if (jsonObject.has("applicationName")) {
					applicationSummary.setApplicationName(jsonObject.getJSONObject("applicationName").getString("value"));
				}
				if (jsonObject.has("healthcareApplicationName")) {
					applicationSummary.setHealthcareApplicationName(jsonObject.getJSONObject("healthcareApplicationName").getString("value"));
				}
				if (jsonObject.has("skinCancerName")) {
					applicationSummary.setSkinCancerName(jsonObject.getJSONObject("skinCancerName").getString("value"));
				}
				if (jsonObject.has("musculoskeletalDisorderName")) {
					applicationSummary.setMusculoskeletalDisorderName(jsonObject.getJSONObject("musculoskeletalDisorderName").getString("value"));
				}
				if (jsonObject.has("data")) {
					applicationSummary.setData(jsonObject.getJSONObject("data").getString("value").split("#")[1]);
				}
				if (jsonObject.has("dataName")) {
					applicationSummary.setDataName(jsonObject.getJSONObject("dataName").getString("value"));
				}
				if (jsonObject.has("dataFeature")) {
					applicationSummary.setDataFeature(jsonObject.getJSONObject("dataFeature").getString("value"));
				}
				if (jsonObject.has("dataDescription")) {
					applicationSummary.setDataDescription(jsonObject.getJSONObject("dataDescription").getString("value"));
				}
				if (jsonObject.has("dataResource")) {
					applicationSummary.setDataResource(jsonObject.getJSONObject("dataResource").getString("value"));
				}
				if (jsonObject.has("accelerometerName")) {
					applicationSummary.setAccelerometerName(jsonObject.getJSONObject("accelerometerName").getString("value"));
				}
				if (jsonObject.has("gyroscopeName")) {
					applicationSummary.setGyroscopeName(jsonObject.getJSONObject("gyroscopeName").getString("value"));
				}
				if (jsonObject.has("modelNumber")) {
					applicationSummary.setModelNumber(Integer.parseInt(jsonObject.getJSONObject("modelNumber").getString("value")));
				}
				if (jsonObject.has("numberOfLayers")) {
					Double a = Double.parseDouble(jsonObject.getJSONObject("numberOfLayers").getString("value"));
					applicationSummary.setNumberOfLayers(a.intValue());
				}
				if (jsonObject.has("maxAccuracy")) {
					applicationSummary.setMaxAccuracy(jsonObject.getJSONObject("maxAccuracy").getString("value"));
				}
				if (jsonObject.has("maxPrecision")) {
					applicationSummary.setMaxPrecision(jsonObject.getJSONObject("maxPrecision").getString("value"));
				}
				if (jsonObject.has("maxRecall")) {
					applicationSummary.setMaxRecall(jsonObject.getJSONObject("maxRecall").getString("value"));
				}
				if (jsonObject.has("maxF1Score")) {
					applicationSummary.setMaxF1Score(jsonObject.getJSONObject("maxF1Score").getString("value"));
				}
				list.add(applicationSummary);
			}
			return list;

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	// find model structure by model ID
	public List<ModelStructure> searchModelStuctureModelID(String modelID) {
		// sparql
		String sparql = "SELECT ?layer ?layerName ?previousLayer ?previousLayerName\r\n" + "WHERE {\r\n" + "onto:"
				+ modelID + " onto:hasLayer ?layer.\r\n" + "?layer onto:layerName ?layerName.\r\n"
				+ "OPTIONAL{?layer onto:hasPreviousLayer ?previousLayer.\r\n"
				+ "?previousLayer onto:layerName ?previousLayerName.}\r\n" + "}\r\n" + "ORDER BY ?layerName";
		// test
		String jsonString = findJsonResult(sparql);
		System.out.println("searchModelStuctureModelID:" + jsonString);
		// result
		JSONObject json;
		try {
			json = new JSONObject(jsonString);
			JSONArray jsonArray = json.getJSONObject("results").getJSONArray("bindings");
			List<ModelStructure> list = new ArrayList<ModelStructure>();
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
				ModelStructure modelStructure = new ModelStructure();
				if (jsonObject.has("layer")) {
					modelStructure.setLayerID(jsonObject.getJSONObject("layer").getString("value").split("#")[1]);
				}
				if (jsonObject.has("layerName")) {
					modelStructure.setLayerName(jsonObject.getJSONObject("layerName").getString("value"));
				}
				if (jsonObject.has("previousLayer")) {
					modelStructure.setPreviousLayerID(
							jsonObject.getJSONObject("previousLayer").getString("value").split("#")[1]);
				}
				if (jsonObject.has("previousLayerName")) {
					modelStructure
							.setPreviousLayerName(jsonObject.getJSONObject("previousLayerName").getString("value"));
				}
				list.add(modelStructure);
			}
			return list;

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	// sort model structure
	public List<ModelStructure> sortModelStructure(List<ModelStructure> li){
		int i = 0;
		while(i<li.size()) {
			String previousLayerID  = li.get(i).getPreviousLayerID();
			if (previousLayerID!=null) {
				i = i+1;
			}else {
				for (int j=i;j<li.size();j++) {
					if (li.get(j).getPreviousLayerID()==previousLayerID) {
						li.add(i,li.get(j));
						li.remove(j+1);
						i=i+2;
					}
				}
			}
		}
		return li;
	}

	// find layer description by layer ID
	public List<LayerDescription> searchLayerDescripitionByLayerID(String layerID) {
		// sparql
		String sparql = "SELECT ?property ?object " + "WHERE { onto:" + layerID + "?property ?object.\r\n}";
		String jsonString = findJsonResult(sparql);
		System.out.println("searchLayerDescripitionByLayerID:" + jsonString);
		// result
		JSONObject json;
		try {
			json = new JSONObject(jsonString);
			JSONArray jsonArray = json.getJSONObject("results").getJSONArray("bindings");
			List<LayerDescription> list = new ArrayList<LayerDescription>();
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
				LayerDescription layerDescription = new LayerDescription();
				// set property
				layerDescription.setSubject(layerID.split("-")[0]);
				if (jsonObject.has("property")) {
					// set property
					layerDescription.setProperty(jsonObject.getJSONObject("property").getString("value").split("#")[1]);
				}
				if (jsonObject.has("object")) {
					// set type
					String type = jsonObject.getJSONObject("object").getString("type");
					layerDescription.setType(type);
					// set object
					if (type.equals("literal")) {
						layerDescription.setObject(jsonObject.getJSONObject("object").getString("value"));
					}
					if (type.equals("uri")) {
						layerDescription.setObject(jsonObject.getJSONObject("object").getString("value").split("#")[1].split("-")[0]);
						layerDescription.setObjectID(jsonObject.getJSONObject("object").getString("value").split("#")[1]);
					}
				}
				list.add(layerDescription);
			}
			return list;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	// find application by application ID
	public ApplicationOverview searchApplicaionOverviewByApplicationID(String applicationID, String modelID){
		// sparql
		String sparql = "SELECT Distinct ?application ?applicationName ?healthcareApplication ?healthcareApplicationName \r\n"
				+ "?skinCancerName ?musculoskeletalDisorderName \r\n"
				+ "?data ?dataName ?dataFeature ?dataDescription ?dataResource ?accelerometerName ?gyroscopeName \r\n"
				+ "?model ?modelName ?modelDescription ?modelResource ?CNNTypeName ?RNNTypeName\r\n"
				+ "?modelPerformance ?performanceAccuracy ?performancePrecision ?performanceRecall ?performanceF1Score\r\n"
				+ "WHERE {\r\n" + "	?application rdf:type onto:DeepLearningApplication.\r\n"
				+ "  	onto:" + applicationID + " onto:applicationName ?applicationName.\r\n"
				+ "  	?application onto:applicationName ?applicationName.\r\n"
			  	+ "     ?application onto:hasHealthcareApplication ?healthcareApplication.\r\n"
			  	+ " 	OPTIONAL{?healthcareApplication onto:healthcareName ?healthcareApplicationName.}\r\n"
			  	+ "	    OPTIONAL{"
			  	+ "		?healthcareApplication onto:hasSkinCancer ?skinCancerApplication.\r\n"
			  	+ "	    ?skinCancerApplication onto:skinCancerName ?skinCancerName.}\r\n"		
			  	+ "	    OPTIONAL{"
			  	+ "     ?healthcareApplication onto:hasMusculoskeletalDisorder ?musculoskeletalDisorderApplication.\r\n"
			  	+ " 	?musculoskeletalDisorderApplication onto:musculoskeletalDisorderName ?musculoskeletalDisorderName.}\r\n"
				+ "    	?application onto:hasData ?data.\r\n"
				+ "  	?data onto:dataName ?dataName.\r\n"
				+ "		?data onto:dataFeature ?dataFeature.\r\n"
				+ "  	?data onto:dataDescription ?dataDescription.\r\n"
				+ "  	?data onto:dataResource ?dataResource.\r\n"
				+ "     ?data onto:hasSensoryType ?sensoryType.\r\n"
				+ "     OPTIONAL{?sensoryType onto:hasAccelerometer ?accelerometer.\r\n"
				+ "     	?accelerometer onto:accelerometerName ?accelerometerName.}\r\n"
				+ "     OPTIONAL{?sensoryType onto:hasGyroscope ?gyroscope.\r\n"
				+ "     	?gyroscope onto:gyroscopeName ?gyroscopeName.}\r\n"
				+ "	    ?application onto:hasModel ?model.\r\n" + "  	?model onto:modelName ?modelName.\r\n"
				+ "  	?model onto:modelDescription ?modelDescription.\r\n"
				+ "  	?model onto:modelResource ?modelResource.\r\n"
				+ "     OPTIONAL{?model onto:hasPerformance ?modelPerformance.}\r\n"
				+ "     OPTIONAL{?modelPerformance onto:performanceAccuracy ?performanceAccuracy.}\r\n"
				+ "     OPTIONAL{?modelPerformance onto:performancePrecision ?performancePrecision.}\r\n"
				+ "     OPTIONAL{?modelPerformance onto:performanceRecall ?performanceRecall.}\r\n"
				+ "     OPTIONAL{?modelPerformance onto:performanceF1Score ?performanceF1Score.}\r\n"
				+ "     ?model onto:hasModelType ?modelType.\r\n"
				+ "     OPTIONAL{?modelType onto:hasCNNType ?CNNType.\r\n"
				+ "     	?CNNType onto:CNNTypeName ?CNNTypeName.}\r\n"
				+ "     OPTIONAL{?modelType onto:hasRNNType ?RNNType.\r\n"
				+ "     	?RNNType onto:RNNTypeName ?RNNTypeName.}\r\n"
				+ "		?model onto:hasLayer ?modelLayer."
				+ "     ?modelLayer ?a ?b.\r\n"
				+ "  	?b ?c ?d.\r\n" 
				+ "  	?d ?e ?f.\r\n";

		// end where
		if (modelID!=null) {
			sparql += "		FILTER (?model = onto:"+ modelID +")";
			sparql += "}";
		}else {
			sparql += "}";
			sparql += "ORDER by DESC (?performanceAccuracy)";
			sparql += "LIMIT 1";
		}
		// test
		String jsonString = findJsonResult(sparql);
		System.out.println("searchApplicationOverview:" + jsonString);
		// result
		JSONObject json;
		try {
			json = new JSONObject(jsonString);
			JSONArray jsonArray = json.getJSONObject("results").getJSONArray("bindings");
			// List<ApplicationOverview> list = new ArrayList<ApplicationOverview>();
			ApplicationOverview applicationOverview = new ApplicationOverview();
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
				if (jsonObject.has("application")) {
					applicationOverview.setApplication(jsonObject.getJSONObject("application").getString("value").split("#")[1]);
				}
				if (jsonObject.has("applicationName")) {
					applicationOverview.setApplicationName(jsonObject.getJSONObject("applicationName").getString("value"));
				}
				if (jsonObject.has("healthcareApplicationName")) {
					applicationOverview.setHealthcareApplicationName(jsonObject.getJSONObject("healthcareApplicationName").getString("value"));
				}
				if (jsonObject.has("skinCancerName")) {
					applicationOverview.setSkinCancerName(jsonObject.getJSONObject("skinCancerName").getString("value"));
				}
				if (jsonObject.has("musculoskeletalDisorderName")) {
					applicationOverview.setMusculoskeletalDisorderName(jsonObject.getJSONObject("musculoskeletalDisorderName").getString("value"));
				}
				if (jsonObject.has("data")) {
					applicationOverview.setData(jsonObject.getJSONObject("data").getString("value").split("#")[1]);
				}
				if (jsonObject.has("dataName")) {
					applicationOverview.setDataName(jsonObject.getJSONObject("dataName").getString("value"));
				}
				if (jsonObject.has("dataFeature")) {
					applicationOverview.setDataFeature(jsonObject.getJSONObject("dataFeature").getString("value"));
				}
				if (jsonObject.has("dataDescription")) {
					applicationOverview.setDataDescription(jsonObject.getJSONObject("dataDescription").getString("value"));
				}
				if (jsonObject.has("dataResource")) {
					applicationOverview.setDataResource(jsonObject.getJSONObject("dataResource").getString("value"));
				}
				if (jsonObject.has("accelerometerName")) {
					applicationOverview.setAccelerometerName(jsonObject.getJSONObject("accelerometerName").getString("value"));
				}
				if (jsonObject.has("gyroscopeName")) {
					applicationOverview.setGyroscopeName(jsonObject.getJSONObject("gyroscopeName").getString("value"));
				}
				if (jsonObject.has("model")) {
					applicationOverview.setModel(jsonObject.getJSONObject("model").getString("value").split("#")[1]);
				}
				if (jsonObject.has("modelName")) {
					applicationOverview.setModelName(jsonObject.getJSONObject("modelName").getString("value"));
				}
				if (jsonObject.has("modelDescription")) {
					applicationOverview.setModelDescription(jsonObject.getJSONObject("modelDescription").getString("value"));
				}
				if (jsonObject.has("modelResource")) {
					applicationOverview.setModelResource(jsonObject.getJSONObject("modelResource").getString("value"));
				}
				if (jsonObject.has("CNNTypeName")) {
					applicationOverview.setCNNTypeName(jsonObject.getJSONObject("CNNTypeName").getString("value"));
				}
				if (jsonObject.has("RNNTypeName")) {
					applicationOverview.setRNNTypeName(jsonObject.getJSONObject("RNNTypeName").getString("value"));
				}
				if (jsonObject.has("modelPerformance")) {
					applicationOverview.setModelPerformance(jsonObject.getJSONObject("modelPerformance").getString("value").split("#")[1]);
				}
				if (jsonObject.has("performanceAccuracy")) {
					applicationOverview.setPerformanceAccuracy(jsonObject.getJSONObject("performanceAccuracy").getString("value"));
				}
				if (jsonObject.has("performancePrecision")) {
					applicationOverview.setPerformancePrecision(jsonObject.getJSONObject("performancePrecision").getString("value"));
				}
				if (jsonObject.has("performanceRecall")) {
					applicationOverview.setPerformanceRecall(jsonObject.getJSONObject("performanceRecall").getString("value"));
				}
				if (jsonObject.has("performanceF1Score")) {
					applicationOverview.setPerformanceF1Score(jsonObject.getJSONObject("performanceF1Score").getString("value"));
				}
				// list.add(applicationOverview);
			}
			return applicationOverview;

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	// find same application but different validation
	public List<ApplicationOverview> searchApplicationOverviewsUseSameApplication(String modelID, String applicationID){
		// sparql
		String sparql = "SELECT Distinct ?application ?applicationName ?healthcareApplication ?healthcareApplicationName \r\n"
				+ "?data ?dataName ?dataFeature ?dataDescription ?dataResource ?accelerometerName ?gyroscopeName \r\n"
				+ "?model ?modelName ?modelDescription ?modelResource ?CNNTypeName ?RNNTypeName\r\n"
				+ "?modelPerformance ?performanceAccuracy ?performancePrecision ?performanceRecall ?performanceF1Score\r\n"
				+ "WHERE {\r\n" + "	?application rdf:type onto:DeepLearningApplication.\r\n"
				+ "  	onto:" + applicationID + " onto:applicationName ?applicationName.\r\n"
				+ "  	?application onto:applicationName ?applicationName.\r\n"
				+ "     ?application onto:hasHealthcareApplication ?healthcareApplication.\r\n"
			  	+ " 	OPTIONAL{?healthcareApplication onto:healthcareName ?healthcareApplicationName.}\r\n"
			  	+ "	    OPTIONAL{"
			  	+ "		?healthcareApplication onto:hasSkinCancer ?skinCancerApplication.\r\n"
			  	+ "	    ?skinCancerApplication onto:skinCancerName ?skinCancerName.}\r\n"		
			  	+ "	    OPTIONAL{"
			  	+ "     ?healthcareApplication onto:hasMusculoskeletalDisorder ?musculoskeletalDisorderApplication.\r\n"
			  	+ " 	?musculoskeletalDisorderApplication onto:musculoskeletalDisorderName ?musculoskeletalDisorderName.}\r\n"
				+ "    	?application onto:hasData ?data.\r\n"
				+ "  	?data onto:dataName ?dataName.\r\n"
				+ "		?data onto:dataFeature ?dataFeature.\r\n"
				+ "  	?data onto:dataDescription ?dataDescription.\r\n"
				+ "  	?data onto:dataResource ?dataResource.\r\n"
				+ "     ?data onto:hasSensoryType ?sensoryType.\r\n"
				+ "     OPTIONAL{?sensoryType onto:hasAccelerometer ?accelerometer.\r\n"
				+ "     	?accelerometer onto:accelerometerName ?accelerometerName.}\r\n"
				+ "     OPTIONAL{?sensoryType onto:hasGyroscope ?gyroscope.\r\n"
				+ "     	?gyroscope onto:gyroscopeName ?gyroscopeName.}\r\n"
				+ "	    ?application onto:hasModel ?model.\r\n" 
				+ "  	?model onto:modelName ?modelName.\r\n"
				+ "  	?model onto:modelDescription ?modelDescription.\r\n"
				+ "  	?model onto:modelResource ?modelResource.\r\n"
				+ "		FILTER (?model != onto:"+ modelID +")"
				+ "     OPTIONAL{?model onto:hasPerformance ?modelPerformance.}\r\n"
				+ "     OPTIONAL{?modelPerformance onto:performanceAccuracy ?performanceAccuracy.}\r\n"
				+ "     OPTIONAL{?modelPerformance onto:performancePrecision ?performancePrecision.}\r\n"
				+ "     OPTIONAL{?modelPerformance onto:performanceRecall ?performanceRecall.}\r\n"
				+ "     OPTIONAL{?modelPerformance onto:performanceF1Score ?performanceF1Score.}\r\n"
				+ "     ?model onto:hasModelType ?modelType.\r\n"
				+ "     OPTIONAL{?modelType onto:hasCNNType ?CNNType.\r\n"
				+ "     	?CNNType onto:CNNTypeName ?CNNTypeName.}\r\n"
				+ "     OPTIONAL{?modelType onto:hasRNNType ?RNNType.\r\n"
				+ "     	?RNNType onto:RNNTypeName ?RNNTypeName.}\r\n"
				+ "		?model onto:hasLayer ?modelLayer."
				+ "     ?modelLayer ?a ?b.\r\n"
				+ "  	?b ?c ?d.\r\n" 
				+ "  	?d ?e ?f.\r\n";

		// end where
		sparql += "}";
		sparql += "ORDER by DESC (?performanceAccuracy)";
		// test
		String jsonString = findJsonResult(sparql);
		System.out.println("searchApplicationOverview:" + jsonString);
		// result
		JSONObject json;
		try {
			json = new JSONObject(jsonString);
			JSONArray jsonArray = json.getJSONObject("results").getJSONArray("bindings");
			List<ApplicationOverview> list = new ArrayList<ApplicationOverview>();
			for (int i = 0; i < jsonArray.length(); i++) {
				ApplicationOverview applicationOverview = new ApplicationOverview();
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
				if (jsonObject.has("application")) {
					applicationOverview.setApplication(jsonObject.getJSONObject("application").getString("value").split("#")[1]);
				}
				if (jsonObject.has("applicationName")) {
					applicationOverview.setApplicationName(jsonObject.getJSONObject("applicationName").getString("value"));
				}
				if (jsonObject.has("healthcareApplicationName")) {
					applicationOverview.setHealthcareApplicationName(jsonObject.getJSONObject("healthcareApplicationName").getString("value"));
				}
				if (jsonObject.has("skinCancerName")) {
					applicationOverview.setSkinCancerName(jsonObject.getJSONObject("skinCancerName").getString("value"));
				}
				if (jsonObject.has("musculoskeletalDisorderName")) {
					applicationOverview.setMusculoskeletalDisorderName(jsonObject.getJSONObject("musculoskeletalDisorderName").getString("value"));
				}
				if (jsonObject.has("data")) {
					applicationOverview.setData(jsonObject.getJSONObject("data").getString("value").split("#")[1]);
				}
				if (jsonObject.has("dataName")) {
					applicationOverview.setDataName(jsonObject.getJSONObject("dataName").getString("value"));
				}
				if (jsonObject.has("dataFeature")) {
					applicationOverview.setDataFeature(jsonObject.getJSONObject("dataFeature").getString("value"));
				}
				if (jsonObject.has("dataDescription")) {
					applicationOverview.setDataDescription(jsonObject.getJSONObject("dataDescription").getString("value"));
				}
				if (jsonObject.has("dataResource")) {
					applicationOverview.setDataResource(jsonObject.getJSONObject("dataResource").getString("value"));
				}
				if (jsonObject.has("accelerometerName")) {
					applicationOverview.setAccelerometerName(jsonObject.getJSONObject("accelerometerName").getString("value"));
				}
				if (jsonObject.has("gyroscopeName")) {
					applicationOverview.setGyroscopeName(jsonObject.getJSONObject("gyroscopeName").getString("value"));
				}
				if (jsonObject.has("model")) {
					applicationOverview.setModel(jsonObject.getJSONObject("model").getString("value").split("#")[1]);
				}
				if (jsonObject.has("modelName")) {
					applicationOverview.setModelName(jsonObject.getJSONObject("modelName").getString("value"));
				}
				if (jsonObject.has("modelDescription")) {
					applicationOverview.setModelDescription(jsonObject.getJSONObject("modelDescription").getString("value"));
				}
				if (jsonObject.has("modelResource")) {
					applicationOverview.setModelResource(jsonObject.getJSONObject("modelResource").getString("value"));
				}
				if (jsonObject.has("CNNTypeName")) {
					applicationOverview.setCNNTypeName(jsonObject.getJSONObject("CNNTypeName").getString("value"));
				}
				if (jsonObject.has("RNNTypeName")) {
					applicationOverview.setRNNTypeName(jsonObject.getJSONObject("RNNTypeName").getString("value"));
				}
				if (jsonObject.has("modelPerformance")) {
					applicationOverview.setModelPerformance(jsonObject.getJSONObject("modelPerformance").getString("value").split("#")[1]);
				}
				if (jsonObject.has("performanceAccuracy")) {
					applicationOverview.setPerformanceAccuracy(jsonObject.getJSONObject("performanceAccuracy").getString("value"));
				}
				if (jsonObject.has("performancePrecision")) {
					applicationOverview.setPerformancePrecision(jsonObject.getJSONObject("performancePrecision").getString("value"));
				}
				if (jsonObject.has("performanceRecall")) {
					applicationOverview.setPerformanceRecall(jsonObject.getJSONObject("performanceRecall").getString("value"));
				}
				if (jsonObject.has("performanceF1Score")) {
					applicationOverview.setPerformanceF1Score(jsonObject.getJSONObject("performanceF1Score").getString("value"));
				}
				list.add(applicationOverview);
			}
			return list;

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	// find application use the same data
	public List<ApplicationOverview> searchApplicationOverviewsUseSameData(String dataID, String applicationID){
		// sparql
		String sparql = "SELECT Distinct ?application ?applicationName ?healthcareApplication ?healthcareApplicationName \r\n"
				+ "?data ?dataName ?dataFeature ?dataDescription ?dataResource ?accelerometerName ?gyroscopeName \r\n"
				+ "?model ?modelName ?modelDescription ?modelResource ?CNNTypeName ?RNNTypeName\r\n"
				+ "?modelPerformance ?performanceAccuracy ?performancePrecision ?performanceRecall ?performanceF1Score\r\n"
				+ "WHERE {\r\n" + "	?application rdf:type onto:DeepLearningApplication.\r\n"
				+ "  	?application onto:applicationName ?applicationName.\r\n"
				+ "     ?application onto:hasHealthcareApplication ?healthcareApplication.\r\n"
			  	+ " 	OPTIONAL{?healthcareApplication onto:healthcareName ?healthcareApplicationName.}\r\n"
			  	+ "	    OPTIONAL{"
			  	+ "		?healthcareApplication onto:hasSkinCancer ?skinCancerApplication.\r\n"
			  	+ "	    ?skinCancerApplication onto:skinCancerName ?skinCancerName.}\r\n"		
			  	+ "	    OPTIONAL{"
			  	+ "     ?healthcareApplication onto:hasMusculoskeletalDisorder ?musculoskeletalDisorderApplication.\r\n"
			  	+ " 	?musculoskeletalDisorderApplication onto:musculoskeletalDisorderName ?musculoskeletalDisorderName.}\r\n"
				+ "    	?application onto:hasData onto:" + dataID + ".\r\n"
				+ "		FILTER (?application != onto:"+ applicationID +")"
				+ "    	?application onto:hasData ?data.\r\n"
				+ "  	?data onto:dataName ?dataName.\r\n"
				+ "		?data onto:dataFeature ?dataFeature.\r\n"
				+ "  	?data onto:dataDescription ?dataDescription.\r\n"
				+ "  	?data onto:dataResource ?dataResource.\r\n"
				+ "     ?data onto:hasSensoryType ?sensoryType.\r\n"
				+ "     OPTIONAL{?sensoryType onto:hasAccelerometer ?accelerometer.\r\n"
				+ "     	?accelerometer onto:accelerometerName ?accelerometerName.}\r\n"
				+ "     OPTIONAL{?sensoryType onto:hasGyroscope ?gyroscope.\r\n"
				+ "     	?gyroscope onto:gyroscopeName ?gyroscopeName.}\r\n"
				+ "	    ?application onto:hasModel ?model.\r\n" + "  	?model onto:modelName ?modelName.\r\n"
				+ "  	?model onto:modelDescription ?modelDescription.\r\n"
				+ "  	?model onto:modelResource ?modelResource.\r\n"
				+ "     OPTIONAL{?model onto:hasPerformance ?modelPerformance.}\r\n"
				+ "     OPTIONAL{?modelPerformance onto:performanceAccuracy ?performanceAccuracy.}\r\n"
				+ "     OPTIONAL{?modelPerformance onto:performancePrecision ?performancePrecision.}\r\n"
				+ "     OPTIONAL{?modelPerformance onto:performanceRecall ?performanceRecall.}\r\n"
				+ "     OPTIONAL{?modelPerformance onto:performanceF1Score ?performanceF1Score.}\r\n"
				+ "     ?model onto:hasModelType ?modelType.\r\n"
				+ "     OPTIONAL{?modelType onto:hasCNNType ?CNNType.\r\n"
				+ "     	?CNNType onto:CNNTypeName ?CNNTypeName.}\r\n"
				+ "     OPTIONAL{?modelType onto:hasRNNType ?RNNType.\r\n"
				+ "     	?RNNType onto:RNNTypeName ?RNNTypeName.}\r\n"
				+ "		?model onto:hasLayer ?modelLayer."
				+ "     ?modelLayer ?a ?b.\r\n"
				+ "  	?b ?c ?d.\r\n" 
				+ "  	?d ?e ?f.\r\n";

		// end where
		sparql += "}";
		// test
		String jsonString = findJsonResult(sparql);
		System.out.println("searchApplicationOverviewsUseSameData:" + jsonString);
		// result
		JSONObject json;
		try {
			json = new JSONObject(jsonString);
			JSONArray jsonArray = json.getJSONObject("results").getJSONArray("bindings");
			List<ApplicationOverview> list = new ArrayList<ApplicationOverview>();
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
				ApplicationOverview applicationOverview = new ApplicationOverview();
				if (jsonObject.has("application")) {
					applicationOverview.setApplication(jsonObject.getJSONObject("application").getString("value").split("#")[1]);
				}
				if (jsonObject.has("applicationName")) {
					applicationOverview.setApplicationName(jsonObject.getJSONObject("applicationName").getString("value"));
				}
				if (jsonObject.has("healthcareApplicationName")) {
					applicationOverview.setHealthcareApplicationName(jsonObject.getJSONObject("healthcareApplicationName").getString("value"));
				}
				if (jsonObject.has("skinCancerName")) {
					applicationOverview.setSkinCancerName(jsonObject.getJSONObject("skinCancerName").getString("value"));
				}
				if (jsonObject.has("musculoskeletalDisorderName")) {
					applicationOverview.setMusculoskeletalDisorderName(jsonObject.getJSONObject("musculoskeletalDisorderName").getString("value"));
				}
				if (jsonObject.has("data")) {
					applicationOverview.setData(jsonObject.getJSONObject("data").getString("value").split("#")[1]);
				}
				if (jsonObject.has("dataName")) {
					applicationOverview.setDataName(jsonObject.getJSONObject("dataName").getString("value"));
				}
				if (jsonObject.has("dataFeature")) {
					applicationOverview.setDataFeature(jsonObject.getJSONObject("dataFeature").getString("value"));
				}
				if (jsonObject.has("dataDescription")) {
					applicationOverview.setDataDescription(jsonObject.getJSONObject("dataDescription").getString("value"));
				}
				if (jsonObject.has("dataResource")) {
					applicationOverview.setDataResource(jsonObject.getJSONObject("dataResource").getString("value"));
				}
				if (jsonObject.has("accelerometerName")) {
					applicationOverview.setAccelerometerName(jsonObject.getJSONObject("accelerometerName").getString("value"));
				}
				if (jsonObject.has("gyroscopeName")) {
					applicationOverview.setGyroscopeName(jsonObject.getJSONObject("gyroscopeName").getString("value"));
				}
				if (jsonObject.has("model")) {
					applicationOverview.setModel(jsonObject.getJSONObject("model").getString("value").split("#")[1]);
				}
				if (jsonObject.has("modelName")) {
					applicationOverview.setModelName(jsonObject.getJSONObject("modelName").getString("value"));
				}
				if (jsonObject.has("modelDescription")) {
					applicationOverview.setModelDescription(jsonObject.getJSONObject("modelDescription").getString("value"));
				}
				if (jsonObject.has("modelResource")) {
					applicationOverview.setModelResource(jsonObject.getJSONObject("modelResource").getString("value"));
				}
				if (jsonObject.has("CNNTypeName")) {
					applicationOverview.setCNNTypeName(jsonObject.getJSONObject("CNNTypeName").getString("value"));
				}
				if (jsonObject.has("RNNTypeName")) {
					applicationOverview.setRNNTypeName(jsonObject.getJSONObject("RNNTypeName").getString("value"));
				}
				if (jsonObject.has("modelPerformance")) {
					applicationOverview.setModelPerformance(jsonObject.getJSONObject("modelPerformance").getString("value").split("#")[1]);
				}
				if (jsonObject.has("performanceAccuracy")) {
					applicationOverview.setPerformanceAccuracy(jsonObject.getJSONObject("performanceAccuracy").getString("value"));
				}
				if (jsonObject.has("performancePrecision")) {
					applicationOverview.setPerformancePrecision(jsonObject.getJSONObject("performancePrecision").getString("value"));
				}
				if (jsonObject.has("performanceRecall")) {
					applicationOverview.setPerformanceRecall(jsonObject.getJSONObject("performanceRecall").getString("value"));
				}
				if (jsonObject.has("performanceF1Score")) {
					applicationOverview.setPerformanceF1Score(jsonObject.getJSONObject("performanceF1Score").getString("value"));
				}
				list.add(applicationOverview);
			}
			return list;

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	// use in the next method
	public ApplicationSummary findApplicationSummaryByApplicationID(String applicationID){
		String sparql = "SELECT Distinct ?application ?applicationName ?healthcareApplication ?healthcareApplicationName \r\n"
				+ "?skinCancerName ?musculoskeletalDisorderName \r\n"
				+ "?data ?dataName ?dataFeature ?dataDescription ?dataResource ?accelerometerName ?gyroscopeName \r\n"
				+ "(COUNT(Distinct ?model) as ?modelNumber)"
				+ "(COUNT(Distinct?modelLayer)/COUNT(Distinct ?model) as ?numberOfLayers)"
				+ "(MAX(?performanceAccuracy) as ?maxAccuracy)"
				+ "(MAX(?performancePrecision) as ?maxPrecision)"
				+ "(MAX(?performanceRecall) as ?maxRecall)"
				+ "(MAX(?performanceF1Score) as ?maxF1Score)"
				+ "WHERE {\r\n" + "	?application rdf:type onto:DeepLearningApplication.\r\n"
				+ "  	onto:" + applicationID + " onto:applicationName ?applicationName.\r\n"
				+ "  	?application onto:hasHealthcareApplication ?healthcareApplication.\r\n"
				+ " 	OPTIONAL{"
				+ "  	?healthcareApplication onto:healthcareName ?healthcareApplicationName.}\r\n"
			  	+ "     OPTIONAL{"
				+ "     ?healthcareApplication onto:hasSkinCancer ?skinCancerApplication.\r\n"
				+ "     ?skinCancerApplication onto:skinCancerName ?skinCancerName.\r\n}"
			  	+ "		OPTIONAL{"
				+ "		?healthcareApplication onto:hasMusculoskeletalDisorder ?musculoskeletalDisorderApplication.\r\n"
				+ " 	?musculoskeletalDisorderApplication onto:musculoskeletalDisorderName ?musculoskeletalDisorderName.\r\n}"
				+ "    	?application onto:hasData ?data.\r\n"
				+ "  	?data onto:dataName ?dataName.\r\n"
				+ "		?data onto:dataFeature ?dataFeature.\r\n"
				+ "  	?data onto:dataDescription ?dataDescription.\r\n"
				+ "  	?data onto:dataResource ?dataResource.\r\n"
				+ "     ?data onto:hasSensoryType ?sensoryType.\r\n"
				+ "     OPTIONAL{?sensoryType onto:hasAccelerometer ?accelerometer.\r\n"
				+ "     	?accelerometer onto:accelerometerName ?accelerometerName.}\r\n"
				+ "     OPTIONAL{?sensoryType onto:hasGyroscope ?gyroscope.\r\n"
				+ "     	?gyroscope onto:gyroscopeName ?gyroscopeName.}\r\n"
				+ "	    ?application onto:hasModel ?model.\r\n" 
				+ "  	?model onto:modelName ?modelName.\r\n"
				+ "  	?model onto:modelDescription ?modelDescription.\r\n"
				+ "  	?model onto:modelResource ?modelResource.\r\n"
				+ "     OPTIONAL{?model onto:hasPerformance ?modelPerformance.}\r\n"
				+ "     OPTIONAL{?modelPerformance onto:performanceAccuracy ?performanceAccuracy.}\r\n"
				+ "     OPTIONAL{?modelPerformance onto:performancePrecision ?performancePrecision.}\r\n"
				+ "     OPTIONAL{?modelPerformance onto:performanceRecall ?performanceRecall.}\r\n"
				+ "     OPTIONAL{?modelPerformance onto:performanceF1Score ?performanceF1Score.}\r\n"
				+ "     ?model onto:hasModelType ?modelType.\r\n"
				+ "     OPTIONAL{?modelType onto:hasCNNType ?CNNType.\r\n"
				+ "     	?CNNType onto:CNNTypeName ?CNNTypeName.}\r\n"
				+ "     OPTIONAL{?modelType onto:hasRNNType ?RNNType.\r\n"
				+ "     	?RNNType onto:RNNTypeName ?RNNTypeName.}\r\n"
				+ "		?model onto:hasLayer ?modelLayer.\r\n"
				+ "     ?modelLayer ?a ?b.\r\n"
				+ "  	?b ?c ?d.\r\n" 
				+ "  	?d ?e ?f.\r\n"
				+ "		FILTER (?application = onto:" + applicationID + ")";
				// end where
				sparql += "}";
				sparql += "GROUP BY\r\n";
				sparql += "?application ?applicationName ?healthcareApplication ?healthcareApplicationName\r\n";
				sparql += "?data ?dataName ?dataFeature ?dataDescription ?dataResource ?accelerometerName ?gyroscopeName\r\n";
				sparql += "?skinCancerName ?musculoskeletalDisorderName\r\n";
				// test
				String jsonString = findJsonResult(sparql);
				System.out.println("findApplicationSummaryByApplicationID:" + jsonString);
				// result
				JSONObject json;
				try {
					json = new JSONObject(jsonString);
					JSONArray jsonArray = json.getJSONObject("results").getJSONArray("bindings");
					// List<ApplicationSummary> list = new ArrayList<ApplicationSummary>();
					ApplicationSummary applicationSummary = new ApplicationSummary();
					for (int i = 0; i < jsonArray.length(); i++) {
						JSONObject jsonObject = (JSONObject) jsonArray.get(i);
						if (jsonObject.has("application")) {
							applicationSummary.setApplication(jsonObject.getJSONObject("application").getString("value").split("#")[1]);
						}
						if (jsonObject.has("applicationName")) {
							applicationSummary.setApplicationName(jsonObject.getJSONObject("applicationName").getString("value"));
						}
						if (jsonObject.has("healthcareApplicationName")) {
							applicationSummary.setHealthcareApplicationName(jsonObject.getJSONObject("healthcareApplicationName").getString("value"));
						}
						if (jsonObject.has("skinCancerName")) {
							applicationSummary.setSkinCancerName(jsonObject.getJSONObject("skinCancerName").getString("value"));
						}
						if (jsonObject.has("musculoskeletalDisorderName")) {
							applicationSummary.setMusculoskeletalDisorderName(jsonObject.getJSONObject("musculoskeletalDisorderName").getString("value"));
						}
						if (jsonObject.has("data")) {
							applicationSummary.setData(jsonObject.getJSONObject("data").getString("value").split("#")[1]);
						}
						if (jsonObject.has("dataName")) {
							applicationSummary.setDataName(jsonObject.getJSONObject("dataName").getString("value"));
						}
						if (jsonObject.has("dataFeature")) {
							applicationSummary.setDataFeature(jsonObject.getJSONObject("dataFeature").getString("value"));
						}
						if (jsonObject.has("dataDescription")) {
							applicationSummary.setDataDescription(jsonObject.getJSONObject("dataDescription").getString("value"));
						}
						if (jsonObject.has("dataResource")) {
							applicationSummary.setDataResource(jsonObject.getJSONObject("dataResource").getString("value"));
						}
						if (jsonObject.has("accelerometerName")) {
							applicationSummary.setAccelerometerName(jsonObject.getJSONObject("accelerometerName").getString("value"));
						}
						if (jsonObject.has("gyroscopeName")) {
							applicationSummary.setGyroscopeName(jsonObject.getJSONObject("gyroscopeName").getString("value"));
						}
						if (jsonObject.has("modelNumber")) {
							applicationSummary.setModelNumber(Integer.parseInt(jsonObject.getJSONObject("modelNumber").getString("value")));
						}
						if (jsonObject.has("numberOfLayers")) {
							Double a = Double.parseDouble(jsonObject.getJSONObject("numberOfLayers").getString("value"));
							applicationSummary.setNumberOfLayers(a.intValue());
						}
						if (jsonObject.has("maxAccuracy")) {
							applicationSummary.setMaxAccuracy(jsonObject.getJSONObject("maxAccuracy").getString("value"));
						}
						if (jsonObject.has("maxPrecision")) {
							applicationSummary.setMaxPrecision(jsonObject.getJSONObject("maxPrecision").getString("value"));
						}
						if (jsonObject.has("maxRecall")) {
							applicationSummary.setMaxRecall(jsonObject.getJSONObject("maxRecall").getString("value"));
						}
						if (jsonObject.has("maxF1Score")) {
							applicationSummary.setMaxF1Score(jsonObject.getJSONObject("maxF1Score").getString("value"));
						}
						//list.add(applicationSummary);
					}
					return applicationSummary;

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
	}
	
	// find application summaries use the same data
	public List<ApplicationSummary> searchApplicationSummariesUseSameData(String dataID, String applicationID){
		// sparql
		String sparql = "SELECT ?application\r\n " 
					  +	"WHERE {"
					  + "?application onto:hasData onto:" + dataID + ".\r\n"
					  + "FILTER (?application != onto:"+ applicationID +")";				
		// end where
		sparql += "}";
		
		// test
		String jsonString = findJsonResult(sparql);
		System.out.println("searchApplicationSummariesUseSameData:" + jsonString);
		
		// result
		JSONObject json;
		try {
			json = new JSONObject(jsonString);
			JSONArray jsonArray = json.getJSONObject("results").getJSONArray("bindings");
			List<ApplicationSummary> list = new ArrayList<ApplicationSummary>();
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
				ApplicationSummary applicationSummary = new ApplicationSummary();
				if (jsonObject.has("application")) {
					applicationSummary = findApplicationSummaryByApplicationID(jsonObject.getJSONObject("application").getString("value").split("#")[1]);
				}
				
				list.add(applicationSummary);
			}
			return list;

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	} 
	
	// find application summaries use the same data
	/*
	public List<ApplicationSummary> searchApplicationSummariesUseSameData(String dataID, String applicationID){
		// sparql
		String sparql = "SELECT Distinct ?application ?applicationName ?healthcareApplication ?healthcareApplicationName \r\n"
				+ "?skinCancerName ?musculoskeletalDisorderName \r\n"
				+ "?data ?dataName ?dataFeature ?dataDescription ?dataResource ?acceleratorName ?gyroscopeName \r\n"
				+ "(COUNT(Distinct ?model) as ?modelNumber)"
				+ "(MAX(?performanceAccuracy) as ?maxAccuracy)"
				+ "(MAX(?performancePrecision) as ?maxPrecision)"
				+ "(MAX(?performanceRecall) as ?maxRecall)"
				+ "(MAX(?performanceF1Score) as ?maxF1Score)"
				+ "WHERE {\r\n" + "	?application rdf:type onto:DeepLearningApplication.\r\n"
				+ "  	?application onto:applicationName ?applicationName.\r\n"
			  	+ "	    OPTIONAL{"
			  	+ "		?healthcareApplication onto:hasSkinCancer ?skinCancerApplication.\r\n"
			  	+ "	    ?skinCancerApplication onto:skinCancerName ?skinCancerName.}\r\n"		
			  	+ "	    OPTIONAL{"
			  	+ "     ?healthcareApplication onto:hasMusculoskeletalDisorder ?musculoskeletalDisorderApplication.\r\n"
			  	+ " 	?musculoskeletalDisorderApplication onto:musculoskeletalDisorderName ?musculoskeletalDisorderName.}\r\n"
				+ "    	?application onto:hasData onto:" + dataID + ".\r\n"
				+ "		FILTER (?application != onto:"+ applicationID +")"
				+ "    	?application onto:hasData ?data.\r\n"
				+ "  	?data onto:dataName ?dataName.\r\n"
				+ "		?data onto:dataFeature ?dataFeature.\r\n"
				+ "  	?data onto:dataDescription ?dataDescription.\r\n"
				+ "  	?data onto:dataResource ?dataResource.\r\n"
				+ "     ?data onto:hasSensoryType ?sensoryType.\r\n"
				+ "     OPTIONAL{?sensoryType onto:hasAccelerator ?accelerator.\r\n"
				+ "     	?accelerator onto:acceleratorName ?acceleratorName.}\r\n"
				+ "     OPTIONAL{?sensoryType onto:hasGyroscope ?gyroscope.\r\n"
				+ "     	?gyroscope onto:gyroscopeName ?gyroscopeName.}\r\n"
				+ "	    ?application onto:hasModel ?model.\r\n" 
				+ "  	?model onto:modelName ?modelName.\r\n"
				+ "  	?model onto:modelDescription ?modelDescription.\r\n"
				+ "  	?model onto:modelResource ?modelResource.\r\n"
				+ "     OPTIONAL{?model onto:hasPerformance ?modelPerformance.}\r\n"
				+ "     OPTIONAL{?modelPerformance onto:performanceAccuracy ?performanceAccuracy.}\r\n"
				+ "     OPTIONAL{?modelPerformance onto:performancePrecision ?performancePrecision.}\r\n"
				+ "     OPTIONAL{?modelPerformance onto:performanceRecall ?performanceRecall.}\r\n"
				+ "     OPTIONAL{?modelPerformance onto:performanceF1Score ?performanceF1Score.}\r\n"
				+ "     ?model onto:hasModelType ?modelType.\r\n"
				+ "     OPTIONAL{?modelType onto:hasCNNType ?CNNType.\r\n"
				+ "     	?CNNType onto:CNNTypeName ?CNNTypeName.}\r\n"
				+ "     OPTIONAL{?modelType onto:hasRNNType ?RNNType.\r\n"
				+ "     	?RNNType onto:RNNTypeName ?RNNTypeName.}\r\n"
				+ "		?model onto:hasLayer ?modelLayer."
				+ "     ?modelLayer ?a ?b.\r\n"
				+ "  	?b ?c ?d.\r\n" 
				+ "  	?d ?e ?f.\r\n";
		// end where
		sparql += "}";
		sparql += "GROUP BY\r\n";
		sparql += "?application ?applicationName ?healthcareApplication ?healthcareApplicationName\r\n";
		sparql += "?data ?dataName ?dataFeature ?dataDescription ?dataResource ?acceleratorName ?gyroscopeName\r\n";
		sparql += "?skinCancerName ?musculoskeletalDisorderName\r\n";
		// test
		String jsonString = findJsonResult(sparql);
		System.out.println("searchApplicationSummariesUseSameData:" + jsonString);
		
		// result
		JSONObject json;
		try {
			json = new JSONObject(jsonString);
			JSONArray jsonArray = json.getJSONObject("results").getJSONArray("bindings");
			List<ApplicationSummary> list = new ArrayList<ApplicationSummary>();
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
				ApplicationSummary applicationSummary = new ApplicationSummary();
				if (jsonObject.has("application")) {
					applicationSummary.setApplication(jsonObject.getJSONObject("application").getString("value").split("#")[1]);
				}
				if (jsonObject.has("applicationName")) {
					applicationSummary.setApplicationName(jsonObject.getJSONObject("applicationName").getString("value"));
				}
				if (jsonObject.has("healthcareApplicationName")) {
					applicationSummary.setHealthcareApplicationName(jsonObject.getJSONObject("healthcareApplicationName").getString("value"));
				}
				if (jsonObject.has("skinCancerName")) {
					applicationSummary.setSkinCancerName(jsonObject.getJSONObject("skinCancerName").getString("value"));
				}
				if (jsonObject.has("musculoskeletalDisorderName")) {
					applicationSummary.setMusculoskeletalDisorderName(jsonObject.getJSONObject("musculoskeletalDisorderName").getString("value"));
				}
				if (jsonObject.has("data")) {
					applicationSummary.setData(jsonObject.getJSONObject("data").getString("value").split("#")[1]);
				}
				if (jsonObject.has("dataName")) {
					applicationSummary.setDataName(jsonObject.getJSONObject("dataName").getString("value"));
				}
				if (jsonObject.has("dataFeature")) {
					applicationSummary.setDataFeature(jsonObject.getJSONObject("dataFeature").getString("value"));
				}
				if (jsonObject.has("dataDescription")) {
					applicationSummary.setDataDescription(jsonObject.getJSONObject("dataDescription").getString("value"));
				}
				if (jsonObject.has("dataResource")) {
					applicationSummary.setDataResource(jsonObject.getJSONObject("dataResource").getString("value"));
				}
				if (jsonObject.has("acceleratorName")) {
					applicationSummary.setAcceleratorName(jsonObject.getJSONObject("acceleratorName").getString("value"));
				}
				if (jsonObject.has("gyroscopeName")) {
					applicationSummary.setGyroscopeName(jsonObject.getJSONObject("gyroscopeName").getString("value"));
				}
				if (jsonObject.has("modelNumber")) {
					applicationSummary.setModelNumber(Integer.parseInt(jsonObject.getJSONObject("modelNumber").getString("value")));
				}
				if (jsonObject.has("maxAccuracy")) {
					applicationSummary.setMaxAccuracy(jsonObject.getJSONObject("maxAccuracy").getString("value"));
				}
				if (jsonObject.has("maxPrecision")) {
					applicationSummary.setMaxPrecision(jsonObject.getJSONObject("maxPrecision").getString("value"));
				}
				if (jsonObject.has("maxRecall")) {
					applicationSummary.setMaxRecall(jsonObject.getJSONObject("maxRecall").getString("value"));
				}
				if (jsonObject.has("maxF1Score")) {
					applicationSummary.setMaxF1Score(jsonObject.getJSONObject("maxF1Score").getString("value"));
				}
				list.add(applicationSummary);
			}
			return list;

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	} 
	*/
}
