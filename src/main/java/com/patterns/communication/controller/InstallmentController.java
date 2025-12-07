package com.patterns.communication.controller;

import com.patterns.communication.dto.request.CreateInstallmentDTO;
import com.patterns.communication.dto.response.GetInstallmentDTO;
import com.patterns.common.interfaces.usecases.CreateInstallmentUseCase;
import com.patterns.common.mapper.InstallmentMapper;
import com.patterns.domain.entity.Installment;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@Validated
@RestController
@RequestMapping("/installments")
public class InstallmentController {

    private CreateInstallmentUseCase createInstallmentUseCase;

    public InstallmentController(CreateInstallmentUseCase createInstallmentUseCase) {
        this.createInstallmentUseCase = createInstallmentUseCase;
    }

    @PostMapping
    public GetInstallmentDTO createInstallment(
            @RequestBody @Validated final CreateInstallmentDTO createInstallmentDTO
    ) {
        final Installment installment = InstallmentMapper.fromDTOToDomain(createInstallmentDTO);
        final Installment createdInstallment = createInstallmentUseCase.create(installment);
        return InstallmentMapper.fromDomainToGetDTO(createdInstallment);
    }

    @PostMapping("/batch")
    public List<GetInstallmentDTO> batchCreateInstallments(
            @RequestBody @Validated final List<CreateInstallmentDTO> installments
    ) {
        if (Objects.isNull(installments) || installments.isEmpty()) {
            throw new IllegalArgumentException("Installments list cannot be null or empty");
        }

        final List<Installment> entities = installments.stream().map(InstallmentMapper::fromDTOToDomain)
                        .toList();

        final List<Installment> result = createInstallmentUseCase.batchCreate(entities);

        return result.stream().map(InstallmentMapper::fromDomainToGetDTO).toList();
    }
}
