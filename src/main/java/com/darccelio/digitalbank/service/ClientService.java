package com.darccelio.digitalbank.service;

import com.darccelio.digitalbank.model.BusinessClient;
import com.darccelio.digitalbank.model.Client;
import com.darccelio.digitalbank.model.PrivateConsumer;

import java.util.Set;

public interface ClientService {

  PrivateConsumer createPrivateConsumer(String name, String cpf);

  BusinessClient createBusinessClient(String name, String cnpj);

  Set<Client> findAllClientByBranch(String numberBranch);

  Client findClientByName(String name);

  PrivateConsumer findClientByCpf(String cpf);

  BusinessClient findClientByCnpj(String cnpj);
}
