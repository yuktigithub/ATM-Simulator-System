
package bank.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class PinChange extends JFrame implements ActionListener{
    JPasswordField pin, repin;
    JButton change, back;
    String pinNumber;
    PinChange(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0 ,0,900,900);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(240,300,500,30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 22));
        image.add(text);
        
        JLabel pintext = new JLabel("New Pin:");
        pintext.setBounds(170,360,80,25);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setBounds(315,360,180,25); pintext.setForeground(Color.WHITE);
        pin.setFont(new Font("raleway", Font.BOLD, 16));
        image.add(pin);
        
        JLabel repintext = new JLabel("Re-Enter New Pin:");
        repintext.setBounds(170,390,200,25);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setBounds(315,390,180,25);
        repin.setFont(new Font("raleway", Font.BOLD, 16));
        image.add(repin);
        
        change = new JButton("Change");
        change.setBounds(380, 450,120,30);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("Back");
        back.setBounds(380,490,120,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setUndecorated(true);
        setVisible(true);
        
        setLocation(300, 0);
        
    }
    public static void main(String args[]){
        new PinChange("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == change){
       
        try{
            String npin = pin.getText();
            String rpin = repin.getText();
            
            
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter new PIN");
                return;
            }if(rpin.equals("")){
                JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                return;
            }if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered pin doesn't match.");
                return;
            }
            
            Conn conn = new Conn();
            String q1 = "update bank set pin ='"+rpin+"' where pin='"+pinNumber+"'";
            String q2 = "update login set pin_number ='"+rpin+"' where pin_number ='"+pinNumber+"'";
            String q3 = "update signupthree set pin_number ='"+rpin+"' where pin_number ='"+pinNumber+"'";
            
            conn.s.executeUpdate(q1);
            conn.s.executeUpdate(q2);
            conn.s.executeUpdate(q3);
            JOptionPane.showMessageDialog(null, "PIN changed Successfully!");
            
            setVisible(false);
            new Transactions(rpin).setVisible(true);

            
            
      
        }catch(Exception e){
        System.out.println(e);
             
        }
    }else{
            new Transactions(pinNumber).setVisible(true);
            setVisible(false);
        }
    }
    
}
