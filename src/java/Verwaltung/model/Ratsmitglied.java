/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Verwaltung.model;

import java.sql.Date;

/**
 *
 * @author 89473
 */
public class Ratsmitglied extends Person {

    String wahlperiode, fraktion, stadtratsarbeit;

    public Ratsmitglied(String wahlperiode, String fraktion, String stadtratsarbeit, int id, String vname, String nname, String telefon, String email, String adresse, String hausnr, Date Geburtstag, String bezirk) {
        super(id, vname, nname, telefon, email, adresse, hausnr, Geburtstag, bezirk);
        this.wahlperiode = wahlperiode;
        this.fraktion = fraktion;
        this.stadtratsarbeit = stadtratsarbeit;
    }

    public String getWahlperiode() {
        return wahlperiode;
    }

    public void setWahlperiode(String wahlperiode) {
        this.wahlperiode = wahlperiode;
    }

    public String getFraktion() {
        return fraktion;
    }

    public void setFraktion(String fraktion) {
        this.fraktion = fraktion;
    }

    public String getStadtratsarbeit() {
        return stadtratsarbeit;
    }

    public void setStadtratsarbeit(String stadtratsarbeit) {
        this.stadtratsarbeit = stadtratsarbeit;
    }

}
