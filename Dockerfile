FROM openjdk:17-jdk-alpine
WORKDIR /usr/src/app
ADD target/triviet-0.0.1-SNAPSHOT.jar triviet
ENTRYPOINT ["java", "-jar", "triviet"]