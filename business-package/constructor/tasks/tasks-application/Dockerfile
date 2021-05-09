FROM openjdk:11-jre

EXPOSE 8761

RUN adduser --system --home /var/cache/bootapp --shell /sbin/nologin bootapp;

COPY /target/tasks.jar /opt/tasks-application.jar

USER bootapp

ENTRYPOINT java -jar /opt/tasks-application.jar

