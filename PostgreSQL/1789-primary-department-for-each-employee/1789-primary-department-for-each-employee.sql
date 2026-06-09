SELECT e1.employee_id, e1.department_id
FROM Employee e1
WHERE e1.primary_flag = 'Y'

UNION

SELECT e2.employee_id, MIN(e2.department_id)
FROM Employee e2
GROUP BY e2.employee_id
HAVING SUM(CASE WHEN e2.primary_flag = 'Y' THEN 1 ELSE 0 END) = 0