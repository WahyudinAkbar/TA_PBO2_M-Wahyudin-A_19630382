package com.wahyudinakbar;

import com.wahyudinakbar.d.db.Database;
import com.wahyudinakbar.d.frame.Login;
import com.wahyudinakbar.d.frame.admin.MainAdmin;
import com.wahyudinakbar.d.kasir.MainKasir;
import com.wahyudinakbar.d.libs.Pref;
import java.sql.Connection;

public class Main {
public static void main(String[] args) {
        
        Pref pref = new Pref();
        
        String username = pref.getUsername();
        
        if(username.equals("")){
            Login login = new Login();
            login.setVisible(true);
        } else {
            if (pref.isAdmin()){
                MainAdmin mainAdmin = new MainAdmin();
                mainAdmin.setVisible(true);
            } else {
                MainKasir mainKasir = new MainKasir();
                mainKasir.setVisible(true);
            }
            
        }
}
}
