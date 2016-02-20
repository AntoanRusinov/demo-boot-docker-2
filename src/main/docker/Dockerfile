FROM java:8
VOLUME /tmp
COPY demo-boot-docker-2-0-SNAPSHOT.jar app2.jar
WORKDIR /apps/spring_app
RUN bash -c 'touch /app2.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app2.jar"]
