package com.myorg.Query;
import com.myorg.Connection.JDBC;

import java.sql.*;
import java.util.*;

public class Query5 {
    // Добавить Нового автора в БД
    public static void main(String[] args) {
        Statement stmt = null;
        try{
            JDBC.connect();

            stmt = JDBC.connection.createStatement();
            String query1Author = "INSERT INTO authors " + "VALUES (123, 'Toto', 'Wolff')";
            String query2Author = "SELECT *FROM authors";

            System.out.println("Show all authors:\n");
            stmt.executeUpdate(query1Author);
            ResultSet rs2 = stmt.executeQuery(query2Author);

            while (rs2.next()) {
                int id = rs2.getInt("authorID");
                String firstName = rs2.getString("firstName");
                String lastName = rs2.getString("lastName");
                System.out.println(id + "\t" + firstName+ "\t" + lastName);
            }

        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } finally {
            //finally block used to close resources
            JDBC.close();
        }
    }
}