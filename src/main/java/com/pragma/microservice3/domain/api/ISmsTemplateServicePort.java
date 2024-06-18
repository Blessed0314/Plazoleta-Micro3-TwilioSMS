package com.pragma.microservice3.domain.api;

import com.pragma.microservice3.domain.model.SmsTemplate;

public interface ISmsTemplateServicePort {
    void sendSms(SmsTemplate smsTemplate);
}
