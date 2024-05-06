/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
import java.util.ArrayList;
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
    
    
    public static ArrayList<Bill> getAllRecordsByInc(String date){
        ArrayList<Bill> bills = new ArrayList<>();
        try {
            String query = "select * from bill where date like '%" + date + "%'";
            ResultSet rs = DbOperations.getData(query);
            while(rs.next()){
                Bill bill = new Bill();
                bill.setId(rs.getInt("id"));
                bill.setName(rs.getString("name"));
                bill.setMobileNumber(rs.getString("mobileNumber"));
                bill.setEmail(rs.getString("email"));
                bill.setDate(rs.getString("date"));
                bill.setTotal(rs.getString("total"));
                bill.setCreateBy(rs.getString("createBy"));
                bills.add(bill);
            }
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return  bills;
    }
    
        public static ArrayList<Bill> getAllRecordsByDesc(String date){
        ArrayList<Bill> bills = new ArrayList<>();
        try {
            String query = "select * from bill where date like '%" + date + "%' order By id DESC";
            ResultSet rs = DbOperations.getData(query);
            while(rs.next()){
                Bill bill = new Bill();
                bill.setId(rs.getInt("id"));
                bill.setName(rs.getString("name"));
                bill.setMobileNumber(rs.getString("mobileNumber"));
                bill.setEmail(rs.getString("email"));
                bill.setDate(rs.getString("date"));
                bill.setTotal(rs.getString("total"));
                bill.setCreateBy(rs.getString("createBy"));
                bills.add(bill);
            }
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return  bills;
    }
}
