Electronic Health Record Management System

Project Description
The Electronic Health Record Management System is a Java desktop application designed to manage hospital records efficiently. It provides a graphical user interface (GUI) to handle doctor and patient information. The system supports basic CRUD operations using Java Swing.

Features

- Login system (LoginFrame)
  - Username: username
  - Password: password
- Manage doctor records
- Manage patient records
- View stored records
- CSV file storage
- Java Swing GUI
- MySQL connector included for future use

Technologies Used

- Java
- Java Swing
- NetBeans IDE structure
- CSV storage
- JDBC (MySQL Connector)

Project Structure
EletronicHealthManagement/

- src/eletronichealthmanagement/
  - LoginFrame.java
  - home.java
  - Doctor.java
  - Patient.java
  - doctorfile.java
  - patientfile.java
  - RoundedBorder.java
- resources/
  - logo.png
- doctor.csv
- patient.csv
- build.xml
- nbproject/

How to Run

1. Open project in NetBeans or Visual Studio Code
2. Compile:
   javac eletronichealthmanagement/\*.java
3. Run:
   java eletronichealthmanagement.LoginFrame

Database Note
Currently uses CSV files. MySQL integration is for future updates.
