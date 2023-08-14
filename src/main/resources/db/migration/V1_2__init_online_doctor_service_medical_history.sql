CREATE TABLE medical_history
(
    medical_history_id      SERIAL                   NOT NULL,
    illness_name            VARCHAR(32),
    diagnosis_date_time     TIMESTAMP WITH TIME ZONE,
    treatment               TEXT,
    patient_id              INT                      NOT NULL,
    PRIMARY KEY (medical_history_id),
    CONSTRAINT fk_patient
        FOREIGN KEY (patient_id)
            REFERENCES patient (patient_id)
);