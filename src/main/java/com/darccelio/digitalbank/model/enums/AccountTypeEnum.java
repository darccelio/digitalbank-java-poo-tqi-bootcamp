package com.darccelio.digitalbank.model.enums;

public enum AccountTypeEnum {
    CHECKING_ACCOUNT("Checking Account"),
    SAVINGS("Savings");

    private String value;

    AccountTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
