/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pharmacy.system;

import Models.DbConnection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author SENURI
 */
public class Company extends javax.swing.JFrame {

    public Company() {
        initComponents();
        SelectCom();
    }

//    Connection Con = null;
    Statement St = null;
    ResultSet rs = null;
    DbConnection dbconn = new DbConnection();
    Connection Con = dbconn.getDbConnection();
    String selectedComID = "";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        CompName_Txt = new javax.swing.JTextField();
        CompAddress_Txt = new javax.swing.JTextField();
        Update_Btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        companyTable = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        Delete_Btn = new javax.swing.JButton();
        Add_Btn = new javax.swing.JButton();
        CompPhone_Txt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Clear_Btn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        jLabel14.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 255, 255));
        jLabel14.setText("X");

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        jLabel5.setBackground(new java.awt.Color(153, 153, 255));
        jLabel5.setFont(new java.awt.Font("Gadugi", 1, 28)); // NOI18N
        jLabel5.setText("   Manage Company");
        jLabel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 51, 102), new java.awt.Color(0, 51, 102), null));

        jLabel8.setBackground(new java.awt.Color(204, 255, 255));
        jLabel8.setFont(new java.awt.Font("Gadugi", 1, 16)); // NOI18N
        jLabel8.setText("Address");

        jLabel11.setBackground(new java.awt.Color(204, 255, 255));
        jLabel11.setFont(new java.awt.Font("Gadugi", 1, 16)); // NOI18N
        jLabel11.setText("Phone Number");

        CompName_Txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompName_TxtActionPerformed(evt);
            }
        });

        CompAddress_Txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompAddress_TxtActionPerformed(evt);
            }
        });

        Update_Btn.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        Update_Btn.setText("UPDATE");
        Update_Btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 51, 102), new java.awt.Color(0, 51, 102), new java.awt.Color(0, 51, 102), new java.awt.Color(0, 51, 102)));
        Update_Btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Update_BtnMouseClicked(evt);
            }
        });
        Update_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Update_BtnActionPerformed(evt);
            }
        });

        companyTable.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        companyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Address", "Phone no"
            }
        ));
        companyTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                companyTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(companyTable);

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Gadugi", 1, 26)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 102));
        jLabel13.setText("   List Of Companies");
        jLabel13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), java.awt.Color.black, java.awt.Color.black));

        Delete_Btn.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        Delete_Btn.setText("DELETE");
        Delete_Btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 51, 102), new java.awt.Color(0, 51, 102), new java.awt.Color(0, 51, 102), new java.awt.Color(0, 51, 102)));
        Delete_Btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Delete_BtnMouseClicked(evt);
            }
        });
        Delete_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_BtnActionPerformed(evt);
            }
        });

        Add_Btn.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        Add_Btn.setText("ADD");
        Add_Btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 51, 102), new java.awt.Color(0, 51, 102), new java.awt.Color(0, 51, 102), new java.awt.Color(0, 51, 102)));
        Add_Btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_BtnMouseClicked(evt);
            }
        });
        Add_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_BtnActionPerformed(evt);
            }
        });

        CompPhone_Txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompPhone_TxtActionPerformed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(204, 255, 255));
        jLabel10.setFont(new java.awt.Font("Gadugi", 1, 16)); // NOI18N
        jLabel10.setText("Name");

        Clear_Btn.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        Clear_Btn.setText("CLEAR");
        Clear_Btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 51, 102), new java.awt.Color(0, 51, 102), new java.awt.Color(0, 51, 102), new java.awt.Color(0, 51, 102)));
        Clear_Btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Clear_BtnMouseClicked(evt);
            }
        });
        Clear_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Clear_BtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CompName_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CompAddress_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CompPhone_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(Add_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Update_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Delete_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel11)))
                        .addGap(18, 18, 18)
                        .addComponent(Clear_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(220, 220, 220))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(41, 41, 41)
                            .addComponent(jLabel11))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(CompPhone_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CompName_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(CompAddress_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add_Btn)
                    .addComponent(Update_Btn)
                    .addComponent(Delete_Btn)
                    .addComponent(Clear_Btn))
                .addGap(69, 69, 69)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jLabel2.setBackground(new java.awt.Color(0, 0, 255));
        jLabel2.setFont(new java.awt.Font("Gadugi", 1, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 255));
        jLabel2.setText("Medicines");

        jLabel3.setBackground(new java.awt.Color(0, 0, 255));
        jLabel3.setFont(new java.awt.Font("Gadugi", 1, 25)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 255, 255));
        jLabel3.setText("Selling");

        jLabel4.setBackground(new java.awt.Color(0, 0, 255));
        jLabel4.setFont(new java.awt.Font("Gadugi", 1, 25)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 255, 255));
        jLabel4.setText("Agents");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CompName_TxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompName_TxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CompName_TxtActionPerformed

    private void CompAddress_TxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompAddress_TxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CompAddress_TxtActionPerformed

    private void Update_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Update_BtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Update_BtnActionPerformed

    private void Delete_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_BtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Delete_BtnActionPerformed

    private void Add_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_BtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Add_BtnActionPerformed

    private void CompPhone_TxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompPhone_TxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CompPhone_TxtActionPerformed

    private void Clear_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Clear_BtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Clear_BtnActionPerformed

    public void SelectCom() {
        try {
//            Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Pharmadb", "User1", "1234");
            St = Con.createStatement();
            rs = St.executeQuery("select * from company");
//            companyTable.setModel(DbUtils.resultSetToTableModel(Rs));
            DefaultTableModel model = (DefaultTableModel) companyTable.getModel();
            model.setRowCount(0);
            Object[] row = new Object[4];
            while (rs.next()) {
                row[0] = rs.getInt("compID");
                row[1] = rs.getString("compName");
                row[2] = rs.getString("compAddress");
                row[3] = rs.getString("compPhone");

                model.addRow(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void Add_BtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_BtnMouseClicked
        if (CompName_Txt.getText().isEmpty() || CompAddress_Txt.getText().isEmpty() || CompPhone_Txt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Missing Information.");
        } else {
            try {
//            Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Pharmadb", "User1", "1234");
                PreparedStatement add = Con.prepareStatement("insert into company (compName, compAddress, compPhone) values(?, ?, ?)");
//            add.setInt(1, Integer.valueOf(CompID_Txt.getText()));
                add.setString(1, CompName_Txt.getText());
                add.setString(2, CompAddress_Txt.getText());
                add.setString(3, CompPhone_Txt.getText());
                int row = add.executeUpdate();
                JOptionPane.showMessageDialog(this, "Company Successfully Added");
//            Con.close();
                SelectCom();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_Add_BtnMouseClicked

    private void Delete_BtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Delete_BtnMouseClicked
        if (selectedComID.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Select the company to be deleted");
        } else {
            try {
//                Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Pharmadb", "User1", "1234");
//                String Id = CompID_Txt.getText();
                String Query = "delete from company where compID=" + selectedComID;
                Statement Add = Con.createStatement();
                Add.executeUpdate(Query);
                SelectCom();
                JOptionPane.showMessageDialog(this, "Company Deleted Successfully");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_Delete_BtnMouseClicked

    private void Update_BtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Update_BtnMouseClicked
        if (selectedComID.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No company selected.");
        } else if (CompName_Txt.getText().isEmpty() || CompAddress_Txt.getText().isEmpty() || CompPhone_Txt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Missing Information.");
        } else {
            try {
//                Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Pharmadb", "User1", "1234");
                String UpdateQuery = "update company set compName= '" + CompName_Txt.getText() + "'" + ",compAddress = '" + CompAddress_Txt.getText() + "'" + ",compPhone = '" + CompPhone_Txt.getText() + "'" + " where compID = " + selectedComID;
                Statement Add = Con.createStatement();
                Add.executeUpdate(UpdateQuery);
                JOptionPane.showMessageDialog(this, "Company Update Successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            SelectCom();
        }
    }//GEN-LAST:event_Update_BtnMouseClicked

    private void Clear_BtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Clear_BtnMouseClicked
//        CompId.setText("");
        selectedComID = "";
        CompName_Txt.setText("");
        CompAddress_Txt.setText("");
        CompPhone_Txt.setText("");
    }//GEN-LAST:event_Clear_BtnMouseClicked

    private void companyTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_companyTableMouseClicked
        DefaultTableModel model = (DefaultTableModel) companyTable.getModel();
//        DefaultTableModel model = (DefaultTableModel).getModel();
        int Myindex = companyTable.getSelectedRow();
//        CompId.setText(model.getValueAt(Myindex, 0).toString());
        selectedComID = model.getValueAt(Myindex, 0).toString();
        CompName_Txt.setText(model.getValueAt(Myindex, 1).toString());
        CompAddress_Txt.setText(model.getValueAt(Myindex, 2).toString());
        CompPhone_Txt.setText(model.getValueAt(Myindex, 3).toString());
    }//GEN-LAST:event_companyTableMouseClicked

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
            java.util.logging.Logger.getLogger(Company.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Company.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Company.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Company.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Company().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add_Btn;
    private javax.swing.JButton Clear_Btn;
    private javax.swing.JTextField CompAddress_Txt;
    private javax.swing.JTextField CompName_Txt;
    private javax.swing.JTextField CompPhone_Txt;
    private javax.swing.JButton Delete_Btn;
    private javax.swing.JButton Update_Btn;
    private javax.swing.JTable companyTable;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
