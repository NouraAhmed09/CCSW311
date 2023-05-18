package projectCCSW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Store extends JFrame{


    private JLabel title;

    private JButton BuyButton;


    private JPanel firstPanel;
    private JLabel firstImage;
    private JLabel firstName;
    private JLabel firstPrice;
    private JCheckBox check1;


    private JPanel secondPanel;
    private JLabel secondImage;
    private JLabel secondName;
    private JLabel secondPrice;
    private JCheckBox check2;


    private JPanel thirdPanel;
    private JLabel thirdImage;
    private JLabel thirdName;
    private JLabel thirdPrice;
    private JCheckBox check3;

    private JPanel fourthPanel;
    private JLabel fourthImage;
    private JLabel fourthName;
    private JLabel fourthPrice;
    private JCheckBox check4;



    private JPanel centerPanel;

    public Store() {

        setTitle("NEEDS Store");
        setSize(750, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setBackground(Color.white);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        getContentPane().setBackground(Color.decode("#7CACC2"));
        setLocationRelativeTo(null);


        buildTitle();

        buildPerfume();



        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2, 2, 50, 50));
        centerPanel.setBackground(Color.decode("#7CACC2"));

        centerPanel.add(firstPanel);
        centerPanel.add(secondPanel);
        centerPanel.add(thirdPanel);
        centerPanel.add(fourthPanel);



        add(title);
        add(centerPanel);
        add(BuyButton);

        setVisible(true);





    }

    private void buildTitle(){

        title = new JLabel("                       Store                      ");
        title.setForeground(Color.decode("#D7D7CD"));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 23));

    }

    private void buildPerfume(){

        firstPanel = new JPanel();
        firstPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        ImageIcon image1 = new ImageIcon(new ImageIcon("chair.jpg").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)); //100, 100 add your own size
        firstImage = new JLabel(image1);
        firstName = new JLabel("Wheel chair");
        firstPrice = new JLabel("30$");
        check1 = new JCheckBox();
        firstPanel.add(firstImage);
        firstPanel.add(firstName);
        firstPanel.add(firstPrice);
        firstPanel.add(check1);

        secondPanel = new JPanel();
        secondPanel.setLayout(new FlowLayout(FlowLayout.CENTER));


        ImageIcon image2 = new ImageIcon(new ImageIcon("feet.jpg").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)); //100, 100 add your own size
        secondImage = new JLabel(image2);
        secondName = new JLabel("industrial man");
        secondPrice = new JLabel("150$");
        check2 = new JCheckBox();
        secondPanel.add(secondImage);
        secondPanel.add(secondName);
        secondPanel.add(secondPrice);
        secondPanel.add(check2);


        thirdPanel = new JPanel();
        thirdPanel.setLayout(new FlowLayout(FlowLayout.CENTER));


        ImageIcon image3 = new ImageIcon(new ImageIcon("hand.jpg").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)); //100, 100 add your own size
        thirdImage = new JLabel(image3);
        thirdName = new JLabel("prosthetic hand");
        thirdPrice = new JLabel("100$");
        check3 = new JCheckBox();
        thirdPanel.add(thirdImage);
        thirdPanel.add(thirdName);
        thirdPanel.add(thirdPrice);
        thirdPanel.add(check3);


        fourthPanel = new JPanel();
        fourthPanel.setLayout(new FlowLayout(FlowLayout.CENTER));


        ImageIcon image4 = new ImageIcon(new ImageIcon("pin.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)); //100, 100 add your own size
        fourthImage = new JLabel(image4);
        fourthName = new JLabel("STICK");
        fourthPrice = new JLabel("10$");
        check4 = new JCheckBox();
        fourthPanel.add(fourthImage);
        fourthPanel.add(fourthName);
        fourthPanel.add(fourthPrice);
        fourthPanel.add(check4);



        BuyButton = new JButton("            BUY            ");
        BuyButton.setBackground(Color.decode("#5B5B5B"));
        BuyButton.setForeground(Color.white);




        BuyButton.addActionListener(new buyAction());

    }


    private class buyAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            int total = 0;

            String item = "";


            if (check1.isSelected()){

                total+=30;
                item += "- Wheel chair\n30$\n\n";

            }if (check2.isSelected()){

                item+= "- Industrial man\n150$\n\n";
                total+=150;

            }if (check3.isSelected()){

                item+= "- Prosthetic Hand\n100$\n\n";
                total+=100;

            }if (check4.isSelected()){

                item+= "- STICK\n10$\n\n";
                total+=10;

            }


            JOptionPane.showMessageDialog(null,"     RECEIPT\n\n"+item+"\n- Total: "+total);
            Payment payment = new Payment(item,total);
        }
    }
}
