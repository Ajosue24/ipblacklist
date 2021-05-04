FROM gradle:7.0.0-jdk11 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build -x test  --no-daemon

FROM amazoncorretto:11

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/*.jar /app/management-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/app/management-0.0.1-SNAPSHOT.jar"]