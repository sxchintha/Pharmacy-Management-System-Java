package Models;

import java.sql.*;

public class DbConnection {

    private Connection cn;

    public Connection getDbConnection() {
        try {
            String dbpath = "jdbc:mysql://localhost:3306/pharmacy_management?useSSL=false";
            cn = DriverManager.getConnection(dbpath, "root", "root");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cn;
    }

}
