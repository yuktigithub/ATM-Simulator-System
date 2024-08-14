/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 *
 * @author Hp
 */
public class SignUpThree extends JFrame implements ActionListener{
    
   JRadioButton r1, r2, r3, r4 ;
   JCheckBox c1, c2, c3, c4, c5,c6, c7;
   JButton submit, cancel ;
   String formNo;
    public SignUpThree(String formNum){
        
        this.formNo = formNum;
        setLayout(null);
        
        
        JLabel l1 = new JLabel("Page 3 : Account Details");
        l1.setFont(new Font("raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);
        
        JLabel type = new JLabel("Account Type:");
        type.setFont(new Font("raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        add(type);
        
        r1 = new JRadioButton("Saving Account");
        r1.setBounds(100, 180, 150, 20);
        r1.setBackground(Color.white);
        add(r1);
        r2 = new JRadioButton("Current Account");    
        r2.setBounds(350, 180, 150, 20);
        r2.setBackground(Color.white);
        add(r2);
        r3 = new JRadioButton("Joint Account");
        r3.setBounds(100, 220, 150, 20);
        r3.setBackground(Color.white);
        add(r3);
        r4 = new JRadioButton("Fixed Diposite Account");
        r4.setBounds(350, 220, 250, 20);
        r4.setBackground(Color.white);
        add(r4);
        
        ButtonGroup typeGroup = new ButtonGroup();
        typeGroup.add(r1);
        typeGroup.add(r2);
        typeGroup.add(r3);
        typeGroup.add(r4);
        
        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("raleway", Font.BOLD, 22));
        card.setBounds(100, 270, 200, 30);
        add(card);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-2329");
        number.setFont(new Font("raleway", Font.BOLD, 22));
        number.setBounds(330, 270, 300, 30);
        add(number);
        
        JLabel cardDetails = new JLabel("Your 16 digit card number");
        cardDetails.setFont(new Font("raleway", Font.BOLD, 12));
        cardDetails.setBounds(100, 300, 300, 30);
        add(cardDetails);
        
        JLabel pin = new JLabel("Pin:");
        pin.setFont(new Font("raleway", Font.BOLD, 22));
        pin.setBounds(100, 350, 200, 30);
        add(pin);
        
        JLabel pinDetails = new JLabel("Your 4 digit pin number");
        pinDetails.setFont(new Font("raleway", Font.BOLD, 12));
        pinDetails.setBounds(100, 380, 300, 30);
        add(pinDetails);
        
        JLabel pNumber = new JLabel("XXXX");
        pNumber.setFont(new Font("raleway", Font.BOLD, 22));
        pNumber.setBounds(330, 350, 300, 30);
        add(pNumber);
        
        JLabel services = new JLabel("Services Required");
        services.setFont(new Font("raleway", Font.BOLD, 22));
        services.setBounds(100, 430, 200, 30);
        add(services);
        
         c1 = new JCheckBox("ATM CARD");
         c1.setFont(new Font("raleway", Font.BOLD, 16));
         c1.setBackground(Color.white);
         c1.setBounds(100, 480, 200, 30);
         add(c1);
         
         c2 = new JCheckBox("Internet Banking");
         c2.setFont(new Font("raleway", Font.BOLD, 16));
         c2.setBackground(Color.white);
         c2.setBounds(300, 480, 200, 30);
         add(c2);
         
         c3 = new JCheckBox("Mobile Banking");
         c3.setFont(new Font("raleway", Font.BOLD, 16));
         c3.setBackground(Color.white);
         c3.setBounds(100, 530, 200, 30);
         add(c3);
         
         c4 = new JCheckBox("Cheque Book");
         c4.setFont(new Font("raleway", Font.BOLD, 16));
         c4.setBackground(Color.white);
         c4.setBounds(300, 530, 200, 30);
         add(c4);
         
         c5 = new JCheckBox("E-statement");
         c5.setFont(new Font("raleway", Font.BOLD, 16));
         c5.setBackground(Color.white);
         c5.setBounds(100, 580, 200, 30);
         add(c5);
         
         
         c6 = new JCheckBox("EMAIL and SMS Alerts");
         c6.setFont(new Font("raleway", Font.BOLD, 16));
         c6.setBackground(Color.white);
         c6.setBounds(300, 580, 200, 30);
         add(c6);
         
         c7 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge.");
         c7.setFont(new Font("raleway", Font.BOLD, 12));
         c7.setBackground(Color.white);
         c7.setBounds(100, 610, 600, 30);
         add(c7);
         
         submit = new JButton("Submit");
         submit.setBackground(Color.black);
         submit.setFont(new Font("raleway", Font.BOLD, 14));
         submit.setBounds(250, 650, 100, 30);
         submit.setForeground(Color.WHITE);
         add(submit);
         submit.addActionListener(this);
         
         cancel = new JButton("Cancel");
         cancel.setFont(new Font("raleway", Font.BOLD, 14));
         cancel.setBounds(420, 650, 100, 30);
         cancel.setBackground(Color.black);
         cancel.setForeground(Color.WHITE);
         add(cancel);
         cancel.addActionListener(this);

        setVisible(true);
        setSize(850,800);
        setLocation(260,0);
        getContentPane().setBackground(Color.WHITE);
        
        
    }
    public static void main(String[] args){
        SignUpThree s3 = new SignUpThree("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){
            String accountType = null;
            if(r1.isSelected()){
                accountType = "Saving Account";
            }else if(r2.isSelected()){
                accountType = "Current Account";
            }else if(r3.isSelected()){
                accountType = "Joint Account";
            }else if(r4.isSelected()){
                accountType = "Fixed Diposite Account";
            }
            Random random = new Random();
            String cardNumber = "" + Math.abs((random.nextLong() % 90000000L) + 6225210000000000L);
            
            String pinNumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
//            String services 
            String facility = "";
            if(c1.isSelected()){
                facility = facility + "ATM CARD";
            }else if(c2.isSelected()){
                facility = facility + " Internet Banking";
            }else if(c3.isSelected()){
                facility = facility + " Mobile Banking";
            }else if(c4.isSelected()){
                facility = facility + " Cheque Book";
            }else if(c5.isSelected()){
                facility = facility + " E-Statement";
            }else if(c6.isSelected()){
                facility = facility + " EMAIL AND SMS Alerts";
            }
            
             try{
                 if(accountType.equals("")){
                     JOptionPane.showMessageDialog(null,"Account Type is Required");
                 }else{
                     Conn conn = new Conn();
                     String query1 = "insert into signupthree values('"+formNo+"','"+accountType+"','"+cardNumber+"','"+pinNumber+"','"+facility+"')";
                     String query2 = "insert into login values('"+formNo+"','"+cardNumber+"','"+pinNumber+"')";
                     conn.s.executeUpdate(query1);
                     conn.s.executeUpdate(query2);
                 }
                 JOptionPane.showMessageDialog(null,"Card number: "+ cardNumber +"\n"+ "Pin: "+pinNumber);
                 setVisible(false);
                 new Deposit(pinNumber).setVisible(true);
                 
             }catch(Exception ex){
                 System.out.println(ex);
             }
        }else if(e.getSource() == cancel){
            
            JOptionPane.showMessageDialog(null, "Are you sure you want to cancel?");
            setVisible(false);
            new Login().setVisible(true);
        
        
    }
    
    
}
}
