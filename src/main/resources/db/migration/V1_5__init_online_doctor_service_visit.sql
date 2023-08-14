CREATE TYPE status AS ENUM ('scheduled', 'completed', 'available')
CREATE TABLE visit
(
    visit_id 	           SERIAL                    NOT NULL,
    visit_number           VARCHAR(32)               NOT NULL,
    visit_date_start_time  TIMESTAMP WITH TIME ZONE  NOT NULL,
    visit_date_end_time    TIMESTAMP WITH TIME ZONE  NOT NULL,
    status                 status                    NOT NULL,
    patient_id             INT         NOT NULL,
    doctor_id              INT         NOT NULL,
    visit_note_id          INT         NOT NULL,
    PRIMARY KEY (visit_id),
    UNIQUE (visit_number),
    CONSTRAINT fk_patient
        FOREIGN KEY (patient_id)
            REFERENCES patient (patient_id),
    CONSTRAINT fk_doctor
        FOREIGN KEY (doctor_id)
            REFERENCES doctor (doctor_id),
    CONSTRAINT fk_visit
        FOREIGN KEY (visit_id)
            REFERENCES visit (visit_id)
);