-- Last updated: 7/9/2026, 2:14:50 PM
SELECT *
FROM Patients
WHERE conditions LIKE 'DIAB1%'
   OR conditions LIKE '% DIAB1%';