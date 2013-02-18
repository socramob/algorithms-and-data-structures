#!/bin/bash

root_path=$(pwd)/$(dirname $0)
echo $root_path

cd $root_path/java && ./gradlew
cd $root_path/groovy && ./gradlew
