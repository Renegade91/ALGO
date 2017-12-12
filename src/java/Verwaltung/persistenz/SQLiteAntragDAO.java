/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Verwaltung.persistenz;

import Verwaltung.model.Antrag;
import java.sql.Connection;
import java.util.List;
import org.sqlite.SQLiteConnection;

/**
 *
 * @author 89473
 */
public class SQLiteAntragDAO extends AbstractAntragDAO{
    
    
    
    @Override
    public boolean create(Antrag element) {
        Connection conn = SQLiteConnectionPool.instance().getConnection();
        
        SQLiteConnectionPool.instance().returnConnection((SQLiteConnection) conn);
    }

    @Override
    public Antrag read(String id) {
        Connection conn = SQLiteConnectionPool.instance().getConnection();
        
        SQLiteConnectionPool.instance().returnConnection((SQLiteConnection) conn);
    }

    @Override
    public List<Antrag> read() {
        Connection conn = SQLiteConnectionPool.instance().getConnection();
        
        SQLiteConnectionPool.instance().returnConnection((SQLiteConnection) conn);
    }

    @Override
    public boolean update(Antrag element) {
        Connection conn = SQLiteConnectionPool.instance().getConnection();
        
        SQLiteConnectionPool.instance().returnConnection((SQLiteConnection) conn);
    }

    @Override
    public boolean delete(String id) {
        Connection conn = SQLiteConnectionPool.instance().getConnection();
        
        SQLiteConnectionPool.instance().returnConnection((SQLiteConnection) conn);
    }
    
}
