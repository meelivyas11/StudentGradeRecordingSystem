# What is it?
This is a Java Project which follows MVC architecture and uses Spring Framwork.

# How do I set up?
## Software Requirement
 - Git Bash: https://git-scm.com/
 - Eclipse
 - Apache Tomcat: http://apache.spinellicreations.com/tomcat/tomcat-8/v8.0.39/bin/apache-tomcat-8.0.39.zip
 - Docker: https://www.docker.com/products/overview (Use the steps provided in `Get Started Tutorial` to install as Virtualization must be enabled for certain platforms)
 - Docker Toolbox: https://www.docker.com/products/docker-toolbox
 - SQL Developer: http://www.oracle.com/technetwork/developer-tools/sql-developer/downloads/index.html
 
## Environment Setup
 - Clone the repository using  `git clone https://github.com/meelivyas11/StudentGradeRecordingSystem.git` command in Git Bash
 - Open the repository 'StudentGradeRecordingSystem' from eclipse IDE
 - Import 'SGRSApp' Project (File->Import->General->Existing Project into Workspace) from eclipse IDE
 - Creating a new Apache Tomcat v8.0 server
 - Clean and Build the Project 
  * Right click project -> Run As -> Maven clean
  * Right click project -> Run As -> Maven install
  * If Build Fails
    1. Right click project -> Maven -> Update Project
    2. Check “Force update of Snapshots/Releases” checkbox
    3. Click ok
    4. Right click project -> Run As -> Maven install

## Database Setup
 - Using the Kitematic (Docker Toolbox) create a Oracle Container.
 - Use the Container details (system user credentials) to connect to the SYS_USER from SQL Developer
 - As a SYS_USER, run `Oracle_SGRS_DB_Creation.sql` script in the repository to create SGRS schema and its tables
 - Connect to the `SGRS` connection and execute the script `TRIGGERS.sql`

# How do I use it?
