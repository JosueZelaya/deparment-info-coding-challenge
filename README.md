# department-info-coding-challenge

This is a Spring boot project.

Pre-requisites: 
    Install java 11.X

In MAC after you install JDK 11, then:
export JAVA_HOME=`/usr/libexec/java_home -v 11.0.1`

Build the project:
./mvnw clean install

The above instruction will download the dependencies and run the integration tests which validate the coding challenge.

The application exposes and API but no user interface.

To run the application:
./mvnw spring-boot:run