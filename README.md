# Remitly-internship-2024

Write a method verifying the input JSON data. Input data format is defined as AWS::IAM::Role Policy

Java + Maven

## Setup
To run this project, make sure you have Java and Maven installed on your computer

* [java download](https://www.oracle.com/java/technologies/downloads/)
* [maven download](https://maven.apache.org/download.cgi)

```
#clone
$ git clone https://github.com/ZuzannaZimmer/Remitly-internship-2024.git

#Compile and package Maven project
$ mvn clean install
$ mvn compile

#run
mvn exec:java -Dexec.mainClass="com.remitly.rolechecker.Main"

#test
mvn test

```
