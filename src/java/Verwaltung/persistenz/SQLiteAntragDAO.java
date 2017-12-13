/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Verwaltung.persistenz;

import Verwaltung.model.Anlage;
import Verwaltung.model.Antrag;
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
public class SQLiteAntragDAO extends AbstractAntragDAO {

    public SQLiteAntragDAO() {
    }

    @Override
    public boolean create(Antrag element) {
        int retAntrag = 0;
        int retAnlage = 0;
        try {
            Connection conn = SQLiteConnectionPool.instance().getConnection();
            conn.setAutoCommit(false);

            //Antrag Handling
            String insertAntragSQL = "INSERT INTO Antrag(gestelltam, personID, betreff,status,typ,details) VALUES(?,?,?,?,?,?,?)";

            PreparedStatement preparedStatement = conn.prepareStatement(insertAntragSQL);
            preparedStatement.setDate(1, (Date) element.getGestelltam());
            preparedStatement.setInt(2, element.getRatsmitglied().getId());
            preparedStatement.setString(3, element.getBetreff());
            preparedStatement.setBoolean(4, element.isAngenommen());
            preparedStatement.setString(5, element.getTyp());
            preparedStatement.setString(6, element.getDetails());
            // execute insert SQL stetement
            retAntrag = preparedStatement.executeUpdate();

            //Anlagen Handling
            for (Anlage anlage : element.getAnlagen()) {
                String insertAnlageSQL = "INSERT INTO anlage(name,lokalerPfad,antrag_id) VALUES(?,?,?)";

                preparedStatement = conn.prepareStatement(insertAnlageSQL);

                preparedStatement.setString(1, anlage.getName());
                preparedStatement.setString(2, anlage.getLokalerPfad());
                preparedStatement.setInt(3, anlage.getId());
                // execute insert SQL stetement
                retAnlage = preparedStatement.executeUpdate();
            }

            //Ratsmitglied Handling
            String insertRatsmitgliedSQL = "INSERT INTO ratsmitglied(vorname,nachname,telefonnr,email,straße,hausnummer,ort,gebDate,wahlperiode,fraktion,stadtratsarbeit) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

            preparedStatement = conn.prepareStatement(insertRatsmitgliedSQL);

            preparedStatement.setString(1, element.getRatsmitglied().getVname());
            preparedStatement.setString(2, element.getRatsmitglied().getNname());
            preparedStatement.setString(3, element.getRatsmitglied().getTelefon());
            preparedStatement.setString(4, element.getRatsmitglied().getEmail());
            preparedStatement.setString(5, element.getRatsmitglied().getAdresse());
            preparedStatement.setString(6, element.getRatsmitglied().getHausnr());
            preparedStatement.setString(7, element.getRatsmitglied().getBezirk());
            preparedStatement.setDate(8, element.getRatsmitglied().getGeburtstag());
            preparedStatement.setString(9, element.getRatsmitglied().getWahlperiode());
            preparedStatement.setString(10, element.getRatsmitglied().getFraktion());
            preparedStatement.setString(11, element.getRatsmitglied().getStadtratsarbeit());

            // execute insert SQL stetement
            retAnlage = preparedStatement.executeUpdate();

            conn.commit();
            conn.setAutoCommit(true);
            SQLiteConnectionPool.instance().returnConnection((SQLiteConnection) conn);
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteAntragDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retAntrag == 1 && retAnlage == 1;
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
                int antragsId = rs.getInt("id");
                Date gestelltam = rs.getDate("gestelltam");
                int gestelltvon = rs.getInt("personID");
                String betreff = rs.getString("betreff");
                boolean status = rs.getBoolean("status");
                String typ = rs.getString("typ");
                String details = rs.getString("details");

                Ratsmitglied rm = (Ratsmitglied) new SQLiteDAOFactory().createRatsmitgliedDAO().read(gestelltvon);

                ret = new Antrag(antragsId, gestelltam, rm, betreff, status, typ, details);
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
                int antragsId = rs.getInt("id");
                Date gestelltam = rs.getDate("gestelltam");
                int gestelltvon = rs.getInt("personID");
                String betreff = rs.getString("betreff");
                boolean status = rs.getBoolean("status");
                String typ = rs.getString("typ");
                String details = rs.getString("details");

                //Ratsmitglied Handling
                Ratsmitglied rm = (Ratsmitglied) new SQLiteDAOFactory().createRatsmitgliedDAO().read(gestelltvon);

                //Anlagen Handling
                //TODO:
                //ArrayList<Anlage> anlagen = (Anlage) new SQLiteDAOFactory().createAnlageDAO().read(antragsId);
                //antrag.setAnlagen(anlagen);
                /* String selectAnlagenSQL = "SELECT * FROM anlage where antragID=?";
                ArrayList<Anlage> anlagen= new ArrayList();
                preparedStatement = conn.prepareStatement(selectAnlagenSQL);
                preparedStatement.setInt(1, antrag.getanlageID());

                // execute insert SQL stetement
                rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    int anlagenID = rs.getInt("id");
                    String anlagenName = rs.getString("name");
                    String anlagenPfad = rs.getString("lokalerPfad");
                    int antragID = rs.getInt("antragID");

                    Anlage anlage = new Anlage(anlagenID, anlagenName, anlagenPfad,antragID);
                    anlagen.add(anlage);
                    
                }*/
                ret.add(new Antrag(antragsId, gestelltam, rm, betreff, status, typ, details));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteAntragDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        SQLiteConnectionPool.instance().returnConnection((SQLiteConnection) conn);
        return ret;
    }

    @Override
    public boolean update(Antrag element) {
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
