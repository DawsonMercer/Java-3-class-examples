package ca.nl.cna.java3.jdbc;

import java.sql.*;

public class JDBCExample {
    static final String DB_URL = "jdbc:mariadb://localhost:3307/javatest";

    //TODO Customize to your setup
    static final String USER = "root";
    static final String PASS = "DXmE4JsCpvmZTQ";

    public static void main(String[] args) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            String sql = "SELECT * from testing";
            stmt.executeUpdate(sql);


            ResultSet resultSet = stmt.getResultSet();
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = resultSet.getString(i);
                    System.out.print(columnValue + " " + rsmd.getColumnName(i));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
