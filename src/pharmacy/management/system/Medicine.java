/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pharmacy.system;

import Models.DbConnection;
import java.sql.Statement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//import net.proteanit.sql.DbUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public final class Medicine extends javax.swing.JFrame {

    /**
     * Creates new form Medicine
     */
    public Medicine() {
        initComponents();
        showMedicineList();
        getCompanyList();
    }

    DbConnection dbconn = new DbConnection();
    Connection Con = dbconn.getDbConnection();

//    Statement St = null, St1 = null;
//    ResultSet Rs = null, rs = null;
//    java.util.Date FDate, EDate;
    String selectedMedID = "";

    @SuppressWarnings("unchecked")
//    public void selectMed() {
//        try {
////            Con = DriverManager.get Connection("jdbc:derby://localhost:1527/Pharmadb", "User1", "1234");
//            St1 = Con.createStatement();
//            rs = St1.executeQuery("Select * from User1.MEDICINETBL");
//
//            DefaultTableModel model = (DefaultTableModel) tblMediList.getModel();
//            model.setRowCount(0);
//
//            Object[] row = new Object[7];
//            while (rs.next()) {
//                row[0] = rs.getInt(1)
//            }
//            tblMediList.setMode1(DbUtils.resultSetToTableMode1(Rs));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    // Get company list
    public void getCompanyList() {
        try {
            Statement stat = Con.createStatement();
            String selectQuery = "select compName from company";
            ResultSet rs = stat.executeQuery(selectQuery);

            while (rs.next()) {
                cmbCompany.addItem(rs.getString("compName"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    // Get medicine list as an array list
    public ArrayList<Models.Medicine> getMedList() {
        ArrayList<Models.Medicine> medList = new ArrayList<>();

        try {
            Statement st = Con.createStatement();
            String query1 = "select * from medicine";
            ResultSet Res = st.executeQuery(query1);
            Models.Medicine med;
            while (Res.next()) {
                med = new Models.Medicine();
                med.setMedID(Res.getInt("medID"));
                med.setMedName(Res.getString("medName"));
                med.setMedPrice(Res.getFloat("medPrice"));
                med.setMedQTY(Res.getInt("medQTY"));
                med.setMedFAB(Res.getDate("medFAB"));
                med.setMedEXP(Res.getDate("medEXP"));
                med.setMedComp(Res.getString("medComp"));
                medList.add(med);
            }
            return medList;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Show medicine list in the table
    public void showMedicineList() {
        ArrayList<Models.Medicine> list = getMedList();
        DefaultTableModel model = (DefaultTableModel) tblMediList.getModel();
        model.setRowCount(0);
        Object[] row = new Object[7];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getMedID();
            row[1] = list.get(i).getMedName();
            row[2] = list.get(i).getMedPrice();
            row[3] = list.get(i).getMedQTY();
            row[4] = list.get(i).getMedFAB();
            row[5] = list.get(i).getMedEXP();
            row[6] = list.get(i).getMedComp();
            model.addRow(row);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtMedQTY = new javax.swing.JTextField();
        txtMedName = new javax.swing.JTextField();
        txtMedPrice = new javax.swing.JTextField();
        cmbCompany = new javax.swing.JComboBox<>();
        btnUpdate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMediList = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        cmbFabM = new javax.swing.JComboBox<>();
        cmbFabY = new javax.swing.JComboBox<>();
        txtFabD = new javax.swing.JTextField();
        cmbExpY = new javax.swing.JComboBox<>();
        cmbExpM = new javax.swing.JComboBox<>();
        txtExpD = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        jLabel5.setBackground(new java.awt.Color(153, 153, 255));
        jLabel5.setFont(new java.awt.Font("Gadugi", 1, 28)); // NOI18N
        jLabel5.setText("   Manage Medicine");
        jLabel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 51, 102), new java.awt.Color(0, 51, 102), null));

        jLabel6.setBackground(new java.awt.Color(204, 255, 255));
        jLabel6.setFont(new java.awt.Font("Gadugi", 1, 16)); // NOI18N
        jLabel6.setText("Med Name");

        jLabel8.setBackground(new java.awt.Color(204, 255, 255));
        jLabel8.setFont(new java.awt.Font("Gadugi", 1, 16)); // NOI18N
        jLabel8.setText("Price");

        jLabel9.setBackground(new java.awt.Color(204, 255, 255));
        jLabel9.setFont(new java.awt.Font("Gadugi", 1, 16)); // NOI18N
        jLabel9.setText("Quantity");

        jLabel10.setBackground(new java.awt.Color(204, 255, 255));
        jLabel10.setFont(new java.awt.Font("Gadugi", 1, 16)); // NOI18N
        jLabel10.setText("Company");

        jLabel11.setBackground(new java.awt.Color(204, 255, 255));
        jLabel11.setFont(new java.awt.Font("Gadugi", 1, 16)); // NOI18N
        jLabel11.setText("FAB Date");

        jLabel12.setBackground(new java.awt.Color(204, 255, 255));
        jLabel12.setFont(new java.awt.Font("Gadugi", 1, 16)); // NOI18N
        jLabel12.setText("EXP Date");

        txtMedName.setToolTipText("dfgfdg");

        btnUpdate.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 51, 102), new java.awt.Color(0, 51, 102), new java.awt.Color(0, 51, 102), new java.awt.Color(0, 51, 102)));
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });

        tblMediList.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        tblMediList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "MEDNAME", "MEDPRICE", "QUANTITY", "FABDATE", "EXPDATE", "COMPANY"
            }
        ));
        tblMediList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMediListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMediList);

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Gadugi", 1, 26)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 102));
        jLabel13.setText("   List Of Medicines");
        jLabel13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), java.awt.Color.black, java.awt.Color.black));

        btnDelete.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 51, 102), new java.awt.Color(0, 51, 102), new java.awt.Color(0, 51, 102), new java.awt.Color(0, 51, 102)));
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnAdd.setText("ADD");
        btnAdd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 51, 102), new java.awt.Color(0, 51, 102), new java.awt.Color(0, 51, 102), new java.awt.Color(0, 51, 102)));
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnClear.setText("CLEAR");
        btnClear.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 51, 102), new java.awt.Color(0, 51, 102), new java.awt.Color(0, 51, 102), new java.awt.Color(0, 51, 102)));
        btnClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClearMouseClicked(evt);
            }
        });

        cmbFabM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        cmbFabY.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" }));

        cmbExpY.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" }));

        cmbExpM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(224, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(210, 210, 210))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(311, 311, 311)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMedName, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMedQTY, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMedPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(101, 101, 101)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cmbFabY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbFabM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFabD, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cmbCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cmbExpY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbExpM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtExpD, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                        .addGap(251, 251, 251))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(328, 328, 328)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtMedName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtMedPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtMedQTY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cmbFabY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbFabM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFabD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(cmbExpY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbExpM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtExpD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cmbCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnClear))
                .addGap(72, 72, 72)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jLabel2.setBackground(new java.awt.Color(0, 0, 255));
        jLabel2.setFont(new java.awt.Font("Gadugi", 1, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 255));
        jLabel2.setText(" Company");

        jLabel3.setBackground(new java.awt.Color(0, 0, 255));
        jLabel3.setFont(new java.awt.Font("Gadugi", 1, 25)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 255, 255));
        jLabel3.setText(" Selling");

        jLabel4.setBackground(new java.awt.Color(0, 0, 255));
        jLabel4.setFont(new java.awt.Font("Gadugi", 1, 25)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 255, 255));
        jLabel4.setText(" Agent");

        jLabel14.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 255, 255));
        jLabel14.setText("X");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(26, 26, 26)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
