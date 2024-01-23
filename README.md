# Exercise # 1 - List Tables in a PostgreqSQL Database

> **Create a Java Application, "TableLister" that connects to the PostgreqSQL database on localhost and list out names of all Tables**

***Hint:*** 
- Download JDBC Driver library for PostgreqSQL
-- Search on internet for the above.
- Add this to the classpath
- Create an instance of *Connection* using *DriverManager* API
-- Specify the URL with specified database, username and password appropriately
- Get hold of *DatabaseMetaData* from the *Connection* object
- Use *getTables* method on above to find the list of tables 
-- Note: Filter out everything which is not a table, technically
- Display the gathered values as the list of Tables

