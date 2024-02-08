FROM openjdk:17
EXPOSE 8087
ADD target/micro2-0.0.1-SNAPSHOT.jar  event.jar
ENTRYPOINT ["java","-jar","Event.jar"]