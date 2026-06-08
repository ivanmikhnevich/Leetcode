WITH AccumulatedWeight AS (
    SELECT 
        person_name,
        SUM(weight) OVER(ORDER BY turn) AS accumed
    FROM Queue
)
SELECT person_name
FROM AccumulatedWeight
WHERE accumed <= 1000
ORDER BY accumed DESC
LIMIT 1