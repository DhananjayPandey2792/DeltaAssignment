# DeltaTestAssignment

Here I have used BDD framework with RestAssured and cucumber. So In this we have src/main/java in which there are following components:

1)CommonLib-Here i have written all the common reusable methods like for get, post, put and delete. Also method to parse json is present in this java class.

3)ObjectDeclaration-Here we have created object for all the classes and all classes can extend these to access method of all other classes.Going forward if we extend this framework for JDBC connection, Fetching data from property page, Fetching data from excel. So we will have many java classes. This class will provide capability to store all object of these classes and any class will extend this. so the subclasses can use any class method.

Package stepdefinition

Here we have the step definition file where we have called our feature lines and added their implementation.

testrunner

In test runner is the place from where we run our cases.

src/test/java

Here i have kept all feature files in a package named features.


Test report will be available in Target folder


pom.xml has project dependencies like rest-assured, junit, cucumber,jsonpath etc. Going forward we can add gson, Hamcrest for validations.
