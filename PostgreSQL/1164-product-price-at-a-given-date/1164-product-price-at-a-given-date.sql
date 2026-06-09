WITH changed_price AS (
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
    pd.product_id,
    COALESCE(cp.new_price, 10) AS price
FROM (SELECT DISTINCT product_id FROM Products) pd
LEFT JOIN changed_price cp ON pd.product_id = cp.product_id AND rn = 1
ORDER BY product_id