-- Insert a sample agreement
INSERT INTO AGREEMENT (id, total_amount) VALUES ('AG-12345', 1500.00);

-- Insert sample installments for the agreement
INSERT INTO INSTALLMENT (agreement_id, number, due_date, payment_date, amount, paid_amount, interest, status, payment_method)
VALUES ('AG-12345', 1, '2024-08-01', null, 750.00, 0.00, 0.00, 'PENDING', 'CREDIT_CARD');

INSERT INTO INSTALLMENT (agreement_id, number, due_date, payment_date, amount, paid_amount, interest, status, payment_method)
VALUES ('AG-12345', 2, '2024-09-01', null, 750.00, 0.00, 0.00, 'PENDING', 'BANK_TRANSFER');

-- Insert sample invoices for the agreement
INSERT INTO INVOICE (id, agreement_id, barcode, amount, due_date, issue_date, issuer, status)
VALUES ('INV-001', 'AG-12345', '12345678901234567890123456789012345678901234', 500.00, '2024-07-15', '2024-07-01', 'PLAYBANK', 'OPEN');

INSERT INTO INVOICE (id, agreement_id, barcode, amount, due_date, issue_date, issuer, status)
VALUES ('INV-002', 'AG-12345', '09876543210987654321098765432109876543210987', 1000.00, '2024-07-20', '2024-07-05', 'TOPBANK', 'OPEN');
