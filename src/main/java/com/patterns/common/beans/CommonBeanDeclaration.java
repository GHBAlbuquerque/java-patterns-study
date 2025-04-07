package com.patterns.common.beans;

import com.patterns.common.properties.PropertiesMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonBeanDeclaration {

    @Bean
    public PropertiesMapper propertiesMapper() {
        return new PropertiesMapper();
    }
}
