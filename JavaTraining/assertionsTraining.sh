#!/bin/bash
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
cd $DIR
rm -R build
mkdir build
javac -d build src/test/java/training/java6/oca/AssertionsTraining.java
cd build
java -da:training... -ea:training.java6.oca.AssertionsTraining training.java6.oca.AssertionsTraining 11
