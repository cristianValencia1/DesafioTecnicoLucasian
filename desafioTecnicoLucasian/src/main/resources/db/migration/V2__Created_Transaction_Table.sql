CREATE TABLE transactions (
    uuid PRIMARY KEY NOT NULL DEFAULT gen_random_uuid(),
    description TEXT NOT NULL,
    dateAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    type VARCHAR(50)
);