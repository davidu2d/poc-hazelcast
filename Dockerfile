FROM adoptopenjdk/openjdk11:ubi
ENV PORT 8080
EXPOSE 8080
RUN mkdir /opt/app
ADD target/poc-hazelcast.jar /opt/app
ENTRYPOINT ["java", "-jar", "/opt/app/poc-hazelcast.jar"]