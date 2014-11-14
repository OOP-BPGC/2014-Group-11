Group-11
========

This is the repository of the Group-11 project for zephyr.  
There are two types of interfaces which we will be implementing in our application :-   

1) Web interface using JSP   
2) Console application using Java.   

Currently, we have implemented the console application part and the html/css part of the web interface. Only some of the classes are incomplete in the console application part.  

There are two branches in this repository one which contains only the source files (without compiled binary) and the other which will contain all the compile binaries with a execuatable jar file. 

Dependencies :- 

Our project depends on these 3rd party tools for succesfull compilation and running of our project :-  
1) JUnit 3.8.1 :- For unit testing.   
2) sqlite-jdbc-3.8.7 :- For database management services.   
3) apache-maven-3.2.3 :- As our build automation tool.   
Some of the common commands of relevance to our project are :-  

We follow the default directory structure of Apacahe maven with some additions like :- 

1) UML Diagrams :- It contains all the uml diagrams relevant to the project.  
2) target :- This folder will contain the output of the build process.    
3) Project requirements :- This will contain the project requirements and the CRC cards.   
4) src :- This will contain the source code for the classes used in our project as well as the source code for the   unit tests. 

To compile and run the project, you neeed to run our Makefile. Options of makefile are explained below :-    

1) make :- Use this to build and run the project. (will only run if you have cmake installed)  
2) make ctest :- Use this to only compile the unit test and not run them.   
3) make test :- Use this to only run the unit test after compilation.   
4) make compile :- Use this to only compile the project.   
5) make clean :- Use this to remove the target directory and start project bulding from scratch.   
6) make rm :- Use this to remove unnecessary swap files created by the editors.    

Complete classes list :-      

1) App.java  
2) Competition.java   
3) DataBaseEntry.java   
4) Event.java  
5) Login.java  
6) Register.java  
7) Student.java  
8) TShirt.java  

Incomplete classes list :-   

1) Utility.java   
2) Pass.java   
3) Performance.java    

Complete unit tests :-   

1) LoginTest.java  
2) AppTest.java  
3) CompetitionTest.java   
4) RegisterTest.java   
5) UtilityTest.java   
