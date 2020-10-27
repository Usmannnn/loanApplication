FROM openjdk:11
ADD out/artifacts/loan_jar/loan.jar loan.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "loan.jar"]