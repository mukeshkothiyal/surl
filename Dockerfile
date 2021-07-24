FROM maven:3.6.3-amazoncorretto-8
EXPOSE 8080
ENV JAVA_TOOL_OPTIONS -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8787
ADD target/surl-0.0.1-SNAPSHOT.jar surl.jar
ENTRYPOINT ["java", "-jar", "surl.jar", "--spring.config.location=optional:classpath:/application-docker.properties"]