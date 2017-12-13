/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  89388
 * Created: 13.12.2017
 */
INSERT INTO antrag (gestelltam, personID, betreff, status, typ, anlageID, details) 
	VALUES (strftime('%s000', '2001-06-09'), 1, 'Anti Anti-Alkohol Petition', 1, 'Petition', NULL, 'Bier bedeutet Freiheit');
INSERT INTO antrag (gestelltam, personID, betreff, status, typ, anlageID, details) 
	VALUES (strftime('%s000', '2009-02-27'), 1, 'Homer bleibt Cheff', 0, 'Gesetzt', NULL, 'Ich will nicht mehr arbeiten müssen...');
INSERT INTO antrag (gestelltam, personID, betreff, status, typ, anlageID, details) 
	VALUES (strftime('%s000', '2010-01-15'), 2, 'Verschrottung des Denkmals', 1, 'Erlass', NULL, 'Das teil is im Weg');

INSERT INTO ratsmitglied (vorname, nachname, telefonnr, email, "straße", hausnummer, ort, gebDate, wahlperiode, fraktion, stadtratsarbeit) 
	VALUES ('Homer', 'Simpson', '555-Bart', 'homer@AKW.burns', 'BURNS ALEE', '1', 'Springfield', strftime('%s000', '1955-05-10'), '2001/2009', 'BEER', 'Not Pushing the Red Button');
INSERT INTO ratsmitglied (vorname, nachname, telefonnr, email, "straße", hausnummer, ort, gebDate, wahlperiode, fraktion, stadtratsarbeit) 
	VALUES ('Peter', 'Griffin', '???', 'peter@griffin', 'Spooner Street', '31', 'Quahog ', strftime('%s000', '1951-12-24'), '2009/X', 'More BEER', 'Make everything great again');

/*
SELECT personID, betreff, status, typ, details FROM antrag;
select * from antrag;
select * from ratsmitglied;
*/