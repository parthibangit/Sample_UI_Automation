# Sample UI automation project for ecommerce website


# Description
This project runs the basic test of ecommerce website.

## How do I get set up?

* Install JAVA JDK 11 (Recommended to use the latest version)
* Install [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download)
* Install maven in local machine (Recommended to use the latest version)
* If project not loaded properly, update the pom.xml file.

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

📦 test
  📦 java
     📦 sample.ecommerce
      ┣ 📂 HomePageTest

📦 resources
   📦 reports
   📦 screenshots
 
 
```
## Run the tests

### Using testng.xml file
Open the testng.xml file and right click to run the script.

### Run from test class
Click the run icon that available for each test method.

### Reports
If we run the test from testng.xml file or test class, we can find the test report on reports folder under the test-output folder.
Path = (test-output -> reports)

### Common Classes
BaseHelper - This class use to set up pre-conditions and post conditions.
DriverFactory - This class use to initialize the driver.
ExtentReport - This class has common methods for extent reports.
PropertyReader - This class has common method to get value from repository file.
pages - This packages contains all pages as per the application.
Utils - This class has common methods for utilities.

