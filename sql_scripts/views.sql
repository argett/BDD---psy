DROP VIEW IF EXISTS [Quick RDV];
DROP VIEW IF EXISTS [Quick Patient];
DROP VIEW IF EXISTS [Distinct RDV];

CREATE VIEW [Quick RDV] AS
SELECT FORMAT(c.horaire, 'dddd dd MMM yy') AS 'Date', FORMAT(c.horaire, 'HH:mm') AS 'Horaire', c.typerdv AS 'Type', c.anxiete, rdv.email AS email, c.horaire AS 'exact_time'
FROM Consultations c JOIN Rendez_Vous rdv ON c.consultationid = rdv.consultationid;

CREATE VIEW [Quick Patient] AS
SELECT email ,nom ,prenom
FROM Patients;

CREATE VIEW [Distinct RDV] AS
SELECT FORMAT(c.horaire, 'dddd dd MMM') AS 'Jour', FORMAT(c.horaire, 'HH:mm') AS 'Heure', p.nom AS 'Nom', p.prenom AS 'Prénom', c.typerdv AS 'Type', c.horaire AS 'Date'
FROM Consultations c JOIN (Rendez_Vous rdv JOIN Patients p ON p.email = rdv.email) ON c.consultationid = rdv.consultationid
WHERE p.email IN (SELECT MAX(r.email) FROM Rendez_Vous r WHERE r.consultationid = c.consultationid);