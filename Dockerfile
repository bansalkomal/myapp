FROM openjdk:11-jre-slim
EXPOSE 8080
ADD target/myapp-0.0.1-SNAPSHOT.jar myapp.jar
ENTRYPOINT ["java","-jar","/myapp.jar"]