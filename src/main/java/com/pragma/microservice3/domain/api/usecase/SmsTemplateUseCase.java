package com.pragma.microservice3.domain.api.usecase;

import com.pragma.microservice3.domain.api.ISmsTemplateServicePort;
import com.pragma.microservice3.domain.model.SmsTemplate;
import com.pragma.microservice3.domain.spi.ISmsTemplateService;

public class SmsTemplateUseCase implements ISmsTemplateServicePort {

    private final ISmsTemplateService smsTemplateService;

    public SmsTemplateUseCase(ISmsTemplateService smsTemplateService) {
        this.smsTemplateService = smsTemplateService;
    }

    @Override
    public void sendSms(SmsTemplate smsTemplate) {
        smsTemplateService.sendSms(smsTemplate);
    }

}
