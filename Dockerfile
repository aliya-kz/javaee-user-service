FROM openjdk:11

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

COPY target/user-service-1.0-SNAPSHOT.war /usr/src/app

ENTRYPOINT ["java","-jar","user-service-1.0-SNAPSHOT.war"]