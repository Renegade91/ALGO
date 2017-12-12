/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Verwaltung.persistenz;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sqlite.SQLiteConnection;

/**
 *
 * @author 89473
 */
public class SQLiteConnectionPool extends AbstractConnectionPool<SQLiteConnection>{
    private static final int MAX_CONNECTIONS = 5;
    private static SQLiteConnectionPool instance = null;
    private final Stack<SQLiteConnection> myDBStack = new Stack();
    
    String host = "jdbc:sqlite:" + System.getProperty("user.home") + "/Documents/NetBeansProjects/ALGO/sqlite/" + "stadtrat.db";
    String user = "";
    String password = "";
    
    public static synchronized SQLiteConnectionPool instance(){
        if(instance == null){
            instance = new SQLiteConnectionPool();
        }
        return instance;
    }
    
    private SQLiteConnectionPool(){   
    }
    
    @Override
    public synchronized SQLiteConnection getConnection(){
        SQLiteConnection conn;
        if(myDBStack.empty()){
            conn = createConnection();
        }else{
            conn = myDBStack.pop();
        }
        return conn;
    }
    @Override
    public synchronized void returnConnection(SQLiteConnection conn){
        try {
            if(conn != null && conn.isValid(200)){
                conn.commit();
                if(myDBStack.size() < MAX_CONNECTIONS){
                    myDBStack.push(conn);
                }else{
                    conn.close();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    protected synchronized SQLiteConnection createConnection(){
        SQLiteConnection conn = null;
        try{
            conn = (SQLiteConnection) DriverManager.getConnection(host);
        }catch(SQLException e){
            
        }
        return conn;
    }
    
    @Override
    public synchronized void closePool(){
        myDBStack.stream().forEach((conn) -> {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(SQLiteConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
}
