package com.darccelio.digitalbank.service.impl;

import com.darccelio.digitalbank.model.Account;
import com.darccelio.digitalbank.model.Branch;
import com.darccelio.digitalbank.model.Client;
import com.darccelio.digitalbank.model.enums.AccountTypeEnum;
import com.darccelio.digitalbank.model.enums.StatusEnum;
import com.darccelio.digitalbank.service.CrudAccountService;

import java.time.LocalDate;
import java.util.List;

public class CrudAccountServiceImpl implements CrudAccountService {

  @Override
  public Account createAccount(
      Client client, Branch branch, AccountTypeEnum typeOfAcctount, LocalDate date) {
    Account account = new Account(client, typeOfAcctount, date);
    return account;
  }

  @Override
  public void printSetOfAccount(Branch branch) {
    for (Account account : branch.getAccounts()) {
      System.out.println(account);
    }
  }

  @Override
  public void disableAccount(Account account) {
    account.setStatus(StatusEnum.DISABLE);
  }

  @Override
  public List<Account> findAllAccount() {
    return null;
  }

  @Override
  public Account findAccountByName(String name) {
    return null;
  }

  @Override
  public Account findAccountByCpf(String cpf) {
    return null;
  }

  @Override
  public Account findAccountByCnpj(String cnpj) {
    return null;
  }
}
