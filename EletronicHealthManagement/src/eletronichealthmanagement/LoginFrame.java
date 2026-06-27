package eletronichealthmanagement;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

public class LoginFrame extends JFrame {
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JLabel login;
    private JLabel show;

    public LoginFrame() {
        initializeComponents();
        setupLayout();
        setupListeners();

        setTitle("Login");
        setSize(500, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new Color(242, 242, 242)); // Light gray background
    }

    private JButton createRoundedButton(String text, int arcSize) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 14));

        button.setBorder(new RoundedBorder(arcSize));
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setBackground(new Color(103, 58, 183)); // Dark purple button color
        button.setForeground(Color.WHITE); // White text for button

        button.setFocusable(false);

        return button;
    }

    private void initializeComponents() {
        lblUsername = new JLabel("Username:");
        lblPassword = new JLabel("Password:");
        txtUsername = new JTextField(10);
        txtPassword = new JPasswordField(10);
        show = new JLabel("Error: Username or password incorrect");
        btnLogin = createRoundedButton("Sign in", 20);
        login = new JLabel("Login");
        Font font = new Font("Arial", Font.PLAIN, 14);
        Font font1 = new Font("Arial", Font.BOLD, 34);

        lblUsername.setFont(font);
        lblPassword.setFont(font);
        txtUsername.setFont(font);
        txtUsername.setBorder(new BottomBorder());
        txtPassword.setFont(font);
        txtPassword.setBorder(new BottomBorder());
        btnLogin.setFont(font);
        login.setFont(font1);

        show.setFont(font);
        show.setForeground(Color.RED); // Error message in red
        show.setVisible(false);
    }

    private void setupLayout() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        panel.setBounds(100, 90, 270, 450);
        login.setBounds(79, 30, 100, 35);
        lblUsername.setBounds(30, 70, 80, 25);
        txtUsername.setBounds(30, 90, 220, 25);
        lblPassword.setBounds(30, 140, 80, 25);
        txtPassword.setBounds(30, 160, 220, 25);
        btnLogin.setBounds(30, 250, 220, 45);
        show.setBounds(30, 180, 220, 25);
        panel.add(show);

        panel.add(lblUsername);
        panel.add(txtUsername);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(btnLogin);
        panel.add(login);
        setLayout(null);
        getContentPane().add(panel);
        panel.setBackground(new Color(240, 240, 240));
        getContentPane().setBackground(new Color(128, 0, 128));
    }

    private void setupListeners() {
    btnLogin.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());

            if (username.equals("admin") && password.equals("password")) {
                JOptionPane.showMessageDialog(null, "Login successful!");
                home home = new home();
                setVisible(false);
            } else {
                show.setVisible(true);
            }
        }
    });
}


public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginFrame frame = new LoginFrame();
            frame.setVisible(true);
        });
    }

    class BottomBorder implements Border {
    private final int thickness;

    public BottomBorder() {
        this.thickness = 1; 
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(c.getForeground());
        g2.fillRect(x, y + height - thickness, width, thickness);
        g2.dispose();
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(0, 0, thickness, 0);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }
}

}
class RoundedBorder implements Border {
    private int arcSize;

    public RoundedBorder(int arcSize) {
        this.arcSize = arcSize;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(c.getForeground());
    
        Shape clip = new RoundRectangle2D.Double(x, y, width - 1, height - 1, arcSize, arcSize);
        g2.draw(clip);
    
        g2.dispose();
    }
    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(arcSize, arcSize, arcSize, arcSize);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }
}
