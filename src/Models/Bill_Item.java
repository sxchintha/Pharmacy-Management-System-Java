package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Bill_Item {

    DbConnection dbconn = new DbConnection();
    Connection conn = dbconn.getDbConnection();

    private int billID, medID, QTY;
    private String medName;
    private float medPrice;

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public int getMedID() {
        return medID;
    }

    public void setMedID(int medID) {
        this.medID = medID;
    }

    public int getQTY() {
        return QTY;
    }

    public void setQTY(int QTY) {
        this.QTY = QTY;
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public float getMedPrice() {
        return medPrice;
    }

    public void setMedPrice(float medPrice) {
        this.medPrice = medPrice;
    }

    public boolean saveBillItem() {
        try {
            PreparedStatement stmt;

            String billItemSql = "insert into bill_items (billID, medID, medName, medPrice, QTY) values (?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(billItemSql);
            stmt.setInt(1, billID);
            stmt.setInt(2, medID);
            stmt.setString(3, medName);
            stmt.setFloat(4, medPrice);
            stmt.setInt(5, QTY);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
