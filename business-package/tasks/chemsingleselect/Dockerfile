FROM openjdk:11-jre

RUN adduser --system --home /var/cache/bootapp --shell /sbin/nologin bootapp;

COPY /chemsingleselect-application/target/chemsingleselect.jar chemsingleselect.jar

USER bootapp

ENTRYPOINT java -jar chemsingleselect.jar