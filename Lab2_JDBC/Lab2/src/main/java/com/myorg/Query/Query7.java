package com.myorg.Query;
import com.myorg.Connection.JDBC;

import java.sql.*;
import java.util.*;

public class Query7 {
    // Добавить нового Publisher, Добавить новую Titles, Добавить authorISBN
    public static void main(String[] args) {
        Statement stmt = null;
        try{

            JDBC.connect();
            stmt = JDBC.connection.createStatement();

            String query1 = "INSERT INTO publishers  (publisherName)" + "VALUES ('New Publisher')";
            String query2 = "INSERT INTO titles  (isbn, title, editionNumber, year, publisherID, price)"
                    + "VALUES (11223300, 'New Book', 11, '2010', (select publisherID from publishers where publisherName ='New Publisher'), 25.38) ";
            String query3 = "INSERT INTO authorisbn  (authorID, isbn)" +
                    "VALUES (31, (select isbn from titles where publisherID = (select publisherID from publishers where publisherName = 'New Publisher'))) ";
            String query4 = "SELECT *FROM publishers";

            System.out.println("Show all publishers:\n");
            stmt.executeUpdate(query1);
            stmt.executeUpdate(query2);
            stmt.executeUpdate(query3);
            ResultSet rs2 = stmt.executeQuery(query4);

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