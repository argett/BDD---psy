ALTER TABLE Patients
    DROP CONSTRAINT IF EXISTS "Patients_Professions_FK";
ALTER TABLE Rendez_Vous
    DROP CONSTRAINT IF EXISTS "Rendez_Vous_Consultations_FK";
ALTER TABLE Rendez_Vous
    DROP CONSTRAINT IF EXISTS "Rendez_Vous_Patients0_FK";
ALTER TABLE Anterieure
    DROP CONSTRAINT IF EXISTS "Anterieure_Patients_FK";
ALTER TABLE Anterieure
    DROP CONSTRAINT IF EXISTS "Anterieure_Professions0_FK";
ALTER TABLE Notes_Postures
    DROP CONSTRAINT IF EXISTS "Notes_Postures_Consultations0_FK";
ALTER TABLE Notes_Postures
    DROP CONSTRAINT IF EXISTS "Notes_Postures_Postures_FK";
ALTER TABLE Notes_Comportements
    DROP CONSTRAINT IF EXISTS "Notes_Comportements_Comportements_FK";
ALTER TABLE Notes_Comportements
    DROP CONSTRAINT IF EXISTS "Notes_Comportements_Consultations0_FK";
ALTER TABLE Notes_Mots
    DROP CONSTRAINT IF EXISTS "Notes_Mots_MotCles_FK";
ALTER TABLE Notes_Mots
    DROP CONSTRAINT IF EXISTS "Notes_Mots_Consultations0_FK";

DROP TABLE  IF EXISTS Consultations;
DROP TABLE  IF EXISTS Professions;
DROP TABLE  IF EXISTS Patients;
DROP TABLE  IF EXISTS MotCles;
DROP TABLE  IF EXISTS Postures;
DROP TABLE  IF EXISTS Comportements;
DROP TABLE  IF EXISTS Rendez_Vous;
DROP TABLE  IF EXISTS Anterieure;
DROP TABLE  IF EXISTS Notes_Comportements;
DROP TABLE  IF EXISTS Notes_Mots;
DROP TABLE  IF EXISTS Notes_Postures;
DROP TABLE  IF EXISTS Compte_Psy;

/*------------------------------------------------------------
# Table: Consultations
------------------------------------------------------------*/

CREATE TABLE Consultations(
        consultationid Int NOT NULL IDENTITY,
        horaire        Datetime NOT NULL ,
        typerdv        Varchar (6) NOT NULL ,
        prix           Decimal (5,2) NOT NULL ,
        reglement      Varchar (20) ,
        anxiete        Int
	,CONSTRAINT Consultations_PK PRIMARY KEY (consultationid)
);


/*------------------------------------------------------------
# Table: Professions
------------------------------------------------------------*/

CREATE TABLE Professions(
        profession Varchar (30) NOT NULL
	,CONSTRAINT Professions_PK PRIMARY KEY (profession)
);


/*------------------------------------------------------------
# Table: Patients
------------------------------------------------------------*/

CREATE TABLE Patients(
        patientid     Int NOT NULL IDENTITY,
        nom           Varchar (20) NOT NULL ,
        prenom        Varchar (20) NOT NULL ,
		email         Varchar (80) NOT NULL ,
        datenaissance Date NOT NULL ,
        sexe          Char (1) NOT NULL ,
        mdp           Varchar (30) NOT NULL,
        connupar      Varchar (50) NOT NULL ,
        profession    Varchar (30)
	,CONSTRAINT Patients_PK PRIMARY KEY (patientid)

	,CONSTRAINT Patients_Professions_FK FOREIGN KEY (profession) REFERENCES Professions(profession)
);


/*------------------------------------------------------------
# Table: MotCles
------------------------------------------------------------*/

CREATE TABLE MotCles(
        mot Varchar (25) NOT NULL
	,CONSTRAINT MotCles_PK PRIMARY KEY (mot)
);


