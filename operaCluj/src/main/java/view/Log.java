package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Log extends JFrame {
    JFrame logginFrame;
    JPanel contentPane;
    JLabel username, pass;
    private JTextField usernameF;
    private JPasswordField passwordF;


    private JButton log;

    public int WIDTH = 350;
    public int HEIGHT = 400;


    public Log() {

        logginFrame = new JFrame("Welcome!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Username");
        lblNewLabel.setBounds(40, 24, 91, 16);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Password");
        lblNewLabel_1.setBounds(40, 110, 91, 16);
        contentPane.add(lblNewLabel_1);

        usernameF = new JTextField();
        usernameF.setBounds(26, 56, 116, 22);
        contentPane.add(usernameF);
        usernameF.setColumns(10);

        passwordF = new JPasswordField();
        passwordF.setBounds(26, 148, 116, 22);
        contentPane.add(passwordF);
        passwordF.setColumns(10);

        log = new JButton("Log in");
        log.setBounds(45, 215, 97, 25);
        contentPane.add(log);

    }

    public JButton getLog() {
        return log;
    }

    public JTextField getUsernameF() {
        return usernameF;
    }

    public JPasswordField getPasswordF() {
        return passwordF;
    }

}
