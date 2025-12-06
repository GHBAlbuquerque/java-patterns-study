CREATE TABLE AGREEMENT (
    id VARCHAR(255) NOT NULL,
    total_amount DECIMAL(19, 2) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE INSTALLMENT (
    agreement_id VARCHAR(255) NOT NULL,
    number INT NOT NULL,
    due_date DATE NOT NULL,
    payment_date DATE,
    amount DECIMAL(19, 2) NOT NULL,
    paid_amount DECIMAL(19, 2),
    interest DECIMAL(19, 2),
    status VARCHAR(255) NOT NULL,
    payment_method VARCHAR(255),
    PRIMARY KEY (agreement_id, number),
    FOREIGN KEY (agreement_id) REFERENCES AGREEMENT(id)
);

CREATE TABLE INVOICE (
    id VARCHAR(255) NOT NULL,
    agreement_id VARCHAR(255) NOT NULL,
    barcode VARCHAR(255) NOT NULL,
    amount DECIMAL(19, 2) NOT NULL,
    due_date DATE NOT NULL,
    issue_date DATE NOT NULL,
    issuer VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (agreement_id) REFERENCES AGREEMENT(id)
);
