FROM openjdk:17-jdk

ARG JAR_FILE=target/eureka-1.0-SNAPSHOT.jar

WORKDIR /opt/eureka

COPY ${JAR_FILE} eureka-1.0-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","eureka-1.0-SNAPSHOT.jar"]