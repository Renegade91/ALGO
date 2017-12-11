package Verwaltung;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 89388
 */

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconn {
    
    // createNewDatabase("test.db");
    public static void createNewDatabase(String fileName) {
        String url = "jdbc:sqlite:C:/Users/89388/Documents/NetBeansProjects/ALGO/sqlite/" + fileName;
 
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
