FROM openjdk:8
ADD target/docker-buddhi-profile.jar docker-buddhi-profile.jar
EXPOSE 9000
ENTRYPOINT ["java","-jar","docker-buddhi-profile.jar"]