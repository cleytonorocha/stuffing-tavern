FROM maven:3.9.9-eclipse-temurin-17-alpine as build
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY . .
RUN mvn package

FROM eclipse-temurin:17.0.12_7-jre-ubi9-minimal
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY --from=build /usr/src/app/target/product-0.0.1-SNAPSHOT.jar product.jar
ENTRYPOINT ["java", "-jar", "product.jar"]
EXPOSE 8095