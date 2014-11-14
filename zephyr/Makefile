all:
	mvn package
	java -classpath .:lib/sqlite-jdbc-3.8.7.jar:target/zephyr-1.0-SNAPSHOT.jar com.group11.app.App

ctest:
	mvn test-compile
test:
	mvn test
run:
	java -classpath .:lib/sqlite-jdbc-3.8.7.jar:target/zephyr-1.0-SNAPSHOT.jar com.group11.app.App
compile:
	mvn compile

clean:
	mvn clean
rm:
	find . -name ".*.swp" -type f -delete	