//        FDate = FabDate.getdate();
//        MyFabdate = new java.sql.Date(FDate.getTime());
//        FDate = ExpDate.getDate();
//        MyExpDate = new java.sql.Date(EDate.getTime());
        String MyFabDate = cmbFabY.getSelectedItem().toString() + "-" + cmbFabM.getSelectedItem().toString() + "-" + txtFabD.getText();
        String MyExpDate = cmbExpY.getSelectedItem().toString() + "-" + cmbExpM.getSelectedItem().toString() + "-" + txtExpD.getText();

        try {
//            Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Pharmadb", "User1", "1234");
            PreparedStatement add = Con.prepareStatement("insert into medicine (medName, medPrice, medQTY, medFAB, medEXP, medComp) values(?,?,?,?,?,?)");
//            add.setInt(1, Integer.valueOf(txtMedID.getText()));
            add.setString(1, txtMedName.getText());
            add.setFloat(2, Integer.valueOf(txtMedPrice.getText()));
            add.setInt(3, Integer.valueOf(txtMedQTY.getText()));
            add.setString(4, MyFabDate);
            add.setString(5, MyExpDate);
            add.setString(6, cmbCompany.getSelectedItem().toString());
            int row = add.executeUpdate();
            JOptionPane.showMessageDialog(this, "Medicine Successfully Added");
//            Con.close();
            showMedicineList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        if (selectedMedID.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No medicine selected.");
        } else {
            try {
//                Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Pharmadb", "User1", "1234");
//                String Id = txtMedID.getText();
                String Query = "delete from medicine where medID = " + selectedMedID;
                Statement Add = Con.createStatement();
                Add.executeUpdate(Query);
                showMedicineList();
                JOptionPane.showMessageDialog(this, "Medicine Deleted Successfully");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void tblMediListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMediListMouseClicked
        DefaultTableModel model = (DefaultTableModel) tblMediList.getModel();
        int Myindex = tblMediList.getSelectedRow();
//        txtMedID.setText((model.getValueAt(Myindex, 0).toString()));
        selectedMedID = model.getValueAt(Myindex, 0).toString();
        txtMedName.setText((model.getValueAt(Myindex, 1).toString()));
        txtMedPrice.setText((model.getValueAt(Myindex, 2).toString()));
        txtMedQTY.setText((model.getValueAt(Myindex, 3).toString()));
        cmbCompany.setSelectedItem(model.getValueAt(Myindex, 6).toString());

        try {
            String strFabDate = model.getValueAt(Myindex, 4).toString();
            Date fabDate = new SimpleDateFormat("yyyy-MM-dd").parse(strFabDate);

            cmbFabY.setSelectedItem("20" + (fabDate.getYear() - 100));
            cmbFabM.setSelectedIndex(fabDate.getMonth());
            txtFabD.setText(fabDate.getDate() + "");

            String strExpDate = model.getValueAt(Myindex, 5).toString();
            Date expDate = new SimpleDateFormat("yyyy-MM-dd").parse(strExpDate);

            cmbExpY.setSelectedItem("20" + (expDate.getYear() - 100));
            cmbExpM.setSelectedIndex(expDate.getMonth());
            txtExpD.setText(expDate.getDate() + "");

        } catch (ParseException e) {

        }

//        System.out.println(model.getValueAt(Myindex, 4).toString());
//        System.out.println(model.getValueAt(Myindex, 5).toString());
    }//GEN-LAST:event_tblMediListMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        if (selectedMedID.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No medicine selected.");
        } else if (txtMedName.getText().isEmpty() || txtMedPrice.getText().isEmpty() || txtMedQTY.getText().isEmpty() || txtExpD.getText().isEmpty() || txtFabD.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Missing Information");
        } else {
            try {
//                FDate = FabDate.getdate();
//                MyFabdate = new java.sql.Date(FDate.getTime());
//                FDate = ExpDate.getDate();
//                MyExpDate = new java.sql.Date(EDate.getTime());
                String MyFabDate = cmbFabY.getSelectedItem().toString() + "-" + cmbFabM.getSelectedItem().toString() + "-" + txtFabD.getText();
                String MyExpDate = cmbExpY.getSelectedItem().toString() + "-" + cmbExpM.getSelectedItem().toString() + "-" + txtExpD.getText();
//                Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Pharmadb", "User1", "1234");
                String UpdateQuery = "update medicine set medName= '" + txtMedName.getText() + "'" + ", medPrice= " + txtMedPrice.getText() + "" + ", medQTY = " + txtMedQTY.getText() + "" + ", medFAB = '" + MyFabDate + "'" + ", medEXP = '" + MyExpDate + "'" + ", medComp = '" + cmbCompany.getSelectedItem().toString() + "'" + " where medID = " + selectedMedID;
                Statement Add = Con.createStatement();
                Add.executeUpdate(UpdateQuery);
                JOptionPane.showMessageDialog(this, "Medicine Updated Successfully");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        showMedicineList();
    }//GEN-LAST:event_btnUpdateMouseClicked

    private void btnClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMouseClicked
        // TODO add your handling code here:
        txtMedName.setText("");
        txtMedPrice.setText("");
        txtMedQTY.setText("");
        txtExpD.setText("");
        txtFabD.setText("");
        cmbCompany.setSelectedIndex(0);
        cmbExpM.setSelectedIndex(0);
        cmbExpY.setSelectedIndex(0);
        cmbFabM.setSelectedIndex(0);
        cmbFabY.setSelectedIndex(0);
    }//GEN-LAST:event_btnClearMouseClicked

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
            java.util.logging.Logger.getLogger(Medicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Medicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Medicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Medicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Medicine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbCompany;
    private javax.swing.JComboBox<String> cmbExpM;
    private javax.swing.JComboBox<String> cmbExpY;
    private javax.swing.JComboBox<String> cmbFabM;
    private javax.swing.JComboBox<String> cmbFabY;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMediList;
    private javax.swing.JTextField txtExpD;
    private javax.swing.JTextField txtFabD;
    private javax.swing.JTextField txtMedName;
    private javax.swing.JTextField txtMedPrice;
    private javax.swing.JTextField txtMedQTY;
    // End of variables declaration//GEN-END:variables

    private Object getSelectedItem() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void SelectMed() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
