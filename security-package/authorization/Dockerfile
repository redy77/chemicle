FROM openjdk:11-jre

RUN adduser --system --home /var/cache/bootapp --shell /sbin/nologin bootapp;

COPY /auth-app/target/authorization.jar /opt/authorization.jar

USER bootapp

ENTRYPOINT ["java","-jar","/opt/authorization.jar"]