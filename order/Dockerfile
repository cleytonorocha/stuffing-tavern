FROM maven:3.9.9-eclipse-temurin-17-alpine as build
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY . .
RUN mvn package

FROM eclipse-temurin:17.0.12_7-jre-ubi9-minimal
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY --from=build /usr/src/app/target/order-0.0.1-SNAPSHOT.jar order.jar
ENTRYPOINT ["java", "-jar", "order.jar"]
EXPOSE 8093