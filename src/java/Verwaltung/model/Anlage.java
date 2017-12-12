/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Verwaltung.model;

/**
 *
 * @author 89473
 */
public class Anlage {
    int id;
    String name;
    String lokalerPfad;

    public Anlage(int id, String name, String lokalerPfad) {
        this.id = id;
        this.name = name;
        this.lokalerPfad = lokalerPfad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLokalerPfad() {
        return lokalerPfad;
    }

    public void setLokalerPfad(String lokalerPfad) {
        this.lokalerPfad = lokalerPfad;
    }
    
    
}
