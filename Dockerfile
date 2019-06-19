FROM openjdk:8u181-jre-slim-stretch
COPY target/becas-1.0.0.jar /opt/becas-1.0.0.jar
#COPY application.properties /application.properties
EXPOSE 8080
ENTRYPOINT ["java", "-Djava.awt.headless=true", "-Xms512m", "-Xmx512m", "-jar", "/opt/becas-1.0.0.jar"]
