# Use a base image with OpenJDK 17
FROM openjdk:17-oracle

# Set the working directory
WORKDIR /app

# Copy the Eureka Server JAR file into the container
COPY target/ordering-1.0-SNAPSHOT.jar .

# Expose the port on which the Eureka Server will run
EXPOSE 8082

# Set the command to run the Eureka Server
CMD ["java", "-jar", "ordering-1.0-SNAPSHOT.jar"]