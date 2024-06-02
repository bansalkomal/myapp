FROM openjdk:11-jre-slim
#VOLUME /tmp
#COPY target/myapp-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080
ADD target/myapp-0.0.1-SNAPSHOT.jar myapp.jar
ENTRYPOINT ["java","-jar","/myapp.jar"]