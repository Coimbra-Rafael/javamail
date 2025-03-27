CREATE TABLE email
(
    email_id uuid NOT NULL,
    to_destni     VARCHAR(255),
    subject  VARCHAR(255),
    body     VARCHAR(255),
    CONSTRAINT pk_email PRIMARY KEY (email_id)
);