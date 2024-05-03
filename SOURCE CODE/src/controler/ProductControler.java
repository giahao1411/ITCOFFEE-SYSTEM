/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import dao.ProductDao;
import java.util.ArrayList;

import model.Product;

/**
 *
 * @author Win
 */
public class ProductControler {
    public static void save(Product product){
        ProductDao.save(product);
    }
    
     public static ArrayList<Product> getAllRecords(){
        return ProductDao.getAllRecords();
     }
     
      public static void update(Product product){
          ProductDao.update(product);
      }
      
      
       public static void delete(String id){
           ProductDao.delete(id);
       }
       
       public static ArrayList<Product> getAllRecordsByCategory(String category){
           return ProductDao.getAllRecordsByCategory(category);
       }
       
        public static ArrayList<Product> filterProductByName(String name, String category){
            return ProductDao.filterProductByName(name, category);
        }
        
        public static Product getProductByname(String name){
            return ProductDao.getProductByname(name);
        }
}
