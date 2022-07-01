package com.darccelio.digitalbank.model.enums;

public enum StatusEnum {
    ENABLE("Enable"),
    DISABLE("Disable");

    public String value;

    StatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
