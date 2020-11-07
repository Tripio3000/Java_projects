## About tests
Unit and integration tests allow the programmer to verify that the programs they have written work correctly. These test methods are performed automatically.
Unit tests in Java are classes containing several test methods for the public methods of the classes under test. Each unit test class must test the functionality of exactly one class. Such testing allows you to reliably identify the locations of errors. In order to perform testing without specific dependencies, stub objects with temporary implementation are used.

## How to use

From the folder where the pom.xml file is located run command: ```mvn test```