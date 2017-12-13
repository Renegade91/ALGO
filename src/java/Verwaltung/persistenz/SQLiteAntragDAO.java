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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sqlite.SQLiteConnection;

/**
 *
 * @author 89473
 */
public class SQLiteAntragDAO extends AbstractAntragDAO{
    
    public SQLiteAntragDAO(){}
    
    @Override
    public boolean create(Antrag element) {
        int retAntrag=0;
        int retAnlage=0;
        try {
            Connection conn = SQLiteConnectionPool.instance().getConnection();
            conn.setAutoCommit(false);
            
            
            //Antrag Handling
            String insertAntragSQL = "INSERT INTO Antrag(gestelltam, gestelltvon, betreff,status,typ,details) VALUES(?,?,?,?,?,?,?)";
            
            PreparedStatement preparedStatement = conn.prepareStatement(insertAntragSQL);
            preparedStatement.setDate(1, (Date) element.getGestelltam());
            preparedStatement.setInt(2, element.getGestelltvon().getId());
            preparedStatement.setString(3, element.getBetreff());
            preparedStatement.setBoolean(4, element.isAngenommen());
            preparedStatement.setString(5, element.getTyp());
            preparedStatement.setString(6, element.getDetails());    
            // execute insert SQL stetement
            retAntrag = preparedStatement.executeUpdate();
            
            //Anlagen Handling
            for (Anlage anlage: element.getAnlagen()) {
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

            preparedStatement.setString(1, element.getGestelltvon().getVname());
            preparedStatement.setString(2, element.getGestelltvon().getNname());
            preparedStatement.setString(3, element.getGestelltvon().getTelefon());
            preparedStatement.setString(4, element.getGestelltvon().getEmail());
            preparedStatement.setString(5, element.getGestelltvon().getAdresse());
            preparedStatement.setString(6, element.getGestelltvon().getHausnr());
            preparedStatement.setString(7, element.getGestelltvon().getBezirk());
            preparedStatement.setDate(8, element.getGestelltvon().getGeburtstag());
            preparedStatement.setString(9, element.getGestelltvon().getWahlperiode());
            preparedStatement.setString(10, element.getGestelltvon().getFraktion());
            preparedStatement.setString(11, element.getGestelltvon().getStadtratsarbeit());
             
              // execute insert SQL stetement
            retAnlage = preparedStatement.executeUpdate();
                        
            conn.commit();
            conn.setAutoCommit(true);
            SQLiteConnectionPool.instance().returnConnection((SQLiteConnection) conn);
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteAntragDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retAntrag==1 && retAnlage ==1;
    }

    @Override
    public Antrag read(int id) {
            Connection conn = SQLiteConnectionPool.instance().getConnection();
            Antrag ret = null;
            Ratsmitglied teilErg = null;
            String selectAntragSQL = "SELECT FROM antrag * where id=?";
            int antragsId=0;
            int gestelltvon=0;
        try {

            
            PreparedStatement preparedStatement = conn.prepareStatement(selectAntragSQL);
            preparedStatement.setInt(1, id);  
            
  
            
            // execute insert SQL stetement
            ResultSet rs =  preparedStatement.executeQuery();
            while(rs.next()){
                antragsId  = rs.getInt("id");
                Date gestelltam = rs.getDate("gestelltam");
                gestelltvon = rs.getInt("gestelltvon");
                String betreff = rs.getString("betreff");
                String status = rs.getString("status");
                String typ = rs.getString("typ");
                String dokumente = rs.getString("dokumente");
                String details = rs.getString("details");
                
                ret = new Antrag(antragsId, gestelltam, null, betreff, typ, details);
            }
            
            
            if(gestelltvon != 0){
            String selectRatsmitgliedSQL = "SELECT FROM ratsmitglied * where id=?";
            
            preparedStatement = conn.prepareStatement(selectRatsmitgliedSQL);
            preparedStatement.setInt(1, gestelltvon);
            
            rs = preparedStatement.executeQuery();
            while(rs.next()){
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
               
               teilErg = new Ratsmitglied(wahlperiode, fraktion, stadtratsarbeit, idTeilErg, vname, nname, telefonnr, email, straße, hausnummer, gebDate, ort);
   
            }
            
            ret.setGestelltvon(teilErg);
            
            }
            
            SQLiteConnectionPool.instance().returnConnection((SQLiteConnection) conn);
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteAntragDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    @Override
    public List<Antrag> read() {
        Connection conn = SQLiteConnectionPool.instance().getConnection();
        
        SQLiteConnectionPool.instance().returnConnection((SQLiteConnection) conn);
     return null;

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
