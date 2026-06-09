SELECT
    ss.student_id,
    ss.student_name,
    ss.subject_name,
    COUNT(e.student_id) AS attended_exams
FROM (
    SELECT 
        s.student_id,
        s.student_name,
        sub.subject_name
    FROM Students s
    CROSS JOIN Subjects sub
) ss
LEFT JOIN Examinations e
ON e.student_id = ss.student_id
AND e.subject_name = ss.subject_name
GROUP BY ss.student_id, ss.student_name, ss.subject_name
ORDER BY ss.student_id, ss.subject_name;