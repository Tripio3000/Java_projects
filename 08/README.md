## About Sockets 
Client-server communication is the backbone of modern systems. The server takes over the execution of a large amount of business logic and information storage. This significantly reduces the load on client applications.
Also, the division of logic into server and client parts allows you to flexibly build a common system architecture, when the server and client implementations are as independent of each other as possible.

## How to use

#### An application is the interaction of two programs, so you need to compile and run them separately.
* ##### Server:
  ```mvn clean install spring-boot:repackage```
  
  ```java -jar target/socket-server.jar --port=8081```
* ##### Client:
  ```mvn clean install spring-boot:repackage```
  
  ```java -jar target/socket-client.jar --port=8081```
  
#### For the server to work correctly, you need to create a database on PostgreSql:
* ```CREATE DATABASE client_server_db;```

  ```CREATE TABLE users (id serial, username text, password text);```
  
#### Spring Security

* In order to ensure secure storage of passwords, I use the hashing mechanism using PasswordEncoder and B CryptPasswordEncoder. Therefore, in the database, the password of each new user will be stored as a hash code.

## Example of client work
  ```Hello from Server!
  Hello from Server!
  $ signUp
  Enter username:
  $ Marsel
  Enter password:
  $ qwerty007
  Successful!