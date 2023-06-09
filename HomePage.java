package projectCCSW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HomePage extends JFrame {
    
   private JLabel label = new JLabel("Our services");

    private ImageIcon imageIcon = new ImageIcon("physicaltherapy.jpg");
    private  JLabel image = new JLabel(imageIcon);
    private JButton bookButton = new JButton("           Booking an Appointment           ");
    private JButton BuyButton = new JButton("           buying tools           ");
    private JButton ReqButton = new JButton("           request an Assistant           ");

    private JMenuBar menuBar = new JMenuBar();
    private JMenu file = new JMenu("File");
    private JMenu help = new JMenu("Help");
    private JMenuItem close = new JMenuItem("Close");
    private JMenuItem aboutUs = new JMenuItem("About Us");


    public HomePage(){
        setTitle("Needs App");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER,10,5));
       getContentPane().setBackground(Color.decode("#7CACC2"));
        setLocationRelativeTo(null);

        label.setFont(new Font("Serif",Font.BOLD,30));
        bookButton.setBackground(Color.decode("#5B5B5B"));
        bookButton.setForeground(Color.white);
        BuyButton.setBackground(Color.decode("#5B5B5B"));
        BuyButton.setForeground(Color.white);
        ReqButton.setBackground(Color.decode("#5B5B5B"));
        ReqButton.setForeground(Color.white);

        add(image);
        add(label);
        add(bookButton);
        add(BuyButton);
        add(ReqButton);

        file.add(close);
        help.add(aboutUs);
        menuBar.add(file);
        menuBar.add(help);


        setJMenuBar(menuBar);

        setVisible(true);

        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                setVisible(false);

                Department dep = new Department();
            }
        });

        BuyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);

                Store store = new Store();
            }
        });
        
        ReqButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);

                NurseRequest req = new NurseRequest();
            }
        });

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        aboutUs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null,"In our application you can find All you Need for helping People with special needs");
            }
        });

    }
      
}

