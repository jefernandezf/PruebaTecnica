FROM java:8-jdk-alpine
COPY ./target/tipo-cambio-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch tipo-cambio-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","tipo-cambio-0.0.1-SNAPSHOT.jar"]