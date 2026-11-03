
# Stage 1: Build the Spring Boot application
FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /workspace

# Copy Maven configuration and download dependencies
COPY pom.xml .
RUN mvn -B dependency:go-offline

# Copy application source code
COPY src ./src

# Package the application
RUN mvn -B clean package -DskipTests


# Stage 2: Run the application
FROM eclipse-temurin:21-jre

WORKDIR /app

# Create a non-root user
RUN useradd --system --uid 10001 appuser

# Copy the executable JAR from the build stage
COPY --from=build /workspace/target/k8s-demo-api-1.0.0.jar app.jar

# Run as non-root user
USER 10001

# Application port
EXPOSE 8080

# Start Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
