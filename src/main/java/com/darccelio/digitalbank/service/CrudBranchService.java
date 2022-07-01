package com.darccelio.digitalbank.service;

import com.darccelio.digitalbank.model.Account;
import com.darccelio.digitalbank.model.Branch;

public interface CrudBranchService {

  Branch createBranch();

  void updateAccountInBranch(Branch branch, Account account);
}
