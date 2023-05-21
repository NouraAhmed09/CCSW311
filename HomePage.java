package projectCCSW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame {
    
    private JLabel title;
    private JButton StoreButton;
   // private JButton AppointmentButton;
   
   private JPanel centerPanel;
    
    public HomePage() {
        setTitle("NEEDS APP");
        setSize(700, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.decode("#7CACC2"));
        setLocationRelativeTo(null);
        
         buildTitle();
        buildHome();
        
       centerPanel = new JPanel();
       centerPanel.setLayout(new GridLayout(4, 2, 0, 50));
       centerPanel.setBackground(Color.decode("#7CACC2"));
       
      
        
        
        add(title);
        add(StoreButton);
       // add(AppointmentButton);
        add(centerPanel);
        
        setVisible(true);
        
     
        StoreButton.addActionListener(new StoreButton());
        
    }

    private void buildTitle() {
        
        title = new JLabel("Select                      ");
        title.setForeground(Color.decode("#D7D7CD"));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 23));
        
    }
     private void buildHome() {
        
        StoreButton = new JButton("            Store            ");
        StoreButton.setBackground(Color.decode("#5B5B5B"));
        StoreButton.setForeground(Color.white);
        
    }

   
    
    private class StoreButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //setVisible(false);
            new Store();
        }
    }
}
