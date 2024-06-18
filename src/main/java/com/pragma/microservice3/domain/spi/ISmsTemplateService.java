package com.pragma.microservice3.domain.spi;

import com.pragma.microservice3.domain.model.SmsTemplate;

public interface ISmsTemplateService {
    void sendSms(SmsTemplate smsTemplate);
}
