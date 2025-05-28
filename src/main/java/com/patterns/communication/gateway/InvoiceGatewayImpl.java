package com.patterns.communication.gateway;

import com.patterns.common.interfaces.datasources.InvoiceRepository;
import com.patterns.common.interfaces.gateways.InvoiceGateway;
import com.patterns.common.mapper.InvoiceMapper;
import com.patterns.domain.entity.Invoice;
import com.patterns.external.database.projections.IssuerView;
import com.patterns.external.database.projections.StatusView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public class InvoiceGatewayImpl implements InvoiceGateway {

    private final InvoiceRepository repository;

    public InvoiceGatewayImpl(InvoiceRepository invoiceRepository) {
        this.repository = invoiceRepository;
    }

    @Override
    public Optional<Invoice> getInvoiceById(String id) {
        var optional = repository.findById(id);

        return optional.map(InvoiceMapper::fromORMtoDomain);
    }

    @Override
    public Invoice getInvoiceByBarcode(String barcode) {
        var optional = repository.findByBarcode(barcode);

        return optional.map(InvoiceMapper::fromORMtoDomain).orElse(null);
    }

    @Override
    public Invoice saveInvoice(Invoice invoice) {
        final var orm = InvoiceMapper.fromDomainToORM(invoice);
        final var result = repository.save(orm);
        return InvoiceMapper.fromORMtoDomain(result);
    }

    @Override
    public IssuerView getInvoiceIssuerById(String id) {
        return repository.getIssuerById(id);
    }

    @Override
    public StatusView getInvoiceStatusById(String id) {
        return repository.getStatusById(id);
    }

    @Override
    public Page<Invoice> findAllByStatus(String status, PageRequest pageRequest) {
        return repository.findAllByStatus(status, pageRequest)
                .map(InvoiceMapper::fromORMtoDomain);
    }

    @Override
    public Page<Invoice> findAllByIssuer(String issuer, PageRequest pageRequest) {
        return repository.findAllByIssuer(issuer, pageRequest)
                .map(InvoiceMapper::fromORMtoDomain);
    }

    @Override
    public Page<Invoice> findAllByIssueDateBetween(LocalDate startDate, LocalDate endDate, PageRequest pageRequest) {
        final var result =  repository.findAllByIssueDateBetween(startDate, endDate, pageRequest)
                .map(InvoiceMapper::fromORMtoDomain);

        return result;
    }

    @Override
    public Page<Invoice> findAllByAmountBetween(BigDecimal minimumAmount, BigDecimal maximumAmount, PageRequest pageRequest) {
        return repository.findAllByAmountBetween(minimumAmount, maximumAmount, pageRequest)
                .map(InvoiceMapper::fromORMtoDomain);
    }
}
