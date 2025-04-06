package com.patterns.common.beans;

import com.patterns.common.properties.PropertiesMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonBeanDeclaration {

    @Bean
    public Logger logger() {
        return LogManager.getLogger();
    }

    @Bean
    public PropertiesMapper propertiesMapper() {
        return new PropertiesMapper();
    }
}
