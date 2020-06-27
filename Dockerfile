FROM java:8
VOLUME /tmp
COPY target/demo-1.0-SNAPSHOT.jar app.jar
CMD ["---server.port = 8080"]
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]

# docker run -d -p 9999:8080 --name docker-demo leesia/demo:1.0
