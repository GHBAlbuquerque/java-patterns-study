package com.patterns.communication.gateway;

import com.patterns.common.interfaces.datasources.InvoiceRepository;
import com.patterns.common.interfaces.gateways.InvoiceGateway;
import com.patterns.common.mapper.InvoiceMapper;
import com.patterns.communication.dto.request.InvoiceFilterRequest;
import com.patterns.domain.entity.Invoice;
import com.patterns.external.database.orm.InvoiceORM;
import com.patterns.external.database.projections.IssuerView;
import com.patterns.external.database.projections.StatusView;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InvoiceGatewayImpl implements InvoiceGateway {

    private final InvoiceRepository repository;

    public InvoiceGatewayImpl(InvoiceRepository invoiceRepository) {
        this.repository = invoiceRepository;
    }

    @Override
    public Invoice saveInvoice(Invoice invoice) {
        final var orm = InvoiceMapper.fromDomainToORM(invoice);
        final var result = repository.save(orm);
        return InvoiceMapper.fromORMtoDomain(result);
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
    public IssuerView getInvoiceIssuerById(String id) {
        return repository.getIssuerById(id);
    }

    @Override
    public StatusView getInvoiceStatusById(String id) {
        return repository.getStatusById(id);
    }

    @Override
    public List<Invoice> findAllByAgreementId(String agreementId) {
        return repository.findAllByAgreementId(agreementId, PageRequest.of(0, 1000))
                .getContent()
                .stream()
                .map(InvoiceMapper::fromORMtoDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Page<Invoice> getInvoicesWithFilter(InvoiceFilterRequest filter, PageRequest pageRequest) {
        final Specification<InvoiceORM> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.status() != null && !filter.status().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("status"), filter.status()));
            }
            if (filter.issuer() != null && !filter.issuer().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("issuer"), filter.issuer()));
            }
            if (filter.startDate() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("issueDate"), filter.startDate()));
            }
            if (filter.endDate() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("issueDate"), filter.endDate()));
            }
            if (filter.minimumAmount() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("amount"), filter.minimumAmount()));
            }
            if (filter.maximumAmount() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("amount"), filter.maximumAmount()));
            }
            if (filter.barcode() != null && !filter.barcode().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("barcode"), filter.barcode()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        return repository.findAll(spec, pageRequest)
                .map(InvoiceMapper::fromORMtoDomain);
    }
}
