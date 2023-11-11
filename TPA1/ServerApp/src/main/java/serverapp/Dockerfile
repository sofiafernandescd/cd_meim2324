# Use a base image with Java and Docker client installed
FROM openjdk:11

# Set the working directory inside the container
WORKDIR /usr/src/app

# Copy the Java source code into the container
COPY . /usr/src/app

# Compile the Java code
RUN javac serverapp/DockerAPI.java
RUN javac serverapp/MarkApp.java

# Define the default command to run when the container starts
CMD ["java", "serverapp/DockerAPI"]
