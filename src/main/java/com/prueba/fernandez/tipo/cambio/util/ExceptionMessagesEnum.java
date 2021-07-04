package com.prueba.fernandez.tipo.cambio.util;

public enum ExceptionMessagesEnum {

    ACCOUNT_NOT_FOUND("Account Not Found"),
    INCORRECT_REQUEST_EMPTY_ITEMS_ORDER("No existe tipo de moneda a cambiar.");

    ExceptionMessagesEnum(String msg) {
        value = msg;
    }

    private final String value;

    public String getValue(){
        return value;
    }
}
