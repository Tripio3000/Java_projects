Compile:
mvn clean install spring-boot:repackage
Run:
java -jar target/socket-server.jar --port=8081

OR RUN:
mvn spring-boot:run

CREATE DATABASE client_server_db;
CREATE TABLE users (id serial, username text, password text);
