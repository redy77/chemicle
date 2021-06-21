FROM openjdk:11-jre

RUN adduser --system --home /var/cache/bootapp --shell /sbin/nologin bootapp;

COPY /answers-application/target/answers.jar /opt/answers.jar

USER bootapp

ENTRYPOINT ["java","-jar","/opt/answers.jar"]