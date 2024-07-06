FROM openjdk:17
LABEL maintainer="Ashutosh Satapathy | Ashutoshrx"
EXPOSE 8080
VOLUME /temp
COPY build/libs/leetcode-0.0.1-plain.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]