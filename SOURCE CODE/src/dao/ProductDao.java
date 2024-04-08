/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Product;
import java.sql.*;

/**
 *
 * @author Win
 */
public class ProductDao {
    public static void save(Product product){
        String query = "INSERT INTO product (name, category, price) VALUES ('" + product.getName() + "', '" + product.getCategory() + "', '" + product.getPrice() + "')";
        DbOperations.setDataOrDelete(query, "Product Added Successfully!");
    }
    
    public static ArrayList<Product> getAllRecords(){
        ArrayList<Product> arrayList = new ArrayList<>();
        try {
            String query = "Select * from product";
            ResultSet rs = DbOperations.getData(query);
            
            while(rs.next()){
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setCategory(rs.getString("category"));
                product.setPrice(rs.getString("price"));
                
                arrayList.add(product);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    
    public static void update(Product product){
        String query = "update product set name='" + product.getName() +"',category='" + product.getCategory()+"',price='" + product.getPrice()+"' where id ='" + product.getId() + "'";
        DbOperations.setDataOrDelete(query, "Product updated Successfully!");
    }
    
    public static void delete(String id){
        String query = "delete from product where id ='" +id +"'";
        DbOperations.setDataOrDelete(query, "Product Delete Successfully!");
    }
}
