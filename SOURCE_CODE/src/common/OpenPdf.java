/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.awt.Desktop;
import javax.swing.JOptionPane;
import java.io.File;
/**
 *
 * @author Win
 */
public class OpenPdf {
    
    public static void openById(String id){
        try {
        File file = new File("E:\\" + id + ".pdf");
        if (file.exists()) {
            Desktop.getDesktop().open(file);
        } else {
            JOptionPane.showMessageDialog(null, "File does not exist");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
    }
}
