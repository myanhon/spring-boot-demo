FROM maven as build-stage
WORKDIR /app
# copy the pom and src code to the container
COPY . ./

# package our application code
RUN mvn clean package
WORKDIR /app/target

FROM openjdk:16-slim-buster as production-stage

# copy only the artifacts we need from the first stage and discard the rest
COPY --from=build-stage /app/target/demo-0.0.1-SNAPSHOT.jar /demo.jar

# set the startup command to execute the jar
CMD ["java", "-jar", "/demo.jar"]
