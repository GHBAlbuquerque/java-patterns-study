package com.patterns.communication.controller;

import com.patterns.communication.dto.request.CreateAgreementDTO;
import com.patterns.communication.dto.request.UpdateAgreementDTO;
import com.patterns.communication.dto.response.GetAgreementByIdDTO;
import com.patterns.communication.dto.response.GetInvoiceDTO;
import com.patterns.communication.filter.RequiresLockToken;
import com.patterns.common.exception.custom.EntityNotFoundException;
import com.patterns.common.interfaces.gateways.AgreementGateway;
import com.patterns.common.interfaces.usecases.CreateAgreementUseCase;
import com.patterns.common.interfaces.usecases.UpdateAgreementUseCase;
import com.patterns.common.mapper.AgreementMapper;
import com.patterns.domain.entity.Agreement;
import com.patterns.domain.enums.EntityEnum;
import com.patterns.domain.facade.GetAgreementByIdFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Set;

@Validated
@RestController
@RequestMapping("/agreements")
public class AgreementController {

    private final GetAgreementByIdFacade agreementFacade;
    private final CreateAgreementUseCase createAgreementUseCase;
    private final UpdateAgreementUseCase updateAgreementUseCase;
    private final AgreementGateway gateway;

    public AgreementController(GetAgreementByIdFacade agreementFacade,
                               CreateAgreementUseCase createAgreementUseCase,
                               UpdateAgreementUseCase updateAgreementUseCase,
                               AgreementGateway agreementGateway) {
        this.agreementFacade = agreementFacade;
        this.createAgreementUseCase = createAgreementUseCase;
        this.updateAgreementUseCase = updateAgreementUseCase;
        this.gateway = agreementGateway;
    }

    @GetMapping("/{agreementId}")
    public ResponseEntity<GetAgreementByIdDTO> getAgreementById(
            @PathVariable(name = "agreementId") final String agreementId,
            @RequestParam(name = "expand", required = true) final Set<EntityEnum> expand
    ) throws EntityNotFoundException {

        final Agreement detailedResponse =
                agreementFacade.getAgreementById(
                        agreementId,
                        expand
                );

        GetAgreementByIdDTO response = AgreementMapper.fromDomainToGetDTO(detailedResponse);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<GetAgreementByIdDTO> createAgreement(
            @RequestBody @Validated final CreateAgreementDTO createAgreementDTO
    ) {
        final Agreement agreement = AgreementMapper.fromDTOtoDomain(createAgreementDTO);
        final Agreement createdAgreement = createAgreementUseCase.createAgreement(agreement, gateway);

        GetAgreementByIdDTO response = AgreementMapper.fromDomainToGetDTO(createdAgreement);
        return ResponseEntity.created(URI.create(response.id())).body(response);
    }

    @PutMapping("/{agreementId}")
    @RequiresLockToken
    public ResponseEntity<GetAgreementByIdDTO> updateAgreement(
            @PathVariable(name = "agreementId") final String agreementId,
            @RequestBody @Validated final UpdateAgreementDTO updateAgreementDTO
    ) throws EntityNotFoundException {
        final Agreement agreement = AgreementMapper.fromUpdateDTOtoDomain(updateAgreementDTO);
        final Agreement updatedAgreement = updateAgreementUseCase.updateAgreement(agreementId, agreement, gateway);

        GetAgreementByIdDTO response = AgreementMapper.fromDomainToGetDTO(updatedAgreement);
        return ResponseEntity.ok(response);
    }
}
