DROP TRIGGER IF EXISTS [Set Type];

CREATE TRIGGER [Set Type]
ON Consultations
AFTER INSERT, UPDATE
AS
BEGIN
	DECLARE @newType VARCHAR(6)
	IF(1  NOT IN (SELECT COUNT(rdv.email) AS numpatient FROM Rendez_Vous rdv WHERE rdv.consultationid = consultationid GROUP BY rdv.consultationid))
        BEGIN
		SET @newType = 'Couple'
        END
	ELSE
	BEGIN
		IF(18 > ANY (SELECT DATEDIFF(YEAR, GETDATE(), p.datenaissance) as age
                        FROM Patients p JOIN Rendez_Vous rdv ON p.email = rdv.email
			WHERE rdv.consultationid = consultationid))
		BEGIN
			IF(13 > ANY (SELECT DATEDIFF(YEAR, GETDATE(), p.datenaissance) as age
                        FROM Patients p JOIN Rendez_Vous rdv ON p.email = rdv.email
			WHERE rdv.consultationid = consultationid))
                        BEGIN
                            SET @newType = 'Enfant'
                        END
			ELSE
                        BEGIN
                            SET @newType = 'Ado'
                        END
		END
		ELSE IF ('M' IN (SELECT p.sexe 
					FROM Patients p JOIN Rendez_Vous rdv ON p.email = rdv.email
					WHERE rdv.consultationid = consultationid))
                BEGIN
			SET @newType = 'Homme'
                END
		ELSE
                BEGIN
			SET @newType = 'Femme'
                END
	END	
	UPDATE Consultations SET typerdv = @newType WHERE consultationid = consultationid
END

CREATE TRIGGER [Availability]
ON Consultations
AFTER INSERT, UPDATE
AS BEGIN
	IF (check_time_day(horaire) = 1 AND
		check_opening_hours (horaire) = 1 AND
		check_timeslot(horaire) = 1)
	BEGIN
		ROLLBACK TRANSACTION
	END
END;

CREATE TRIGGER [Future Date]
ON Patients
AFTER INSERT
AS BEGIN
	IF (DATEDIFF(day, datenaissance, GETDATE()) < 0)
	BEGIN
		ROLLBACK TRANSACTION
	END
END;

