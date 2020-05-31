DROP VIEW IF EXISTS [Quick RDV];
DROP VIEW IF EXISTS [Quick Patient];

CREATE VIEW [Quick RDV] AS
SELECT FORMAT(c.horaire, 'dddd, MMM dd ') AS 'Date', FORMAT(c.horaire, 'hh:mm') AS 'Horaire', c.typerdv AS 'Type', c.anxiete, rdv.email AS email, c.horaire AS 'exact_time'
FROM Consultations c JOIN Rendez_Vous rdv ON c.consultationid = rdv.consultationid;

CREATE VIEW [Quick Patient] AS
SELECT email ,nom ,prenom
FROM Patients;