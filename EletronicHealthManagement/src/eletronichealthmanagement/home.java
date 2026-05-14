
package eletronichealthmanagement;
import java.awt.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class home extends JFrame {

    public home() {
        // Get screen dimensions
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Create the main frame
        JFrame homepageFrame = new JFrame("Electronic Health Record");
        homepageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homepageFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Create the main panel
        JPanel wrapper = new JPanel();
        wrapper.setLayout(null);
        wrapper.setBackground(new Color(230, 230, 250)); // Light blue

        // Create the header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(null);
        headerPanel.setBounds(5, 5, screenSize.width - 10, 100);
        headerPanel.setBackground(new Color(128, 182, 247)); // Light blue with a hint of green
           
        JPanel headerpanelsh = new JPanel();
        headerpanelsh.setLayout(null);
        headerpanelsh.setBounds(16, 16, screenSize.width - 20, 100);
        headerpanelsh.setBackground(new Color(200, 200, 200));
        // Logo panel (optional)
        JPanel logoPanel = new JPanel();
        logoPanel.setLayout(null);
        logoPanel.setBounds(20, 15, 80, 70);
        logoPanel.setBackground(Color.WHITE); // White for logo to stand out

        // Hospital name label
        JLabel hospitalNameLabel = new JLabel("Black Lion Hospital");
        Font hospitalNameFont = new Font("Arial", Font.BOLD, 30);
        hospitalNameLabel.setFont(hospitalNameFont);
        hospitalNameLabel.setForeground(Color.WHITE);
        hospitalNameLabel.setBounds(120, 20, screenSize.width - 200, 60);
        headerPanel.add(hospitalNameLabel);

        // Create the information panel
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BorderLayout());
        infoPanel.setBounds(100, 130, screenSize.width - 200, 400);
        infoPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED)); // Optional border

        // Information text
        JLabel infoLabel = new JLabel(
                "<html><div style='text-align: center;'><br><p style='color:green; font-size:18px;'>Objectives of Electronic Health Record System</p><br><br>**Goal:** To streamline and automate various processes within a hospital, including patient registration, appointment scheduling, medical records management, billing and invoicing, inventory management, and overall administration.<br><br>**This system aims to improve efficiency, reduce errors, enhance communication, and provide a seamless experience for both staff and patients.</div></html>");
        infoLabel.setHorizontalAlignment(JLabel.CENTER);
        infoLabel.setVerticalAlignment(JLabel.CENTER);
        infoPanel.add(infoLabel, BorderLayout.CENTER);

        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();

        // Sign Out menu
        JMenu exitMenu = new JMenu("Exit");
        JMenuItem signOutItem = new JMenuItem("Sign Out");
        signOutItem.addActionListener(e -> {
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);
            homepageFrame.setVisible(false);
        });
        exitMenu.add(signOutItem);
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        exitMenu.add(exitItem);

        // Doctors and Patients menus
        JMenu doctorsMenu = new JMenu("Doctors");
        JMenuItem addDoctorItem = new JMenuItem("Add Doctor");
        addDoctorItem.addActionListener(e -> new Doctor());
        JMenuItem viewDoctorsItem = new JMenuItem("View Doctors");
        viewDoctorsItem.addActionListener(e -> new doctorfile());
        doctorsMenu.add(addDoctorItem);
        doctorsMenu.add(viewDoctorsItem);

        JMenu patientsMenu = new JMenu("Patients");
        JMenuItem addPatientItem = new JMenuItem("Add Patients");
        addPatientItem.addActionListener(e -> new Patient());// Assuming Patient class
        JMenuItem viewPatientsItem = new JMenuItem("View Patients");
        viewPatientsItem.addActionListener(e -> new patientfile());
        patientsMenu.add(addPatientItem);
        patientsMenu.add(viewPatientsItem);
            

        patientsMenu.add(addPatientItem);
        patientsMenu.add(viewPatientsItem);
        menuBar.add(doctorsMenu);
        menuBar.add(patientsMenu);
        menuBar.add(exitItem);
        menuBar.add(exitItem);

        

        wrapper.add(headerPanel);
        wrapper.add(headerpanelsh);
        wrapper.add(infoPanel);
        
        homepageFrame.setJMenuBar(menuBar);
        homepageFrame.add(wrapper);
        JScrollPane pane = new JScrollPane(wrapper);
        homepageFrame.add(pane);
        homepageFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        homepageFrame.setVisible(true);
    }

    public static void main(String[] args) {
        home home = new home();
    }
}