/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Verwaltung.persistenz.SQLite;

import Verwaltung.model.Ratsmitglied;
import Verwaltung.persistenz.AbstractRatsmitgliedDAO;
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
public class SQLiteRatsmitgliedDAO extends AbstractRatsmitgliedDAO {

    @Override
    public boolean create(Ratsmitglied element) {
        // Not yet implemented
        return false;
    }

    @Override
    public Ratsmitglied read(int id) {
        Connection conn = SQLiteConnectionPool.instance().getConnection();
        Ratsmitglied ret = null;

        try {
            String selectRatsmitgliedSQL = "SELECT * FROM ratsmitglied where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(selectRatsmitgliedSQL);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ret = DBtoClass(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteRatsmitgliedDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        SQLiteConnectionPool.instance().returnConnection((SQLiteConnection) conn);
        return ret;
    }

    @Override
    public ArrayList<Ratsmitglied> read() {
        // Not yet implemented
        return null;
    }

    private Ratsmitglied DBtoClass(ResultSet rs) throws SQLException {
        int idTeilErg          = rs.getInt("id");
        String vname           = rs.getString("vorname");
        String nname           = rs.getString("nachname");
        String telefonnr       = rs.getString("telefonnr");
        String email           = rs.getString("email");
        String straße          = rs.getString("straße");
        String hausnummer      = rs.getString("hausnummer");
        String ort             = rs.getString("ort");
        Date gebDate           = rs.getDate("gebDate");
        String wahlperiode     = rs.getString("wahlperiode");
        String fraktion        = rs.getString("fraktion");
        String stadtratsarbeit = rs.getString("stadtratsarbeit");

        return new Ratsmitglied(wahlperiode, fraktion, stadtratsarbeit, idTeilErg, vname, nname, telefonnr, email, straße, hausnummer, gebDate, ort);
    }

    @Override
    public boolean update(Ratsmitglied element) {
        // Not yet implemented
        return false;
    }

    @Override
    public boolean delete(int id) {
        // Not yet implemented
        return false;
    }

}
