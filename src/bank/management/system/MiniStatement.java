/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
/**
 *
 * @author Hp
 */
public class MiniStatement extends JFrame implements ActionListener{
    JButton ok ;
    String pinNumber;
    int total;
    
    MiniStatement(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(105, 10,200,30);
        bank.setFont(new Font("raleway", Font.BOLD, 30));
        add(bank);
        
        JLabel mini = new JLabel("Mini-Statement");
        mini.setBounds(135, 40,150,30);
        mini.setFont(new Font("raleway", Font.BOLD, 15));
        add(mini);
      
        
        JLabel card = new JLabel();
        card.setBounds(30, 100,300,30);
        card.setFont(new Font("raleway", Font.BOLD, 15));
        add(card);
        
        JLabel statement = new JLabel();
        statement.setBounds(30,150,400,200);
        add(statement);
        
        ok = new JButton("Cancel");
        ok.setBounds(230, 450,100,30);
        ok.setBackground(Color.black);
        ok.setForeground(Color.white);
        ok.addActionListener(this);
        add(ok);
        
        JLabel balance = new JLabel();
        balance.setBounds(30, 350,500,30);
        balance.setFont(new Font("System",Font.PLAIN , 20));
        add(balance);
        
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin_number = '"+pinNumber+"'");
            while(rs.next()){
                card.setText("Card Number:  "+ rs.getString("card_number").substring(0,4)+"XXXXXXXX"+rs.getString("card_number").substring(12));
                
            }
        }catch(Exception e){
            System.out.println(e);
        }
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinNumber+"' ORDER BY date ASC LIMIT 5");
            while(rs.next()){
                statement.setText(statement.getText()+ "<html>"+ rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
            }  
        }catch(Exception e){
            System.out.println(e);
        }
        
        try{
            Conn conn = new Conn();
            total = 0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
            while(rs.next()){
                if(rs.getString("type").equals("deposit")){
                    total += Integer.parseInt(rs.getString("amount"));
                }else{
                    total -= Integer.parseInt(rs.getString("amount"));
                }
                balance.setText("Balance in rupess: "+total+".000");
        }
        }catch(Exception e){
            System.out.println(e);
        }
        
        setSize(400,600);
        setLocation(500,30);
        setBackground(Color.white);
        setVisible(true);
        
        
    }
    public static void main(String args[]){
        new MiniStatement("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == ok){
             setVisible(false);
             
        }
    }
}
