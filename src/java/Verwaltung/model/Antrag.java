/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Verwaltung.model;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author 89473
 */
public class Antrag {
    
    int antragsnummer;
    Date gestelltam;
    Ratsmitglied gestelltvon;
    String betreff;
    boolean angenommen;
    String typ;
    ArrayList<Anlage> anlagen;
    String details;

    public Antrag(int antragsnummer, Date gestelltam, Ratsmitglied gestelltvon, String betreff, String typ,  String details) {
        this.antragsnummer = antragsnummer;
        this.gestelltam = gestelltam;
        this.gestelltvon = gestelltvon;
        this.betreff = betreff;
        this.angenommen = false;
        this.typ = typ;
        this.anlagen = new ArrayList<>();
        this.details = details;
    }

    
    
    
    
    public int getAntragsnummer() {
        return antragsnummer;
    }

    public void setAntragsnummer(int antragsnummer) {
        this.antragsnummer = antragsnummer;
    }

    public Date getGestelltam() {
        return gestelltam;
    }

    public void setGestelltam(Date gestelltam) {
        this.gestelltam = gestelltam;
    }

    public Ratsmitglied getGestelltvon() {
        return gestelltvon;
    }

    public void setGestelltvon(Ratsmitglied gestelltvon) {
        this.gestelltvon = gestelltvon;
    }

    public String getBetreff() {
        return betreff;
    }

    public void setBetreff(String betreff) {
        this.betreff = betreff;
    }

    public boolean isAngenommen() {
        return angenommen;
    }

    public void setAngenommen(boolean angenommen) {
        this.angenommen = angenommen;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public ArrayList<Anlage> getAnlagen() {
        return anlagen;
    }

    public void setAnlagen(ArrayList<Anlage> anlagen) {
        this.anlagen = anlagen;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
    
    
    
}
