package ca.nl.cna.java3.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Example to show the creation of a Database. Taken from JDBC Unit notes example "JDBCExample.java"
 */
public class FunCreatingDB {
    //Database parameters - "jdbc:mariadb" lets JDBC know to look for the Maria DB driver
    static final String DB_URL = "jdbc:mariadb://localhost:3307";
    //TODO Customize to your setup
    static final String USER = "root";
    static final String PASS = "DXmE4JsCpvmZTQ";

    public static void main(String[] args) {
        // Open a connection
        try(Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = connection.createStatement();
        ) {
            //If this Database already exists it will crash. You can "drop" it in the database view or use a drop query.
            String sql = "CREATE DATABASE STUDENTS";
            statement.executeUpdate(sql);
            System.out.println("Database created successfully...");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

