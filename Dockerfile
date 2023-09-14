FROM amazoncorretto:17-alpine-jdk

ENV JAVA_OPTS " -Xms512m -Xmx512m -Djava.security.egd=file:/dev/.urandom"

WORKDIR application

COPY target/csm-users-0.0.1-SNAPSHOT.jar csm-users.jar

ENTRYPOINT ["java", "-jar", "csm-users.jar"]