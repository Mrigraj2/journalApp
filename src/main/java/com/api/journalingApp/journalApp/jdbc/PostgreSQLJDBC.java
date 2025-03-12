package com.api.journalingApp.journalApp.jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PostgreSQLJDBC {
    public static void insertData(Connection conn) {
        String insertSQL = "INSERT INTO your_table (column1, column2) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, "Value1");
            pstmt.setString(2, "Value2");
            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) inserted.");
        } catch (SQLException e) {
            System.err.println("Insert operation failed!");
            e.printStackTrace();
        }
    }
}
