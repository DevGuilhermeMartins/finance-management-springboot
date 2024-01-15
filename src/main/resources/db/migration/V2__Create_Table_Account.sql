CREATE TABLE account (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    register_date DATE,
    income DECIMAL(10, 2),
    CONSTRAINT unique_email UNIQUE (email)
);