/*------------------------------------------------------------
# Table: Consultations
------------------------------------------------------------*/

CREATE TABLE Consultations(
        consultationid Int NOT NULL ,
        horaire        Datetime NOT NULL ,
        typerdv        Varchar (6) NOT NULL ,
        prix           Decimal (5,2) NOT NULL ,
        reglement      Varchar (20) ,
        anxiete        Int
	,CONSTRAINT Consultations_PK PRIMARY KEY (consultationid)
);


/*------------------------------------------------------------
# Table: Proffessions
------------------------------------------------------------*/

CREATE TABLE Proffessions(
        profession Varchar (30) NOT NULL
	,CONSTRAINT Proffessions_PK PRIMARY KEY (profession)
);


/*------------------------------------------------------------
# Table: Patients
------------------------------------------------------------*/

CREATE TABLE Patients(
        patientid     Int NOT NULL ,
        nom           Varchar (20) NOT NULL ,
        prenom        Varchar (20) NOT NULL ,
        datenaissance Date NOT NULL ,
        sexe          Char (1) NOT NULL ,
        connupar      Varchar (50) NOT NULL ,
        profession    Varchar (30)
	,CONSTRAINT Patients_PK PRIMARY KEY (patientid)

	,CONSTRAINT Patients_Proffessions_FK FOREIGN KEY (profession) REFERENCES Proffessions(profession)
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

	,CONSTRAINT Rendez_Vous_Consultations_FK FOREIGN KEY (consultationid) REFERENCES Consultations(consultationid)
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
	,CONSTRAINT Anterieure_Proffessions0_FK FOREIGN KEY (profession) REFERENCES Proffessions(profession)
);


/*------------------------------------------------------------
# Table: Notes Comportements
------------------------------------------------------------*/

CREATE TABLE Notes_Comportements(
        comportement   Varchar (25) NOT NULL ,
        consultationid Int NOT NULL
	,CONSTRAINT Notes_Comportements_PK PRIMARY KEY (comportement,consultationid)

	,CONSTRAINT Notes_Comportements_Comportements_FK FOREIGN KEY (comportement) REFERENCES Comportements(comportement)
	,CONSTRAINT Notes_Comportements_Consultations0_FK FOREIGN KEY (consultationid) REFERENCES Consultations(consultationid)
);


/*------------------------------------------------------------
# Table: Notes Mots
------------------------------------------------------------*/

CREATE TABLE Notes_Mots(
        mot            Varchar (25) NOT NULL ,
        consultationid Int NOT NULL
	,CONSTRAINT Notes_Mots_PK PRIMARY KEY (mot,consultationid)

	,CONSTRAINT Notes_Mots_MotCles_FK FOREIGN KEY (mot) REFERENCES MotCles(mot)
	,CONSTRAINT Notes_Mots_Consultations0_FK FOREIGN KEY (consultationid) REFERENCES Consultations(consultationid)
);


/*------------------------------------------------------------
# Table: Notes Postures
------------------------------------------------------------*/

CREATE TABLE Notes_Postures(
        posture        Varchar (25) NOT NULL ,
        consultationid Int NOT NULL
	,CONSTRAINT Notes_Postures_PK PRIMARY KEY (posture,consultationid)

	,CONSTRAINT Notes_Postures_Postures_FK FOREIGN KEY (posture) REFERENCES Postures(posture)
	,CONSTRAINT Notes_Postures_Consultations0_FK FOREIGN KEY (consultationid) REFERENCES Consultations(consultationid)
);