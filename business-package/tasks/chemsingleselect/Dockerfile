FROM openjdk:11-jre

EXPOSE 0

RUN adduser --system --home /var/cache/bootapp --shell /sbin/nologin bootapp;

COPY /chemsingleselect-application/target/chemsingleselect.jar /opt/chemsingleselect.jar

USER bootapp

ENTRYPOINT ["java","-jar","/opt/chemsingleselect.jar"]
