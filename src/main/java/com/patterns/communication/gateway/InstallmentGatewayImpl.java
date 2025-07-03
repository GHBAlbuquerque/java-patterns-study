package com.patterns.communication.gateway;

import com.patterns.common.interfaces.datasources.InstallmentRepository;
import com.patterns.common.interfaces.gateways.InstallmentGateway;
import com.patterns.common.mapper.InstallmentMapper;
import com.patterns.domain.entity.Installment;
import com.patterns.external.database.id.InstallmentId;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InstallmentGatewayImpl implements InstallmentGateway {

    private final InstallmentRepository repository;

    public InstallmentGatewayImpl(InstallmentRepository installmentRepository) {
        this.repository = installmentRepository;
    }

    @Override
    public Optional<Installment> getById(InstallmentId id) {
        var optional = repository.findById(null); //TODO
        return optional.map(InstallmentMapper::fromORMtoDomain);
    }

    @Override
    public Installment save(Installment installment) {
        final var orm = InstallmentMapper.fromDomainToORM(installment);
        final var result = repository.save(orm);
        return InstallmentMapper.fromORMtoDomain(result);
    }

    @Override
    public List<Installment> findAllByAgreementId(String agreementId) {
        return repository.findByIdAgreementId(agreementId).stream()
                .map(InstallmentMapper::fromORMtoDomain)
                .collect(Collectors.toList());
    }
}