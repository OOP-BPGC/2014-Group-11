Group-11
========

This branch of zephyr project uses the maven build system along with a Makefile which has frequently called target through
which we call mvn.  

We also, have put up the compiled binary packages on this repository so that the latest commit can always be run without 
the need for building it.  

Some of the common commands of relevance to our project are :- 

1) make :- Use this to build and run the project. 
2) make ctest :- Use this to only compile the unit test and not run them. 
3) make test :- Use this to only run the unit test after compilation. 
4) make compile :- Use this to only compile the project. 
5) make clean :- Use this to remove the target directory and start project bulding from scratch. 
6) make rm :- Use this to remove unnecessary swap files created by the editors. 
