FROM openjdk
VOLUME /tmp

LABEL name="hoytNote" version="1.0" author="844567321"

ADD target/note-0.0.1-SNAPSHOT.jar target/app.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom"]
#ENTRYPOINT ["java","-jar","/app.jar"]
#CMDjava -jar /app.jar

ENTRYPOINT ["java","-jar","-Dspring.profiles.active=local","target/app.jar"]