package eletronichealthmanagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class patientfile extends JFrame {

    private JTable table;
    private JButton exit;
    private JPanel panel;
    private JLabel titLabel;
    private JPanel titPanel;

    public patientfile() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("View Patient");

        titPanel = new JPanel();
        table = new JTable();
        panel = new JPanel();
        titLabel = new JLabel("<html><body><h1 style='color:blue'>Patient' Record</h1></body></html>");
        titPanel.add(titLabel);
        exit = new JButton("Exit");
        exit.addActionListener(new ExitButtonListener()); // Use inner class for action listener
        panel.add(exit);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        add(titPanel, BorderLayout.NORTH);
        readDoctorsFromDatabase(); // Call method to read data
        setSize(700, 300);
        add(panel, BorderLayout.SOUTH);
        setVisible(true);
    }

    private void readDoctorsFromDatabase() {
        // Connect to database and retrieve data
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            String query = "SELECT * FROM patients";
            java.sql.ResultSet resultSet = statement.executeQuery(query);

            // Build table model from result set
            DefaultTableModel model = new DefaultTableModel();
            int columnCount = resultSet.getMetaData().getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(resultSet.getMetaData().getColumnName(i));
            }

            while (resultSet.next()) {
                String[] rowData = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = resultSet.getString(i);
                }
                model.addRow(rowData);
            }

            table.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error occurred while fetching data", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Helper method to establish connection (can be moved to a separate class)
    private Connection getConnection() throws SQLException {
        // Replace with your XAMPP database connection details
        String jdbcDriver = "com.mysql.cj.jdbc.Driver";
        String dbUrl = "jdbc:mysql://localhost:3306/electronic_health_records";
        String user = "admin";
        String password = "password";

        try {
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(patientfile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DriverManager.getConnection(dbUrl, user, password);
    }

    private static class ResultSet {

        public ResultSet() {
        }
    }

    // Inner class for cleaner action listener implementation (optional)
    private class ExitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new patientfile();
    }
}
