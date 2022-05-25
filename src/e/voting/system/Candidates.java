/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.voting.system;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ADMIN
 */
public class Candidates extends javax.swing.JFrame {
    
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs =null;
    Statement st=null;
    String imgpath=null;

    /**
     * Creates new form Candidates
     */
    public Candidates() {
        initComponents();
        GetElection();
        CDisplay();
      CandidateCount();
    }

   
    @SuppressWarnings("unchecked")
    
    int CId;
    Statement st1=null;
    ResultSet rs1=null;
    private void CandidateCount(){
    
    try{
    st1=con.createStatement();
    rs1=st1.executeQuery("select MAX(CId)from candidatetbl");
    rs1.next();
    CId=rs1.getInt(1)+1;
    
    
    }
    catch(Exception e){
    
    
    }
    }
    private void GetElection(){
    
     try{
         Class.forName("org.mariadb.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mariadb://localhost:3306/E_Voting","root", "Eldinah8703");
         st =con.createStatement();
         rs=st.executeQuery("select*from electiontbl");
        while (rs.next()){
        
            String ElectId=rs.getString("EId");
            CElection.addItem(ElectId);
        
        }
        }
        catch(Exception e){
        
        JOptionPane.showMessageDialog(null, e);
        
        }
        
    }
    
     private Icon ResizePhoto(String imgpath, byte [] pic){
     
      ImageIcon MyImage=null;
      if (imgpath!=null){
      
      MyImage=new ImageIcon(imgpath);
      
      }else{
      
        MyImage=new ImageIcon(pic);  
      
      }
      Image img =MyImage.getImage();
      Image newImg=img.getScaledInstance(CPhoto.getWidth(),CPhoto.getHeight() , Image.SCALE_SMOOTH);
      ImageIcon image=new ImageIcon(newImg);
      
      return image;
     }
     
      private void CDisplay(){
    
    try{
         Class.forName("org.mariadb.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mariadb://localhost:3306/E_Voting","root", "Eldinah8703");
         st =con.createStatement();
         rs=st.executeQuery("select*from candidatetbl");
         CTable.setModel(DbUtils.resultSetToTableModel(rs));
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        CName = new javax.swing.JTextField();
        CAge = new javax.swing.JTextField();
        CGen = new javax.swing.JComboBox<>();
        CElection = new javax.swing.JComboBox<>();
        CPhoto = new javax.swing.JLabel();
        browsebtn = new javax.swing.JButton();
        addbtn = new javax.swing.JButton();
        editbtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
        backbtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        CTable = new javax.swing.JTable();

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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 992, -1));

