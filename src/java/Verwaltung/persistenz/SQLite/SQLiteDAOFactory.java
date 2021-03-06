/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Verwaltung.persistenz.SQLite;

import Verwaltung.persistenz.AbstractDAO;
import Verwaltung.persistenz.AbstractDAOFactory;

/**
 *
 * @author 89473
 */
public class SQLiteDAOFactory extends AbstractDAOFactory<AbstractDAO> {

    @Override
    public SQLiteAntragDAO createAntragDAO() {
        return new SQLiteAntragDAO();
    }

    @Override
    public SQLiteRatsmitgliedDAO createRatsmitgliedDAO() {
        return new SQLiteRatsmitgliedDAO();
    }
}