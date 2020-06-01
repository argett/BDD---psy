/* THEO DELETTRE
 LILIAN FAVRE GARCIA */

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

INSERT INTO Anterieure (email, profession)
VALUES ('John.smith@fakemail.com','Cuisinier'),('Jdoe@fakemail.com','Danseur'),('Jdoe@fakemail.com','Cuisinier');

INSERT INTO Rendez_Vous (consultationid, email)
VALUES (1,'John.smith@fakemail.com'), (2,'JustineTime@fakemail.com'), (3,'Jdoe@fakemail.com'), (3,'Williwonder@fakemail.com');

INSERT INTO Notes_Postures (posture, consultationid)
VALUES ('Relax',1), ('Relax',2), ('Tendu',3);