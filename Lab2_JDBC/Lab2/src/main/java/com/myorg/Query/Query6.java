package com.myorg.Query;
import com.myorg.Connection.JDBC;

import java.sql.*;
import java.util.*;

public class Query6 {
    // Обновить Имя автора по определенному id
    public static void main(String[] args) {
        Statement stmt = null;
//        Scanner in = new Scanner(System.in);
//        System.out.println("Enter Author from 1 to 123");
//        int publisherNumber = in.nextInt();

        try{
            JDBC.connect();

            stmt = JDBC.connection.createStatement();
            String query1Author = "UPDATE authors " + "SET firstName = 'Changed firstName', lastName = 'Changed lastName' " +
                    "WHERE authorID in (123)";
            String query2Author = "SELECT DISTINCT lastName, firstName FROM authors";

            System.out.println("All Authors:\n");
            stmt.executeUpdate(query1Author);
            ResultSet rs2 = stmt.executeQuery(query2Author);

            while (rs2.next()) {
                String firstName = rs2.getString("firstName");
                String lastName = rs2.getString("lastName");
                System.out.println(firstName + "\t" + lastName);
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