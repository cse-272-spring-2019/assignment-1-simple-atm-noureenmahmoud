/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Cherine
 */
public class SignIn 
{
    // layout
    JLabel card_number = new JLabel("Card Number");
    JLabel password = new JLabel("PIN");
    JTextField card = new JTextField();
    JPasswordField pin = new JPasswordField();
    JButton signin = new JButton("Sign In");
    JButton signinexit = new JButton("Exit");
    
    
    //window
    JPanel panel_1; 
    JFrame frame;  
    
    //call
    Account acc;
    Main_Menu_GUI main_menu;
    
    
    void signin_gui() 
    {
       password.setLabelFor(pin); //hide the password
        panel_1 = new JPanel();
        GridLayout grid = new GridLayout(3, 2);
        panel_1.setLayout(grid);
        
        
        panel_1.add(card_number);
        panel_1.add(card);
        panel_1.add(password);
        panel_1.add(pin);
        panel_1.add(signin);
        panel_1.add(signinexit);
        

        frame = new JFrame("Sign In");
        frame.setContentPane(panel_1);
        frame.setSize(400,200);
        

        //frame.pack(); //fit
        frame.setVisible(true);
        Listen();
    }
    
    //void actionperformed ()
    //{ signinexit.addActionListener ();
    
    
    
    
    
    
     
    void Listen()
    {
        signin.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String card_txt = card.getText().trim();
                String Pin_txt = pin.getText().trim();
               
                
                if(card_txt.isEmpty() || Pin_txt.isEmpty())
                {
                    JOptionPane.showMessageDialog(panel_1, "Please Enter Card number and PIN");
                    return;
                }
                
                
                try 
                {
                    acc = new Account(Integer.parseInt(card_txt), Integer.parseInt(Pin_txt));
                    acc.account_check();
                    card.setText("");
                    pin.setText("");
                } 
                catch (Exception e1)
                {
                    JOptionPane.showMessageDialog(panel_1, "Please Enter valid value");
                    card.setText("");
                    pin.setText("");
                
                    return;
                }
               
                
                if (acc.isValid_account())
                {
                    main_menu = new Main_Menu_GUI(acc);
                    main_menu.Gui();
                    frame.dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(panel_1, "Please check card or PIN");
                }

            }
        });
              signinexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
              System.exit(0);
            }
          
            }); 
    }

}
