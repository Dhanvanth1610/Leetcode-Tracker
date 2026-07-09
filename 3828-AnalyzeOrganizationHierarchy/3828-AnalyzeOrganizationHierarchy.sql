-- Last updated: 7/9/2026, 2:14:03 PM
WITH RECURSIVE EmployeeHierarchy AS (
    SELECT
        employee_id,
        employee_name,
        manager_id,
        salary,
        1 AS level
    FROM Employees
    WHERE manager_id IS NULL

    UNION ALL

    SELECT
        e.employee_id,
        e.employee_name,
        e.manager_id,
        e.salary,
        eh.level + 1
    FROM Employees e
    JOIN EmployeeHierarchy eh
        ON e.manager_id = eh.employee_id
),
Subordinates AS (
    SELECT
        manager_id,
        employee_id,
        salary
    FROM Employees
    WHERE manager_id IS NOT NULL

    UNION ALL

    SELECT
        s.manager_id,
        e.employee_id,
        e.salary
    FROM Employees e
    JOIN Subordinates s
        ON e.manager_id = s.employee_id
),
TeamSizeAndBudget AS (
    SELECT
        e.employee_id,
        COUNT(DISTINCT s.employee_id) AS team_size,
        COALESCE(SUM(s.salary), 0) + e.salary AS budget
    FROM Employees e
    LEFT JOIN Subordinates s
        ON e.employee_id = s.manager_id
    GROUP BY e.employee_id, e.salary
)

SELECT
    eh.employee_id,
    eh.employee_name,
    eh.level,
    tsb.team_size,
    tsb.budget
FROM EmployeeHierarchy eh
JOIN TeamSizeAndBudget tsb
    ON eh.employee_id = tsb.employee_id
ORDER BY
    eh.level,
    tsb.budget DESC,
    eh.employee_name;