package com.darccelio.digitalbank.service;

import com.darccelio.digitalbank.model.Account;
import com.darccelio.digitalbank.model.Branch;
import com.darccelio.digitalbank.model.Client;
import com.darccelio.digitalbank.model.enums.AccountTypeEnum;

import java.time.LocalDate;
import java.util.List;

public interface CrudAccountService {

  Account createAccount(
      Client client, Branch branch, AccountTypeEnum typeOfAcctount, LocalDate Date);

  void printSetOfAccount(Branch branch);

  void disableAccount(Account account);

  List<Account> findAllAccount();

  Account findAccountByName(String name);

  Account findAccountByCpf(String cpf);

  Account findAccountByCnpj(String cnpj);
}
