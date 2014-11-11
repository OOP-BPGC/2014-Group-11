all:Utility.class Person.class Competition.class
	javac console/Application.java    
	java -classpath ".:../lib/sqlite-jdbc-3.8.7.jar" console/Application  

Utility.class: zephyr/util/Utility.java
	javac zephyr/util/Utility.java -d zephyr/util/ 
Person.class: zephyr/Person.java
	javac zephyr/Person.java
#Pair.class: zephyr/Pair.java
#	javac zephyr/Pair.java
#CustomComparator.class: zephyr/CustomComparator.java
	#javac zephyr/CustomComparator.java 
Competition.class: zephyr/Competition.java
	javac zephyr/Competition.java
clean:
	rm -v -r *.class 
