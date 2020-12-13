package com.qzc.ontology.init;

import org.apache.jena.query.Dataset;
import org.apache.jena.query.ReadWrite;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.tdb.TDBFactory;
import org.apache.jena.util.FileManager;

import com.qzc.ontology.init.Naming;

public class OntologyPersistence {

	public Dataset dataset = null;
	public OntologyPersistence() {}

	public void loadModel(String dirctory, String modelName, String rdfFilePath, Boolean isOverride) {
		dataset = TDBFactory.createDataset(dirctory);
		String result;
		Model model = null;
		dataset.begin(ReadWrite.WRITE);
		try {
			// model exist, do not override
			if (dataset.containsNamedModel(modelName) && (!isOverride)) {
				result = modelName + ": model exist and do not override";
			}
			//
			else {
				// model exist, override
				if (dataset.containsNamedModel(modelName)) {
					dataset.removeNamedModel(modelName);
					result = modelName + ": model exist and override";
				} else {
					result = modelName + ": model do not exist, create a new model";
				}
				// create new model
				model = dataset.getNamedModel(modelName);
				FileManager.get().readModel(model, rdfFilePath);
				dataset.commit();
			}
		} catch (Exception e) {
			// load model error
			result = modelName + ": load model error";
		} finally {
			dataset.end();
		}
		System.out.println(result);
	}

	// do not use now
	public static void saveOntology() {
		String directory = Naming.TDB_DATABASE;
		Dataset dataset = TDBFactory.createDataset(directory);
		dataset.begin(ReadWrite.WRITE);
		Model model = dataset.getDefaultModel();
		String source = Naming.LOAD_OWL_PATH;
		FileManager.get().readModel(model, source);
		dataset.commit();
		dataset.end();
	}

	// test
	public static void main(String[] args) {
		// saveOntology();
		OntologyPersistence ontologyPersistence = new OntologyPersistence();
		ontologyPersistence.loadModel(Naming.TDB_DATABASE,Naming.TDB_MODEL, Naming.LOAD_OWL_PATH, true);
	}

}
