/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import com.mysql.cj.xdevapi.Result;
import javax.swing.JOptionPane;
import model.User;
import java.sql.*;

/**
 *
 * @author Win
 */
public class UserDao {
    public static void save(User user){
        String query = "Insert into user(name, email,mobileNumber,address, password, securityQuestion, answer, status) values('"+ user.getName() +"','"+ user.getEmail()+"','"+ user.getMobileNumber()+"','"+ user.getAddress()+"','"+ user.getPassword()+"','"+ user.getSecurityQuestion()+"','"+ user.getAnswer()+"','false' )";
        
        DbOperations.setDataOrDelete(query, "Registered Successfully! Wait for Admin Approval!");
    }
    
    public static  void Login(String email, String password){
        User user = null;
        try {
            String query ="Select * from user where email='"+ email +"' and password ='"+ password+ "'";
            ResultSet rs = DbOperations.getData(query);
            
            while(rs.next()){
                user = new User();
                user.setStatus(rs.getString("status"));
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
