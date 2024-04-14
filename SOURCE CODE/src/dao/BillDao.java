/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
import javax.swing.JOptionPane;
import model.Bill;
/**
 *
 * @author Win
 */
public class BillDao {
    public static String getId(){
        int id = 1;
        try {
            String query = "select max(id) from bill";
            ResultSet rs = DbOperations.getData(query);
            if(rs.next()){
                id = rs.getInt(1);
                id += 1;
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return String.valueOf(id);
    }
    
    public static void save(Bill bill){
        String query = "Insert into bill values("+ bill.getId() + ",'" +  bill.getName()+ "','" + bill.getMobileNumber()+ "','" + bill.getEmail()+ "','" + bill.getDate() + "','" + bill.getTotal() + "','" + bill.getCreateBy()+"')";
        DbOperations.setDataOrDelete(query, "Bill created successfully!");
    }
}
