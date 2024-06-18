package com.pragma.microservice3.adapters.driving.http.controller;

import com.pragma.microservice3.adapters.driving.http.dto.request.AddSmsTemplateRequest;
import com.pragma.microservice3.adapters.driving.http.mapper.ISmsTemplateRequestMapper;
import com.pragma.microservice3.domain.api.ISmsTemplateServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/sms")
@RequiredArgsConstructor
public class SmsTemplateControllerAdapter {

    private final ISmsTemplateServicePort smsTemplateServicePort;
    private final ISmsTemplateRequestMapper smsTemplateRequestMapper;

    @PostMapping("/send")
    public void sendSms(@RequestBody AddSmsTemplateRequest addSmsTemplateRequest) {
        smsTemplateServicePort.sendSms(smsTemplateRequestMapper.toSmsTemplate(addSmsTemplateRequest));
    }
}
