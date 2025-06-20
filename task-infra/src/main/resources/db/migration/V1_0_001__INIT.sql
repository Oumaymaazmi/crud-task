CREATE TABLE product (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    price NUMERIC(19, 2),
    quantity INTEGER,
    created_by VARCHAR(255),
    creation_date TIMESTAMP,
    update_date TIMESTAMP
);