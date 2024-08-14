/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

/**
 *
 * @author Hp
 */
public class FastCash extends JFrame implements ActionListener{
    String pinNumber;
    JButton deposit, cashWithdrawl, fastCash, miniStatement, pinChange,balanceEnquiry, back;
    FastCash(String pin){ 
        this.pinNumber = pin;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0 ,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Please select amount you want to withdraw");
        text.setBounds(170,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("raleway", Font.BOLD, 16));
        image.add(text);
        
        deposit = new JButton("RS 100");
        deposit.setBounds(170, 410, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        cashWithdrawl = new JButton("RS 500");
        cashWithdrawl.setBounds(355, 410, 150, 30);
        cashWithdrawl.addActionListener(this);
        image.add(cashWithdrawl);
        
        fastCash = new JButton("RS 1000");
        fastCash.setBounds(170, 445, 150, 30);
        fastCash.addActionListener(this);
        image.add(fastCash);
        
        miniStatement = new JButton("RS 2000");
        miniStatement.setBounds(355, 445, 150, 30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);
        
        pinChange = new JButton("RS 5000");
        pinChange.setBounds(170, 480, 150, 30);
        pinChange.addActionListener(this);
        image.add(pinChange);
        
        balanceEnquiry = new JButton("RS 10000");
        balanceEnquiry.setBounds(355, 480, 150, 30);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);
        
        back = new JButton("Back");
        back.setBounds(355, 515, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(250,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    public static void main(String args[]){
        new FastCash("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn conn = new Conn();
            try{
                ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return ;
                    
                }
                int availableBalance = balance - Integer.parseInt(amount);
                Date date = new Date();
                String query = "insert into bank values ('"+pinNumber+"','"+date+"','withdraw','"+amount+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Successfully!\n"+"Available Balance: "+availableBalance);
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
}


