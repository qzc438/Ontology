# OROTUND: Ontology-based Platform for Effective Sharing and Reuse of Deep Learning Models

## System Design

OROTUND has been developed in Java. It follows the MVC (i.e., Model, View and Controller) design pattern and includes 90,022 total lines of code implemented. The init package (i.e., Model) stores all the class related to generating models, including build DL ontology, create instances and store the ontology. The mbean and controller package (i.e., Controller) stores all the class related to request handler, including query the datastore and send the data to the web pages. The view package (i.e., View) stores all the classes related to the user interface, including the representation of index page and detail page. Besides, the util package stores the utilities used in this project, including the generators for Universally Unique Identifier (UUID) and Jena-TDB database.

## Home Page

The home-page is the landing page and provides the user with different options to search for DL models from different aspects such as the application domain, performance metrics (including accuracy, precision, recall and F1 score), model type, sensor type, number of layers, layer type, core layer type and functional layer type. When a search returns multiple models, the UI presents and orders models based on their performance (i.e. accuracy, precision etc).
<br/>
<br/>
<img src="https://github.com/zqia0007/OROTUND/blob/master/WebContent/img/case2a-860-983.png" />

## DL Model Details Page

If the user clicks the view button in the index page, it will redirect to DL model details page. For each model, the user can review information such as the feature set, sensor data type and other trained DL models for the same application that produced different accuracy results (this is due to the fact that DL models have mechanisms to assign weight and with each training run with same data, a new model with different accuracy may be generated).
<br/>
<br/>
<img src="https://github.com/zqia0007/OROTUND/blob/master/WebContent/img/case2a-additional.png" />
