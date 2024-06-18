package com.pragma.microservice3.configuration;

import com.pragma.microservice3.domain.api.ISmsTemplateServicePort;
import com.pragma.microservice3.domain.api.usecase.SmsTemplateUseCase;
import com.pragma.microservice3.domain.spi.ISmsTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {


    @Bean
    public ISmsTemplateServicePort smsTemplateServicePort(ISmsTemplateService smsTemplateService){
        return new SmsTemplateUseCase(smsTemplateService);
    }

}
