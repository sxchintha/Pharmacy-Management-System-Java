package Models;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class Medicine {

    DbConnection dbconn = new DbConnection();
    Connection conn = dbconn.getDbConnection();

    int medID, medQTY;
    String medName, medComp;
    java.sql.Date medEXP, medFAB;
    float medPrice;

    public Medicine() {
    }

    public int getMedID() {
        return medID;
    }

    public void setMedID(int medID) {
        this.medID = medID;
    }

    public int getMedQTY() {
        return medQTY;
    }

    public void setMedQTY(int medQTY) {
        this.medQTY = medQTY;
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public String getMedComp() {
        return medComp;
    }

    public void setMedComp(String medComp) {
        this.medComp = medComp;
    }

    public Date getMedEXP() {
        return medEXP;
    }

    public void setMedEXP(Date medEXP) {
        this.medEXP = medEXP;
    }

    public Date getMedFAB() {
        return medFAB;
    }

    public void setMedFAB(Date medFAB) {
        this.medFAB = medFAB;
    }

    public float getMedPrice() {
        return medPrice;
    }

    public void setMedPrice(float medPrice) {
        this.medPrice = medPrice;
    }

    public void updateQTY(int qty) {
        try {
            String updateSQL = "update medicine set medQTY = medQTY - ? where medID = ?";
            PreparedStatement stmt = conn.prepareStatement(updateSQL);

            stmt.setInt(1, qty);
            stmt.setInt(2, medID);

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
