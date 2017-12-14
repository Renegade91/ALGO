/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Verwaltung.persistenz.SQLite;

import Verwaltung.model.Antrag;
import Verwaltung.model.Ratsmitglied;
import Verwaltung.persistenz.AbstractAntragDAO;
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
 * @author 89473
 */
public class SQLiteAntragDAO extends AbstractAntragDAO {

    @Override
    public boolean create(Antrag element) {
        // Not yet implemented
        return false;
    }

    @Override
    public Antrag read(int id) {
        Connection conn = SQLiteConnectionPool.instance().getConnection();
        Antrag ret = null;

        try {
            String selectAntragSQL = "SELECT * FROM antrag where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(selectAntragSQL);
            preparedStatement.setInt(1, id);

            // execute insert SQL stetement
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ret = DBtoClass(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteAntragDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        SQLiteConnectionPool.instance().returnConnection((SQLiteConnection) conn);
        return ret;
    }

    @Override
    public ArrayList<Antrag> read() {
        Connection conn = SQLiteConnectionPool.instance().getConnection();
        ArrayList<Antrag> ret = new ArrayList();

        try {
            String selectAntragSQL = "SELECT * FROM antrag";
            PreparedStatement preparedStatement = conn.prepareStatement(selectAntragSQL);

            // execute insert SQL stetement
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ret.add(DBtoClass(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteAntragDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        SQLiteConnectionPool.instance().returnConnection((SQLiteConnection) conn);
        return ret;
    }

    private Antrag DBtoClass(ResultSet rs) throws SQLException {
        int antragsId   = rs.getInt("id");
        Date gestelltam = rs.getDate("gestelltam");
        int gestelltvon = rs.getInt("personID");
        String betreff  = rs.getString("betreff");
        boolean status  = rs.getBoolean("status");
        String typ      = rs.getString("typ");
        String details  = rs.getString("details");

        Ratsmitglied rm = (Ratsmitglied) new SQLiteDAOFactory().createRatsmitgliedDAO().read(gestelltvon);

        return new Antrag(antragsId, gestelltam, rm, betreff, status, typ, details);
    }

    @Override
    public boolean update(Antrag element) {
        // Not yet implemented
        return false;
    }

    @Override
    public boolean delete(int id) {
        // Not yet implemented
        return false;
    }

}
