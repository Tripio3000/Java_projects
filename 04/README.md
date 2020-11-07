## About JAR
Any library or framework in Java is a collection of JAR files that are archives of compiled classes and other resources.
Thus, the task of any Java developer is to properly organize the source code and then transfer the assembled JAR archive with the implemented functionality to other programmers.
Today, special systems such as Maven are used to build large projects. The task of this project is to parse a .bmp (16x16) image and display white and black pixels in different characters.

## Build the project

Java source files are in the src folder and the JVM executables are in the target folder. This project is compiled into a jar file. To do this, run the following commands from folder ImagesToChar:
  
  * javac -d target/  src/java/edu/school21/printer/*/*.java
  
  * java -classpath target/ edu/school21/printer/app/Program P . resources/it.bmp