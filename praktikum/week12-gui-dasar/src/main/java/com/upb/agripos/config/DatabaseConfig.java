package com.upb.agripos.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    public static Connection getConnection() throws SQLException {
        // Nama database harus 'agripos' sesuai settinganmu
        String url = "jdbc:postgresql://localhost:5432/agripos";
        String user = "postgres";
        
        // GANTI INI dengan password yang kamu pakai saat instal PostgreSQL
        String password = " "; 
        
        return DriverManager.getConnection(url, user, password);
    }
}