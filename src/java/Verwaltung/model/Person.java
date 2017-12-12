/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Verwaltung.model;

import java.util.Date;

/**
 *
 * @author 89473
 */
public abstract class Person {
    
    String id;
    String vname, nname;
    String telefon, email, adresse;
    String hausnr;
    Date Geburtstag;
    String bezirk;

    public Person(String id, String vname, String nname, String telefon, String email, String adresse, String hausnr, Date Geburtstag, String bezirk) {
        this.id = id;
        this.vname = vname;
        this.nname = nname;
        this.telefon = telefon;
        this.email = email;
        this.adresse = adresse;
        this.hausnr = hausnr;
        this.Geburtstag = Geburtstag;
        this.bezirk = bezirk;
    }

    
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getNname() {
        return nname;
    }

    public void setNname(String nname) {
        this.nname = nname;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getHausnr() {
        return hausnr;
    }

    public void setHausnr(String hausnr) {
        this.hausnr = hausnr;
    }

    public Date getGeburtstag() {
        return Geburtstag;
    }

    public void setGeburtstag(Date Geburtstag) {
        this.Geburtstag = Geburtstag;
    }

    public String getBezirk() {
        return bezirk;
    }

    public void setBezirk(String bezirk) {
        this.bezirk = bezirk;
    }
    
    
    
}
