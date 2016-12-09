# What is it?
This is a Java Project which follows MVC architecture using Maven and Spring Framwork.

# How do I set up?
## Software Requirement
 - Git Bash: https://git-scm.com/
 - Eclipse Java EE IDE for Web Developers
 - Apache Tomcat: http://apache.spinellicreations.com/tomcat/tomcat-8/v8.0.39/bin/apache-tomcat-8.0.39.zip
 - Docker: https://www.docker.com/products/overview (Use the steps provided in `Get Started Tutorial` to install as Virtualization must be enabled for certain platforms)
 - Docker Toolbox: https://www.docker.com/products/docker-toolbox
 - SQL Developer: http://www.oracle.com/technetwork/developer-tools/sql-developer/downloads/index.html
 
## Environment Setup
 - Clone the repository using  `git clone https://github.com/meelivyas11/StudentGradeRecordingSystem.git` command in Git Bash
 - Open the repository `StudentGradeRecordingSystem` from eclipse IDE
 - Import `SGRSApp` Project (File->Import->General->Existing Project into Workspace) from eclipse IDE
 - Creating a new Apache Tomcat v8.0 server
 - Clean and Build the Maven Project 
  * Right click project -> Run As -> Maven clean
  * Right click project -> Run As -> Maven install
  * If Build Fails
    1. Right click project -> Maven -> Update Project
    2. Check “Force update of Snapshots/Releases” checkbox
    3. Click ok
    4. Right click project -> Run As -> Maven install

## Database Setup
 - Using the Kitematic (Docker Toolbox) create a Oracle Container.
 - Use the Container details (system user credentials) to connect to the system user from SQL Developer
 - As a system user, run `Oracle_SGRS_DB_Creation.sql` script in the repository to create SGRS schema and its tables
 - Connect to the `SGRS` connection and execute the script `TRIGGERS.sql`
 - Update the port number in the connenction url (`DB_CONNECTION_URL`) in your DBUtils.java file present at  `SGRSApp\src\main\java\sgrs\DataProvider` location inside `StudentGradeRecordingSystem` repository
 - Clean and build the Maven project again (see steps in "Environment Setup"

# How do I use it?
 - Create a maven build using `tomcat:run -X` goal
 ![Maven Build Configuration](https://cloud.githubusercontent.com/assets/7827378/21065081/7fbe0da0-be2c-11e6-886a-3c5ab596f66b.PNG "Maven Build Configuration")
 - Open http://localhost:8080/SGRSApp/ from your web browser
 - Use following credentials to login as a professor or student to checkout the features 
 ![Login Credentials](https://cloud.githubusercontent.com/assets/7827378/21064893/7d41d1b6-be2b-11e6-8459-b9f9f247f3fe.PNG "Login Credentials")
