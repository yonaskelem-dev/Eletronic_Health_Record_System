
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

public class Doctor extends JFrame {

    JLabel name;
    JLabel address;
    JLabel phone;
    JLabel specialization;
    JLabel id;
    JTextField nameTextField;
    JTextField addressTextField;
    JTextField phoneTextField;
    JTextField specializationTextField;
    JTextField idTextField;
    JButton saveButton;
    JButton exitButton;
    JButton resetButton;
    Font titleFont;
    Font labelFont;
    Font textFieldFont;
    JPanel panel;

    public Doctor() {
        setLayout(null);
        setTitle("Doctor Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set fonts
        titleFont = new Font("Arial", Font.BOLD, 29);
        labelFont = new Font("Arial", Font.PLAIN, 20);
        textFieldFont = new Font("Arial", Font.PLAIN, 16);

        // Set background color
        getContentPane().setBackground(new Color(173, 216, 230)); // Light Blue

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(80, 40, 450, 530);
        panel.setBackground(Color.WHITE); // White for contrast

        // Create labels
        name = new JLabel("Name");
        name.setFont(labelFont);
        address = new JLabel("Address");
        address.setFont(labelFont);
        phone = new JLabel("Phone");
        phone.setFont(labelFont);
        specialization = new JLabel("Specialization");
        specialization.setFont(labelFont);
        id = new JLabel("ID");
        id.setFont(labelFont);

        // Create text fields
        nameTextField = new JTextField();
        nameTextField.setFont(textFieldFont);
        nameTextField.setPreferredSize(new Dimension(210, 30));
        addressTextField = new JTextField();
        addressTextField.setFont(textFieldFont);
        addressTextField.setPreferredSize(new Dimension(210, 30));
        phoneTextField = new JTextField();
        phoneTextField.setFont(textFieldFont);
        phoneTextField.setPreferredSize(new Dimension(210, 30));
        specializationTextField = new JTextField();
        specializationTextField.setFont(textFieldFont);
        specializationTextField.setPreferredSize(new Dimension(210, 30));
        idTextField = new JTextField();
        idTextField.setFont(textFieldFont);
        idTextField.setPreferredSize(new Dimension(210, 30));

        // Create buttons
        saveButton = new JButton("Save");
        saveButton.setFont(textFieldFont);
        saveButton.addActionListener(new Saver());
        saveButton.setBackground(new Color(230, 173, 216)); // Light Purple for buttons

        resetButton = new JButton("Reset");
        resetButton.setFont(textFieldFont);
        resetButton.addActionListener(new Reset());
        resetButton.setBackground(new Color(230, 173, 216)); // Light Purple for buttons
        
         exitButton = new JButton("Exit");
       exitButton.setFont(textFieldFont);
        exitButton.addActionListener(e->{System.exit(0);});
        exitButton.setBackground(new Color(230, 173, 216)); // Light Purple for buttons

        // Add components to panel
        panel.add(name);
        panel.add(address);
        panel.add(phone);
        panel.add(specialization);
        panel.add(id);
        panel.add(nameTextField);
        panel.add(addressTextField);
        panel.add(phoneTextField);
        panel.add(specializationTextField);
        panel.add(idTextField);
        panel.add(saveButton);
        panel.add(exitButton);
        panel.add(resetButton);

        // Set component bounds
        name.setBounds(40, 80, 100, 30);
        address.setBounds(40, 130, 100, 30);
        phone.setBounds(40, 180, 100, 30);
        specialization.setBounds(30, 230, 150, 30);
        id.setBounds(40, 280, 100, 30);

        nameTextField.setBounds(160, 80, 200, 30);
        addressTextField.setBounds(160, 130, 200, 30);
        phoneTextField.setBounds(160, 180, 200, 30);
        specializationTextField.setBounds(160, 230, 200, 30);
        idTextField.setBounds(160, 280, 200, 30);

        saveButton.setBounds(30, 400, 100, 30);
        resetButton.setBounds(160, 400, 100, 30);
       exitButton.setBounds(290, 400, 100, 30);

        add(panel);
    
        setResizable(false);
        setSize(650, 650);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Doctor();
    }

    private class Reset implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
             nameTextField.setText("");
        addressTextField.setText("");
        phoneTextField.setText("");
        specializationTextField.setText("");
        idTextField.setText("");
        }
    }

     private class Saver implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String doctor_name = nameTextField.getText();
            String doctor_address = addressTextField.getText();
            String doctor_phone = phoneTextField.getText();
            String doctor_specialization = specializationTextField.getText();
            String doctor_id = idTextField.getText();

            if (doctor_name.isEmpty() || doctor_address.isEmpty() || doctor_phone.isEmpty() || doctor_specialization.isEmpty() || doctor_id.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Fill in all necessary information");
                return;
            }

            // Connect to database and save data
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(
                         "INSERT INTO doctor (doctor_name, doctor_address, doctor_phone, doctor_specialization, doctor_id) VALUES (?, ?, ?, ?, ?)")) {

                preparedStatement.setString(1, doctor_name);
                preparedStatement.setString(2, doctor_address);
                preparedStatement.setString(3, doctor_phone);
                preparedStatement.setString(4, doctor_specialization);
                preparedStatement.setString(5, doctor_id);

                preparedStatement.executeUpdate();

                JOptionPane.showMessageDialog(null, "Doctor information saved successfully!");
                resetFields(); // Call a method to reset text fields
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error occurred while saving the data", "Error",
                        JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace(); // Print stack trace for debugging (optional)
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // Helper method to establish connection
    private Connection getConnection() throws SQLException, ClassNotFoundException {
        // Replace with your XAMPP database connection details
        String jdbcDriver = "com.mysql.cj.jdbc.Driver";
        String dbUrl = "jdbc:mysql://localhost:3306/electronic_health_records";
        String user = "admin";
        String password = "password";

        Class.forName(jdbcDriver);
        return DriverManager.getConnection(dbUrl, user, password);
    }

    // Method to reset text fields (optional)
    private void resetFields() {
        nameTextField.setText("");
        addressTextField.setText("");
        phoneTextField.setText("");
        specializationTextField.setText("");
        idTextField.setText("");
    }
}