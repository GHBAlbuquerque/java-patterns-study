package com.patterns.communication.controller;

import com.patterns.common.dto.response.GetAgreementByIdDTO;
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

    public AgreementController(GetAgreementByIdFacade agreementFacade) {
        this.agreementFacade = agreementFacade;
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

    //TODO post method
}
