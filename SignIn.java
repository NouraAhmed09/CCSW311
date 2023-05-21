package projectCCSW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SignIn extends JFrame{


    private JLabel title;
    private JTextField emailInput;
    private JLabel emailText;
    private JTextField passInput;
    private JLabel passText;
    private JButton singInButton;

    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenu aboutMenu;
    private JMenuItem exitItem;
    private JMenuItem contactItem;



    private JPanel centerPanel;

    public SignIn() {

        setTitle("NEEDS Store");
        setSize(700, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setBackground(Color.white);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        getContentPane().setBackground(Color.decode("#7CACC2"));
        setLocationRelativeTo(null);


        buildTitle();

        buildSignUp();



        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 2, 0, 50));
        centerPanel.setBackground(Color.decode("#7CACC2"));

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
        add(singInButton);

        setVisible(true);


        exitItem.addActionListener(new exitAction());

        contactItem.addActionListener(new contactAction());


        singInButton.addActionListener(new signAction());

    }

    private void buildTitle(){

        title = new JLabel("Sign In                      ");
        title.setForeground(Color.decode("#D7D7CD"));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 23));

    }

    private void buildSignUp(){


        emailInput = new JTextField(15);
        emailText = new JLabel("Email Address");
        emailText.setForeground(Color.decode("#F1F1F1"));

        passInput = new JTextField(15);
        passText = new JLabel("Password");
        passText.setForeground(Color.decode("#F1F1F1"));

        singInButton = new JButton("            Sign In            ");
        singInButton.setBackground(Color.decode("#5B5B5B"));
        singInButton.setForeground(Color.white);

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


    private class signAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            boolean isFlag = true;

            try {
                File file = new File("accounts.txt");
                Scanner scannerFileReader = new Scanner(file);

                while (scannerFileReader.hasNextLine()) {

                    String name = scannerFileReader.nextLine();
                    String email = scannerFileReader.nextLine();
                    String pass = scannerFileReader.nextLine();

                    if (email.equals(emailInput.getText()) && pass.equals(passInput.getText())){

                        setVisible(false);

                        isFlag = false;

                        new HomePage();

                    }

                }
                if (isFlag){
                    JOptionPane.showMessageDialog(null,"Please Enter correct information ");
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
    }
}
