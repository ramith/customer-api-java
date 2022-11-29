FROM maven:3.8.5-openjdk-17 as build
ENV HOME=/usr/app
RUN mkdir -p $HOME
WORKDIR $HOME
ADD . $HOME
RUN mvn -version
RUN mvn package -Dmaven.test.skip
RUN echo $JAVA_HOME
FROM openjdk:17-alpine
COPY --from=build /usr/app/target/customer-api-1.0.0.jar /app/customer-api-1.0.0.jar

# Set a non-root user
USER 10014
EXPOSE 8080
ENTRYPOINT java -jar /app/customer-api-1.0.0.jar