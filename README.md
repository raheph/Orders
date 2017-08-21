# Orders

Technologies used:
Build tool                         Gradle
Languge                            Java 8
Database                           PostgreSql 9.4
Web service framework              Jersey 2.26
Server                             Tomcat 7

prerequisite
PostgreSql 9.4 installed and running (please create a username:postgres, password:password)  Or 
create a user in postgreSql that has a read/write credential and update hibernate_cfg.xml file it is located at main/resources/hibernate_cfg.xml

How to run on Windows:
cd to the project file and run gradlew.bat build tomcatRunWar

How to run on Mac/Linux:
cd to the project file and run ./gradlew build tomcatRunWar

open browser/postman to test the services

http://localhost:8080/Orders/rest/Order/Order001       to test an order by order id where Order001 is Order id.

http://localhost:8080/Orders/rest/Process/Order001     to test the total for the order by order id

