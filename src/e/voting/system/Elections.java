/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.voting.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;


public class Elections extends javax.swing.JFrame {
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs =null;
    Statement st=null;

    
    public Elections() {
        initComponents();
        EDisplay();
    }

    
    @SuppressWarnings("unchecked")
    
    int EId;
    Statement st1=null;
    ResultSet rs1=null;
    
    private void ElecCount(){
    
    try{
    st1=con.createStatement();
    rs1=st1.executeQuery("select MAX(EId)from electiontbl");
    rs1.next();
    EId=rs1.getInt(1)+1;
    
    
    }
    catch(Exception e){
    
    
    }
    
    }
    
    private void EDisplay(){
    
    try{
         Class.forName("org.mariadb.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mariadb://localhost:3306/E_Voting","root", "Eldinah8703");
         st =con.createStatement();
         rs=st.executeQuery("select*from electiontbl");
         ElectionTable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
        
        JOptionPane.showMessageDialog(null, e);
        
        }
        
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ElectionTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ElectionNameTbl = new javax.swing.JTextField();
        Editbtn = new javax.swing.JButton();
        Addbtn = new javax.swing.JButton();
        Backbtn = new javax.swing.JButton();
        Deletebtn = new javax.swing.JButton();
        ElectionDate = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));
        jPanel2.setForeground(new java.awt.Color(0, 51, 204));

        jLabel2.setBackground(new java.awt.Color(51, 0, 204));
        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("E-VOTING  SYSTEM");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(361, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(302, 302, 302))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 0, 1210, -1));

        jLabel1.setBackground(new java.awt.Color(51, 0, 204));
        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("Manage  Elections");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 230, 49));

        ElectionTable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ElectionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Date"
            }
        ));
        ElectionTable.setRowHeight(25);
        ElectionTable.setSelectionBackground(new java.awt.Color(255, 204, 0));
        ElectionTable.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                ElectionTableAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        ElectionTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ElectionTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ElectionTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 820, 232));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Name");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 213, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Date");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 213, -1, -1));

        ElectionNameTbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(ElectionNameTbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 253, 163, -1));

        Editbtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Editbtn.setText("Edit");
        Editbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditbtnMouseClicked(evt);
            }
        });
        Editbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditbtnActionPerformed(evt);
            }
        });
        jPanel1.add(Editbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 405, -1, -1));

        Addbtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Addbtn.setText("Add");
        Addbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddbtnMouseClicked(evt);
            }
        });
        Addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddbtnActionPerformed(evt);
            }
        });
        jPanel1.add(Addbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 405, -1, -1));

        Backbtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Backbtn.setText("Back");
        Backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackbtnActionPerformed(evt);
            }
        });
        jPanel1.add(Backbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 471, 117, -1));

        Deletebtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Deletebtn.setText("Delete");
        Deletebtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeletebtnMouseClicked(evt);
            }
        });
        Deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletebtnActionPerformed(evt);
            }
        });
        jPanel1.add(Deletebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 405, -1, -1));
        jPanel1.add(ElectionDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 140, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AddbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddbtnActionPerformed
        // TODO add your handling code here:
        
       
    }//GEN-LAST:event_AddbtnActionPerformed

    private void ElectionTableAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_ElectionTableAncestorAdded
        // TODO add your handling code here:
         
    }//GEN-LAST:event_ElectionTableAncestorAdded
    int key =-1;
    private void ElectionTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ElectionTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel df=(DefaultTableModel)ElectionTable.getModel();
         int selectedIndex=ElectionTable.getSelectedRow();
         key=Integer.valueOf(df.getValueAt(selectedIndex,0).toString());
        ElectionNameTbl.setText(df.getValueAt(selectedIndex, 1).toString());
         // ElectionDatetbl.setText(df.getValueAt(selectedIndex, 2).toString());
        
    }//GEN-LAST:event_ElectionTableMouseClicked

    private void EditbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditbtnActionPerformed
        // TODO add your handling code here:
        
        
        
    }//GEN-LAST:event_EditbtnActionPerformed

    private void DeletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletebtnActionPerformed
       
    }//GEN-LAST:event_DeletebtnActionPerformed

    private void BackbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackbtnActionPerformed
        // TODO add your handling code here:
        new MainDashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackbtnActionPerformed

    private void AddbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddbtnMouseClicked
        if(ElectionNameTbl.getText().isEmpty()){
        
            JOptionPane.showMessageDialog(this, "Kindly enter the election name");
        
        }else{
        
            try{
                 String day=String.valueOf(ElectionDate.getDate().getDay());
              String month=String.valueOf(ElectionDate.getDate().getMonth());
               String year=String.valueOf(ElectionDate.getDate().getYear());
               String EDate=day +"/ "+month+"/"+year;
               ElecCount();
            Class.forName("org.mariadb.jdbc.Driver");
          con=DriverManager.getConnection("jdbc:mariadb://localhost:3306/E_Voting","root", "Eldinah8703");
           PreparedStatement Add=con.prepareStatement("insert into electiontbl values (?, ?, ?)");
           
       
       Add.setInt(1, EId);
       Add.setString(2, ElectionNameTbl.getText());
       Add.setString(3, EDate);
       
       int row=Add.executeUpdate();
       
       
         JOptionPane.showMessageDialog(this, "Added successfully");
       
       con.close();
      EDisplay();
       
       
            
            }
            catch(Exception e){
            
            JOptionPane.showMessageDialog(this, e);
            
        }
        }
    }//GEN-LAST:event_AddbtnMouseClicked

    private void DeletebtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeletebtnMouseClicked
        // TODO add your handling code here:
        
        if(key==-1){
        
        JOptionPane.showMessageDialog(this, "Select the Election to be deleted");
        } else{
         try{
               
        Class.forName("org.mariadb.jdbc.Driver");
       Connection con=DriverManager.getConnection("jdbc:mariadb://localhost:3306/E_Voting","root", "Eldinah8703");
        String query="Delete from electiontbl where EId="+key;
        Statement del=con.createStatement();
       del.executeUpdate(query);
       JOptionPane.showMessageDialog(this, "Election deleted successfully");
        EDisplay();
       
       
       } 
          
       catch (Exception e) {
           
            JOptionPane.showMessageDialog(this, e);
        }
        
        
        
        }
    }//GEN-LAST:event_DeletebtnMouseClicked

    private void EditbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditbtnMouseClicked
      if(key==-1 || ElectionDate.getDate().toString().isEmpty()){
        
        JOptionPane.showMessageDialog(this, "Missing information");
        } else{
         try{
             
             String day=String.valueOf(ElectionDate.getDate().getDay());
              String month=String.valueOf(ElectionDate.getDate().getMonth());
               String year=String.valueOf(ElectionDate.getDate().getYear());
               String EDate=day +"/ "+month+"/"+year;
               
        Class.forName("org.mariadb.jdbc.Driver");
       Connection con=DriverManager.getConnection("jdbc:mariadb://localhost:3306/E_Voting","root", "Eldinah8703");
        String query="update electiontbl set EName=?,EDate=? where EId=?";
        PreparedStatement updateQuery=con.prepareStatement(query);
         updateQuery.setString(1, ElectionNameTbl.getText());
         updateQuery.setString(2, EDate);
         updateQuery.setInt(3, key);
       updateQuery.executeUpdate();
     
       JOptionPane.showMessageDialog(this, "Elected updated successfully");
       EDisplay();
       
       
       } 
          
       catch (Exception e) {
           
            JOptionPane.showMessageDialog(this, e);
        }
        
        
        
        }        
    }//GEN-LAST:event_EditbtnMouseClicked

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
            java.util.logging.Logger.getLogger(Elections.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Elections.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Elections.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Elections.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Elections().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Addbtn;
    private javax.swing.JButton Backbtn;
    private javax.swing.JButton Deletebtn;
    private javax.swing.JButton Editbtn;
    private com.toedter.calendar.JDateChooser ElectionDate;
    private javax.swing.JTextField ElectionNameTbl;
    private javax.swing.JTable ElectionTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
