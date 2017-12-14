/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Verwaltung.persistenz.SQLite;

import Verwaltung.model.Anlage;
import Verwaltung.model.Antrag;
import Verwaltung.model.Ratsmitglied;
import Verwaltung.persistenz.AbstractAnlageDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sqlite.SQLiteConnection;

/**
 *
 * @author 89351
 */
public class SQLiteAnlageDAO extends AbstractAnlageDAO {

    public SQLiteAnlageDAO() {
    }

    @Override
    public boolean create(Anlage element) {
        return false;
    }

    @Override
    public Anlage read(int id) {
        Anlage anlage = null;
        try {
            Connection conn = SQLiteConnectionPool.instance().getConnection();
            String selectAnlagenSQL = "SELECT * FROM anlage where antragID=?";

            PreparedStatement preparedStatement = conn.prepareStatement(selectAnlagenSQL);
            preparedStatement.setInt(1, id);

            // execute insert SQL stetement
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int anlagenID = rs.getInt("id");
                String anlagenName = rs.getString("name");
                String anlagenPfad = rs.getString("lokalerPfad");
                int antragID = rs.getInt("antragID");

                anlage = new Anlage(anlagenID, anlagenName, anlagenPfad, antragID);

            }
            SQLiteConnectionPool.instance().returnConnection((SQLiteConnection) conn);
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteAnlageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return anlage;
    }

    @Override
    public ArrayList<Anlage> read() {
        ArrayList<Anlage> anlagen = new ArrayList();

        try {
            Connection conn = SQLiteConnectionPool.instance().getConnection();

            String selectAnlagenSQL = "SELECT * FROM anlage";
            PreparedStatement preparedStatement = conn.prepareStatement(selectAnlagenSQL);

            // execute insert SQL stetement
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int anlagenID = rs.getInt("id");
                String anlagenName = rs.getString("name");
                String anlagenPfad = rs.getString("lokalerPfad");
                int antragID = rs.getInt("antragID");

                Anlage anlage = new Anlage(anlagenID, anlagenName, anlagenPfad, antragID);
                anlagen.add(anlage);
            }
            SQLiteConnectionPool.instance().returnConnection((SQLiteConnection) conn);

        } catch (SQLException ex) {
            Logger.getLogger(SQLiteAnlageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  anlagen;
    }

    @Override
    public boolean update(Anlage element) {
        Connection conn = SQLiteConnectionPool.instance().getConnection();

        SQLiteConnectionPool.instance().returnConnection((SQLiteConnection) conn);
        return false;

    }

    @Override
    public boolean delete(int id) {
        Connection conn = SQLiteConnectionPool.instance().getConnection();

        SQLiteConnectionPool.instance().returnConnection((SQLiteConnection) conn);
        return false;
    }

}
