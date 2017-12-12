/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  DB
 * Created: 12.12.2017
 */

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
gestelltvon INTEGER NOT NULL, 
betreff VARCHAR(45) NOT NULL,  
status VARCHAR(45) NOT NULL,  
typ VARCHAR(45) NULL,
dokumente INTEGER NOT NULL,  
details VARCHAR(65536) NULL,
    FOREIGN KEY (gestelltvon) REFERENCES ratsmitglied(id)
    FOREIGN KEY (dokumente) REFERENCES anlagen(id)
);

CREATE TABLE IF NOT EXISTS anlage(
id INTEGER PRIMARY KEY AUTOINCREMENT,
name VARCHAR(45) NOT NULL,
lokalerPfad VARCHAR(45) NOT NULL,
antrag_id INTEGER NOT NULL,
    FOREIGN KEY (antrag_id)  REFERENCES antrag(id)
);

