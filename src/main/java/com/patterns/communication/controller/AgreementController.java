package com.patterns.communication.controller;

import com.patterns.common.dto.request.CreateAgreementDTO;
import com.patterns.common.dto.response.GetAgreementByIdDTO;
import com.patterns.common.interfaces.gateways.AgreementGateway;
import com.patterns.common.interfaces.usecases.CreateAgreementUseCase;
import com.patterns.common.mapper.AgreementMapper;
import com.patterns.domain.entity.Agreement;
import com.patterns.domain.enums.EntityEnum;
import com.patterns.domain.facade.GetAgreementByIdFacade;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Validated
@RestController
@RequestMapping("/agreements")
public class AgreementController {

    private final GetAgreementByIdFacade agreementFacade;
    private final CreateAgreementUseCase createAgreementUseCase;
    private final AgreementGateway gateway;

    public AgreementController(GetAgreementByIdFacade agreementFacade, CreateAgreementUseCase createAgreementUseCase, AgreementGateway agreementGateway) {
        this.agreementFacade = agreementFacade;
        this.createAgreementUseCase = createAgreementUseCase;
        this.gateway = agreementGateway;
    }

    @GetMapping("/{agreementId}")
    public GetAgreementByIdDTO getAgreementById(
            @PathVariable(name = "agreementId") final String agreementId,
            @RequestParam(name = "expand", required = true) final Set<EntityEnum> expand
    ) {

        final Agreement detailedResponse =
                agreementFacade.getAgreementById(
                        agreementId,
                        expand
                );

        return AgreementMapper.fromDomainToGetDTO(detailedResponse);
    }

    @PostMapping
    public GetAgreementByIdDTO createAgreement(
            @RequestBody @Validated final CreateAgreementDTO createAgreementDTO
    ) {
        final Agreement agreement = AgreementMapper.fromDTOtoDomain(createAgreementDTO);
        final Agreement createdAgreement = createAgreementUseCase.createAgreement(agreement, gateway);
        return AgreementMapper.fromDomainToGetDTO(createdAgreement);
    }
}
