-- Last updated: 7/9/2026, 2:15:46 PM
SELECT
    MAX(num) AS num
FROM (
    SELECT num
    FROM MyNumbers
    GROUP BY num
    HAVING COUNT(*) = 1
) AS t;