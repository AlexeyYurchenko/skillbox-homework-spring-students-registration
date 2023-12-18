FROM maven:3.9.4-eclipse-temurin-17 as build

COPY src src
COPY pom.xml pom.xml

RUN mvn clean package

FROM bellsoft/liberica-openjdk-debian:17

RUN adduser --system spring-boot && addgroup --system spring-boot && adduser spring-boot spring-boot
USER spring-boot

WORKDIR /app

COPY --from=build target/students-registration-0.0.1-SNAPSHOT.jar ./application.jar

ENTRYPOINT ["java", "-jar", "application.jar"]


#command:
#docker build -t students .
#docker run -it -p 8080:8080 --name=students-container students
#mvn clean package dependency:copy-dependencies -DincludeScope=runtime