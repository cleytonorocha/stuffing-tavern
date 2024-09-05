FROM eclipse-temurin:17.0.12_7-jre-ubi9-minimal
WORKDIR /app
COPY target/payment-0.0.1-SNAPSHOT.jar payment.jar
EXPOSE 8094
ENTRYPOINT ["java", "-jar", "payment.jar"]

FROM maven:3.9.9-eclipse-temurin-17-alpine as build
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY . .
RUN mvn package

FROM eclipse-temurin:17.0.12_7-jre-ubi9-minimal
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY --from=build /usr/src/app/target/payment-0.0.1-SNAPSHOT.jar payment.jar
ENTRYPOINT ["java", "-jar", "payment.jar"]
EXPOSE 8094