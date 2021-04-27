# Mo_RESTAPI_Task

## Getting started

### Before using that framework locally you should have the following: 
- Must have MAVEN and JAVA installed
- Must have IntelliJ or Eclipse setup

## That Automation Testing framework is Hybrid and uses the below:
- Apache Maven 
- Java
- Rest Assured Libraries
- Using Extent report versio #5 for generating PDF & Spark reports for test results
- Using TestNg for assertions
- Reading from Properties files for storing environment variables
- Integaring with CircleCI CI/CD to run over configured pipline for supporting DevOps Methodolgy 
- Run on dockerized container image (Java & Maven)
- Generating real time dashboard containing the test result
- The Solution supports cross-platform. Pull the repository and be able to run the tests with no or minimal additional
configuration.

_________
## Structure of Project:
### 1- src/main/java

#### apiBuilders Package:
* contains class for pasting the request body for POST/GET/PUT requests

#### apiConfig Package:
##### APIPath:
- Contains all the end points that will be used for testing across all the requests

##### HeaderConfigs:
- Contains HashMaps for the reusable headers used for testing across all the requests

##### QueryParams:
- Contains HashMaps for the reusable query parameters used for testing across all the requests
_________
#### apiVerification Package:

##### APIVerification
- Contains common methods used for validating the belows:
1. Response validation code
2. Certain key inside array in the response body of any request
3. Response Time validation
4. Certain key inside objects in the response body of any request
_________
#### POJO Package:
- Contains serizalization of the POST/PUT/DELETE request by initializing Encapsulation methodology

_________
#### Utils Package:
1. ExtentReportListner:
- Contains the configuration for creating Extend reports after every test & the path of the test report
2. FileandEnv:
- Contains defining the Env baseurl, Port No, Credentials from Properties files
3. Java Utils:
- Contains any Java common methods used during testing the APIs requests
_________
### 2- src/test/java

#### APIs Package:
* Contains all the APIs testng test classes

#### TestBase Package:
* Contains the base class for defining which env I am testing against and which variable I am calling such as ***baseUrl***

_________
### 3- Env Folder:
* Contains property file for every Env that I am testing against and every Env file includes evn variables

_________
## Runnning the tests from the command line:

* Navigate to the root of your project and type ***mvn clean test*** and all the tests under tests folder and all the test cases written in Testng will be executed
_________
### Generating The Test Reports :
* Open ***test-output*** folder Then open ***Report*** folder, you will find  ***test*** folder that contains the generated test report such as below:

<img width="1655" alt="Screen Shot 2021-04-27 at 11 00 16 AM" src="https://user-images.githubusercontent.com/66884373/116215307-d865d100-a747-11eb-97f1-987975fdce79.png">

<img width="1677" alt="Screen Shot 2021-04-27 at 11 01 20 AM" src="https://user-images.githubusercontent.com/66884373/116215415-f2071880-a747-11eb-9780-b7665494ed67.png">

_________
## Runnning framework locally:

- Navigate to the path of your project locally on your machine.   ***cd/project path on your machine/***    on the command/terminam then run the following command
***mvn clean test***

_________
## Runnning over CircleCI CI/CD:

### For Configuring running over CircleCI:

1. Create ***Config.yml*** file under ***.circleci*** folder in the root of the project and the following the configurations 

<img width="829" alt="Screen Shot 2021-04-27 at 11 07 31 AM" src="https://user-images.githubusercontent.com/66884373/116216312-c9335300-a748-11eb-80a2-63a75bbb90e9.png">


### Example For Successfull Build & Test over CircleCI:

<img width="1588" alt="Screen Shot 2021-04-27 at 11 08 31 AM" src="https://user-images.githubusercontent.com/66884373/116216448-ebc56c00-a748-11eb-8052-30c67f41aa28.png">


<img width="1658" alt="Screen Shot 2021-04-27 at 11 09 26 AM" src="https://user-images.githubusercontent.com/66884373/116216568-0e578500-a749-11eb-8bc1-040dbaf248f9.png">


<img width="1657" alt="Screen Shot 2021-04-27 at 11 10 06 AM" src="https://user-images.githubusercontent.com/66884373/116216670-23ccaf00-a749-11eb-9261-cd763a462d3c.png">

_________

### Example For Failed Build & Test (Test cases failed):

<img width="1592" alt="Screen Shot 2021-04-27 at 11 11 02 AM" src="https://user-images.githubusercontent.com/66884373/116216764-44950480-a749-11eb-9389-e4e4bda58e36.png">


<img width="1678" alt="Screen Shot 2021-04-27 at 11 11 43 AM" src="https://user-images.githubusercontent.com/66884373/116216857-5d9db580-a749-11eb-97aa-892fec0f6d15.png">



