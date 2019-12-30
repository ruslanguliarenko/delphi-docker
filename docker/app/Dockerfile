FROM openjdk:12-jdk-alpine
COPY delphi-docker-0.0.1-SNAPSHOT.jar /delphi-docker.jar
CMD ["java", "-jar", "-Dspring.profiles.active=default", "/delphi-docker.jar"]
