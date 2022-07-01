package com.darccelio.digitalbank.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TransactionsEnum {
    DEBIT("Débito"),
    CREDIT("Crédito");
    private String transactions;
}

