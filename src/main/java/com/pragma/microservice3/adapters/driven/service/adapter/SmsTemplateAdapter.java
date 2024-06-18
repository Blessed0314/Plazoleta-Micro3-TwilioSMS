package com.pragma.microservice3.adapters.driven.service.adapter;

import com.pragma.microservice3.adapters.driven.service.exception.SmsNotSendException;
import com.pragma.microservice3.domain.model.SmsTemplate;
import com.pragma.microservice3.domain.spi.ISmsTemplateService;
import com.twilio.Twilio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SmsTemplateAdapter implements ISmsTemplateService {

    @Value("${twilio.account_sid}")
    private String sid;

    @Value("${twilio.auth_token}")
    private String token;

    @Value("${twilio.trial_number}")
    private String phone_number;


    @Override
    public void sendSms(SmsTemplate smsTemplate) {
        smsTemplate.setBodyMessage("Hello, " + smsTemplate.getName() + "\n" + "Your delivery's code is: " + smsTemplate.getCode() + "\n" + "Thanks for your purchase");
        try{
            Twilio.init(sid, token);
            com.twilio.rest.api.v2010.account.Message.creator(
                    new com.twilio.type.PhoneNumber(smsTemplate.getCellphone()),
                    new com.twilio.type.PhoneNumber(phone_number),
                    smsTemplate.getBodyMessage()
            ).create();

        } catch (SmsNotSendException e) {
            e.printStackTrace();
        }
    }
}
