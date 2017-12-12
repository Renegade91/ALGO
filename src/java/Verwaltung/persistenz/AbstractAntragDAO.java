/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Verwaltung.persistenz;

import Verwaltung.model.Antrag;
import java.util.List;

/**
 *
 * @author 89473
 */
public abstract class AbstractAntragDAO implements AbstractDAO<Antrag> {
    
    @Override
    public abstract boolean create(Antrag element);
    @Override
    public abstract Antrag read(String id);
    @Override
    public abstract List<Antrag> read();
    @Override
    public abstract boolean update(Antrag element);
    @Override
    public abstract boolean delete(String id);
    
    
}
