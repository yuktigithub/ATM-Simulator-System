
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener{
    String pinNumber;
    JTextField amountTextField;
    JButton withdraw, back;
    Withdrawl(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0 ,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to withdraw:");
        text.setBounds(170,300,400,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("raleway", Font.BOLD, 16));
        image.add(text);
        
        amountTextField = new JTextField();
        amountTextField.setBounds(170,350,310,35);
        amountTextField.setFont(new Font("raleway", Font.BOLD, 16));
        image.add(amountTextField);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355,480,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        
        back = new JButton("Back");
        back.setBounds(355, 515, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(250,0);
//        setUndecorated(true);
        setVisible(true);
    }
    public static void main(String[] args){
        new Withdrawl("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == withdraw){
            String amount = amountTextField.getText();
            Date date = new Date();
            if(amount.equals("")){
                JOptionPane.showMessageDialog(null,"Enter the valid amount!");
            }else{
            try{
                Conn conn = new Conn();
                String query = "insert into bank values('"+pinNumber+"','"+date+"','withdraw','"+amount+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" withdraw Successfully!");
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
                
                
            }catch(Exception e){
                System.out.println(e);
            }
            }
        
            
        }else if(ae.getSource() == back){
            setVisible(false);
            new Transactions("").setVisible(true);
        }
    }
}

