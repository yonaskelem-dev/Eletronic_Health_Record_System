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

## How to Run
## Database Setup (MySQL with XAMPP)

1. Install XAMPP and start **Apache** and **MySQL** from the Control Panel
2. Go to `http://localhost/phpmyadmin` and create a database named `electronic_health_records`
3. Click the **SQL** tab and run:
```sql
   CREATE TABLE doctor (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(100),
       specialty VARCHAR(100),
       phone VARCHAR(20),
       email VARCHAR(100)
   );
   CREATE TABLE patient (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(100),
       age INT,
       phone VARCHAR(20),
       email VARCHAR(100)
   );
```
4. Open `doctorfile.java` and `patientfile.java`, change the connection details:
```java
   String user = "root";
   String password = "";
```
5. Recompile:
```bash
   javac -cp ".;../mysql-connector-j-8.4.0/mysql-connector-j-8.4.0.jar" src/eletronichealthmanagement/*.java
```
6. Run:
```bash
   java -cp ".;src;../mysql-connector-j-8.4.0/mysql-connector-j-8.4.0.jar" eletronichealthmanagement.LoginFrame
```


