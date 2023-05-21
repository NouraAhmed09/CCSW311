package projectCCSW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Department extends JFrame {

    private JLabel label = new JLabel("Our Department");

    private ImageIcon imageIcon = new ImageIcon("physicaltherapy.jpg");
    private  JLabel image = new JLabel(imageIcon);
    private JButton PHButton = new JButton("           physical therapy Department           ");
    private JButton REHButton = new JButton("           Rehabilitation Techniques Department           ");

    private JMenuBar menuBar = new JMenuBar();
    private JMenu file = new JMenu("File");
    private JMenu help = new JMenu("Help");
    private JMenuItem close = new JMenuItem("Close");
    private JMenuItem aboutUs = new JMenuItem("About Us");


    public Department(){
        setTitle("Needs App");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER,40,50));
       getContentPane().setBackground(Color.decode("#f0f4f7"));
        setLocationRelativeTo(null);

        label.setFont(new Font("Serif",Font.BOLD,30));
        PHButton.setBackground(Color.decode("#4894fe"));
        PHButton.setForeground(Color.white);
        REHButton.setBackground(Color.decode("#4894fe"));
        REHButton.setForeground(Color.white);

        add(image);
        add(label);
        add(PHButton);
        add(REHButton);
        file.add(close);
        help.add(aboutUs);
        menuBar.add(file);
        menuBar.add(help);


        setJMenuBar(menuBar);

        setVisible(true);

        PHButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                setVisible(false);

                Appointment apoin = new Appointment();
            }
        });

        REHButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);

                Appointment apoin = new Appointment();
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
