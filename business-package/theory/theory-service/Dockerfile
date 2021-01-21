FROM openjdk:11-jre

RUN adduser --system --home /var/cache/bootapp --shell /sbin/nologin bootapp;

COPY /target/theory-application-1.0.0.jar theory-application-1.0.0.jar

USER bootapp

ENTRYPOINT java -jar theory-application.jar
