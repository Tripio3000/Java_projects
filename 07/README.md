## About reflection
Reflection is a powerful mechanism for making frameworks (like Spring and Hibernate) work. Understanding how the Java Reflection API works will ensure the correct use of various technologies to implement enterprise systems.
The reflection tool allows you to flexibly use information about classes at the time of program execution, as well as dynamically change the state of objects without using such information when writing source code.
So, one of the possibilities of reflection is to change the value of the object's private fields from the outside.

## How to use:
* mvn package
* java -jar target/Mod07-1.0-SNAPSHOT-jar-with-dependencies.jar

## The implemented application should work like this:
* Provide information about any class of the classes package.
* Allow the user to create objects of a specified class with specific
field values.
* Display information about the created object of the class.
* Call class methods.

```Classes:
- User
- Car
---------------------
Enter class name:
-> User
---------------------
fields:
       String firstName
       String lastName
       int height
methods:
       int grow(int)
---------------------
Let’s create an object.
firstName:
-> UserName
lastName:
-> UserSurname
height:
-> 185
Object created: User[firstName='UserName', lastName='UserSurname', height=185] 
---------------------
Enter name of the field for changing:
-> firstName
Enter String value:
-> Name
Object updated: User[firstName='Name', lastName='UserSurname', height=185]
---------------------
Enter name of the method for call:
-> grow(int)
Enter int value:
-> 10
Method returned:
195```