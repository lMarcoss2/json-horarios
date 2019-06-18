FROM openjdk:8u181-jre-slim-stretch
MAINTAINER AMIS
COPY target/becas-1.jar /opt/becas-1.jar
#COPY application.properties /application.properties
EXPOSE 8182
ENTRYPOINT ["java", "-Djava.awt.headless=true", "-Xms512m", "-Xmx512m", "-jar", "/opt/becas-1.jar"]
