/*------------------------------------------------------------
# Consultations jour
------------------------------------------------------------*/


CREATE FUNCTION view_day (@d DATE)
RETURNS TABLE
AS RETURN
	SELECT FORMAT(horaire, 'hh:mm') AS 'horaire', typerdv AS 'type', Patients.patientid AS 'id', prenom , nom
	FROM (Consultations JOIN Rendez_Vous ON Consultations.consultationid = Rendez_Vous.consultationid)
	    JOIN Patients ON Rendez_Vous.patientid = Patients.patientid
	WHERE FORMAT(horaire, 'yyyy-MM-dd') = FORMAT(@d, 'yyyy-MM-dd')
	ORDER BY horaire;

/*------------------------------------------------------------
# Consultations semaine 
------------------------------------------------------------*/

CREATE FUNCTION view_week (@d DATE)
RETURNS TABLE
AS RETURN
	SELECT FORMAT(horaire, 'dddd, MMM dd ') AS 'date', FORMAT(horaire, 'hh:mm') AS 'horaire', typerdv AS 'type', Patients.patientid AS 'id',  prenom , nom
	FROM (Consultations JOIN Rendez_Vous ON Consultations.consultationid = Rendez_Vous.consultationid)
	    JOIN Patients ON Rendez_Vous.patientid = Patients.patientid
	WHERE  DATEPART(wk,horaire) = DATEPART(wk,@d) AND DATEPART(year ,horaire) = DATEPART(year,@d)
	ORDER BY horaire;

/*------------------------------------------------------------
# Consultations d un patient
------------------------------------------------------------*/

CREATE FUNCTION view_patient (@pid INTEGER)
RETURNS TABLE
AS RETURN
	SELECT FORMAT(horaire, 'dddd, MMM dd ') AS 'date', FORMAT(horaire, 'hh:mm') AS 'horaire', typerdv AS 'type', anxiete, prix, reglement
	FROM (Consultations JOIN Rendez_Vous ON Consultations.consultationid = Rendez_Vous.consultationid)
	    JOIN Patients ON Rendez_Vous.patientid = Patients.patientid
	WHERE Patients.patientid = @pid
	ORDER BY horaire;

/*------------------------------------------------------------
# Inscriptions patient
------------------------------------------------------------*/

CREATE FUNCTION add_patient (@nom VARCHAR, @prenom VARCHAR, @datenaissance DATE, @sexe CHAR, @connupar VARCHAR)
RETURNS BIT
AS BEGIN
    IF (@datenaissance<SYSDATETIME())
        RETURN 0;
    DECLARE pid INTEGER;
    SET pid = (SELECT MAX(patientid) FROM Patients) +1;
    INSERT INTO Patients (patientid , nom , prenom, datenaissance , sexe, connupar)
    VALUES (pid , @nom , @prenom , @datenaissance , @sexe , @connupar );
    RETURN 1;
END;

CREATE PROCEDURE new_proffession (@patientid INTEGER, @proffession Varchar)
AS BEGIN
    DECLARE cur INTEGER;
    SET cur = (SELECT profession from Patients WHERE patientid=@patientid);
    IF(cur IS NOT NULL)
        INSERT INTO Anterieure (patientid, profession) VALUES (@patientid, cur);

    IF( NOT EXISTS (SELECT * FROM Proffessions WHERE profession LIKE @proffession))
        INSERT INTO Proffessions (profession) VALUES (@proffession);

    UPDATE Patients
    SET profession = @proffession
    WHERE patientid = @patientid;
END;

/*------------------------------------------------------------
# Type rendez-vous
------------------------------------------------------------*/

CREATE FUNCTION find_type (@numpatients INTEGER, @horaire DATETIME, @pid INTEGER)
RETURNS VARCHAR(6)
AS BEGIN
	DECLARE age INTEGER;
	SET age = DATEDIFF(YEAR, GETDATE(), (SELECT datenaissance FROM Patients WHERE patientid=@pid));
	IF (@numpatients!=1)
		RETURN 'couple';
	ELSE IF( age < 18)
	BEGIN
		IF(age <13)
			RETURN 'enfant';
		ELSE
			RETURN 'ado';
    END
	ELSE IF( (SELECT sexe FROM Patients WHERE patientid=@pid) = 'M')
		RETURN 'homme';
	ELSE
		RETURN 'femme';
END;

/*------------------------------------------------------------
# Ajout rendez-vous:
  Comportement etc...
------------------------------------------------------------*/

CREATE FUNCTION add_rdv (@horaire DATETIME, @prix DECIMAL, @patientid INTEGER)
RETURNS BIT
AS BEGIN
    IF( ( NOT EXISTS (SELECT patientid FROM Patients WHERE patientid = @patientid))
            AND @horaire < SYSDATETIME()
            AND NOT check_time_day(@horaire) = 0
            AND NOT check_opening_hours(@horaire) = 0
            AND NOT check_timeslot(@horaire) = 0 )
                RETURN 0;

    DECLARE newtype CHAR;
    SET newtype = find_type(1, @horaire, @patientid);

    DECLARE cid INTEGER;
    SET cid = (SELECT MAX(consultationid) FROM Consultations) +1;

    INSERT INTO Consultations (consultationid, horaire, typerdv, prix)
    VALUES (cid,@horaire, newtype,@prix);

    INSERT INTO Rendez_Vous (consultationid, patientid) VALUES (cid, @patientid);

    RETURN 1;
END;

/*------------------------------------------------------------
# Time per day Check
------------------------------------------------------------*/

CREATE FUNCTION check_time_day (@d DATE)
RETURNS BIT
AS BEGIN
    IF(20 > (SELECT COUNT(DISTINCT horaire)
			FROM Consultations
			WHERE FORMAT(horaire, 'yyyy-MM-dd') = FORMAT(@d, 'yyyy-MM-dd') ) )
        RETURN 1;
	ELSE RETURN 0;
END;

/*------------------------------------------------------------
# Opening hours check
------------------------------------------------------------*/

CREATE FUNCTION check_opening_hours (@horaire DATETIME)
RETURNS BIT
AS BEGIN
	IF (FORMAT(@horaire, 'hh') >= '08' AND FORMAT(@horaire, 'hh:mm') <= '2130' AND FORMAT(@horaire, 'ddd') != 'Sun')
	    RETURN 1;
	ELSE RETURN 0;
END;

/*------------------------------------------------------------
# Available Timeslot check
------------------------------------------------------------*/

CREATE FUNCTION check_timeslot (@d DATETIME)
RETURNS BIT
AS BEGIN
    IF(NOT EXISTS(SELECT consultationid
			FROM Consultations
			WHERE @d BETWEEN horaire AND DATEADD(MINUTE, 30, horaire)))
        RETURN 1;
	ELSE RETURN 0;
END;




/*------------------------------------------------------------
# Annulation rendez-vous
------------------------------------------------------------*/



/*------------------------------------------------------------
# Modification rendez-vous:
  add patient
  add reglement
  change date
  add anxiete
  change prix?
------------------------------------------------------------*/

