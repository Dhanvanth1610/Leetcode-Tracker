-- Last updated: 7/9/2026, 2:15:14 PM
SELECT
    actor_id,
    director_id
FROM ActorDirector
GROUP BY actor_id, director_id
HAVING COUNT(*) >= 3;