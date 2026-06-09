-- Write your PostgreSQL query statement below
WITH RankedRows AS (
    SELECT 
        id,
        recordDate,
        temperature,
        LAG(temperature, 1) OVER (ORDER BY recordDate) AS prev_temp,
        LAG(recordDate, 1) OVER (ORDER BY recordDate) AS prev_date
    FROM Weather
)
SELECT id
FROM RankedRows
WHERE temperature > prev_temp
  AND recordDate = prev_date + INTERVAL '1 day';