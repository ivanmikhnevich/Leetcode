SELECT
    class
FROM (
    SELECT 
        class,
        COUNT(student) AS sn
    FROM Courses
    GROUP BY class
) csn
WHERE csn.sn >= 5