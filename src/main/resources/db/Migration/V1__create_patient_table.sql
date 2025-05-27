CREATE TABLE patient (
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(255),
    age INT,
    gender VARCHAR(50),
    phone VARCHAR(50),
    email VARCHAR(100),
    address TEXT,
    disease TEXT,
    medication TEXT
);
