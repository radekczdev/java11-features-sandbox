#!/bin/sh
cd /c/gitrepos/tests/cloud-loadbalancer/say-hello
. /c/workspace/notes/scripts/switchToJava18.sh
SERVER_PORT=$1 mvn spring-boot:run

