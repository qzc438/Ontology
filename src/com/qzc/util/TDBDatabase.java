package com.qzc.util;

import org.apache.jena.query.Dataset;
import org.apache.jena.tdb.TDBFactory;

import com.qzc.ontology.init.Naming;

public class TDBDatabase {

	private static TDBDatabase database;
	Dataset dataset;

	private TDBDatabase() {
		dataset = TDBFactory.createDataset(Naming.TDB_DATABASE);
	}

	public static TDBDatabase getTDBDatabase() {
		if (database == null) {
			synchronized (TDBDatabase.class) {
				database = new TDBDatabase();
			}
		}
		return database;
	}

	public Dataset getDataset() {
		return dataset;
	}

}