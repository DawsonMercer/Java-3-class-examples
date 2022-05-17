package ca.nl.cna.java3.jdbc;

import java.sql.*;

/**
 * Get a simple result set from a Database and display it on scree.
 * <b>Note:</b> the database and data was created in advance.
 *
 * @author Josh
 */
public class FunWithSelectStatements {

    //Set up the Database Parameters
    static final String DB_URL = "jdbc:mariadb://localhost:3307/javatest";
    //TODO Customize to your setup
    static final String USER = "root";
    static final String PASS = "DXmE4JsCpvmZTQ";

    public static void main(String[] args) {
        // Open a connection
        try(
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = connection.createStatement();
        ){
            String sqlQuery = "SELECT * from testing";          //The Query

            //Execute the query and get the result set
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            System.out.print("ID \t\t\t TEST");
            while (resultSet.next()) {
                System.out.printf("\n%d \t\t\t %s",
                        resultSet.getInt("id"), resultSet.getString("test"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
