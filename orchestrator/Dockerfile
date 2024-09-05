FROM eclipse-temurin:17.0.12_7-jre-ubi9-minimal
WORKDIR /app
COPY target/orchestrator-0.0.1-SNAPSHOT.jar orchestrator.jar
EXPOSE 3000
ENTRYPOINT ["java", "-jar", "orchestrator.jar"]