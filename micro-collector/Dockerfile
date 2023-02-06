FROM openjdk:11 as builder
RUN mkdir -p /app/source
COPY . /app/source
WORKDIR /app/source
RUN ./mvnw clean package

FROM openjdk:11
ARG JAR_FILE=/app/source/target/*.jar
COPY --from=builder ${JAR_FILE} /app/collector.jar
ENTRYPOINT ["java","-jar","/app/collector.jar"]
EXPOSE 8080
