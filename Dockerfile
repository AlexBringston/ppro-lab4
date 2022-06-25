# syntax=docker/dockerfile:1

FROM openjdk:8u111-jdk-alpine

ENV LANG en_GB.UTF-8

RUN apk add --update ttf-dejavu && rm -rf /var/cache/apk/*
WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./

RUN ./mvnw dependency:go-offline

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]