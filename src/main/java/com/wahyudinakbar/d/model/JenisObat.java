package com.wahyudinakbar.d.model;

import com.wahyudinakbar.d.db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class JenisObat {
    private int id;
    private String namaJenisObat;
    private int stok;
    private int harga;
    
    public Database database;
    public Connection connection;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaJenisObat() {
        return namaJenisObat;
    }

    public void setNamaJenisObat(String namaJenisObat) {
        this.namaJenisObat = namaJenisObat;
    }
    
    public int getStok() {
        return stok;
    }
    
    public void setStok(int stok) {
        this.stok = stok;
    }
    
    public int getHarga() {
        return harga;
    }
    
    public void setHarga(int harga) {
        this.harga = harga;
    }
    
    public boolean create(){
        String insertSQL = "INSERT INTO jenis_obat VALUES (NULL,?,?,?)";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(insertSQL);
            ps.setString(1, this.getNamaJenisObat());
            ps.setInt(2, this.getStok());
            ps.setInt(3, this.getHarga());
            ps.execute();
            return true;
            
        } catch (SQLException ex) {
            System.out.println("Error SQL");
        }
        
        return false;
    }
    
    public boolean update(){
        String updateSQL = "UPDATE jenis_obat SET nama_obat = ?, stok = ?, harga = ? WHERE id_obat = ?";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(updateSQL);
            ps.setString(1, this.getNamaJenisObat());
            ps.setInt(2, this.getStok());
            ps.setInt(3, this.getHarga());
            ps.setInt(4, this.getId());
            ps.execute();
            return true;
            
        } catch (SQLException ex) {
            System.out.println("Error SQL");
        }
        
        return false;
    }
    
    public boolean delete(){
        String deleteSQL = "DELETE FROM jenis_obat WHERE id_obat = ?";
        
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
    
    public ArrayList<JenisObat> read(){
        String selectSQL = "SELECT * FROM jenis_obat";
        ArrayList<JenisObat> list = new ArrayList<>();
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(selectSQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                JenisObat jb = new JenisObat();
                jb.setId(rs.getInt(1));
                jb.setNamaJenisObat(rs.getString(2));
                jb.setStok(rs.getInt(3));
                jb.setHarga(rs.getInt(4));
                
                list.add(jb);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Error SQL");
        }
        
        
        return null;
    }
    
    public ArrayList<JenisObat> search(String keywords){
        String searchSQL = "SELECT * FROM jenis_obat WHERE nama_obat like ?";
        ArrayList<JenisObat> list = new ArrayList<>();
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        keywords = "%" + keywords + "%";
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(searchSQL);
            ps.setString(1, keywords);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                JenisObat jb = new JenisObat();
                jb.setId(rs.getInt(1));
                jb.setNamaJenisObat(rs.getString(2));
                jb.setStok(rs.getInt(3));
                jb.setHarga(rs.getInt(4));
                
                list.add(jb);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Error SQL");
        }
        
        
        return null;
    }
}
