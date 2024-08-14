
package bank.management.system;
import java.sql.*;


public class Conn {
    
    Connection c;
    Statement s;
    Conn(){
        
        try{
//           Step 1: register driver
//           Class.forName(com.mysql.cj.jdbc.Driver); //after selecting library mysql-connector-java-8.0.28.jar we don not need to write this line any more because of this driver is already register.
//           step 2: create connection
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "yukti@123");
//           step 3: create statement
            s = c.createStatement();
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
