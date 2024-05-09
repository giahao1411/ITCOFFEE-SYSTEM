/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Bill;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 *
 * @author Win
 */
public class BillDao {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    public static String getId(){
        int billNumber = 1;
        Date date = new Date();
        String formattedDate = dateFormat.format(date);
        String id = "HD-" + formattedDate + "-" + String.format("%04d", billNumber);
        
        try {
            String query = "SELECT id FROM bill ORDER BY STR_TO_DATE(SUBSTRING_INDEX(id, '-', -1), '%d/%m/%Y') DESC, id DESC LIMIT 1";

            ResultSet rs = DbOperations.getData(query);
            if(rs.next()){
                id = rs.getString(1);
                if(id.split("-")[1].equals(formattedDate)){
                    billNumber = Integer.parseInt(id.split("-")[2]) + 1;
                }
                id = "HD-" + formattedDate + "-" + String.format("%04d", billNumber);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return id;
    }
    
    public static void save(Bill bill){
        try {
            String query = "Insert into bill values('"+ bill.getId() + "','" +  bill.getName() + "','" + bill.getMobileNumber()+ "','" + bill.getEmail()+ "','" + bill.getDate() + "','" + bill.getTotal() + "','" + bill.getCreateBy()+"')";
            DbOperations.setDataOrDelete(query, "Bill created successfully!");
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
       
    }
    
    
    public static ArrayList<Bill> getAllRecordsByInc(String date){
        ArrayList<Bill> bills = new ArrayList<>();
        try {
            String query = "select * from bill where date like '%" + date + "%'";
            ResultSet rs = DbOperations.getData(query);
            while(rs.next()){
                Bill bill = new Bill();
                bill.setId(rs.getString("id"));
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
                bill.setId(rs.getString("id"));
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
