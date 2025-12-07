package com.patterns.communication.gateway;

import com.patterns.common.interfaces.datasources.AgreementRepository;
import com.patterns.common.interfaces.gateways.AgreementGateway;
import com.patterns.common.mapper.AgreementMapper;
import com.patterns.domain.entity.Agreement;
import java.util.Optional;

public class AgreementGatewayImpl implements AgreementGateway {

    private final AgreementRepository repository;

    public AgreementGatewayImpl(AgreementRepository agreementRepository) {
        this.repository = agreementRepository;
    }

    @Override
    public Optional<Agreement> getById(String id) {
        var optional = repository.findById(id);
        return optional.map(AgreementMapper::fromORMtoDomain);
    }

    @Override
    public Agreement save(Agreement agreement) {
        final var orm = AgreementMapper.fromDomainToORM(agreement);
        final var result = repository.save(orm);
        return AgreementMapper.fromORMtoDomain(result);
    }

    @Override
    public Agreement update(Agreement agreement) {
        final var orm = AgreementMapper.fromDomainToORM(agreement);
        final var result = repository.save(orm); // save can be used for update if the ID exists
        return AgreementMapper.fromORMtoDomain(result);
    }

    @Override
    public boolean existsById(String id) {
        return repository.existsById(id);
    }
}