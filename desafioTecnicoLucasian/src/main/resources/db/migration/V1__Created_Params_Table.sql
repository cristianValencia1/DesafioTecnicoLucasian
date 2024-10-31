CREATE TABLE params (
    uuid PRIMARY KEY NOT NULL DEFAULT gen_random_uuid(),
    name VARCHAR(100) NOT NULL,
    value VARCHAR(255) NOT NULL,
    description TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modified_at TIMESTAMP
);