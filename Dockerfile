FROM openjdk:17-jdk-alpine
EXPOSE 5500
ADD target/transfer_money_API-0.0.1-SNAPSHOT.jar transfer.jar
CMD ["java","-jar","/transfer.jar"]