/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Verwaltung.persistenz;

import Verwaltung.model.Ratsmitglied;
import java.util.ArrayList;

/**
 *
 * @author 89473
 */
public abstract class AbstractRatsmitgliedDAO implements AbstractDAO<Ratsmitglied>{

    @Override
    public abstract boolean create(Ratsmitglied element);

    @Override
    public abstract Ratsmitglied read(int id);

    @Override
    public abstract ArrayList<Ratsmitglied> read();

    @Override
    public abstract boolean update(Ratsmitglied element);

    @Override
    public abstract boolean delete(int id);
    
}
