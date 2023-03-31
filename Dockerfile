FROM gradle:7.6.1-jdk17-alpine as builder
USER root
WORKDIR /builder
ADD . /builder
RUN gradle build --stacktrace

FROM openjdk:17-alpine
WORKDIR /app
EXPOSE 8080
COPY --from=builder /builder/build/libs/bnb-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "bnb-0.0.1-SNAPSHOT.jar"]