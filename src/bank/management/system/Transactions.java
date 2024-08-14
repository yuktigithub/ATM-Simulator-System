/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Hp
 */
public class Transactions extends JFrame implements ActionListener{
    String pinNumber;
    JButton deposit, cashWithdrawl, fastCash, miniStatement, pinChange,balanceEnquiry, exit;
    Transactions(String pin){ 
        this.pinNumber = pin;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0 ,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Please select yout Transaction");
        text.setBounds(215,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("raleway", Font.BOLD, 16));
        image.add(text);
        
        deposit = new JButton("Diposit");
        deposit.setBounds(170, 410, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        cashWithdrawl = new JButton("Cash Withdrawl");
        cashWithdrawl.setBounds(355, 410, 150, 30);
        cashWithdrawl.addActionListener(this);
        image.add(cashWithdrawl);
        
        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(170, 445, 150, 30);
        fastCash.addActionListener(this);
        image.add(fastCash);
        
        miniStatement = new JButton("Mini-Statement");
        miniStatement.setBounds(355, 445, 150, 30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);
        
        pinChange = new JButton("Pin Change");
        pinChange.setBounds(170, 480, 150, 30);
        pinChange.addActionListener(this);
        image.add(pinChange);
        
        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(355, 480, 150, 30);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);
        
        exit = new JButton("Exit");
        exit.setBounds(355, 515, 150, 30);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(900,900);
        setLocation(250,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    public static void main(String args[]){
        new Transactions("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == exit){
            System.exit(0);
        }else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
            
        }else if(ae.getSource() == cashWithdrawl){
            setVisible(false);
            new Withdrawl(pinNumber).setVisible(true);
            
        }else if(ae.getSource() == fastCash){
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
            
        }else if(ae.getSource() == pinChange){
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
            
        }
        else if(ae.getSource() == balanceEnquiry){
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
            
        }
        else if(ae.getSource() == miniStatement){
            new MiniStatement(pinNumber).setVisible(true);
            
        }
    }
}
