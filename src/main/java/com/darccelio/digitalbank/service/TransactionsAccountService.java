package com.darccelio.digitalbank.service;

import com.darccelio.digitalbank.model.Account;

import java.time.LocalDate;

public interface TransactionsAccountService {

  double withdrawCurrency(Account account, double currency, LocalDate date);

  void depositCurrency(Account account, double currency, LocalDate date);

  //    void transferAccount(Account accountFrom, Account accountTo, double currency);

  void transferAccount(Account accountFrom, Account accountTo, double currency);

  double getBalanceAccount(Account account);
}
