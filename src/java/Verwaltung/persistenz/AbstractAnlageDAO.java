/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Verwaltung.persistenz;

import Verwaltung.model.Anlage;
import Verwaltung.model.Antrag;
import java.util.ArrayList;

/**
 *
 * @author 89351
 */
public abstract class AbstractAnlageDAO implements AbstractDAO<Anlage>{
    @Override
    public abstract boolean create(Anlage element);

    @Override
    public abstract Anlage read(int id);

    @Override
    public abstract ArrayList<Anlage> read();

    @Override
    public abstract boolean update(Anlage element);

    @Override
    public abstract boolean delete(int id);

}