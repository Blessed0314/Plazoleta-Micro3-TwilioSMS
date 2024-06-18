package com.pragma.microservice3.adapters.driving.http.dto.request;

import com.pragma.microservice3.adapters.driving.http.util.MessageConstants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddSmsTemplateRequest {
    @NotBlank(message = MessageConstants.FIELD_NAME_NULL_MESSAGE)
    private String name;

    @NotBlank(message = MessageConstants.FIELD_CELLPHONE_NULL_MESSAGE)
    @Pattern(regexp = "^(\\+)?\\d{1,13}$", message = MessageConstants.FIELD_CELLPHONE_ONLY_NUMBERS_MESSAGE)
    private String cellphone;
}
