DROP VIEW IF EXISTS [Quick RDV];

CREATE VIEW [Quick RDV] AS
SELECT FORMAT(c.horaire, 'dddd, MMM dd ') AS 'date', FORMAT(c.horaire, 'hh:mm') AS 'horaire', c.typerdv AS 'type', c.anxiete, rdv.email AS email, c.horaire AS 'exact_time'
FROM Consultations c JOIN Rendez_Vous rdv ON c.consultationid = rdv.consultationid;