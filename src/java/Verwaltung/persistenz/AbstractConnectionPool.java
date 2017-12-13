/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Verwaltung.persistenz;

import java.sql.Connection;

/**
 *
 * @author 89473
 */
public abstract class AbstractConnectionPool<T extends Connection> {

    public static AbstractConnectionPool instance() {
        return null;
    }

    public abstract T getConnection();

    public abstract void returnConnection(T conn);

    protected abstract T createConnection();

    public abstract void closePool();
}
