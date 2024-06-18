package com.pragma.microservice3.adapters.driving.http.mapper;

import com.pragma.microservice3.adapters.driving.http.dto.request.AddSmsTemplateRequest;
import com.pragma.microservice3.domain.model.SmsTemplate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ISmsTemplateRequestMapper {
    SmsTemplate toSmsTemplate(AddSmsTemplateRequest addSmsTemplateRequest);
}
