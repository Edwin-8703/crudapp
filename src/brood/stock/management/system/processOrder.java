/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brood.stock.management.system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ADMIN
 */
public class processOrder extends javax.swing.JFrame {
   Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs =null;
    Statement st=null;
    /**
     * Creates new form processOrder
     */
    public processOrder() {
        initComponents();
        GetCustomerDetails();
        ODisplay();
      
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    
    private void GetCustomerDetails(){
        
        try{
        
        Class.forName("org.mariadb.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mariadb://localhost:3306/brood","root", "Eldinah8703");
         st =con.createStatement();
          rs=st.executeQuery("select*from customer");
          while (rs.next()){
        
            String CId=rs.getString("id");
             String name=rs.getString("Name");
              String dest=rs.getString("Address");
             
          customer.addItem( "Name: "  +name+  ",    CId: "+ CId+ ",    Adress:  " +dest);
            
           // COrder.addItem( name);
        
        }
        }
        catch(Exception e){
        
         JOptionPane.showMessageDialog(null, e);
        
        }
    }
    int  orderId;
    Statement st1=null;
    ResultSet rs1=null;
     private void OrderCount(){
    
    try{
    st1=con.createStatement();
    rs1=st1.executeQuery("select MAX( orderId)from porders");
    rs1.next();
   orderId =rs1.getInt(1)+1;
    
    
    }
    catch(Exception e){
    
    }
    }
    private void ODisplay(){
    
    try{
         Class.forName("org.mariadb.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mariadb://localhost:3306/brood","root", "Eldinah8703");
         st =con.createStatement();
         rs=st.executeQuery("select*from porders");
         jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
        
        JOptionPane.showMessageDialog(null, e);
        
        }
    
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        customer = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtime = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        ODate = new javax.swing.JLabel();
        quantitytbl = new javax.swing.JTextField();
        jdate = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        customer.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerActionPerformed(evt);
            }
        });
        jPanel1.add(customer, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 450, 60));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Order time");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 290, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Customer details");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        jtime.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jtime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtimeMouseClicked(evt);
            }
        });
        jtime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtimeActionPerformed(evt);
            }
        });
        jPanel1.add(jtime, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 290, 130, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "orderId", "customerDetails", " orderDate", " orderTime", "quantity"
            }
        ));
        jTable1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTable1ComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 240));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Edit");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 480, -1, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("Add order");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, -1, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("Delete order");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 480, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Quantity");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, -1, 30));

        ODate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ODate.setText("Order date");
        ODate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ODateMouseClicked(evt);
            }
        });
        jPanel1.add(ODate, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 290, -1, -1));

        quantitytbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        quantitytbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantitytblActionPerformed(evt);
            }
        });
        jPanel1.add(quantitytbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 200, 30));

        jdate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jdateMouseClicked(evt);
            }
        });
        jdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdateActionPerformed(evt);
            }
        });
        jPanel1.add(jdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 290, 180, 30));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 480, -1, -1));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setText("Invoice");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 480, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jtimeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtimeMouseClicked

     
        
    }//GEN-LAST:event_jtimeMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        
          if(quantitytbl.getText().isEmpty()){
        
          JOptionPane.showMessageDialog(this, "missing information", "Warning",JOptionPane.ERROR_MESSAGE);
   
        }else{
       try{
           OrderCount();
         Calendar timer=Calendar.getInstance();
        timer.getTime();
        SimpleDateFormat Tt=new SimpleDateFormat("HH:mm:ss");
        jtime.setText(Tt.format(timer.getTime()));
        
         SimpleDateFormat Dd=new SimpleDateFormat("dd-MMM-YYYY");
         jdate.setText(Dd.format(timer.getTime()));
       Class.forName("org.mariadb.jdbc.Driver");
       Connection con=DriverManager.getConnection("jdbc:mariadb://localhost:3306/brood","root", "Eldinah8703");
       PreparedStatement Add=con.prepareStatement("insert into  porders values (?, ?, ?, ?, ?)");
               
                
                Add.setInt(1, orderId);
                Add.setString(2, customer.getSelectedItem().toString());
                 Add.setString(3, jdate.getText());
                  Add.setString(4, jtime.getText());
                Add.setInt(5, Integer.valueOf(quantitytbl.getText()));
                
                
                
                 int row=Add.executeUpdate();
                JOptionPane.showMessageDialog(this, "Order added successfully");
                
                con.close();
                ODisplay();
                
               } 
       
       catch (Exception e) {
           
            JOptionPane.showMessageDialog(this, "connection error");
        }}
       
      
         
    }//GEN-LAST:event_jButton2MouseClicked

    private void jdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jdateActionPerformed

    private void jdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jdateMouseClicked

    }//GEN-LAST:event_jdateMouseClicked

    private void ODateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ODateMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_ODateMouseClicked

    private void customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerActionPerformed

    private void jtimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtimeActionPerformed
    int key=-1;
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        //jTable1.setAutoResizeMode(jTable1.resize(WIDTH, HEIGHT));
         DefaultTableModel df=(DefaultTableModel)jTable1.getModel();
         int selectedIndex=jTable1.getSelectedRow();
         
         key=Integer.valueOf(df.getValueAt(selectedIndex,0).toString());
          customer.setSelectedItem(df.getValueAt(selectedIndex, 1).toString());
         jdate.setText(df.getValueAt(selectedIndex, 2).toString());
          jtime.setText(df.getValueAt(selectedIndex, 3).toString());
         quantitytbl.setText(df.getValueAt(selectedIndex, 4).toString());
        
         
    }//GEN-LAST:event_jTable1MouseClicked

    private void quantitytblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantitytblActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantitytblActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        
         if(key==-1){
        
        JOptionPane.showMessageDialog(this, "Select an order to be deleted");
        } else{
         try{
               
        Class.forName("org.mariadb.jdbc.Driver");
       Connection con=DriverManager.getConnection("jdbc:mariadb://localhost:3306/brood","root", "Eldinah8703");
        String query="Delete from porders where orderId="+key;
        Statement del=con.createStatement();
       del.executeUpdate(query);
       JOptionPane.showMessageDialog(this, "order deleted successfully");
        ODisplay();
       
       
       } 
          
       catch (Exception e) {
           
            JOptionPane.showMessageDialog(this, e);
        }
        
        
                }
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
       customerpage cO=new customerpage();
        cO.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        if(key==-1 || quantitytbl.getText().isEmpty()){
        
        JOptionPane.showMessageDialog(this, "Missing information");
        } else{
         try{
             
                        
        Class.forName("org.mariadb.jdbc.Driver");
       Connection con=DriverManager.getConnection("jdbc:mariadb://localhost:3306/brood","root", "Eldinah8703");
       
        String query="update porders set customerId=?,orderDate=?, orderTime=?, quantity=? where orderId=?";
        PreparedStatement updateQuery=con.prepareStatement(query);
         updateQuery.setString(1, customer.getSelectedItem().toString());
         updateQuery.setString(2, jdate.getText());
         updateQuery.setString(3, jtime.getText());
         updateQuery.setInt(4, Integer.valueOf(quantitytbl.getText()));
         
         updateQuery.setInt(5, key);
       updateQuery.executeUpdate();
     
       JOptionPane.showMessageDialog(this, "Order updated successfully");
       ODisplay();
       
       
       } 
          
       catch (Exception e) {
           
            JOptionPane.showMessageDialog(this, e);
        }
        
        
        
        }        
    }//GEN-LAST:event_jButton1MouseClicked

    private void jTable1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1AncestorAdded

    private void jTable1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable1ComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1ComponentShown

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
       new Invoice1().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(processOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(processOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(processOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(processOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new processOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ODate;
    private javax.swing.JComboBox<String> customer;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jdate;
    private javax.swing.JTextField jtime;
    private javax.swing.JTextField quantitytbl;
    // End of variables declaration//GEN-END:variables
}
