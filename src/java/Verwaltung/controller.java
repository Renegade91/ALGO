/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Verwaltung;

import Verwaltung.model.*;
import Verwaltung.persistenz.*;
import java.util.ArrayList;

/**
 *
 * @author 89388
 */
public class controller {

    private static final controller instance = new controller();
    private final AbstractDAOFactory factory;

    private controller() {
        factory = new SQLiteDAOFactory();
    }

    public static controller instance() {
        return instance;
    }

    public Ratsmitglied getRatsmitglied(int id) {
        Ratsmitglied rm = (Ratsmitglied) factory.createRatsmitgliedDAO().read(id);

        /*
        Ratsmitglied rm = new Ratsmitglied(
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
        );
         */
        return rm;
    }

    public Antrag getAntrag(int id) {
        Antrag antrag = (Antrag) factory.createAntragDAO().read(id);

        /*Antrag data = new Antrag(
                1, 
                Date.valueOf("2020-12-12"), 
                rm, 
                "Verschrottung des Denkmals", 
                "Langweilig", 
                "none"
        );*/
        return antrag;
    }

    public ArrayList<Antrag> getAntragAlle() {
        ArrayList<Antrag> data = factory.createAntragDAO().read();

        return data;
    }
}
