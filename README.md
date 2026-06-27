# Electronic Health Record Management System

## Project Description

The Electronic Health Record Management System is a Java desktop application designed to manage hospital records efficiently. It provides a graphical user interface (GUI) to handle doctor and patient information. The system supports basic CRUD operations using Java Swing.

## Features

- Login system (LoginFrame)
  - Username: username
  - Password: password
- Manage doctor records
- Manage patient records
- View stored records
- CSV file storage
- Java Swing GUI
- MySQL connector included for future use

## Technologies Used

- Java
- Java Swing
- NetBeans IDE structure
- CSV storage
- JDBC (MySQL Connector)

## Project Structure

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

1. Navigate: `cd Eletronic_Health_Record_System-main` then `cd EletronicHealthManagement`
2. Compile: `javac src/eletronichealthmanagement/*.java`
3. Run: `java -cp src eletronichealthmanagement.LoginFrame`
4. Login — Username: `username` Password: `password`

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

> **Note:** This project uses XAMPP default MySQL credentials.
> If your MySQL has a different password, update `user` and `password`
> inside `getConnection()` method in `doctorfile.java` and `patientfile.java`.
> Example:
>
> ```java
> String user = "root";        // your MySQL username
> String password = "1234";    // your MySQL password
> ```
