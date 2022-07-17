package com.myorg.Query;
import com.myorg.Connection.JDBC;

import java.sql.*;
import java.util.*;

public class Query1 {
// Сделать выборку по авторам, отсортировав по их Имени и Фамилии
    public static void main(String[] args) {
        Statement stmt = null;
        try{

            JDBC.connect();

            stmt = JDBC.connection.createStatement();
            String query1Author = "SELECT DISTINCT lastName, firstName FROM authors order by lastName asc";

            System.out.println("Show all authors:\n");
            ResultSet rs1 = stmt.executeQuery(query1Author);

            while (rs1.next()) {
                String firstName = rs1.getString("firstName");
                String lastName = rs1.getString("lastName");
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