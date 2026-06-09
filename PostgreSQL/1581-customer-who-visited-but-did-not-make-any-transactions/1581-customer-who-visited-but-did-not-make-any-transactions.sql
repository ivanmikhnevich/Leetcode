-- Write your PostgreSQL query statement below
SELECT customer_id, COUNT(*) AS count_no_trans
FROM Visits
LEFT JOIN Transactions ON Transactions.visit_id = Visits.visit_id
WHERE Transactions.visit_id IS NULL
GROUP BY customer_id