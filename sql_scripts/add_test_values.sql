INSERT INTO Compte_Psy (psyid, mdp)
VALUES ('admin','password');

INSERT INTO Consultations (horaire, typerdv, prix, reglement, anxiete)
VALUES ('2020-30-05 12:30','Homme',45.50,'Cheque',5),
        ('2020-31-05 12:30','Enfant',50,'Especes',2),
        ('2020-31-05 9:00','Couple',12.25,'Carte',9);

INSERT INTO Postures (posture)
VALUES ('Alonge'), ('Tendu'), ('Relax');

INSERT INTO Professions (profession)
VALUES ('Bricoleur'), ('Ecoliere'), ('Ecrivaine'), ('Chanteur'), ('Cuisinier'), ('Danseur');

INSERT INTO Patients (nom, prenom, email, datenaissance, sexe, mdp, connupar, profession)
VALUES ('Smith', 'John', 'John.smith@fakemail.com', '2000-01-01','M','1234','Pub','Bricoleur'),
       ('Time','Justine','JustineTime@fakemail.com','2020-02-03','F', 'abcd','Pub','Ecoliere'),
       ('Doe','Jane','Jdoe@fakemail.com','1992-05-05','F','0000','Ami(e)','Ecrivaine'),
       ('Doe','William','Williwonder@fakemail.com','1992-06-06','M','Fido33','Ami(e)','Chanteur');

INSERT INTO Anterieure (patientid, profession)
VALUES (1,'Cuisinier'),(3,'Danseur'),(3,'Cuisinier');

INSERT INTO Rendez_Vous (consultationid, patientid)
VALUES (1,1), (2,2), (3,3), (3,4);

INSERT INTO Notes_Postures (posture, consultationid)
VALUES ('Relax',1), ('Relax',2), ('Tendu',3);

INSERT INTO Compte_Psy(psyid, mdp)
VALUES (1,'1234'),(2,'abcd'),(3,'azer');

INSERT INTO Compte_Patient(patientid, mdp)
VALUES (1,'test'),(2,'qwer'),(3,'pasadmin');