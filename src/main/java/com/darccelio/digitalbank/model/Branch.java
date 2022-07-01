package com.darccelio.digitalbank.model;

import lombok.Getter;

import java.util.Set;

@Getter
public class Branch {

    static StringBuilder str = new StringBuilder();
    private int sequence = 0;
    private String number;
    private Set<Account> accounts;

    public Branch() {
        this.number = generateSequenceNumberBranch(++sequence);
    }

    private String generateSequenceNumberBranch(int number) {
        if (number < 10) return "000".concat(String.valueOf(number));
        if (number < 100) return "00".concat(String.valueOf(number));
        if (number < 1000) return "0".concat(String.valueOf(number));
        return String.valueOf(number);
    }
}
