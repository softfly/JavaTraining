#!/bin/bash
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
cd $DIR
rm -R build
mkdir build
javac -d build src/test/java/training/java6/ocp/io/ConsoleTraining.java
jar -cvfe myproject.jar training.java6.ocp.io.ConsoleTraining -C build/ training/java6/ocp/io/ConsoleTraining.class
#java -cp myproject.jar training.java6.ocp.io.ConsoleTraining
java -jar myproject.jar
