/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

/**
 *
 * @author Hp
 */
public class Login extends JFrame implements ActionListener{             //ActionListener is an interface
    
    JButton loginBtn, clearBtn, signUpBtn ;
    JTextField  cardTextField;
    JPasswordField pinTextField;
    Login(){
        
        setLayout(null);  //using no layout managers  
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg")); 
        Image img2 = img1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);   //setting image width and height
        ImageIcon img3 = new ImageIcon(img2);          //Image cant be use directly with label therefore here we are again converting it into image icon
        JLabel imgLabel = new JLabel(img3);  
        imgLabel.setBounds(70, 10, 100, 100);
        add(imgLabel);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("osward", Font.BOLD, 38));
        text.setBounds(200, 40,400, 40);
        add(text);
        
          
        JLabel cardNo = new JLabel("Card No:");
        cardNo.setFont(new Font("raleway", Font.BOLD, 28));
        cardNo.setBounds(120, 150,200, 40);
        add(cardNo);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(300, 155, 250, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD , 14));
        
        add(cardTextField);
       
          
        JLabel pin = new JLabel("Pin:");
        pin.setFont(new Font("raleway", Font.BOLD, 28));
        pin.setBounds(120, 220,100, 40);
        add(pin);
    
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 225, 250, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD , 14));
        add(pinTextField);
        
        loginBtn = new JButton("SIGN IN");
        loginBtn.setBounds(300, 300, 120, 30);
        loginBtn.setBackground(Color.black);
        loginBtn.setForeground(Color.white);
        loginBtn.addActionListener(this);  //passing current instance  
        add(loginBtn);          
        
        clearBtn = new JButton("CLEAR");
        clearBtn.setBounds(430, 300, 120, 30);
        clearBtn.setBackground(Color.black);
        clearBtn.setForeground(Color.white);
        clearBtn.addActionListener(this);  //passing current instance  
        add(clearBtn);
        
        signUpBtn = new JButton("SIGN UP");
        signUpBtn.setBounds(300, 340, 250, 30);
        signUpBtn.setBackground(Color.black);
        signUpBtn.setForeground(Color.white);
        signUpBtn.addActionListener(this);  //passing current instance  
        add(signUpBtn);
        
        
        
      
        setTitle("Automated Teller Machine");
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);   //from which location the the frame orgin display first
    }
     @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == loginBtn){
            
            Conn conn = new Conn();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
            
            String query = "select * from login where card_number = "+cardNumber+" and pin_number = "+pinNumber;
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card number or Pin");
                }
                
            }catch(Exception e){
                System.out.println(e);
            }
            

            
            
        }else if(ae.getSource() == clearBtn){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if(ae.getSource() == signUpBtn ){  //6225210079808282
            setVisible(false);
            SignUpOne signUp = new SignUpOne();
            signUp.setVisible(true);      
        }
        
    }
    
    public static void main(String args[]){
        Login login = new Login();
    }

   
            
}
