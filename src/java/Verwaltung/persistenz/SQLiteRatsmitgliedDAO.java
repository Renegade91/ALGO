/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Verwaltung.persistenz;

import Verwaltung.model.Ratsmitglied;
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
        int retAnlage = 0;
        try {
            Connection conn = SQLiteConnectionPool.instance().getConnection();

            String insertRatsmitgliedSQL = "INSERT INTO ratsmitglied(vorname,nachname,telefonnr,email,straße,hausnummer,ort,gebDate,wahlperiode,fraktion,stadtratsarbeit) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement preparedStatement = conn.prepareStatement(insertRatsmitgliedSQL);

            preparedStatement.setString(1, element.getVname());
            preparedStatement.setString(2, element.getNname());
            preparedStatement.setString(3, element.getTelefon());
            preparedStatement.setString(4, element.getEmail());
            preparedStatement.setString(5, element.getAdresse());
            preparedStatement.setString(6, element.getHausnr());
            preparedStatement.setString(7, element.getBezirk());
            preparedStatement.setDate(8, element.getGeburtstag());
            preparedStatement.setString(9, element.getWahlperiode());
            preparedStatement.setString(10, element.getFraktion());
            preparedStatement.setString(11, element.getStadtratsarbeit());

            // execute insert SQL stetement
            retAnlage = preparedStatement.executeUpdate();

            SQLiteConnectionPool.instance().returnConnection((SQLiteConnection) conn);
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteRatsmitgliedDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retAnlage == 1;
    }

    @Override
    public Ratsmitglied read(int id) {
        Ratsmitglied ret = null;
        try {
            Connection conn = SQLiteConnectionPool.instance().getConnection();

            String selectRatsmitgliedSQL = "SELECT * FROM ratsmitglied where id=?";

            PreparedStatement preparedStatement = conn.prepareStatement(selectRatsmitgliedSQL);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idTeilErg = rs.getInt("id");
                String vname = rs.getString("vorname");
                String nname = rs.getString("nachname");
                String telefonnr = rs.getString("telefonnr");
                String email = rs.getString("email");
                String straße = rs.getString("straße");
                String hausnummer = rs.getString("hausnummer");
                String ort = rs.getString("ort");
                Date gebDate = rs.getDate("gebDate");
                String wahlperiode = rs.getString("wahlperiode");
                String fraktion = rs.getString("fraktion");
                String stadtratsarbeit = rs.getString("stadtratsarbeit");

                ret = new Ratsmitglied(wahlperiode, fraktion, stadtratsarbeit, idTeilErg, vname, nname, telefonnr, email, straße, hausnummer, gebDate, ort);

            }

            SQLiteConnectionPool.instance().returnConnection((SQLiteConnection) conn);
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteRatsmitgliedDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    @Override
    public ArrayList<Ratsmitglied> read() {
        Connection conn = SQLiteConnectionPool.instance().getConnection();

        SQLiteConnectionPool.instance().returnConnection((SQLiteConnection) conn);
        return null;
    }

    @Override
    public boolean update(Ratsmitglied element) {
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
