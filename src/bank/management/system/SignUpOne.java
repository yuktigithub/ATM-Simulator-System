
package bank.management.system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class SignUpOne extends JFrame implements ActionListener{
    
    long randomFormNumber;
    JTextField nameTextField, fNameTextField, emailTextField, addressTextField, stateTextField, cityTextField, pinTextField;
    JRadioButton male, female, other, married, unmarried;
    JDateChooser dateChooser;
    JButton next;
    
    SignUpOne(){
        
        Random ran = new Random();
        randomFormNumber = Math.abs(ran.nextLong() % 9000L + 1000L);
        
        setLayout(null);
        
        JLabel formNo = new JLabel("APPLICATION FORM NO: "+ randomFormNumber);
        formNo.setFont(new Font("raleway", Font.BOLD, 38));
        formNo.setBounds(140, 20, 600, 40);
        add(formNo);
        
        JLabel personalDetails = new JLabel("Page 1 : Personal Details");
        personalDetails.setFont(new Font("raleway", Font.BOLD, 22));
        personalDetails.setBounds(290, 80, 300, 40);
        add(personalDetails);
        
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);
        
        JLabel  fName = new JLabel("Father's Name:");
        fName.setFont(new Font("raleway", Font.BOLD, 20));
        fName.setBounds(100, 190, 200, 30);
        add(fName);
        
        fNameTextField = new JTextField();
        fNameTextField.setFont(new Font("raleway", Font.BOLD, 14));
        fNameTextField.setBounds(300, 190, 400, 30);
        add(fNameTextField);
        
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(Color.BLACK);
        add(dateChooser);
        
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60,30);
        male.setBackground(Color.white);
        add(male);
                
        female = new JRadioButton("Female");
        female.setBounds(450, 290, 100,30);
        female.setBackground(Color.white);
        add(female);
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        
         
        JLabel email = new JLabel("Email:");
        email.setFont(new Font("raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);
         
        JLabel martialStatus = new JLabel("Martial Status:");
        martialStatus.setFont(new Font("raleway", Font.BOLD, 20));
        martialStatus.setBounds(100, 390, 200, 30);
        add(martialStatus);
        
        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100,30);
        married.setBackground(Color.white);
        add(married);
                
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 100,30);
        unmarried.setBackground(Color.white);
        add(unmarried);
        
        other = new JRadioButton("Other");
        other.setBounds(630, 390, 80,30);
        other.setBackground(Color.white);
        add(other);
        
        ButtonGroup martialGroup = new ButtonGroup();
        martialGroup.add(married);
        martialGroup.add(unmarried);
        martialGroup.add(other);
        
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("raleway", Font.BOLD, 14));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);
        
        JLabel city = new JLabel("City");
        city.setFont(new Font("raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("raleway", Font.BOLD, 14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);
        
        JLabel state = new JLabel("State");
        state.setFont(new Font("raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("raleway", Font.BOLD, 14));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);
        
        JLabel pincode = new JLabel("Pincode:");
        pincode.setFont(new Font("raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);
        
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("raleway", Font.BOLD, 14));
        pinTextField.setBounds(300, 590, 400, 30);
        add(pinTextField);
        
        
        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(600, 640, 100, 30);
        add(next);
        next.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setVisible(true);
        setLocation(260,10);
    }
      @Override
    public void actionPerformed(ActionEvent e) {
        String formNo = "" + randomFormNumber;
        String name = nameTextField.getText();
        String fName = fNameTextField.getText();
        String email = emailTextField.getText();
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pincode = pinTextField.getText();
        String dob = ((JTextField)(dateChooser.getDateEditor().getUiComponent())).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "male";
        }else if(female.isSelected()){
            gender = "female";
        }
        
        String martial = null;
        if(married.isSelected()){
            martial = "Married";
        }else if(unmarried.isSelected()){
            martial = "Unmarried";
        }else if(other.isSelected()){
            martial = "Other";
        }
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name field is Required.");
            }else if(dob.equals("")){
                JOptionPane.showMessageDialog(null, "Date of Birth is Required.");
            }else if(address.equals("") || address.length() > 150){
                 JOptionPane.showMessageDialog(null, "Fill the address field correctly.");
            }else{
                Conn c = new Conn();
                String query = "insert into signup values('"+formNo+"','"+name+"','"+fName+"','"+dob+"','"+gender+"','"+email+"','"+martial+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
                c.s.executeUpdate(query); 
                
                setVisible(false);
                SignUpTwo s2 = new SignUpTwo(formNo);
                s2.setVisible(true);
            }
        }catch(Exception ae){
            System.out.println(ae);
        }
        
    }
    
     public static void main(String args[]){
         SignUpOne signUpOne = new SignUpOne();
    }

  
}
