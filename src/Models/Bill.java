package Models;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class Bill {

    DbConnection dbconn = new DbConnection();
    Connection conn = dbconn.getDbConnection();

    private int billID;
    private double total;
    private java.sql.Date date;
    private java.sql.Timestamp time;

    ArrayList<Bill_Item> billItems = new ArrayList<>();
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<Bill_Item> getBillItems() {
        return billItems;
    }

    public void setBillItems(ArrayList<Bill_Item> billItems) {
        this.billItems = billItems;
    }

    public void addBillItem(Bill_Item billItem) {
        this.billItems.add(billItem);
    }

    public boolean saveBill() {
        try {
            // Insert data to bill table
            String insertQuery = "insert into bill (total, date, time) values (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(insertQuery);

            // Get current date and time
            java.util.Date now = new java.util.Date();
            setDate(new java.sql.Date(now.getTime()));
            setTime(new java.sql.Timestamp(now.getTime()));

            stmt.setDouble(1, total);
            stmt.setDate(2, date);
            stmt.setTimestamp(3, time);

            if (stmt.executeUpdate() > 0) {
                // Get the bill id from the last inserted row
                try ( Statement st = conn.createStatement()) {
                    ResultSet rs = st.executeQuery("select billID from bill order by billID desc limit 1;");
                    rs.next();
                    setBillID(rs.getInt("billID")); // bill id of the last record
                }

                // Insert data into bill items table
                Bill_Item billItem;
                for (int i = 0; i < billItems.size(); i++) {
                    billItem = billItems.get(i);
                    billItem.setBillID(billID);

                    if (!billItem.saveBillItem()) {
                        return false;
                    }
                }

                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    // Get bill item list from database
    public ArrayList<Bill_Item> getBillItemList() {
        try {
            PreparedStatement stmt;
            ArrayList<Bill_Item> billItemList = new ArrayList<>();
            ResultSet rs;
            Bill_Item billItem = new Bill_Item();

            String getBillItemSql = "select * from bill_items where billID = ?";
            stmt = conn.prepareStatement(getBillItemSql);
            stmt.setInt(1, billID);

            rs = stmt.executeQuery();
            while (rs.next()) {
                // Set bill item details
                billItem.setMedID(rs.getInt("medID"));
                billItem.setQTY(rs.getInt("QTY"));

                // Add bill item to the bill item list
                billItemList.add(billItem);
            }

            return billItemList;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Bill getBill() {
        try {
            PreparedStatement stmt;
            ResultSet rs;
            Bill bill = new Bill();

            // Get bill data with billID
            String getBillSql = "select * from bill where billID = ?";
            stmt = conn.prepareStatement(getBillSql);
            stmt.setInt(1, billID);

            rs = stmt.executeQuery();
            rs.next();
            bill.setBillID(billID);
            bill.setTotal(rs.getDouble("total"));

            // Set bill item list
            bill.setBillItems(bill.getBillItemList());

            return bill;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
