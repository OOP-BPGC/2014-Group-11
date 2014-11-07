Group-11
========

This is the official repository for the OOP Zephyr project of Group 11.
##### Note
only stub codes are present as of now. Stub refinements and actual codes will be updated in the future.

## Architecture
The application is designed with MVC(Model View Controller) architecture in mind. The idea is to separate out the logic and state of application (model), handlers  (controller) and UI (view). This allows the model to exist independently so that the application doesn't become platform dependent. As a result the same model can be used for GUI, Web App, Mobile App etc. The controller and view will change correspondingly. Since we are making a Web Application - the controller will be Servlets and the view will be JSP.

## Directory Structure for Development Environment
src - java source files

---- zephyr - model of the application

---- console - controller java files for console related operations for Zephyr Controls

---- web - controller servelt files for the webapp

lib - contains all third party libraries

etc - contains all configuration files

classes - Java bytecodes

ui - UI files (JSP, HTML, CSS)


## Installation
Below listed are the instructions for setting up the environment and building the project :- 

Setting up the environment (for console application) :- 
1)To compile the project you need to have make installed on your PC.  
2)You need to have sqlite3 installed on your PC.  

Building :- 
If you are using some variant of linux, just cd to the directory Console in the github repository directory and use the command  

make 

If you want to clean up all the class files created you can use 
 
make clean 
