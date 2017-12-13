/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Verwaltung.persistenz;

/**
 *
 * @author 89473
 */
public abstract class AbstractDAOFactory<T extends AbstractDAO> {

    public abstract T createAntragDAO();
    public abstract T createRatsmitgliedDAO();
}
