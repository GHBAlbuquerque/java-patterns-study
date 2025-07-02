package com.patterns.communication.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/agreements")
public class AgreementController {


//    @GetMapping("/{agreementId}")
//    public GetAgreementById getAgreementById(
//            @PathVariable(name = "agreementId") final String agreementId,
//            @RequestParam(name = "expand", required = true) final Set<EntityEnum> expand
//) {
//
//        final AgreementDetailedResponse detailedResponse =
//                agreementFacade.getAgreementById(
//                        agreementId,
//                        resolveExpandSet(expand),
//                        baseOrigin
//                );
//
//        return new SaidaDefault(detailedResponse);
//    }
}
