FROM maven:3.8.1-openjdk-17-slim
COPY . .
EXPOSE 8081
CMD mvn spring-boot:run