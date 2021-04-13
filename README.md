# OROTUND: Ontology-based Platform for Effective Sharing and Reuse of Deep Learning Models

## System Design

OROTUND has been developed in Java. It follows the MVC (i.e., Model, View and Controller) design pattern and includes 90,022 total lines of code implemented. The init package (i.e., Model) stores all the class related to generating models, including build DL ontology, create instances and store the ontology. The mbean and controller package (i.e., Controller) stores all the class related to request handler, including query the datastore and send the data to the web pages. The view package (i.e., View) stores all the classes related to the user interface, including the representation of index page and detail page. Besides, the util package stores the utilities used in this project, including the generators for Universally Unique Identifier (UUID) and Jena-TDB database.
<br/>
<br/>
<img src="https://github.com/zqia0007/OROTUND/blob/master/WebContent/img/Library.png" />

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

## References
K. Sirinukunwattana, S. E. A. Raza, Y. Tsang, D. R. J. Snead, I. A. Cree, and N. M. Rajpoot, “Locality Sensitive Deep Learning for Detection and Classification of Nuclei in Routine Colon Cancer Histology Images,” IEEE Transactions on Medical Imaging, vol. 35, no. 5, pp. 1196–1206, May 2016, conference Name: IEEE Transactions on Medical Imaging.
<br/>
D. Anguita, A. Ghio, L. Oneto, X. Parra, and J. L. Reyes-Ortiz, “A Public Domain Dataset for Human Activity Recognition using Smartphones,” in ESANN, 2013.

## Thanks to my HD+ supervisors
#### Dr Pari Delir Haghighi, A/Prof Prem Prakash Jayaraman, Prof Frada Burstein, Yuxin Zhang and Dr Abdur Rahim Mohammad Forkan
