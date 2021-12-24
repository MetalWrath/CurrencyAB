FROM openjdk:11-jdk
ARG JAR_FILE=build/libs/CurrencyAB-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 5000
ENTRYPOINT ["java","-jar","/app.jar"]