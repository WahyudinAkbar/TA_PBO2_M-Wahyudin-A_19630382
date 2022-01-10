package com.wahyudinakbar.d.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

   private final String URL = "jdbc:mysql://localhost:3306/";
    private final String DB_NAME = "project_apotek";
    private final String USER = "root";
    private final String PASS = "";
    
    public Connection getConnection(){
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL+DB_NAME, USER, PASS);
            System.out.println("Koneksi Berhasil");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.toString());
        }
        return con;
    }

}
