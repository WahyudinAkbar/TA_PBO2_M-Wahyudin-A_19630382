package com.wahyudinakbar.d.model;

import com.wahyudinakbar.d.db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pengguna {
   private int id;
   private String username;
   private String password;
   private String namaLengkap;
   private boolean isAdmin;
   
   private Connection connection;
   private Database database;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
   
    public boolean login(){
        String loginSql = "SELECT * FROM pengguna WHERE username = ? AND password = MD5(?)";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
       try {
           PreparedStatement preparedStatement = this.connection.prepareStatement(loginSql);
           preparedStatement.setString(1,this.username);
           preparedStatement.setString(2,this.password);
           ResultSet resultSet = preparedStatement.executeQuery();
           
           while(resultSet.next()){
               this.id = resultSet.getInt(1);
               this.username = resultSet.getString(2);
               this.namaLengkap = resultSet.getString(4);
               this.isAdmin = resultSet.getBoolean(5);
               return true;
           }
       } catch (SQLException ex) {
           Logger.getLogger(Pengguna.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       return false;
    }
    
    public boolean create(){
        String insertSQL = "INSERT INTO pengguna VALUES (NULL,?,?,?,0)";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(insertSQL);
            ps.setString(1, this.getUsername());
            ps.setString(2, this.getPassword());
            ps.setString(3, this.getNamaLengkap());
            ps.execute();
            return true;
            
        } catch (SQLException ex) {
            System.out.println("Error SQL");
        }
        
        return false;
    }
    
    public boolean update(){
        String updateSQL = "UPDATE pengguna SET username = ?, password = ?, namalengkap = ? WHERE id = ?";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(updateSQL);
            ps.setString(1, this.getUsername());
            ps.setString(2, this.getPassword());
            ps.setString(3, this.getNamaLengkap());
            ps.setInt(4, this.getId());
            ps.execute();
            return true;
            
        } catch (SQLException ex) {
            System.out.println("Error SQL");
        }
        
        return false;
    }
    
    public boolean delete(){
        String deleteSQL = "DELETE FROM pengguna WHERE id = ?";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(deleteSQL);
            ps.setInt(1, this.getId());
            ps.execute();
            return true;
            
        } catch (SQLException ex) {
            System.out.println("Error SQL");
        }
        
        return false;
    }
    
    public ArrayList<Pengguna> read(){
        String selectSQL = "SELECT * FROM pengguna WHERE isadmin = 0";
        ArrayList<Pengguna> list = new ArrayList<>();
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(selectSQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                Pengguna jb = new Pengguna();
                jb.setId(rs.getInt(1));
                jb.setUsername(rs.getString(2));
                jb.setPassword(rs.getString(3));
                jb.setNamaLengkap(rs.getString(4));
                
                list.add(jb);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Error SQL");
        }
        
        
        return null;
    }
    
    public ArrayList<Pengguna> search(String keywords){
        String searchSQL = "SELECT * FROM pengguna WHERE namalengkap like ?";
        ArrayList<Pengguna> list = new ArrayList<>();
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        keywords = "%" + keywords + "%";
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(searchSQL);
            ps.setString(1, keywords);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                Pengguna jb = new Pengguna();
                jb.setId(rs.getInt(1));
                jb.setUsername(rs.getString(2));
                jb.setPassword(rs.getString(3));
                jb.setNamaLengkap(rs.getString(4));
                
                list.add(jb);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Error SQL");
        }
        
        
        return null;
    } 
    
 }
