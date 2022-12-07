# Base image
FROM gradle:7.4-jdk11

# Make folder to put our files in
RUN mkdir -p /usr/src/app
RUN mkdir -p /usr/src/app/backend

# Set working directory so that all subsequent command runs in this folder
WORKDIR /usr/src/app/backend

COPY . .
RUN gradle build
CMD ["java", "-jar", "build/libs/projet_Java-0.0.1-SNAPSHOT.jar"]