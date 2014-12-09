#!/bin/sh

echo "************ UNDEPLOYING *******************"
asadmin undeploy polishKings
echo "************ BUILDING **********************"
mvn package
echo "************ DEPLOYING *********************"
asadmin deploy target/polishKings.war
