all:Utility.class Zephyr.class Person.class Pair.class CustomComparator.class Event.class
	javac Application.java 
	java -classpath ".:sqlite-jdbc-3.8.7.jar" Application  

Utility.class: Utility.java
	javac Utility.java 
Person.class: Person.java
	javac Person.java
Pair.class: Pair.java
	javac Pair.java
CustomComparator.class: CustomComparator.java
	javac CustomComparator.java 
Event.class: Event.java
	javac Event.java
Zephyr.class: Zephyr.java
	javac Zephyr.java
clean:
	rm -v *.class 
