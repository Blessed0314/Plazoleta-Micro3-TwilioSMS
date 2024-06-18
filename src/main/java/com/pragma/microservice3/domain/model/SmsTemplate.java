package com.pragma.microservice3.domain.model;

public class SmsTemplate {

    private final String name;
    private final String cellphone;
    private String bodyMessage;
    private final String code;


    public SmsTemplate(String name, String cellphone, String bodyMessage) {
        this.name = name;
        this.cellphone = cellphone;
        this.bodyMessage = bodyMessage;
        this.code = createCode(cellphone);
    }

    private String createCode(String number) {
        return number.substring(number.length() - 4);
    }

    public String getCellphone() {
        return cellphone;
    }


    public String getBodyMessage() {
        return bodyMessage;
    }

    public void setBodyMessage(String bodyMessage) {
        this.bodyMessage = bodyMessage;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
