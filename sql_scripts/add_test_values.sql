INSERT INTO Compte_Psy (psyid, mdp)
VALUES ('admin','password');

INSERT INTO Consultations (consultationid, horaire, typerdv, prix, reglement, anxiete)
VALUES (1,'2020-06-12 12:30','Homme',45.50,'Cheque',5),
        (2,'2020-06-10 12:30','Enfant',50,'Especes',2),
        (3,'2020-06-10 9:00','Couple',12.25,'Carte',9);

INSERT INTO Postures (posture)
VALUES ('Alonge'), ('Tendu'), ('Relax');

INSERT INTO Proffessions (profession)
VALUES ('Bricoleur'), ('Ecoliere'), ('Ecrivaine'), ('Chanteur'), ('Cuisinier'), ('Danseur');

INSERT INTO Patients (patientid, nom, prenom, datenaissance, sexe, mdp, connupar, profession)
VALUES (1,'Smith', 'John', '2000-01-01','M','1234','Pub','Bricoleur'),
       (2,'Justine','Tinejust','2020-02-03','F', 'abcd','Pub','Ecoliere'),
       (3,'Doe','Jane','1992-05-05','F','0000','Ami(e)','Ecrivaine'),
       (4,'Doe','William','1992-06-06','M','Fido33','Ami(e)','Chanteur');

INSERT INTO Anterieure (patientid, profession)
VALUES (1,'Cuisinier'),(3,'Danseur'),(3,'Cuisinier');

INSERT INTO Rendez_Vous (consultationid, patientid)
VALUES (1,1), (2,2), (3,3), (3,4);

INSERT INTO Notes_Postures (posture, consultationid)
VALUES ('Relax',1), ('Relax',2), ('Tendu',3);