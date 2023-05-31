package projectCCSW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NurseRequest extends JFrame {
    
   private JLabel label = new JLabel("Nurse rquest form");
    private JPanel genderPanel;
    private JPanel NationalityPanel;
    private JPanel AgePanel;


    private JRadioButton male;
    private JRadioButton female;
    private JRadioButton Nationality1;
    private JRadioButton Nationality2;
    private JRadioButton Nationality3;
    private JRadioButton Nationality4;
    private JRadioButton age1;
    private JRadioButton age2;
    private JRadioButton age3;
    private JRadioButton age4;

    
    private JLabel contactLabel;
    private JTextField contactTextField;
    private JPanel contactPanel;
    private JLabel SalaryLabel;
    private JTextField SalaryTextField;
    private JPanel SalaryPanel;
    
    private JButton  OkButton = new JButton("         Ok         ");

    
    public NurseRequest(){

        setTitle("Needs App");
        setSize(700, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER,50,50));
        getContentPane().setBackground(Color.decode("#7CACC2"));
        setLocationRelativeTo(null);

        label.setFont(new Font("Serif",Font.BOLD,20));
        label.setForeground(Color.decode("#2e3b5c"));

        OkButton.setBackground(Color.decode("#5B5B5B"));
        OkButton.setForeground(Color.white);
        contactBuild();
        SalaryBuild();
        build();

        add(label);
        add(genderPanel);
        add(NationalityPanel);
        add(AgePanel);
        add(contactPanel);
        add(SalaryPanel);
        add(OkButton);

        setVisible(true);

    }
    
    public void build(){

        genderPanel = new JPanel(new GridLayout(5,1,30,10));

        male = new JRadioButton("Male");
        male.setForeground(Color.decode("#2e3b5c"));
        female = new JRadioButton("Female");
        female.setForeground(Color.decode("#2e3b5c"));
       
        ButtonGroup group1 = new ButtonGroup();
        group1.add(male);
        group1.add(female);
        

        genderPanel.add(male);
        genderPanel.add(female);
        
        NationalityPanel = new JPanel(new GridLayout(5,1,30,10));

        Nationality1 = new JRadioButton("Saudi Arabia");
        Nationality1.setForeground(Color.decode("#2e3b5c"));
        Nationality2 = new JRadioButton("Philippines");
        Nationality2.setForeground(Color.decode("#2e3b5c"));
        Nationality3 = new JRadioButton("Indonesia");
        Nationality3.setForeground(Color.decode("#2e3b5c"));
        Nationality4 = new JRadioButton("India");
        Nationality4.setForeground(Color.decode("#2e3b5c"));
       
        ButtonGroup group2 = new ButtonGroup();
        group2.add(Nationality1);
        group2.add(Nationality2);
        group2.add(Nationality3);
        group2.add(Nationality4);


        NationalityPanel.add(Nationality1);
        NationalityPanel.add(Nationality2);
        NationalityPanel.add(Nationality3);
        NationalityPanel.add(Nationality4);

        AgePanel = new JPanel(new GridLayout(5,1,30,10));

        age1 = new JRadioButton("25 to 30");
        age1.setForeground(Color.decode("#2e3b5c"));
        age2 = new JRadioButton("31 to 35");
        age2.setForeground(Color.decode("#2e3b5c"));
        age3 = new JRadioButton("36 to 40");
        age3.setForeground(Color.decode("#2e3b5c"));
        age4 = new JRadioButton("41 to 45");
        age4.setForeground(Color.decode("#2e3b5c"));
       
        ButtonGroup group3 = new ButtonGroup();
        group3.add(age1);
        group3.add(age2);
        group3.add(age3);
        group3.add(age4);


        AgePanel.add(age1);
        AgePanel.add(age2);
        AgePanel.add(age3);
        AgePanel.add(age4);

          
     
        OkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String gender= "";
                if (male.isSelected()){
                    gender = "male";
                }else if (female.isSelected()){
                    gender = "female";
                }
                
                String Nationality= "";
                if(Nationality1.isSelected()){
                    Nationality="Saudi Arabia";
                }else if(Nationality2.isSelected()){
                    Nationality="Philippines";
                }else if(Nationality3.isSelected()){
                    Nationality="Indonesia";
                }else if(Nationality4.isSelected()){
                    Nationality="India";
                }
                String Age= "";
                if(age1.isSelected()){
                    Age="25 to 30";
                }else if(age2.isSelected()){
                    Age="31 to 35";
                }else if(age3.isSelected()){
                    Age="36 to 40";
                }else if(age4.isSelected()){
                    Age="41 to 45";
                }


                if (contactTextField.getText().isEmpty()){

                    JOptionPane.showMessageDialog(null,"Please Enter your contact information ");

                }else if(SalaryTextField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please Enter the approximate salary ");

                }
                else {

                    JOptionPane.showMessageDialog(null,"your choosen Nurse: \n\n gender: "+gender+"\n\n"+
                            "Nationality: "+Nationality+"\n\n"+"Age: "+Age+
                            "\n\n The approximate Salary: "+SalaryTextField.getText()+"\n\n Your contact Information: "+contactTextField.getText());
                    try {
                        FileWriter file = new FileWriter("NurseRequest.txt",true);
                        file.write("contact info: "+contactTextField.getText());
                        file.write("\nSalary: "+SalaryTextField.getText());
                        file.write("\nGender: "+gender+",Nationality: "+Nationality+",Age: "+Age+"\n");
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
    
    public void contactBuild(){

        contactLabel = new JLabel("Enter contact information");
        contactTextField = new JTextField(20);

        contactPanel = new JPanel();

        contactPanel.add(contactLabel);
        contactPanel.add(contactTextField);

    }
    public void SalaryBuild(){

        SalaryLabel = new JLabel("Enter approximate Salary");
        SalaryTextField = new JTextField(5);

        SalaryPanel = new JPanel();

        SalaryPanel.add(SalaryLabel);
        SalaryPanel.add(SalaryTextField);

    }

}

