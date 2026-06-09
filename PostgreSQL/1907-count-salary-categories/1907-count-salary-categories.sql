WITH categoried AS(
    SELECT 
        account_id,
        income,
        CASE
            WHEN income < 20000 THEN 'Low Salary'
            WHEN income <= 50000 THEN 'Average Salary' 
            WHEN income > 50000 THEN 'High Salary' 
        END AS category
    FROM Accounts
),
all_categories AS (
    SELECT unnest(ARRAY['Low Salary', 'Average Salary', 'High Salary']) AS category
)
SELECT 
    cats.category,
    COALESCE(COUNT(cated.account_id), 0) AS accounts_count
FROM all_categories cats
LEFT JOIN categoried cated
ON cats.category = cated.category
GROUP BY cats.category
ORDER BY accounts_count DESC