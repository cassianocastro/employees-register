/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */

/**
 * 
 * Created: 18 de mai de 2022
 */

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
    ('Ana Maria', 'f', '123.456.789/00', 984452400000),
    ('Bia Mattos', 'f', '456.789.123/00', 740458800000),
    ('Carlos Lopes', 'm', '789.456.123/00', 951012000000);