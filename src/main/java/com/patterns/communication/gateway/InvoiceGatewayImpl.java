package com.patterns.communication.gateway;

import com.patterns.common.interfaces.datasources.InvoiceRepository;
import com.patterns.common.interfaces.gateways.InvoiceGateway;
import com.patterns.common.mapper.InvoiceMapper;
import com.patterns.domain.entity.Invoice;
import com.patterns.external.database.projections.IssuerView;
import com.patterns.external.database.projections.StatusView;

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
}
