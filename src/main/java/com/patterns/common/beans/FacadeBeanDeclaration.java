package com.patterns.common.beans;

import com.patterns.domain.facade.GetAgreementByIdFacade;
import com.patterns.domain.strategy.entity.Middleware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class FacadeBeanDeclaration {

     @Bean
     public GetAgreementByIdFacade getAgreementByIdFacade(List<Middleware> entityStrategies) {
         return new GetAgreementByIdFacade(entityStrategies);
     }
}
