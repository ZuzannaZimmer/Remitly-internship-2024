# Remitly-internship-2024

The method validates the input JSON data. The input data format is defined as AWS::IAM::Role Policy. The method returns false if an input JSON Resource field contains a single asterisk, and true otherwise

## Requirements
* Java 21.0.2
* Apache Maven 3.9.6

## Setup
To run this project, make sure you have Java and Maven installed on your computer

* [java download](https://www.oracle.com/java/technologies/downloads/)
* [maven download](https://maven.apache.org/download.cgi)


### Clone repository to your local machine
```
git clone https://github.com/ZuzannaZimmer/Remitly-internship-2024.git
```
### Navigate to the project directory
```
cd Remitly-internship-2024
```
### Compile and package Maven project
```
mvn clean install
```
```
mvn compile
```
### Run
```
mvn exec:java -Dexec.mainClass="com.remitly.rolechecker.Main"
```
### Test
```
mvn test
```

### Note

You can also use an IDE (e.g IntelliJ IDEA) that works with Maven for easier compile, run and test

