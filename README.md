## Azure Synapse Note Book Unit Testing

1. Using Library Management

   - Change the directory to businessfunctions
   - run `mvn clean compile test package` to execute test cases and create the package
   - You can deploy businessfunction-1.0.jar from target folder to Synapse [Workspace packages](https://learn.microsoft.com/en-us/azure/synapse-analytics/spark/apache-spark-manage-workspace-packages) if you would like to use from Notebook

2. Using Function and Unit Test Notebook
