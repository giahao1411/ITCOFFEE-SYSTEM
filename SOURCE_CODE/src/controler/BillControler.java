/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import dao.BillDao;
import java.util.ArrayList;
import model.Bill;

/**
 *
 * @author Win
 */
public class BillControler {
     public static String getId(){
         return BillDao.getId();
     }
     
     public static void save(Bill bill){
         BillDao.save(bill);
     }
     
     public static ArrayList<Bill> getAllRecordsByInc(String date){
         return BillDao.getAllRecordsByInc(date);
     }
     
     public static ArrayList<Bill> getAllRecordsByDesc(String date){
         return BillDao.getAllRecordsByDesc(date);
     }
}
