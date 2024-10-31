CREATE TABLE param_transaction (
    uuid PRIMARY KEY NOT NULL DEFAULT gen_random_uuid(),
    param_id INT REFERENCES params(uuid) ON DELETE CASCADE,
    transaction_id INT REFERENCES transactions(uuid) ON DELETE CASCADE,
    dateAction TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);