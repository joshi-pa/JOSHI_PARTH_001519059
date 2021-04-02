/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CustomerRole;

import Business.Customer.Customer;
import Business.Customer.CustomerDirectory;
import Business.DeliveryMan.DeliveryManDirectory;
import Business.EcoSystem;
import Business.Menu.Menu;
import Business.Menu.MenuDirectory;
import Business.Order.Order;
import Business.Order.OrderDirectory;
import Business.Restaurant.Restaurant;
import Business.Restaurant.RestaurantDirectory;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import static jdk.nashorn.internal.objects.NativeMath.max;

/**
 *
 * @author raunak
 */
public class CustomerAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem ecoSystem;
    private UserAccount account;
    private CustomerDirectory customerDirectory;
    private RestaurantDirectory restaurantDirectory;
    private DeliveryManDirectory deliveryManDirectory;
    private MenuDirectory menuDirectory;
    private OrderDirectory orderDirectory;
    
    
//    private int count = 1;
//    private int count;
//    private String idCOunt;
//    private int lnum;
    
    
    
    
    public CustomerAreaJPanel(JPanel userProcessContainer, UserAccount account, EcoSystem ecoSystem, 
            CustomerDirectory customerDirectory, RestaurantDirectory restaurantDirectory, 
            DeliveryManDirectory deliveryManDirectory, MenuDirectory menuDirectory, OrderDirectory orderDirectory) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.ecoSystem = ecoSystem;
        this.customerDirectory = ecoSystem.getCustomerDirectory();
        this.restaurantDirectory = ecoSystem.getRestaurantDirectory();
        this.menuDirectory = ecoSystem.getMenuDirectory();
        this.deliveryManDirectory = ecoSystem.getDeliveryManDirectory();
        this.orderDirectory = ecoSystem.getOrderDirectory();
        valueLabel.setText(account.getUsername());
        populateRequestTable();
