FROM adoptopenjdk/openjdk11:jre-11.0.13_8-alpine

EXPOSE 5501

COPY  ./target/demo-0.0.1-SNAPSHOT.jar  ./app.jar
RUN mkdir log
RUN touch log/logFile.log

RUN chmod 777 log
RUN chmod 777 log/logFile.log

#CMD ["./unix.sh"]
CMD ["java", "-jar", "./app.jar"]