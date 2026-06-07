WITH partitioned AS (
    SELECT
        product_id,
        new_price,
        change_date,
        ROW_NUMBER() OVER(
            PARTITION BY product_id
            ORDER BY change_date DESC
        ) AS rn
    FROM Products
    WHERE change_date <= '2019-08-16'            
)
SELECT 
    p.product_id,
    COALESCE(part.new_price, 10) AS price
FROM ( SELECT DISTINCT product_id FROM Products ) p
LEFT JOIN partitioned part ON p.product_id = part.product_id AND part.rn = 1