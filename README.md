# Sample UI automation project for ecommerce website


# Description
This project runs the basic test of ecommerce website.

## How do I get set up?

* Install JAVA JDK 11 (Recommended to use the latest version)
* Install [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download)
* Install maven in local machine (Recommended to use the latest version)
* If project not loaded properly, reload the project.
  (Build menu -> Build project/Rebuild project)

## Architecture
The application packages are organized by application that is being tested, e.g.:

```diagram
📦 main
  📦 java
    📦 org.example
       ┣ 📂 base
       ┣ 📂 configuration
       ┣ 📂 pages
       ┣ 📂 utilities
    📦 test.data
       📦 dev
       📦 qa
         ┣ 📂 configuration.properties

📦 test
  📦 java
     📦 sample.ecommerce
      ┣ 📂 HomePageTest

📦 resources
   📦 reports
   📦 screenshots
 
 
```
## Run the tests

### i) Using testng.xml file
Open the testng.xml file and right click to run the script.

### ii) Run from test class
Click the run icon that available for each test method.

### iii) Using terminal
Use 'mvn install' or 'mvn test' command on terminal.

Note: By default test runs on 'qa' environment. If we want to run on different environment
follow below maven command.

Ex:
For DEV Env: mvn test -DtestEnvironment=dev
For QA Env: mvn test -DtestEnvironment=qa

Note: Run the tests only for 'qa' env now.

However, sometime sample testing application not loading properly when we run tests after sometime.

### iv) Using run configuration
Choose edit configurations on run menu. Click 'add new configuration' and select maven.
Then add mvn commands on Run field and click apply and ok button.
Run -> Edit configurations -> Select '+' icon -> Select maven -> input mvn command on Run field.
Ex cmd: test

## Reports
If we run the test from testng.xml file or test class, we can find the test report on reports folder under the test-output folder.
Path = (test-output -> reports)

## Common Classes
BaseHelper - This class use to set up pre-conditions and post conditions.
DriverFactory - This class use to initialize the driver.
ExtentReport - This class has common methods for extent reports.
PropertyReader - This class has common method to get value from repository file.
pages - This packages contains all pages as per the application.
Utils - This class has common methods for utilities.

