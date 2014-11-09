# This is the makefile for the testCases It is different from the makefile above.
all: TestCase.java TestRunner.java
	javac -cp ".:*" TestCase.java 
	javac -cp ".:junit-4.11.jar" TestRunner.java 
	#java -cp ".:hamcrest-core-1.3.jar" TestRunner  
	java -cp ".:*" TestRunner  
