CREATE TABLE IF NOT EXISTS employee (
    PK_ID     INTEGER PRIMARY KEY,
    name      TEXT NOT NULL,
    sex       TEXT NOT NULL,
    cpf       TEXT NOT NULL,
    birthDate INTEGER NOT NULL
);

INSERT INTO
    employee(name, sex, cpf, birthDate)
VALUES
    ('Ana Maria', 'F', '123.456.789/00', 984452400000),
    ('Bia Mattos', 'F', '456.789.123/00', 740458800000),
    ('Carlos Lopes', 'M', '789.456.123/00', 951012000000);