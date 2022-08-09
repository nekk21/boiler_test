# This section needed to catche spring boot and common dependencies in gradle
FROM gradle:7.4-jdk17 as cache
RUN mkdir -p /home/gradle/cache_home
ENV GRADLE_USER_HOME /home/gradle/cache_home

WORKDIR /app

COPY ./build.gradle ./
COPY ./settings.gradle ./

RUN gradle -i clean fetchDependencies

# Build service
FROM gradle:7.4-jdk17 as builder

COPY --from=cache /home/gradle/cache_home /home/gradle/.gradle
WORKDIR /build
COPY . /build

ARG SERVICE_NAME
ENV SERVICE_NAME $SERVICE_NAME

RUN gradle --no-daemon clean build -Denv=DEV

# Copy service stage
FROM openjdk:17 as service

ARG SERVICE_NAME
ENV SERVICE_NAME $SERVICE_NAME

WORKDIR /app
COPY --from=builder /build/build/libs/*.jar ./$SERVICE_NAME.jar

CMD java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:9999 -jar $SERVICE_NAME.jar