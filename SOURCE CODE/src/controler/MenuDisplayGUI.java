/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import model.Product;


/**
 *
 * @author Win
 */
public class MenuDisplayGUI extends JPanel{
    
    public MenuDisplayGUI (ArrayList<Product> products) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 4, 20, 20)); // 3 columns, 0 rows (automatically adjust rows)

        mainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230), 2));


        for (int i = 0; i < products.size(); i++) {
            JPanel productPanel = new JPanel(new BorderLayout());

            productPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230), 2), BorderFactory.createEmptyBorder(5, 10, 0, 5)));
            productPanel.setPreferredSize(new Dimension(190, 100));

            // Product icon (replace iconLabel with your icon)
            JLabel iconLabel = new JLabel(new ImageIcon(getClass().getResource("../images/category.png")));
            iconLabel.setPreferredSize(new Dimension(190, 100));

            productPanel.add(iconLabel, BorderLayout.NORTH);

            // Product name and price
            JLabel nameLabel = new JLabel("Name:");
            JLabel priceLabel = new JLabel("Price:");

            JPanel namePricePanel = new JPanel(new GridLayout(2, 1));
            namePricePanel.add(nameLabel);
            namePricePanel.add(priceLabel);

            productPanel.add(namePricePanel, BorderLayout.WEST);

            // Additional labels on the right side (label1 and label2)
            JLabel label1 = new JLabel("tra su tran chau duong den 1");
            JLabel label2 = new JLabel("Info 2");

            JPanel additionalInfoPanel = new JPanel(new GridLayout(2, 1));
            additionalInfoPanel.add(label1);
            additionalInfoPanel.add(label2);
            additionalInfoPanel.setPreferredSize(new Dimension(130, 10));

            productPanel.add(additionalInfoPanel, BorderLayout.EAST);

            // Add product panel to main panel
            mainPanel.add(productPanel);
        }
        
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        add(scrollPane);
    }
}
