FROM openjdk:11
ADD target/my-app-1.0-SNAPSHOT.jar my-app-1.0-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","my-app-1.0-SNAPSHOT.jar"]
EXPOSE 8085
ENV JAVA_OPTS="-XX:PermSize=1024m -XX:MaxPermSize=1024"