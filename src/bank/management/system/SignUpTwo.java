
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener{
    
    JTextField aadharTextField, panTextField;
    JRadioButton sYes, sNo, eYes, eNo;
    JComboBox religionBox, categoryBox, incomeBox, eduBox, occupationBox;
    JButton next;
    String formNo;
    
    SignUpTwo(String number){
       
        this.formNo = number;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 50, 300, 40);
        add(additionalDetails);
        
        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("raleway", Font.BOLD, 20));
        religion.setBounds(100, 140, 100, 30);
        add(religion);
        
        String[] religionVal = new String[]{"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religionBox = new JComboBox(religionVal);
        religionBox.setBounds(300, 140, 400, 30);
        add(religionBox);
        religionBox.setFont(new Font("raleway", Font.BOLD, 14));
        
        
        JLabel  category = new JLabel("Category:");
        category.setFont(new Font("raleway", Font.BOLD, 20));
        category.setBounds(100, 190, 200, 30);
        add(category);
        
        String[] categoryValues = new String[]{"General","SC","ST","OBC", "Other"};
        categoryBox = new JComboBox(categoryValues);
        categoryBox.setFont(new Font("raleway", Font.BOLD, 14));
        categoryBox.setBounds(300, 190, 400, 30);
        add(categoryBox);
        
     
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("raleway", Font.BOLD, 20));
        income.setBounds(100, 240, 200, 30);
        add(income);
        
        String[] incomeCategory = new String[]{"Null","< 1,50,000","< 2,50,000","< 5,00000", "Upto 10,00000"};
        incomeBox = new JComboBox(incomeCategory);
        incomeBox.setFont(new Font("raleway", Font.BOLD, 14));
        incomeBox.setBounds(300, 240, 400, 30);
        add(incomeBox);
        
        JLabel edu = new JLabel("Educational");
        edu.setFont(new Font("raleway", Font.BOLD, 20));
        edu.setBounds(100, 290, 200, 30);
        add(edu);
  
        JLabel qua = new JLabel("Qualification:");
        qua.setFont(new Font("raleway", Font.BOLD, 20));
        qua.setBounds(100, 320, 200, 30);
        add(qua);
        
        String[] educationValues = new String[]{"HSC","SSC", "Graduate", "Post-Graduate", "Doctrate","Other"};
        eduBox = new JComboBox(educationValues);
        eduBox.setFont(new Font("raleway", Font.BOLD, 14));
        eduBox.setBounds(300, 320, 400, 30);
        add(eduBox);
        
     
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("raleway", Font.BOLD, 20));
        occupation.setBounds(100, 390, 200, 30);
        add(occupation);
        
        String[] occupationValues = new String[]{"Employed","Self-Employed", "Bussiness", "Student", "Retired","Other"};
        occupationBox = new JComboBox(occupationValues);
        occupationBox.setFont(new Font("raleway", Font.BOLD, 14));
        occupationBox.setBounds(300, 390, 400, 30);
        add(occupationBox);
     
        
        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("raleway", Font.BOLD, 20));
        pan.setBounds(100, 440, 200, 30);
        add(pan);
        
        panTextField = new JTextField();
        panTextField.setFont(new Font("raleway", Font.BOLD, 14));
        panTextField.setBounds(300, 440, 400, 30);
        add(panTextField);
        
        JLabel adhar = new JLabel("Aadhar Number:");
        adhar.setFont(new Font("raleway", Font.BOLD, 20));
        adhar.setBounds(100, 490, 200, 30);
        add(adhar);
        
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("raleway", Font.BOLD, 14));
        aadharTextField.setBounds(300, 490, 400, 30);
        add(aadharTextField);
        
        JLabel senior = new JLabel("Sinior Citizen:");
        senior.setFont(new Font("raleway", Font.BOLD, 20));
        senior.setBounds(100, 540, 200, 30);
        add(senior);
        
        sYes = new JRadioButton("Yes");
        sYes.setBounds(300, 540, 100, 30);
        sYes.setBackground(Color.white);
        add(sYes);
                
        sNo = new JRadioButton("No");
        sNo.setBounds(450, 540, 100, 30);
        sNo.setBackground(Color.white);
        add(sNo);
        
        ButtonGroup citizenGroup = new ButtonGroup();
        citizenGroup.add(sYes);
        citizenGroup.add(sNo);
       
        
        JLabel existingAccountLabel = new JLabel("Existing Account:");
        existingAccountLabel.setFont(new Font("raleway", Font.BOLD, 20));
        existingAccountLabel.setBounds(100, 590, 200, 30);
        add(existingAccountLabel);
        
        eYes = new JRadioButton("Yes");
        eYes.setBounds(300, 590, 100, 30);
        eYes.setBackground(Color.white);
        add(eYes);
                
        eNo = new JRadioButton("No");
        eNo.setBounds(450, 590, 100, 30);
        eNo.setBackground(Color.white);
        add(eNo);
        
        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(eYes);
        accountGroup.add(eNo);
      
        
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
        String religion = (String)religionBox.getSelectedItem();     //Jcombo is returning an Object here we are converting it into String
        String category = (String)categoryBox.getSelectedItem();
        String income = (String) incomeBox.getSelectedItem();
        String education = (String) eduBox.getSelectedItem();
        String occupation = (String) occupationBox.getSelectedItem();
        String pan = panTextField.getText();
        String aadhar = aadharTextField.getText();
        String seniorCitizen = null;
        if(sYes.isSelected()){
            seniorCitizen = "Yes";
        }else if(sNo.isSelected()){
            seniorCitizen = "No";
        }
        
        String existingAccount = null;
        if(eYes.isSelected()){
            existingAccount = "Yes";
        }else if(eNo.isSelected()){
            existingAccount = "No";
        }
        try{
            if(pan.equals("")){
                JOptionPane.showMessageDialog(null, "PAN Number is Required.");
            }else if(aadhar.equals("")){
                JOptionPane.showMessageDialog(null, "Aadhar Number is Required.");
            }else{
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formNo+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+aadhar+"','"+seniorCitizen+"','"+existingAccount+"')";
                c.s.executeUpdate(query); 
                
                //signup 3 action after successfully inserting the 
                setVisible(false);
                SignUpThree s3 = new SignUpThree(formNo);
                s3.setVisible(true);
            }
        }catch(Exception ae){
            System.out.println(ae);
        }
        
    }
    
     public static void main(String args[]){
         SignUpTwo signUpTwo = new SignUpTwo("1234");
    }

  
}
