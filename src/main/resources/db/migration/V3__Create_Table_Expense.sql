CREATE TABLE expense (
    id SERIAL PRIMARY KEY,
    description VARCHAR(255),
    value DECIMAL(19, 2),
    quantity INT,
    time_of_expense TIMESTAMP,
    local_expense VARCHAR(255),
    category_expense_id BIGINT REFERENCES category_expense(id),
    account_id BIGINT REFERENCES account(id)
);