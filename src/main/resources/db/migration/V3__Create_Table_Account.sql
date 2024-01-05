CREATE TABLE account (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    register_date DATE,
    role VARCHAR(255),
    CONSTRAINT unique_email UNIQUE (email)
);
