package com.darccelio.digitalbank.service.impl;

import com.darccelio.digitalbank.model.BusinessClient;
import com.darccelio.digitalbank.model.Client;
import com.darccelio.digitalbank.model.PrivateConsumer;
import com.darccelio.digitalbank.service.ClientService;

import java.util.Set;

public class ClientServiceImpl implements ClientService {

  @Override
  public PrivateConsumer createPrivateConsumer(String name, String cpf) {
    PrivateConsumer privateConsumer = new PrivateConsumer(name, cpf);
    return privateConsumer;
  }

  @Override
  public BusinessClient createBusinessClient(String name, String cnpj) {
    BusinessClient businessClient = new BusinessClient(name, cnpj);
    return businessClient;
  }

  @Override
  public Set<Client> findAllClientByBranch(String numberBranch) {
    return null;
  }

  @Override
  public Client findClientByName(String name) {
    return null;
  }

  @Override
  public BusinessClient findClientByCnpj(String cnpj) {
    return null;
  }

  @Override
  public PrivateConsumer findClientByCpf(String cpf) {
    return null;
  }
}
