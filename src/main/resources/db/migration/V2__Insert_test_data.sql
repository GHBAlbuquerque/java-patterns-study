-- Insert a sample agreement
INSERT INTO AGREEMENT (id, total_amount) VALUES ('AG-12345', 1500.00);

-- Insert sample installments for the agreement
INSERT INTO INSTALLMENT (agreement_id, number, due_date, payment_date, amount, paid_amount, interest, status, payment_method)
VALUES ('AG-12345', 1, '2024-08-01', null, 750.00, 0.00, 0.00, 'PENDING', 'CREDIT_CARD');

INSERT INTO INSTALLMENT (agreement_id, number, due_date, payment_date, amount, paid_amount, interest, status, payment_method)
VALUES ('AG-12345', 2, '2024-09-01', null, 750.00, 0.00, 0.00, 'PENDING', 'BANK_TRANSFER');

-- Insert sample invoices for the agreement
INSERT INTO INVOICE (id, agreement_id, barcode, amount, due_date, issue_date, issuer, status)
VALUES ('INV-001', 'AG-12345', '000011112222-3333-4444-5555-666677778888', 500.00, '2024-07-15', '2024-07-01', 'PLAYBANK', 'PAID');

INSERT INTO INVOICE (id, agreement_id, barcode, amount, due_date, issue_date, issuer, status)
VALUES ('INV-002', 'AG-12345', '0000aaaabbbb-cccc-dddd-eeee-ffff00001111', 1000.00, '2024-07-20', '2024-07-05', 'TOPBANK', 'PENDING');

-- Insert second agreement
INSERT INTO AGREEMENT (id, total_amount) VALUES ('AG-67890', 2500.00);

-- Insert installments for the second agreement
INSERT INTO INSTALLMENT (agreement_id, number, due_date, payment_date, amount, paid_amount, interest, status, payment_method)
VALUES ('AG-67890', 1, '2024-10-01', null, 1250.00, 0.00, 0.00, 'PENDING', 'PIX');
INSERT INTO INSTALLMENT (agreement_id, number, due_date, payment_date, amount, paid_amount, interest, status, payment_method)
VALUES ('AG-67890', 2, '2024-11-01', null, 1250.00, 0.00, 0.00, 'PENDING', 'DEBIT_CARD');

-- Insert third agreement
INSERT INTO AGREEMENT (id, total_amount) VALUES ('AG-abcde', 300.50);

-- Insert installments
INSERT INTO INSTALLMENT (agreement_id, number, due_date, payment_date, amount, paid_amount, interest, status, payment_method)
VALUES ('AG-abcde', 1, '2025-01-15', '2025-01-10', 150.25, 150.25, 0.00, 'PAID', 'CREDIT_CARD');
INSERT INTO INSTALLMENT (agreement_id, number, due_date, payment_date, amount, paid_amount, interest, status, payment_method)
VALUES ('AG-abcde', 2, '2025-02-15', null, 150.25, 0.00, 0.00, 'PENDING', 'CREDIT_CARD');

-- Insert additional invoices
INSERT INTO INVOICE (id, agreement_id, barcode, amount, due_date, issue_date, issuer, status)
VALUES ('INV-003', 'AG-67890', '000033334444-5555-6666-7777-888899990000', 1250.00, '2024-09-25', '2024-09-10', 'MOCKBANK', 'ACTIVE');

INSERT INTO INVOICE (id, agreement_id, barcode, amount, due_date, issue_date, issuer, status)
VALUES ('INV-004', 'AG-67890', '000055556666-7777-8888-9999-000011112222', 1250.00, '2024-10-25', '2024-10-10', 'PLAYBANK', 'INACTIVE');

INSERT INTO INVOICE (id, agreement_id, barcode, amount, due_date, issue_date, issuer, status)
VALUES ('INV-005', 'AG-abcde', '000077778888-9999-0000-1111-222233334444', 300.50, '2024-12-20', '2024-12-01', 'TOPBANK', 'SUSPENDED');

INSERT INTO INVOICE (id, agreement_id, barcode, amount, due_date, issue_date, issuer, status)
VALUES ('INV-006', 'AG-12345', '000099990000-1111-2222-3333-444455556666', 750.00, '2024-08-15', '2024-08-01', 'MOCKBANK', 'INCONSISTENT');

-- Insert additional installments
INSERT INTO INSTALLMENT (agreement_id, number, due_date, payment_date, amount, paid_amount, interest, status, payment_method)
VALUES ('AG-12345', 3, '2024-10-01', null, 250.00, 0.00, 0.00, 'PENDING', 'BANK_TRANSFER');
INSERT INTO INSTALLMENT (agreement_id, number, due_date, payment_date, amount, paid_amount, interest, status, payment_method)
VALUES ('AG-67890', 3, '2024-12-01', null, 500.00, 0.00, 0.00, 'SUSPENDED', 'PIX');
