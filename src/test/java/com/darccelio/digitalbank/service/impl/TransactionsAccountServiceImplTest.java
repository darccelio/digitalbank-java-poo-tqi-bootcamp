package com.darccelio.digitalbank.service.impl;

import com.darccelio.digitalbank.model.Account;
import com.darccelio.digitalbank.model.Branch;
import com.darccelio.digitalbank.model.BusinessClient;
import com.darccelio.digitalbank.model.enums.AccountTypeEnum;
import com.darccelio.digitalbank.service.ClientService;
import com.darccelio.digitalbank.service.CrudAccountService;
import com.darccelio.digitalbank.service.CrudBranchService;
import com.darccelio.digitalbank.service.TransactionsAccountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class TransactionsAccountServiceImplTest {

  @Test
  void CheckBalanceAccountAfterWithdral_WhenPassedValidValue() {
    CrudBranchService crudBranch = new CrudBranchServiceImpl();
    Branch branchTest = crudBranch.createBranch();

    ClientService client = new ClientServiceImpl();
    BusinessClient businessClientTest =
        client.createBusinessClient("Caleb e Heloisa Mudanças Ltda 1", "04.544.227/0001-59");

    CrudAccountService crudAccount = new CrudAccountServiceImpl();
    Account accountTest =
        crudAccount.createAccount(
            businessClientTest,
            branchTest,
            AccountTypeEnum.CHECKING_ACCOUNT,
            LocalDate.of(2021, 06, 29));

    TransactionsAccountService transacoes = new TransactionsAccountServiceImpl();
    double saldo = transacoes.withdrawCurrency(accountTest, 100.00, LocalDate.of(2021, 06, 29));
    Assertions.assertEquals(-100.00, saldo);
  }

  @Test
  void CheckBalanceAccountAfterDepositValue_WhenPassedValildValue() {
    CrudBranchService crudBranch = new CrudBranchServiceImpl();
    Branch branchTest = crudBranch.createBranch();

    ClientService client = new ClientServiceImpl();
    BusinessClient businessClientTest =
        client.createBusinessClient("Caleb e Heloisa Mudanças Ltda 1", "04.544.227/0001-59");

    CrudAccountService crudAccount = new CrudAccountServiceImpl();
    Account accountTest =
        crudAccount.createAccount(
            businessClientTest,
            branchTest,
            AccountTypeEnum.CHECKING_ACCOUNT,
            LocalDate.of(2021, 06, 29));

    TransactionsAccountService transacoes = new TransactionsAccountServiceImpl();
    transacoes.depositCurrency(accountTest, 1000.00, LocalDate.now());
    Assertions.assertEquals(1000.00, accountTest.getBalance());
  }

  @Test
  void CheckBalanceInSavingAccountAfterDepositValue_WhenPassedValildValue() {

    CrudBranchService crudBranch = new CrudBranchServiceImpl();
    Branch branchTest = crudBranch.createBranch();

    ClientService client = new ClientServiceImpl();
    BusinessClient businessClientTest =
        client.createBusinessClient("Caleb e Heloisa Mudanças Ltda 1", "04.544.227/0001-59");

    CrudAccountService crudAccount = new CrudAccountServiceImpl();
    Account accountTest =
        crudAccount.createAccount(
            businessClientTest, branchTest, AccountTypeEnum.SAVINGS, LocalDate.of(2021, 06, 29));

    TransactionsAccountService transacoes = new TransactionsAccountServiceImpl();
    transacoes.depositCurrency(accountTest, 1000.00, LocalDate.of(2022, 05, 27));
    transacoes.withdrawCurrency(accountTest, 500.00, LocalDate.of(2022, 05, 27));
    transacoes.depositCurrency(accountTest, 2000.00, LocalDate.of(2022, 04, 27));
    transacoes.depositCurrency(accountTest, 3000.00, LocalDate.of(2022, 03, 27));
    Assertions.assertEquals(7764.300000000002, transacoes.getBalanceAccount(accountTest));
  }
}
