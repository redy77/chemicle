FROM openjdk:11-jre

RUN adduser --system --home /var/cache/bootapp --shell /sbin/nologin bootapp;

COPY /chat-application/target/chat.jar /opt/chat.jar

USER bootapp

ENTRYPOINT ["java","-jar","/opt/chat.jar"]