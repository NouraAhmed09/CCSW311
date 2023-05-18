package projectCCSW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

public class ProjectCCSW extends JFrame {


    private JLabel title;
    private JTextField usernameInput;
    private JLabel usernameText;
    private JTextField emailInput;
    private JLabel emailText;
    private JTextField passInput;
    private JLabel passText;
    private JButton singUpButton;
    private JButton singInButton;


    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenu aboutMenu;
    private JMenuItem exitItem;
    private JMenuItem contactItem;


    private JPanel centerPanel;

    public ProjectCCSW() {

        setTitle("Store");
        setSize(700, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        getContentPane().setBackground(Color.decode("#7CACC2"));
        setLocationRelativeTo(null);


        buildTitle();

        buildSignUp();


        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(4, 2, 0, 50));
        centerPanel.setBackground(Color.decode("#7CACC2"));
        centerPanel.add(usernameText);
        centerPanel.add(usernameInput);
        centerPanel.add(emailText);
        centerPanel.add(emailInput);
        centerPanel.add(passText);
        centerPanel.add(passInput);

        exitItem = new JMenuItem("Exist");
        fileMenu = new JMenu("File");
        fileMenu.add(exitItem);

        contactItem = new JMenuItem("Contact");
        aboutMenu = new JMenu("About");
        aboutMenu.add(contactItem);

        menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        menuBar.add(aboutMenu);
        setJMenuBar(menuBar);


        add(title);
        add(centerPanel);
        add(singUpButton);
        add(singInButton);

        setVisible(true);


        singUpButton.addActionListener(new SignUpAction());

        exitItem.addActionListener(new exitAction());

        contactItem.addActionListener(new contactAction());

        singInButton.addActionListener(new signInAction());


    }

    private void buildTitle() {

        title = new JLabel("Sign Up                      ");
        title.setForeground(Color.decode("#D7D7CD"));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 23));

    }

    private void buildSignUp() {

        usernameInput = new JTextField(15);
        usernameText = new JLabel("Username");
        usernameText.setForeground(Color.decode("#F1F1F1"));

        emailInput = new JTextField(15);
        emailText = new JLabel("Email Address");
        emailText.setForeground(Color.decode("#F1F1F1"));

        passInput = new JTextField(15);
        passText = new JLabel("Password");
        passText.setForeground(Color.decode("#F1F1F1"));

        singUpButton = new JButton("            Sign Up            ");
        singUpButton.setBackground(Color.decode("#5B5B5B"));
        singUpButton.setForeground(Color.white);

        singInButton = new JButton("     Sign In     ");
        singInButton.setBackground(Color.decode("#5B5B5B"));
        singInButton.setForeground(Color.white);


    }


    private class SignUpAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            try {

                if (!usernameInput.getText().isEmpty() && !emailInput.getText().isEmpty() && !passInput.getText().isEmpty()) {
                    FileWriter txt = new FileWriter("accounts.txt", true);

                    txt.write(usernameInput.getText() + "\n");
                    txt.write(emailInput.getText() + "\n");
                    txt.write(passInput.getText() + "\n");
                    txt.close();

                    setVisible(false);

                    new SignIn();
                }
                else {

                    JOptionPane.showMessageDialog(null,"Please write all information");

                }
            } catch (Exception e) {
                System.out.println("File can't open");
                ;
            }


        }
    }

    public static void main(String[] args) {
        ProjectCCSW p = new ProjectCCSW();


    }


    private class exitAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.exit(0);
        }
    }

    private class contactAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JOptionPane.showMessageDialog(null, " store online");
        }
    }

    private class signInAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            setVisible(false);

            new SignIn();
        }
    }
}
