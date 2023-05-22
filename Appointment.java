package projectCCSW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class Appointment extends JFrame{

    private JLabel label = new JLabel("Avalable Appointments");

    private JPanel datesPanel;

    private JRadioButton Date1;
    private JRadioButton Date2;
    private JRadioButton Date3;
    private JRadioButton Date4;
    private JLabel labelID;
    private JTextField textFieldID;
    private JPanel panelID;
    
    private JButton  buttonSubmit = new JButton("         Book         ");
    
    public Appointment(){

        setTitle("Departmens");
        setSize(700, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER,300,50));
        getContentPane().setBackground(Color.decode("#f0f4f7"));
        setLocationRelativeTo(null);

        label.setFont(new Font("Serif",Font.BOLD,20));
        label.setForeground(Color.decode("#2e3b5c"));

        buttonSubmit.setBackground(Color.decode("#4894fe"));
        buttonSubmit.setForeground(Color.white);
        
        buildID();
        buildDates();

        add(label);
        add(datesPanel);
        add(buttonSubmit);

        setVisible(true);

    }
    
    public void buildDates(){

        datesPanel = new JPanel(new GridLayout(5,1,50,25));

        Date1 = new JRadioButton("9-10:30 am Doctor omar Alharbi");
        Date1.setForeground(Color.decode("#2e3b5c"));
        Date2 = new JRadioButton("11-12:30 pm Doctor Khalid Edress");
        Date2.setForeground(Color.decode("#2e3b5c"));

        Date3 = new JRadioButton("1-2:30 pm Doctor Majed sonari");
        Date3.setForeground(Color.decode("#2e3b5c"));

        Date4 = new JRadioButton("3-4:30 Doctor Hend Al-sulmai");
        Date4.setForeground(Color.decode("#2e3b5c"));

        ButtonGroup group = new ButtonGroup();
        group.add(Date1);
        group.add(Date2);
        group.add(Date3);
        group.add(Date4);


        datesPanel.add(Date1);
        datesPanel.add(Date2);
        datesPanel.add(Date3);
        datesPanel.add(Date4);
        datesPanel.add(panelID);
        

        buttonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String choose= "";
                if (Date1.isSelected()){

                    choose = "9-10:30 am Doctor omar Alharbi";

                }else if (Date2.isSelected()){

                    choose = "11-12:30 pm Doctor Khalid Edress";

                }else if (Date3.isSelected()){

                    choose = "1-2:30 pm Doctor Majed sonari";

                }else if (Date4.isSelected()){

                    choose = "3-4:30 Doctor Hend Al-sulmai";

                }
                if (textFieldID.getText().isEmpty()){

                    JOptionPane.showMessageDialog(null,"Please Enter your ID");

                }else {

                    JOptionPane.showMessageDialog(null,"Your Appointment\n\n"+choose+"\n");
                    try {
                        FileWriter file = new FileWriter("appointments.txt",true);
                        file.write(textFieldID.getText());
                        file.write("\n"+choose+"\n");
                        file.close();

                        setVisible(false);

                        ProjectCCSW pro = new ProjectCCSW();

                    } catch (IOException e) {
                        e.toString();
                    }

                }
            }
        });
    }

    public void buildID(){

        labelID = new JLabel("Enter ID");
        textFieldID = new JTextField(20);

        panelID = new JPanel();

        panelID.add(labelID);
        panelID.add(textFieldID);

    }
}
    

