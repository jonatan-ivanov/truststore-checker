# truststore-checker

A simple cli to check your truststore over HTTPS.

## Run as a script

`./src/main/groovy/truststore-checker.groovy --trustStore $JAVA_HOME/jre/lib/security/cacerts --trustStorePassword changeit --url https://httpbin.org/headers --verbose`

## Build and run as a jar

`./gradlew clean build`
`java -jar build/libs/truststore-checker.jar --trustStore $JAVA_HOME/jre/lib/security/cacerts --trustStorePassword changeit --url https://httpbin.org/headers --verbose`
