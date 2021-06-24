FROM openjdk:11-jre

RUN adduser --system --home /var/cache/bootapp --shell /sbin/nologin bootapp;

COPY /registration-application/target/registration.jar /opt/registration.jar

USER bootapp

ENTRYPOINT ["java","-jar","/opt/registration.jar"]