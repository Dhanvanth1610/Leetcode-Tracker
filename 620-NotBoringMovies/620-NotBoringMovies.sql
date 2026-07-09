-- Last updated: 7/9/2026, 2:15:43 PM
SELECT *
FROM Cinema
WHERE id % 2 = 1
AND description != 'boring'
ORDER BY rating DESC;