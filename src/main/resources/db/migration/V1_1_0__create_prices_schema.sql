CREATE TABLE IF NOT EXISTS `Prices` (
    `id`         INTEGER PRIMARY KEY AUTO_INCREMENT,
    `start_date` TIMESTAMP,
    `end_date`   TIMESTAMP,
    `brand_id`   INTEGER,
    `price_list` INTEGER,
    `product_id` INTEGER,
    `priority`   INTEGER,
    `price`      DECIMAL,
    `curr`       VARCHAR(3)
);