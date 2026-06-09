WITH teacher_subject AS (
    SELECT DISTINCT
        teacher_id,
        subject_id        
    FROM Teacher
    ORDER BY teacher_id
),
numbered AS (
    SELECT
        teacher_id,
        subject_id,
        ROW_NUMBER() OVER(
            PARTITION BY teacher_id
        ) AS rn
    FROM teacher_subject
)
SELECT 
    teacher_id,
    MAX(rn) AS cnt
FROM numbered
GROUP BY teacher_id