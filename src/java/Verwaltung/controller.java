/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Verwaltung;
        
import Verwaltung.model.*;
import Verwaltung.persistenz.AbstractDAOFactory;
import Verwaltung.persistenz.SQLiteDAOFactory;
import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author 89388
 */
public class controller {factory
    
    private static final controller instance = new controller();
    private AbstractDAOFactory factory;
    
    private controller() {
        factory = new SQLiteDAOFactory();
    }
    
    public static controller instance(){
        return instance;
    }
    
    public Ratsmitglied getRatsmitglied(int id) {
        // hier muss der dao call hin
        Antrag antrag = (Antrag) factory.createAntragDAO().read(id);
        Ratsmitglied rm = antrag.getGestelltvon();
                
                /*new Ratsmitglied(
                "5",
                "Bauer",
                "NEIN",
                1, 
                "Peter", 
                "Griffin", 
                "telefon", 
                "email", 
                "adresse", 
                "hausnr", 
                Date.valueOf("2020-12-12"), 
                "bezirk"
        );*/
        
        return rm;
    }
 
    public Antrag getAntrag(int id) {
        // hier muss der dao call hin
        
        Ratsmitglied rm = getRatsmitglied(id);
        
        Antrag data = new Antrag(
                1, 
                Date.valueOf("2020-12-12"), 
                rm, 
                "Verschrottung des Denkmals", 
                "Langweilig", 
                "none"
        );
        
        return data;
    }
    
    public ArrayList<Antrag> getAntragAlle() {
        // hier muss der dao call hin

        Antrag single = getAntrag(1);
        
        ArrayList<Antrag> data = new ArrayList<>();
        
        data.add(single);
        data.add(single);
        data.add(single);
        
        return data;
    }
}
