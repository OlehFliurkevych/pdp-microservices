FROM openjdk:11
WORKDIR /
ADD target/pdpmicrocollector-0.0.1-SNAPSHOT.jar //
ENTRYPOINT ["java","-jar","/pdpmicrocollector-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080