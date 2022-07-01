package com.darccelio.digitalbank.service.impl;

import com.darccelio.digitalbank.model.Account;
import com.darccelio.digitalbank.model.Branch;
import com.darccelio.digitalbank.service.CrudBranchService;

public class CrudBranchServiceImpl implements CrudBranchService {

  @Override
  public Branch createBranch() {
    return new Branch();
  }

  @Override
  public void updateAccountInBranch(Branch branch, Account account) {
    branch.getAccounts().add(account);
  }
}
