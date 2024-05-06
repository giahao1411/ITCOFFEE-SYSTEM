/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import dao.UserDao;
import java.util.ArrayList;
import model.User;

/**
 *
 * @author Win
 */
public class UserControler {

    public static void save(User user) {
        UserDao.save(user);
    }
    
    public static User Login(String email, String password) {
        return UserDao.Login(email, password);
    }
    
    public static User getSecurityQuestion(String email) {
        return UserDao.getSecurityQuestion(email);
    }
    
    public static void update(String email, String newPassword) {
        UserDao.update(email, newPassword);
    }
    
    public static ArrayList<User> getAllRecords(String email) {
        return UserDao.getAllRecords(email);
    }
    
    public static void changeStatus(String email, String status) {
        UserDao.changeStatus(email, status);
    }
    
    public static String getNameByEmail(String email) {
        return UserDao.getNameByEmail(email);
    }
    
    public static void changePassword(String email, String oldPassword, String newPassword) {
        UserDao.changePassword(email, oldPassword, newPassword);
    }
    
    public static void changeSecurityQuestion(String email, String password, String securityQuestion, String answer) {
        UserDao.changeSecurityQuestion(email, password, securityQuestion, answer);
    }
    
    public static void update(String email, String securityQuestion, String answer) {
        UserDao.update(email, securityQuestion, answer);
    }
}