//        initializeLastOrderID();
//        count = workRequestJTable.getRowCount();

        
        populateRestaurantCombo(); 
        
        
        
    }
    
    public void populateTable() {
        DefaultTableModel dtm = (DefaultTableModel) tblItem.getModel();
        dtm.setRowCount(0);
        String restaurantName = cmbRestaurant.getSelectedItem().toString();
        Restaurant restaurant = ecoSystem.getRestaurantDirectory().getRestaurant(restaurantName);
        for(Menu menu : ecoSystem.getMenuDirectory().getMenuDirectory()){
            if(restaurant.getRestaurantName().equals(menu.getRestaurantName())) {
                Object [] row = new Object[4];
                row[0] = menu;
                row[1] = menu.getPrice();
                row[2] = menu.getCuisine();
                row[3] = menu.getItemType();
                dtm.addRow(row);
            }
        }
    }
    
    public void populateRestaurantCombo() {
        cmbRestaurant.removeAllItems();
        cmbRestaurant.addItem("--Select Restaurant--");
        for(Restaurant res : ecoSystem.getRestaurantDirectory().getRestaurantDirectory()) {
            cmbRestaurant.addItem(res.getRestaurantName());
        }
    }
    
    public void populateRequestTable(){
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        model.setRowCount(0);
        for (Order order : ecoSystem.getOrderDirectory().getOrderDirectory()){
            if(account.getEmployee().getName().equals(order.getCustomer().getName())) {
                Object[] row = new Object[8];
                row[0] = order;
                row[1] = order.getMenu().getItemName();
                row[2] = order.getQuantity();
                row[3] = order.getQuantity() * order.getMenu().getPrice();
                row[4] = order.getRestaurant().getRestaurantName();
                row[5] = order.getMessage();
                row[6] = order.getCustomer().getName();
                row[7] = order.getOrderStatus();
                model.addRow(row);
            }
        }     
    }
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        requestTestJButton = new javax.swing.JButton();
        refreshTestJButton = new javax.swing.JButton();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblItem = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        btnConfirm = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtComment = new javax.swing.JTextField();
        btnMenuShow = new javax.swing.JButton();
        cmbRestaurant = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btnfeedback = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtFeedback = new javax.swing.JTextArea();
        lblLogo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 204));

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Item Name", "Quantity", "Price", "Restaurant", "Message", "Customer", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);

        requestTestJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        requestTestJButton.setText("Add Comment");
        requestTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTestJButtonActionPerformed(evt);
            }
        });

        refreshTestJButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        refreshTestJButton.setText("Refresh");
        refreshTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTestJButtonActionPerformed(evt);
            }
        });

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("Welcome,");

        valueLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        valueLabel.setText("<value>");

        tblItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Item Name", "Price", "Cuisine", "Item Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblItem);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Enter Quantity:");

        txtQuantity.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        btnConfirm.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnConfirm.setText("Confirm");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Comment:");

        btnMenuShow.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnMenuShow.setText("Show Menu");
        btnMenuShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuShowActionPerformed(evt);
            }
        });

        cmbRestaurant.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmbRestaurant.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Select Restaurant--", "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbRestaurant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRestaurantActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Orders :");

        btnfeedback.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnfeedback.setText("Add Feedback");
        btnfeedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfeedbackActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Provide Feedback:");

        txtFeedback.setColumns(20);
        txtFeedback.setRows(5);
        jScrollPane3.setViewportView(txtFeedback);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(requestTestJButton)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(40, 40, 40)
                                .addComponent(txtComment, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(127, 127, 127)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(180, 180, 180)
                                .addComponent(btnfeedback))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(168, 168, 168)
                        .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(enterpriseLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(102, 102, 102)
                                .addComponent(cmbRestaurant, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnMenuShow))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(195, 195, 195)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(48, 48, 48)
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(refreshTestJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnMenuShow)
                        .addComponent(cmbRestaurant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirm))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(refreshTestJButton)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtComment, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)))
                        .addGap(33, 33, 33)
                        .addComponent(requestTestJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnfeedback)))
                .addGap(18, 106, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void requestTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestTestJButtonActionPerformed

        if(txtComment.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Field cannot be empty");
            return;
        }
        
        int selectedRow = workRequestJTable.getSelectedRow();
        if(selectedRow < 0) {
            JOptionPane.showMessageDialog(null,"Please Select a row from table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Order order = (Order)workRequestJTable.getValueAt(selectedRow, 0);
        order.setMessage(txtComment.getText());
        populateRequestTable();
        txtComment.setText(" ");
        JOptionPane.showMessageDialog(null, "Comment is added for the Order");
    }//GEN-LAST:event_requestTestJButtonActionPerformed

    private void refreshTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTestJButtonActionPerformed

        populateRequestTable();
        txtQuantity.setText("");
//        populateTable();
        
    }//GEN-LAST:event_refreshTestJButtonActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        // TODO add your handling code here:
        
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream("src/MyFile.txt"), "UTF-8");
            try {
                int lnum= reader.read();
//                this.lnum = lastnum;
//                idCOunt = String.valueOf(lnum);
                int selectedRow = tblItem.getSelectedRow();
                //        int selectedRow []= tblItem.getSelectedRows();
                if(selectedRow < 0) {
                    JOptionPane.showMessageDialog(null,"Please Select a row from table first", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                int quantity = Integer.parseInt(txtQuantity.getText());
                if((txtQuantity).equals(null)){
                JOptionPane.showMessageDialog(null,"Enter Quantity greater than 0", "Warning", JOptionPane.WARNING_MESSAGE);
            }
                if (quantity < 1){
                    JOptionPane.showMessageDialog(null,"Enter Quantity greater than 0", "Warning", JOptionPane.WARNING_MESSAGE);
                }
                String restaurantName = cmbRestaurant.getSelectedItem().toString();
                Restaurant restaurant = ecoSystem.getRestaurantDirectory().getRestaurant(restaurantName);
                Customer customer = ecoSystem.getCustomerDirectory().getCustomer(account.getEmployee().getName());
//                int lastOrderID ;
                Menu menu = (Menu) tblItem.getValueAt(selectedRow, 0);
                String status = "Order Placed";

                Order order = ecoSystem.getOrderDirectory().newOrder();
                order.setCustomer(customer);


        // commented 
                order.setOrderId(String.valueOf(lnum++));
                order.setQuantity(quantity);
                order.setMenu(menu);
                order.setRestaurant(restaurant);
                order.setOrderStatus(status);
                order.setAssign(false);
                OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("src/MyFile.txt"), "UTF-8");
                writer.write(lnum);
                writer.close();


            } catch (IOException ex) {
                Logger.getLogger(CustomerAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CustomerAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CustomerAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        int selectedRow = tblItem.getSelectedRow();
////        int selectedRow []= tblItem.getSelectedRows();
//        if(selectedRow < 0) {
//            JOptionPane.showMessageDialog(null,"Please Select a row from table first", "Warning", JOptionPane.WARNING_MESSAGE);
//            return;
//        }
//        int quantity = Integer.parseInt(txtQuantity.getText());
//        String restaurantName = cmbRestaurant.getSelectedItem().toString();
//        Restaurant restaurant = ecoSystem.getRestaurantDirectory().getRestaurant(restaurantName);
//        Customer customer = ecoSystem.getCustomerDirectory().getCustomer(account.getEmployee().getName());
//        int lastOrderID ;
//        Menu menu = (Menu) tblItem.getValueAt(selectedRow, 0);
//        String status = "Order Placed";
//
//        Order order = ecoSystem.getOrderDirectory().newOrder();
//        order.setCustomer(customer);
//        
//
//// commented 
//        order.setOrderId(String.valueOf(lnum++));
//        order.setQuantity(quantity);
//        order.setMenu(menu);
//        order.setRestaurant(restaurant);
//        order.setOrderStatus(status);
//        order.setAssign(false);
//        String status = "Order Placed";
//        ***********************************************************
//        for (int i=0; i < selectedRow.length; i++){
//            
//            String status = "Order Placed";
//            Menu menu = (Menu) tblItem.getValueAt(i, 0);
//            
//            
//            Order order = ecoSystem.getOrderDirectory().newOrder();
//            order.setCustomer(customer);
//        //        for (Order order : ecoSystem.getOrderDirectory().getOrderDirectory()){
//        //            cou
//        //        }
//        //        count = ecoSystem.getOrderDirectory()
//            order.setOrderId(String.valueOf(lnum++));
//            order.setQuantity(quantity);
//            order.setMenu(menu);
//            order.setRestaurant(restaurant);
//            order.setOrderStatus(status);
//            order.setAssign(false);
//                        
//        }
        
        
//        int lastOrderID = lnum;
//        String num = String.valueOf(lastOrderID);
//        FileWriter writer = new FileWriter("YourFile.txt");
//        try {
//            try {
//                OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("src/MyFile.txt"), "UTF-8");
//                try {
//                    writer.write(num);
//                    writer.close();
//                } catch (IOException ex) {
//                    Logger.getLogger(CustomerAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            } catch (UnsupportedEncodingException ex) {
//                Logger.getLogger(CustomerAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(CustomerAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
//        }    
//          ***********************************************************        
        
        
// commented 
        
        JOptionPane.showMessageDialog(null,"Order has been placed successfully!");
        populateRequestTable();
                
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnMenuShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuShowActionPerformed
        // TODO add your handling code here:
        if(cmbRestaurant.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Select a restaurant to view the Menu");
            return;
        }
        populateTable();
        String restaurantName = cmbRestaurant.getSelectedItem().toString();
        Restaurant restaurant = ecoSystem.getRestaurantDirectory().getRestaurant(restaurantName);
        String logo = restaurant.getRestLogo();
        lblLogo.setIcon(display(logo));
//        System.out.println(logo);
//        BufferedImage image = ImageIO.read(logo);
//        originalImageBuffer = image;
//        ImageIcon icon = new ImageIcon(image);

    }//GEN-LAST:event_btnMenuShowActionPerformed

    private void cmbRestaurantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRestaurantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbRestaurantActionPerformed

    private void btnfeedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfeedbackActionPerformed
        // TODO add your handling code here:
        if(txtFeedback.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Feedback cannot be empty");
            return;
        }
        
        int selectedRow = workRequestJTable.getSelectedRow();
        if(selectedRow < 0) {
            JOptionPane.showMessageDialog(null,"Select a row from table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        
        Order order = (Order)workRequestJTable.getValueAt(selectedRow, 0);
        if (order.getOrderStatus().equals("Delivered")){
        order.setOrderFeedback(txtFeedback.getText());
        populateRequestTable();
        txtFeedback.setText("");
        JOptionPane.showMessageDialog(null, "Feedback is added for the Order");
        System.out.println(order.getOrderFeedback());
        }
        else JOptionPane.showMessageDialog(null,"Feedback can be given only after Order is delivered.","Warning",  JOptionPane.WARNING_MESSAGE);
        txtFeedback.setText("");
    }//GEN-LAST:event_btnfeedbackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnMenuShow;
    private javax.swing.JButton btnfeedback;
    private javax.swing.JComboBox<String> cmbRestaurant;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JButton refreshTestJButton;
    private javax.swing.JButton requestTestJButton;
    private javax.swing.JTable tblItem;
    private javax.swing.JTextField txtComment;
    private javax.swing.JTextArea txtFeedback;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables

//    private void initializeLastOrderID() {
//        try {
//            InputStreamReader reader = new InputStreamReader(new FileInputStream("src/MyFile.txt"), "UTF-8");
//            try {
//                int lastnum= reader.read();
////                this.lnum = lastnum;
////                idCOunt = String.valueOf(lnum);
//            } catch (IOException ex) {
//                Logger.getLogger(CustomerAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(CustomerAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (UnsupportedEncodingException ex) {
//            Logger.getLogger(CustomerAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    private Icon display(String logo) {
        ImageIcon ic = new ImageIcon(logo);
        Image originalImage = ic.getImage();
        Image scaledImage = originalImage.getScaledInstance(350, 175, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(scaledImage);
        return image;
        
    }
}
