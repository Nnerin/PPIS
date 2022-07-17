package com.myorg.Query;
import com.myorg.Connection.JDBC;

import java.sql.*;
import java.util.*;

public class Query4 {
    // Предоставьте отсортированный список книг определенного издателя
    // (при этом id требуемого издателя можно менять в sql запросе)
    public static void main(String[] args) {
        Statement stmt = null;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Publisher from 1 to 22");
        int publisherNumber = in.nextInt();

        try{

            JDBC.connect();

            stmt = JDBC.connection.createStatement();
            String queryBooks = "SELECT title FROM titles where publisherID in ("+publisherNumber+") order by title asc";

            System.out.println("All books:\n");
            ResultSet rs2 = stmt.executeQuery(queryBooks);

            while (rs2.next()) {
                String books = rs2.getString("title");
                System.out.println(books);

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
