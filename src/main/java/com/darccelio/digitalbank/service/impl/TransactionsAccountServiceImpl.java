package com.darccelio.digitalbank.service.impl;

import com.darccelio.digitalbank.model.Account;
import com.darccelio.digitalbank.model.PostingBank;
import com.darccelio.digitalbank.model.enums.AccountTypeEnum;
import com.darccelio.digitalbank.model.enums.TransactionsEnum;
import com.darccelio.digitalbank.service.TransactionsAccountService;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class TransactionsAccountServiceImpl implements TransactionsAccountService {

  @Override
  public double withdrawCurrency(Account account, double currency, LocalDate date) {
    updateStatements(account, currency, LocalDate.now(), TransactionsEnum.DEBIT);
    account.setBalance(account.getBalance() - currency);
    return account.getBalance();
  }

  @Override
  public void depositCurrency(Account account, double currency, LocalDate date) {
    updateStatements(account, currency, date, TransactionsEnum.CREDIT);
    account.setBalance(account.getBalance() + currency);
  }

  private void updateStatements(
      Account account, double currency, LocalDate date, TransactionsEnum transaction) {

    if (transaction.equals(TransactionsEnum.DEBIT)) {
      currency *= -1.0;
    }

    PostingBank postingBank = new PostingBank(date, account, currency, transaction);
    System.out.println(
        "updateStatements \n PostingBanck: "
            + postingBank.getCurrency()
            + " ID: "
            + postingBank.getId());

    Map<Integer, PostingBank> postingBanksList = account.getStatements();
    postingBanksList.put(postingBank.getId(), postingBank);
    account.setStatements(postingBanksList);

    System.out.println("\nTamanho do Extrato após insercao: " + account.getStatements().size());

    for (PostingBank value : postingBanksList.values()) {
      System.out.println("Value update: " + value.getCurrency() + " ID: " + value.getId());
    }
  }

  @Override
  public void transferAccount(Account accountFrom, Account accountTo, double currency) {
    double teste = withdrawCurrency(accountFrom, currency, LocalDate.now());
    depositCurrency(accountTo, currency, LocalDate.now());
  }

  @Override
  public double getBalanceAccount(Account account) {
    if (account.getAccountTypeEnum().equals(AccountTypeEnum.SAVINGS)) {
      return calculateInterest(account);
    }
    return account.getBalance();
  }

  private double calculateInterest(Account account) {

    double accBalance = 0.0;

    Map<Integer, PostingBank> statements = account.getStatements();
    Collection<PostingBank> values = statements.values();
    System.out.println("Tamanho do Extrato: " + values.size());

    Iterator<PostingBank> iterator = values.iterator();
    System.out.println("Value: " + values);

    while (iterator.hasNext()) {
      PostingBank value = iterator.next();
      System.out.println("Value: " + value.getCurrency());
      LocalDate depositDate = value.getDate();
      int qttDiffMonths = calculateDiffMonths(depositDate);
      double interestRatesInDecimal = 1.1;
      double rateToPow = Math.pow(interestRatesInDecimal, qttDiffMonths);
      double updateInterest = value.getCurrency() * rateToPow;
      accBalance += updateInterest;
    }

    return accBalance;
  }

  private int calculateDiffMonths(LocalDate depositDate) {

    LocalDate localDateToCompare = LocalDate.now();
    int dateDiff = localDateToCompare.compareTo(depositDate);

    if (dateDiff < 0)
      throw new RuntimeException("Date of Opening Account had informed is after date of today");

    return dateDiff;
  }
}
