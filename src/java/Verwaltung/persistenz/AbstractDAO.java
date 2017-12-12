/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Verwaltung.persistenz;

import java.util.List;

/**
 *
 * @author 89473
 */
public interface AbstractDAO<T> {
    public abstract boolean create(T element);
    public abstract T read(String id);
    public abstract List<T> read();
    public abstract boolean update(T element);
    public abstract boolean delete(String id);
}
