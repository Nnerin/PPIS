package com.myorg.Query;
import com.myorg.Connection.JDBC;

import java.sql.*;
import java.util.*;

public class Query2 {
    // Добавить нового Издателя (publisher).
    public static void main(String[] args) {
        Statement stmt = null;
        try{

            JDBC.connect();

            stmt = JDBC.connection.createStatement();
            String query1Publisher = "INSERT INTO publishers  (publisherName)" + "VALUES ('My New Publisher')";
            String query2Publisher = "SELECT *FROM publishers";

            System.out.println("Show all publishers:\n");
            stmt.executeUpdate(query1Publisher);
            ResultSet rs2 = stmt.executeQuery(query2Publisher);

            while (rs2.next()) {
                int id = rs2.getInt("publisherID");
                String pubName = rs2.getString("publisherName");
                System.out.println(id + "\t" + pubName);
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