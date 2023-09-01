CREATE TYPE gender AS ENUM ('male', 'female', 'other');
CREATE TABLE patient
(
    patient_id   SERIAL      NOT NULL,
    name         VARCHAR(32) NOT NULL,
    surname      VARCHAR(32) NOT NULL,
    gender       gender      NOT NULL,
    pesel        VARCHAR(32) NOT NULL,
    email        VARCHAR(32) NOT NULL,
    PRIMARY KEY (patient_id),
    UNIQUE (pesel),
    UNIQUE (email)
);