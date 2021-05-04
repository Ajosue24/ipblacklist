FROM amazoncorretto:11
WORKDIR "./Docker
COPY "./build/libs/management-0.0.1-SNAPSHOT.jar" "."
# run application with this command line
COPY start.sh .
RUN javac Hello.java
ENTRYPOINT ["sh", "start.sh"]