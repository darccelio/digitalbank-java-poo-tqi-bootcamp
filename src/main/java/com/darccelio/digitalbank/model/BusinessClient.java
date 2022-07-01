package com.darccelio.digitalbank.model;

import com.darccelio.digitalbank.model.enums.ClientTypeEnum;
import org.hibernate.validator.constraints.br.CNPJ;

public class BusinessClient extends Client {

  @CNPJ private String cnpj;
  private ClientTypeEnum clientType;

  public BusinessClient(String nome, String cnpj) {
    super(nome);
    this.cnpj = cnpj;
    this.clientType = ClientTypeEnum.BUSINESS_CLIENT;
  }
}
