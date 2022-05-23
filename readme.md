Setup Mysql Database
---------------------------
Step 1: Steup mysql and create the databases

create database my_db;
use my_db;
source D:\SpringApps\abhijeetpadhy\src\main\resources\schema.sql
source D:\SpringApps\abhijeetpadhy\src\main\resources\data.sql

Step 2: Add the dependency to pom.xml

		<!-- Use MySQL Connector-J -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
		</dependency>

You might see a warning that cannot find mysql. To automatically download dependencies 
by maven, restart intellij idea.

Step 3: Add the lines to application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/my_db
spring.datasource.username=root
spring.datasource.password=mysql

Step 4: Create the required java files.

