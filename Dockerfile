FROM maven:3.8.1-openjdk-17-slim
COPY . .
EXPOSE 8082
RUN mvn clean package
CMD ["java","-jar","target/PortFolio_Page-0.0.1-SNAPSHOT.jar"]