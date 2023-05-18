package projectCCSW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Payment extends JFrame {

    private JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 200, 10));
    private JLabel label = new JLabel("       BILL       ");



    private JLabel toLabel = new JLabel("Items : \n");

    private JLabel labelTotal = new JLabel("Total : ");

    private JButton button = new JButton("      PAY      ");

    private JPanel compPanel = new JPanel(new GridLayout(2, 1));

    JTextArea textArea = new JTextArea();


    double price;

    public Payment(String order, double price) {


        this.price = price;


        setTitle("Booking");
        setSize(645, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        panel.setBackground(Color.decode("#7CACC2"));
        compPanel.setBackground(Color.decode("#7CACC2"));

        label.setFont(new Font("Serif", Font.BOLD, 40));

        buildPanelInformation();


        panel.add(label);
        panel.add(compPanel);
        panel.add(button);

        add(panel);


        System.out.println(order);

        toLabel.setText("Items: \n"+order);

        labelTotal.setText("Total: "+price);

        textArea.setText("Items:\n" + order);
        textArea.setEditable(false);

        textArea.setBackground(Color.decode("#7CACC2"));



        button.setBackground(Color.decode("#5B5B5B"));
        button.setForeground(Color.white);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "your Bill is Done");
                System.exit(0);
            }
        });


    }

    public void buildPanelInformation() {


        compPanel.add(textArea);
        compPanel.add(labelTotal);


    }
}