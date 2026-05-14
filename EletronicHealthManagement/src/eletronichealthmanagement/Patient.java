package eletronichealthmanagement;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Patient extends JFrame {

    String genders[] = {"Female", "Male"};
    JLabel info;
    JLabel name;
    JLabel age;
    JLabel gender;
    JLabel department;
    JLabel medicalHistory;
    JLabel allergies;
    JLabel medications;
    JLabel labResults;
    JLabel imagingReports;
    JLabel phone;
    JTextField nameTextField;
    JTextField ageTextField;
    JTextField phonTextField;
    JComboBox<String> genderComboBox;
    JTextArea medicalHistoryTextArea;
    JTextArea allergiesTextArea;
    JTextArea medicationsTextArea;
    JTextArea labResultsTextArea;
    JTextArea imagingReportsTextArea;

    JButton saveButton;
    JButton exitButton;
    JButton resetButton;
    Font titleFont;
    Font labelFont;
    Font textFieldFont;
    JPanel panel;

    public Patient() {
        setLayout(null);
        setTitle("Patient Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set fonts
        titleFont = new Font("Arial", Font.BOLD, 29);
        labelFont = new Font("Arial", Font.PLAIN, 20);
        textFieldFont = new Font("Arial", Font.PLAIN, 16);

        // Set background color
        getContentPane().setBackground(new Color(173, 216, 230)); // Light Blue

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(110, 50, 760, 550);
        panel.setBackground(Color.WHITE); // White for contrast

        // Create labels
        info = new JLabel("INFORMATION OF A PATIENT");
        info.setFont(titleFont);
        info.setForeground(Color.BLACK); // Black text
        info.setBounds(20, 40, 760, 40);

        name = new JLabel("Name");
        name.setFont(labelFont);
        age = new JLabel("Age");
        age.setFont(labelFont);
        gender = new JLabel("Gender");
        gender.setFont(labelFont);
        department = new JLabel("Department");
        department.setFont(labelFont);
        medicalHistory = new JLabel("Medical History");
        medicalHistory.setFont(labelFont);
        allergies = new JLabel("Allergies");
        allergies.setFont(labelFont);
        medications = new JLabel("Medications");
        medications.setFont(labelFont);
        labResults = new JLabel("Lab Results");
        labResults.setFont(labelFont);
        imagingReports = new JLabel("Imaging Reports");
        imagingReports.setFont(labelFont);
        phone = new JLabel("Phone");
        phone.setFont(labelFont);

        // Create text fields, combo box, and text areas
        nameTextField = new JTextField();
        nameTextField.setFont(textFieldFont);
        nameTextField.setPreferredSize(new Dimension(210, 30));
        ageTextField = new JTextField();
        ageTextField.setFont(textFieldFont);
        phonTextField = new JTextField();
        phonTextField.setFont(textFieldFont);
        phonTextField.setPreferredSize(new Dimension(210, 30));
        ageTextField.setPreferredSize(new Dimension(210, 30));
        genderComboBox = new JComboBox<>(genders);
        genderComboBox.setFont(textFieldFont);
        medicalHistoryTextArea = new JTextArea();
        medicalHistoryTextArea.setFont(textFieldFont);
        allergiesTextArea = new JTextArea();
        allergiesTextArea.setFont(textFieldFont);
        medicationsTextArea = new JTextArea();
        medicationsTextArea.setFont(textFieldFont);
        labResultsTextArea = new JTextArea();
        labResultsTextArea.setFont(textFieldFont);
        imagingReportsTextArea = new JTextArea();
        imagingReportsTextArea.setFont(textFieldFont);

        // Create scroll panes for text areas
        JScrollPane medicalHistoryScrollPane = new JScrollPane(medicalHistoryTextArea);
        JScrollPane allergiesScrollPane = new JScrollPane(allergiesTextArea);
        JScrollPane medicationsScrollPane = new JScrollPane(medicationsTextArea);
        JScrollPane labResultsScrollPane = new JScrollPane(labResultsTextArea);
        JScrollPane imagingReportsScrollPane = new JScrollPane(imagingReportsTextArea);


        saveButton = new JButton("Save");
        saveButton.setFont(labelFont);
        saveButton.addActionListener(new Saver());

        resetButton = new JButton("Reset");
        resetButton.setFont(labelFont);
        resetButton.addActionListener(new Reset());
        
        exitButton = new JButton("Exit");
        exitButton.setFont(labelFont);
        exitButton.addActionListener(e->{System.exit(0);});

        panel.add(info);
        panel.add(name);
        panel.add(age);
        panel.add(gender);
        panel.add(phone);
        panel.add(medicalHistory);
        panel.add(allergies);
        panel.add(medications);
        panel.add(labResults);
        panel.add(imagingReports);
        panel.add(nameTextField);
        panel.add(ageTextField);
        panel.add(genderComboBox);
        panel.add(medicalHistoryScrollPane);
        panel.add(allergiesScrollPane);
        panel.add(medicationsScrollPane);
        panel.add(labResultsScrollPane);
        panel.add(imagingReportsScrollPane);
        panel.add(phonTextField);
        panel.add(exitButton);
        panel.add(saveButton);
        panel.add(resetButton);

        info.setBounds(40, 20, 700, 40);
        name.setBounds(40, 80, 100, 30);
        age.setBounds(40, 130, 100, 30);
        gender.setBounds(40, 180, 100, 30);
        medicalHistory.setBounds(30, 280, 150, 30);
        allergies.setBounds(40, 380, 100,45);
        phone.setBounds(40,240,150,30);

        medications.setBounds(400, 80, 150, 30);
        labResults.setBounds(400, 280, 150, 30);
        imagingReports.setBounds(400, 380, 150, 30);

        nameTextField.setBounds(160, 80, 200, 30);
        ageTextField.setBounds(160, 130, 200, 30);
        genderComboBox.setBounds(160, 180, 200, 30);
        medicalHistoryScrollPane.setBounds(160, 280, 200, 80);
        allergiesScrollPane.setBounds(160, 380, 200, 80);
        medicationsScrollPane.setBounds(550, 80, 200, 80);
        labResultsScrollPane.setBounds(550, 280, 200, 80);
        imagingReportsScrollPane.setBounds(550, 380, 200, 80);
        phonTextField.setBounds(160, 240, 200,30);

        saveButton.setBounds(160, 500, 100, 30);
        resetButton.setBounds(310, 500, 100, 30);
        exitButton.setBounds(460, 500, 100, 30);

        add(panel);
     
        setResizable(false);
        setSize(1000, 650);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Patient();
    }

    private  class Reset implements ActionListener {

        public Reset() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            nameTextField.setText("");
            ageTextField.setText("");
            medicalHistoryTextArea.setText("");
            allergiesTextArea.setText("");
            medicationsTextArea.setText("");
            labResultsTextArea.setText("");
            imagingReportsTextArea.setText("");
            phonTextField.setText("");
        }
    }

     private class Saver implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String patient_name = nameTextField.getText();
            String patient_age = ageTextField.getText();
            int patient = 0;
            try {
                patient = Integer.parseInt(patient_age);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid age format");
                return;
            }
            String patient_gender = (String) genderComboBox.getSelectedItem();
            String patient_medical_history = medicalHistoryTextArea.getText();
            String patient_allergies = allergiesTextArea.getText();
            String patient_medications = medicationsTextArea.getText();
            String patient_lab_results = labResultsTextArea.getText();
            String patient_imaging_reports = imagingReportsTextArea.getText();
            String patient_phone = phonTextField.getText();
            if (patient_name.isEmpty() || patient_age.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Fill in all necessary information");
                return;
            }

            // Connect to database and save data
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(
                         "INSERT INTO patients (patient_name, patient_age, patient_gender, patient_phone, " +
                                 "patient_medical_history, patient_allergies, patient_medications, patient_lab_results, " +
                                 "patient_imaging_reports) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

                preparedStatement.setString(1, patient_name);
                preparedStatement.setInt(2, patient);
                preparedStatement.setString(3, patient_gender);
                preparedStatement.setString(4, patient_phone);
                preparedStatement.setString(5, patient_medical_history);
                preparedStatement.setString(6, patient_allergies);
                preparedStatement.setString(7, patient_medications);
                preparedStatement.setString(8, patient_lab_results);
                preparedStatement.setString(9, patient_imaging_reports);

                preparedStatement.executeUpdate();

                JOptionPane.showMessageDialog(null, "Patient information saved successfully!");
                resetFields(); // Call a method to reset text fields
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error occurred while saving the data", "Error",
                        JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace(); // Print stack trace for debugging (optional)
            }
        }
    }

    // Helper method to establish connection
    private Connection getConnection() throws SQLException {
        // Replace with your XAMPP database connection details
        String jdbcDriver = "com.mysql.cj.jdbc.Driver";
        String dbUrl = "jdbc:mysql://localhost:3306/electronic_health_records";
        String user = "admin";
        String password = "password";

        try {
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DriverManager.getConnection(dbUrl, user, password);
    }

    // Method to reset text fields (optional)
    private void resetFields() {
        nameTextField.setText("");
        ageTextField.setText("");
        medicalHistoryTextArea.setText("");
        allergiesTextArea.setText("");
        medicationsTextArea.setText("");
        labResultsTextArea.setText("");
        imagingReportsTextArea.setText("");
        phonTextField.setText("");
    }
}