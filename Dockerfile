FROM openjdk:11.0.5-jre-stretch
ARG JAR_FILE=service/build/libs/service.jar
COPY ${JAR_FILE} app.jar


HEALTHCHECK --interval=5s --timeout=3s CMD curl --fail http://localhost:8080/health || exit 1