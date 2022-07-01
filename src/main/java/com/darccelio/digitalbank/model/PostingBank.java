package com.darccelio.digitalbank.model;

import com.darccelio.digitalbank.model.enums.TransactionsEnum;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class PostingBank implements Comparable<LocalDate> {

  private static int sequence = 0;
  private int id;
  private LocalDate date;
  private Account account;
  private double currency;
  private TransactionsEnum transactions;

  public PostingBank(
      LocalDate date, Account account, double currency, TransactionsEnum transactions) {
    this.id = ++sequence;
    this.date = date;
    this.account = account;
    this.currency = currency;
    this.transactions = transactions;
  }

  public int getId() {
    return id;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public double getCurrency() {
    return currency;
  }

  public void setCurrency(double currency) {
    this.currency = currency;
  }

  public TransactionsEnum getTransactions() {
    return transactions;
  }

  public void setTransactions(TransactionsEnum transactions) {
    this.transactions = transactions;
  }

  @Override
  public int compareTo(LocalDate anotherDate) {
    return this.date.compareTo(anotherDate);
  }

  @Override
  public String toString() {
    return "PostingBank{"
        + "sequence="
        + sequence
        + ", id="
        + id
        + ", date="
        + date
        + ", account="
        + account
        + ", currency="
        + currency
        + ", transactions="
        + transactions
        + '}';
  }
}
