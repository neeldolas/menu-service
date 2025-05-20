FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY target/menu-service-0.0.1-SNAPSHOT.jar app.jar

# Application port
EXPOSE 8082
# Debug port
EXPOSE 5005

#ENTRYPOINT ["java", "-jar", "app.jar"]
ENTRYPOINT ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005", "-jar", "app.jar"]

