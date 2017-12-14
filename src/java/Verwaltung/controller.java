/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Verwaltung;

import Verwaltung.persistenz.SQLite.SQLiteDAOFactory;
import Verwaltung.model.*;
import Verwaltung.persistenz.*;
import java.util.ArrayList;

/**
 *
 * @author 89388
 */
public class controller {

    private static final controller instance = new controller("SQLite3");
    private final AbstractDAOFactory factory;

    public static controller instance() {
        return instance;
    }

    private controller(String DBtype) {
        switch (DBtype) {
            case "SQLite3":
                factory = new SQLiteDAOFactory();
                break;
            case "Oracle":
                //factory = new OracleDAOFactory();
                throw new RuntimeException("Oracle DB is not supported !!!");
            default:
                throw new IllegalArgumentException(DBtype + " is an unkown database type.");
        }
    }

    public Ratsmitglied getRatsmitglied(int id) {
        Ratsmitglied rm = (Ratsmitglied) factory.createRatsmitgliedDAO().read(id);

        return rm;
    }

    public Antrag getAntrag(int id) {
        Antrag antrag = (Antrag) factory.createAntragDAO().read(id);

        return antrag;
    }

    public ArrayList<Antrag> getAntragAlle() {
        ArrayList<Antrag> data = factory.createAntragDAO().read();

        return data;
    }
}
