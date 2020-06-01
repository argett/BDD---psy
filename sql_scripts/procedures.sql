/* THEO DELETTRE
 LILIAN FAVRE GARCIA */


CREATE FUNCTION check_time_day (@d DATETIME)
RETURNS BIT
AS BEGIN
    DECLARE @res BIT
    
    IF(20 > (SELECT COUNT(DISTINCT horaire)
			FROM Consultations
			WHERE FORMAT(horaire, 'yyyy-MM-dd') = FORMAT(@d, 'yyyy-MM-dd') ) )
    BEGIN
        SET @res = 1
    END
    ELSE
    BEGIN	
        SET @res = 0
    END

    RETURN @res
END;

CREATE FUNCTION check_opening_hours (@horaire DATETIME)
RETURNS BIT
AS BEGIN
    DECLARE @res BIT

    IF (FORMAT(@horaire, 'hh') >= '08' AND FORMAT(@horaire, 'hh:mm') <= '2130' AND FORMAT(@horaire, 'ddd') != 'Sun')
    BEGIN
        SET @res = 1
    END
    ELSE
    BEGIN	
        SET @res = 0
    END

    RETURN @res
END;

CREATE FUNCTION check_timeslot (@d DATETIME)
RETURNS BIT
AS BEGIN
    DECLARE @res BIT

    IF(NOT EXISTS(SELECT consultationid
			FROM Consultations
			WHERE @d BETWEEN horaire AND DATEADD(MINUTE, 30, horaire)))
    BEGIN
        SET @res = 1
    END
    ELSE
    BEGIN	
        SET @res = 0
    END

    RETURN @res
END;
