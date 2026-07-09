-- Last updated: 7/9/2026, 2:15:52 PM
SELECT customer_number
FROM Orders
GROUP BY customer_number
ORDER BY COUNT(*) DESC
LIMIT 1;