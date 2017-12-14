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
    Ratsmitglied ratsmitglied;
    String betreff;
    boolean status;
    String typ;
    String anlagen;
    String details;

    public Antrag(int antragsnummer, Date gestelltam, Ratsmitglied ratsmitglied, String betreff, boolean status,String typ, String details) {
        this.antragsnummer = antragsnummer;
        this.gestelltam = gestelltam;
        this.ratsmitglied = ratsmitglied;
        this.betreff = betreff;
        this.status = status;
        this.typ = typ;
        this.anlagen = "None";
        this.details = details;
    }

    public String getName() {
        return ratsmitglied.getVname() + " " + ratsmitglied.getNname();
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

    public Ratsmitglied getRatsmitglied() {
        return ratsmitglied;
    }

    public void setRatsmitglied(Ratsmitglied ratsmitglied) {
        this.ratsmitglied = ratsmitglied;
    }

    public String getBetreff() {
        return betreff;
    }

    public void setBetreff(String betreff) {
        this.betreff = betreff;
    }

    public boolean isAngenommen() {
        return status;
    }

    public String getStatus() {
        if (isAngenommen()) {
            return "Angenommen";
        } else {
            return "Abgelehnt";
        }
    }

    public void setAngenommen(boolean angenommen) {
        this.status = angenommen;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getAnlagen() {
        return anlagen;
    }

    public void setAnlagen(String anlagen) {
        this.anlagen = anlagen;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}
