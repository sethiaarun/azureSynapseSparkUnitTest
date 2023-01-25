## Azure Synapse Note Book Unit Testing

Example code for unit test cases for Synapse Notebook. These example codes are written in Scala; in the future, we will also add more code for PySpark.

1. Using Library Management

   - Change the directory to businessfunctions
   - run `mvn clean compile test package` to execute test cases and create the package
   - You can deploy businessfunction-1.0.jar from target folder to Synapse [Workspace packages](https://learn.microsoft.com/en-us/azure/synapse-analytics/spark/apache-spark-manage-workspace-packages) if you would like to use from Notebook

2. Using Function and Unit Test Notebook
   1. Approach#1 - Business functions and Unit test cases are outside of Notebook. 
      1. LibraryNoteBookTest.ipynb - The notebook leverage businessfunction-1.0.jar to build applications.
   2. Approach#2 - Functions and Unit Test Notebook
      1. BusinessFunctionsLibrary.ipynb - Business Function Notebook
      2. UnitTestBusinessFunctionsLibrary.ipynb - Unit Test cases for BusinessFunctionsLibrary.ipynb