        jLabel1.setBackground(new java.awt.Color(51, 0, 204));
        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("Manage candidates");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 139, 242, 49));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Age");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 220, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Name");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Gender");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 220, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Elections");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Photo");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 320, -1, -1));

        CName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        CName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CNameActionPerformed(evt);
            }
        });
        jPanel1.add(CName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 140, -1));

        CAge.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(CAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 260, 74, -1));

        CGen.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        CGen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", " " }));
        CGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CGenActionPerformed(evt);
            }
        });
        jPanel1.add(CGen, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 260, -1, -1));

        CElection.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        CElection.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CElectionMouseClicked(evt);
            }
        });
        CElection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CElectionActionPerformed(evt);
            }
        });
        jPanel1.add(CElection, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, -1, -1));

        CPhoto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CPhoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CPhotoMouseEntered(evt);
            }
        });
        jPanel1.add(CPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 180, 190));

        browsebtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        browsebtn.setText("Browse");
        browsebtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                browsebtnMouseClicked(evt);
            }
        });
        browsebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browsebtnActionPerformed(evt);
            }
        });
        jPanel1.add(browsebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 560, -1, -1));

        addbtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addbtn.setText("Add");
        addbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addbtnMouseClicked(evt);
            }
        });
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });
        jPanel1.add(addbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, -1, -1));

        editbtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        editbtn.setText("Edit");
        editbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editbtnMouseClicked(evt);
            }
        });
        editbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtnActionPerformed(evt);
            }
        });
        jPanel1.add(editbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 650, -1, -1));

        deletebtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        deletebtn.setText("Delete");
        deletebtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deletebtnMouseClicked(evt);
            }
        });
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });
        jPanel1.add(deletebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 650, -1, -1));

        backbtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        backbtn.setText("Back");
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });
        jPanel1.add(backbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 650, -1, -1));

        CTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CId", "Name", "Age", "Gender", "Election", "Photo"
            }
        ));
        CTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(CTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, 550, 379));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1006, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 14, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 694, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CGenActionPerformed

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_addbtnActionPerformed

    private void CNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CNameActionPerformed

    private void addbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbtnMouseClicked
        // TODO add your handling code here:
          if(CAge.getText().isEmpty() || CName.getText().isEmpty()||CElection.getSelectedIndex()==-1||CGen.getSelectedIndex()==-1){
        
          JOptionPane.showMessageDialog(this, "missing information");
   
        }else{
        
            try {
                
                
                Class.forName("org.mariadb.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mariadb://localhost:3306/E_Voting","root", "Eldinah8703");
                PreparedStatement Add=con.prepareStatement("insert into candidatetbl values (?, ?, ?, ?, ?, ?)");
               
                InputStream img=new FileInputStream(imgpath);
                CandidateCount();
                Add.setInt(1, CId);
                Add.setString(2, CName.getText());
                Add.setInt(3, Integer.valueOf(CAge.getText()));
                Add.setString(4, CGen.getSelectedItem().toString());
                Add.setBlob(5, img);
                Add.setInt(6, Integer.valueOf(CElection.getSelectedItem().toString()));
                
                
                 int row=Add.executeUpdate();
                JOptionPane.showMessageDialog(this, "Candidate registered");
                
                con.close();
                CDisplay();
                
            } catch (Exception e) {
                
                 JOptionPane.showMessageDialog(this, e);
             
            }
        
        }
        
    }//GEN-LAST:event_addbtnMouseClicked

    private void browsebtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_browsebtnMouseClicked
        // TODO add your handling code here:
        
       JFileChooser chooser=new  JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter= new FileNameExtensionFilter("*.image", "jpg", "gif", "png");
        chooser.addChoosableFileFilter(filter);
        int result=chooser.showSaveDialog(null);
        if(result==JFileChooser.APPROVE_OPTION){
        
        File SelectedFile = chooser.getSelectedFile();
        String path=SelectedFile.getAbsolutePath();
        CPhoto.setIcon(ResizePhoto(path,null));
        imgpath = path;
        
        }
        
    }//GEN-LAST:event_browsebtnMouseClicked

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        // TODO add your handling code here:
        new MainDashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backbtnActionPerformed

    
    private void FetchPhoto(){
    
    String query="select CPhoto from candidatetbl where CId="+key;
    Statement st;
    ResultSet rs;
     try{
     
      Class.forName("org.mariadb.jdbc.Driver");
      con=DriverManager.getConnection("jdbc:mariadb://localhost:3306/E_Voting","root", "Eldinah8703");
       st=con.createStatement();
       rs=st.executeQuery(query);
       if(rs.next()){
       
       CPhoto.setIcon(ResizePhoto(null, rs.getBytes("CPhoto")));
       
       
       }
     }
     catch(Exception e){
     
     
     }
    
    
    }
    int key=-1;
    private void CTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel df=(DefaultTableModel)CTable.getModel();
         int selectedIndex=CTable.getSelectedRow();
         
         key=Integer.valueOf(df.getValueAt(selectedIndex,0).toString());
         CName.setText(df.getValueAt(selectedIndex, 1).toString());
         CAge.setText(df.getValueAt(selectedIndex, 2).toString());
         CGen.setSelectedItem(df.getValueAt(selectedIndex, 3).toString());
         CElection.setSelectedItem(df.getValueAt(selectedIndex, 4).toString());
         FetchPhoto();
        
    }//GEN-LAST:event_CTableMouseClicked

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
        // TODO add your handling code here:
        
       
    }//GEN-LAST:event_deletebtnActionPerformed

    private void editbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtnActionPerformed

  
    }//GEN-LAST:event_editbtnActionPerformed

    private void editbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editbtnMouseClicked
        // TODO add your handling code here:
         if(key==-1 || CName.getText().isEmpty()||CAge.getText().isEmpty()||CElection.getSelectedIndex()==-1||CGen.getSelectedIndex()==-1){
        
        JOptionPane.showMessageDialog(this, "Missing information");
        } else if (imgpath !=null){
          try{
             
              InputStream img=new FileInputStream (imgpath);
       Class.forName("org.mariadb.jdbc.Driver");
       Connection con=DriverManager.getConnection("jdbc:mariadb://localhost:3306/E_Voting","root", "Eldinah8703");
       
       String query="update Candidatetbl set CName=?, CAge=?, CGen=?, CElect=?, CPhoto=? where CId=?";
       
       PreparedStatement updateQuery=con.prepareStatement(query);
         updateQuery.setString(1, CName.getText());
         updateQuery.setInt(2, Integer.valueOf(CAge.getText().toString()));
         updateQuery.setString(3, CGen.getSelectedItem().toString());
         updateQuery.setString(4, CElection.getSelectedItem().toString());
         updateQuery.setBlob(5, img);
         updateQuery.setInt(6, key);
       if (updateQuery.executeUpdate()==1){
     
       JOptionPane.showMessageDialog(this, "Candidate updated successfully");
       CName.setText(" ");
       CAge.setText(" ");
       CGen.setSelectedItem("  ");
       CElection.setSelectedItem(" ");
       CDisplay();
       
       }else{
       
       JOptionPane.showMessageDialog(this, "Missing information");
       
       }
       } 
          catch (Exception e) {
           
            JOptionPane.showMessageDialog(this, e);

       }
         } else{
        
                    JOptionPane.showMessageDialog(this, "Select photo");
                     CPhoto.setIcon(null);
                     CPhoto.setText(" ");
        
        }
         imgpath=null;
    }//GEN-LAST:event_editbtnMouseClicked

    private void CPhotoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CPhotoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_CPhotoMouseEntered

    private void browsebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browsebtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_browsebtnActionPerformed

    private void CElectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CElectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CElectionActionPerformed

    private void CElectionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CElectionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_CElectionMouseClicked

    private void deletebtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletebtnMouseClicked
  
         if(key==-1){
        
        JOptionPane.showMessageDialog(this, "Select the Candidate to be deleted");
        } else{
         try{
               
        Class.forName("org.mariadb.jdbc.Driver");
       Connection con=DriverManager.getConnection("jdbc:mariadb://localhost:3306/E_Voting","root", "Eldinah8703");
        String query="Delete from candidatetbl where CId="+key;
        Statement del=con.createStatement();
       del.executeUpdate(query);
       JOptionPane.showMessageDialog(this, "Candidate deleted successfully");
        CDisplay();
       
       
       } 
          
       catch (Exception e) {
           
            JOptionPane.showMessageDialog(this, e);
        }
        
        
                }

    }//GEN-LAST:event_deletebtnMouseClicked

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
            java.util.logging.Logger.getLogger(Candidates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Candidates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Candidates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Candidates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Candidates().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CAge;
    private javax.swing.JComboBox<String> CElection;
    private javax.swing.JComboBox<String> CGen;
    private javax.swing.JTextField CName;
    private javax.swing.JLabel CPhoto;
    private javax.swing.JTable CTable;
    private javax.swing.JButton addbtn;
    private javax.swing.JButton backbtn;
    private javax.swing.JButton browsebtn;
    private javax.swing.JButton deletebtn;
    private javax.swing.JButton editbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
