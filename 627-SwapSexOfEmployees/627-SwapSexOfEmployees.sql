-- Last updated: 7/9/2026, 2:15:41 PM
UPDATE Salary
SET sex = CASE
            WHEN sex = 'm' THEN 'f'
            ELSE 'm'
          END;