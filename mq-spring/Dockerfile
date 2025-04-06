FROM openjdk:17-jdk-slim AS build

COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package -Dmaven.test.skip

FROM openjdk:17-jdk-slim
WORKDIR demo
COPY --from=build target/*.jar mq-spring.jar
ENTRYPOINT ["java","-jar","mq-spring.jar","-web -webAllowOthers -tcp -tcpAllowOthers -browser"]