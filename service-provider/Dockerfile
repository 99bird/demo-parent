FROM registry.cn-hangzhou.aliyuncs.com/itlz/openjdk:11.0.2
MAINTAINER liuzd <qq 77822013>
ARG JAR_FILE
EXPOSE 9009
COPY target/${JAR_FILE} /opt/app.jar
WORKDIR /opt/
ENTRYPOINT ["java","-jar","app.jar"]
