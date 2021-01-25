This Test enables a user to select a property and raise issue for it.
-It uses Factory method approach
-It is coded in Java
-TestNG is used for running tests
-Build automation tool is Gradle

Test is broken into Five scenaros:
1. App Login
2. Selecting City and Localities
3. Selecting property type and checkbox of including nearby properties
4. Reporting property
5. Editing configurations and saving changes 

Structure of Project:
base
  |__Base Class  ---> Initializing driver
  
pageObject
  |__Base Page   --> Utility methods e.g: all expected conditions used methods
  |__Login Page  --> Login page related elements 
  |__Home Page   --> Home page related elements
  |__Buy Page    --> Buy page related elements
  |__Property Page  --> Property page related elements
  |__Edit Page  --> Edit page related elements
  
 global.properties  ---> app, device and other information can be kept here
 
 NoBroker.apk ---> one place to keep apk, it can be kept in a folder as well
 
 Note: To run it as an end to end scenario, kindly create a method and copy all other test in same sequence, just 
 remove the asserts from the tests except the last one.
 
 One extra feature of adding note before submitting feedback is mandatory , so i have added that as well.
   

