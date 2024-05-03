/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.border.Border;
import model.Product;

/**
 *
 * @author Win
 */
public class MenuDisplayDao extends JFrame {

    public MenuDisplayDao() {
        pack();
        setLocationRelativeTo(null);
    }

    public interface ProductPanelClickListener {

        void onProductPanelClick(Product product);
    }

    public ImageIcon resizePic(String path, int width, int height) {
        ImageIcon myImg = new ImageIcon(path);

        Image img = myImg.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon myPicture = new ImageIcon(img);

        return myPicture;
    }

    public JScrollPane getMainPanel(ProductPanelClickListener listener) {
        ArrayList<Product> products = ProductDao.getAllRecords();
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 4, 20, 20)); // 3 columns, 0 rows (automatically adjust rows)
        mainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230), 2));
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        mainPanel.setLayout(new GridLayout(0, 4, 20, 20));

        for (Product product : products) {
            JPanel productPanel = new JPanel(new BorderLayout());
            productPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230), 2), null));
            // Fixed height for productPanel
            productPanel.setPreferredSize(new Dimension(190, 150)); // Adjust the height as needed

            // Product icon (replace iconLabel with your icon)
            JLabel iconLabel = new JLabel(resizePic("src/images/products/" + product.getImg(), 190, 100));

            productPanel.add(iconLabel, BorderLayout.NORTH);

            // Product name and price
            JLabel nameLabel = new JLabel("Name:");
            JLabel priceLabel = new JLabel("Price:");

            Font labelFont = nameLabel.getFont();
            nameLabel.setFont(new Font(labelFont.getName(), Font.BOLD, 14));
            priceLabel.setFont(new Font(labelFont.getName(), Font.BOLD, 14));

            JPanel detail = new JPanel(new BorderLayout());

            JPanel namePricePanel = new JPanel(new GridLayout(2, 1));
            namePricePanel.add(nameLabel);
            namePricePanel.add(priceLabel);

            detail.add(namePricePanel, BorderLayout.WEST);

            // Additional labels on the right side (label1 and label2)
            JLabel label1 = new JLabel(product.getName());
            JLabel label2 = new JLabel((product.getPrice()));

            label1.setFont(new Font(labelFont.getName(), Font.BOLD, 14));
            label2.setFont(new Font(labelFont.getName(), Font.BOLD, 14));

            JPanel additionalInfoPanel = new JPanel(new GridLayout(2, 1));
            additionalInfoPanel.add(label1);
            additionalInfoPanel.add(label2);
            additionalInfoPanel.setPreferredSize(new Dimension(115, 10));

            detail.add(additionalInfoPanel, BorderLayout.EAST);
            Border border = BorderFactory.createEmptyBorder(0, 10, 0, 10);
            detail.setBorder(border);

            productPanel.add(detail, BorderLayout.SOUTH);
            // Add action listener to the product panel
            productPanel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    listener.onProductPanelClick(product);
                }
            });

            // Add product panel to main panel
            mainPanel.add(productPanel);
        }
        scrollPane.setPreferredSize(new Dimension(850, 300)); // Adjust the width and height of the scrollPane as needed

        return scrollPane;
    }
}
