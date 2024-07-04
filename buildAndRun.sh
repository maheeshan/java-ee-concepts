#!/bin/sh
mvn clean package && docker build -t org.example/javaee-test .
docker rm -f javaee-test || true && docker run -d -p 8080:8080 -p 4848:4848 --name javaee-test org.example/javaee-test 
