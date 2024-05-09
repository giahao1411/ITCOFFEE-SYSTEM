/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import model.Category;
import dao.CategoryDao;
import java.util.ArrayList;

/**
 *
 * @author Win
 */
public class CategoryControler {

    public static void save(Category category) {
        CategoryDao.save(category);
    }
    
    public static ArrayList<Category> getAllRecords() {
        return CategoryDao.getAllRecords();
    }
    
    public static void delete(String id) {
        CategoryDao.delete(id);
    }
    
}
