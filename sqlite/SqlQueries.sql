/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  DB
 * Created: 12.12.2017
 */
drop table if exists ratsmitglied;
drop table if exists antrag;
drop table if exists anlage;


CREATE TABLE IF NOT EXISTS ratsmitglied (
id INTEGER PRIMARY KEY AUTOINCREMENT,  
vorname VARCHAR(50) NOT NULL,  
nachname VARCHAR(50) NOT NULL,  
telefonnr VARCHAR(50) NULL,
email VARCHAR(50) NULL,  
straße VARCHAR(50) NOT NULL,  
hausnummer VARCHAR(45) NOT NULL,  
ort VARCHAR(45) NOT NULL,  
gebDate DATE NOT NULL,  
wahlperiode VARCHAR(45) NOT NULL,
fraktion VARCHAR(100) NULL, 
stadtratsarbeit VARCHAR(45) NOT NULL);


CREATE TABLE IF NOT EXISTS antrag (  
id INTEGER PRIMARY KEY AUTOINCREMENT,
gestelltam DATE NOT NULL, 
personID INTEGER NOT NULL, 
betreff VARCHAR(45) NOT NULL,  
status boolean NOT NULL,  
typ VARCHAR(45) NULL,
anlageID INTEGER,  
details VARCHAR(65536) NULL,
    FOREIGN KEY (personID) REFERENCES ratsmitglied(id)
    FOREIGN KEY (anlageID) REFERENCES anlage(id)
);

CREATE TABLE IF NOT EXISTS anlage(
id INTEGER PRIMARY KEY AUTOINCREMENT,
name VARCHAR(45) NOT NULL,
lokalerPfad VARCHAR(45) NOT NULL,
antragID INTEGER NOT NULL,
    FOREIGN KEY (antragID)  REFERENCES antrag(id)
);

