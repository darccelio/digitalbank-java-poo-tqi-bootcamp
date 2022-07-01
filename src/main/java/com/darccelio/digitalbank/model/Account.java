package com.darccelio.digitalbank.model;

import com.darccelio.digitalbank.model.enums.AccountTypeEnum;
import com.darccelio.digitalbank.model.enums.StatusEnum;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class Account {

    private static int SEQUENCIAL = 1;
    Map<Integer, PostingBank> statements = new LinkedHashMap<>();
    private int number;
    private double balance;
    private Client client;
    private AccountTypeEnum accountTypeEnum;
    private StatusEnum status;

    //  private PostingBank statements;
    //  private List<Map.Entry<LocalDate, PostingBank>> statements = new LinkedList<>();
    private LocalDate openingDate;

    public Account(Client client, AccountTypeEnum accountTypeEnum, LocalDate openingDate) {
        this.number = SEQUENCIAL++;
        this.client = client;
        this.accountTypeEnum = accountTypeEnum;
        this.status = StatusEnum.ENABLE;
        this.openingDate = openingDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Map<Integer, PostingBank> getStatements() {
        return statements;
    }

    public void setStatements(Map<Integer, PostingBank> statements) {
        this.statements = statements;
    }

    //  protected void imprimirInfosComuns() {
    //    System.out.println(String.format("Titular: %s", this.client.getNome()));
    //    System.out.println(String.format("Numero: %d", this.number));
    //    System.out.println(String.format("Saldo: %.2f", this.balance));
    //  }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public AccountTypeEnum getAccountTypeEnum() {
        return accountTypeEnum;
    }

    public void setAccountTypeEnum(AccountTypeEnum accountTypeEnum) {
        this.accountTypeEnum = accountTypeEnum;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }
}