/*------------------------------------------------------------
# Table: Postures
------------------------------------------------------------*/

CREATE TABLE Postures(
        posture Varchar (25) NOT NULL
	,CONSTRAINT Postures_PK PRIMARY KEY (posture)
);


/*------------------------------------------------------------
# Table: Comportements
------------------------------------------------------------*/

CREATE TABLE Comportements(
        comportement Varchar (25) NOT NULL
	,CONSTRAINT Comportements_PK PRIMARY KEY (comportement)
);


/*------------------------------------------------------------
# Table: Rendez Vous
------------------------------------------------------------*/

CREATE TABLE Rendez_Vous(
        consultationid Int NOT NULL ,
        patientid      Int NOT NULL
	,CONSTRAINT Rendez_Vous_PK PRIMARY KEY (consultationid,patientid)

	,CONSTRAINT Rendez_Vous_Consultations_FK FOREIGN KEY (consultationid) REFERENCES Consultations(consultationid) ON DELETE CASCADE
	,CONSTRAINT Rendez_Vous_Patients0_FK FOREIGN KEY (patientid) REFERENCES Patients(patientid)
);


/*------------------------------------------------------------
# Table: Anterieure
------------------------------------------------------------*/

CREATE TABLE Anterieure(
        patientid  Int NOT NULL ,
        profession Varchar (30) NOT NULL
	,CONSTRAINT Anterieure_PK PRIMARY KEY (patientid,profession)

	,CONSTRAINT Anterieure_Patients_FK FOREIGN KEY (patientid) REFERENCES Patients(patientid)
	,CONSTRAINT Anterieure_Professions0_FK FOREIGN KEY (profession) REFERENCES Professions(profession)
);


/*------------------------------------------------------------
# Table: Notes Comportements
------------------------------------------------------------*/

CREATE TABLE Notes_Comportements(
        comportement   Varchar (25) NOT NULL ,
        consultationid Int NOT NULL
	,CONSTRAINT Notes_Comportements_PK PRIMARY KEY (comportement,consultationid)

	,CONSTRAINT Notes_Comportements_Comportements_FK FOREIGN KEY (comportement) REFERENCES Comportements(comportement)
	,CONSTRAINT Notes_Comportements_Consultations0_FK FOREIGN KEY (consultationid) REFERENCES Consultations(consultationid) ON DELETE CASCADE
);


/*------------------------------------------------------------
# Table: Notes Mots
------------------------------------------------------------*/

CREATE TABLE Notes_Mots(
        mot            Varchar (25) NOT NULL ,
        consultationid Int NOT NULL
	,CONSTRAINT Notes_Mots_PK PRIMARY KEY (mot,consultationid)

	,CONSTRAINT Notes_Mots_MotCles_FK FOREIGN KEY (mot) REFERENCES MotCles(mot)
	,CONSTRAINT Notes_Mots_Consultations0_FK FOREIGN KEY (consultationid) REFERENCES Consultations(consultationid) ON DELETE CASCADE
);


/*------------------------------------------------------------
# Table: Notes Postures
------------------------------------------------------------*/

CREATE TABLE Notes_Postures(
        posture        Varchar (25) NOT NULL ,
        consultationid Int NOT NULL
	,CONSTRAINT Notes_Postures_PK PRIMARY KEY (posture,consultationid)

	,CONSTRAINT Notes_Postures_Postures_FK FOREIGN KEY (posture) REFERENCES Postures(posture)
	,CONSTRAINT Notes_Postures_Consultations0_FK FOREIGN KEY (consultationid) REFERENCES Consultations(consultationid) ON DELETE CASCADE
);

/*------------------------------------------------------------
# Table: Compte Psy
------------------------------------------------------------*/

CREATE TABLE Compte_Psy(
        psyid        Varchar (15) NOT NULL ,
        mdp          Varchar (30) NOT NULL
	,CONSTRAINT Compte_Psy_PK PRIMARY KEY (psyid)
);