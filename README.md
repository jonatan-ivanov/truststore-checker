# truststore-checker

A simple cli to check your truststore over HTTPS.

## Build and run as a jar

```shell
./gradlew clean assemble
java -jar build/libs/truststore-checker.jar --trustStore $JAVA_HOME/jre/lib/security/cacerts --trustStorePassword changeit --url https://httpbin.org/headers --verbose
```
