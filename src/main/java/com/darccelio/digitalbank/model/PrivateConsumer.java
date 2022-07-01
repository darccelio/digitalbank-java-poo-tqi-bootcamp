package com.darccelio.digitalbank.model;

import com.darccelio.digitalbank.model.enums.ClientTypeEnum;
import jakarta.validation.constraints.NotBlank;

public class PrivateConsumer extends Client {

  @NotBlank private String cpf;

  private ClientTypeEnum typeConsumer;

  public PrivateConsumer(String nome, String cpf) {
    super(nome);
    this.cpf = cpf;
    this.typeConsumer = ClientTypeEnum.PRIVATE_CONSUMER;
  }

  public String getCpf() {
    return this.cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public ClientTypeEnum getTypeConsumer() {
    return this.typeConsumer;
  }

  public void setTypeConsumer(ClientTypeEnum typeConsumer) {
    this.typeConsumer = typeConsumer;
  }

  public boolean equals(final Object o) {
    if (o == this) return true;
    if (!(o instanceof PrivateConsumer)) return false;
    final PrivateConsumer other = (PrivateConsumer) o;
    if (!other.canEqual((Object) this)) return false;
    final Object this$cpf = this.getCpf();
    final Object other$cpf = other.getCpf();
    if (this$cpf == null ? other$cpf != null : !this$cpf.equals(other$cpf)) return false;
    final Object this$typeConsumer = this.getTypeConsumer();
    final Object other$typeConsumer = other.getTypeConsumer();
    if (this$typeConsumer == null
        ? other$typeConsumer != null
        : !this$typeConsumer.equals(other$typeConsumer)) return false;
    return true;
  }

  protected boolean canEqual(final Object other) {
    return other instanceof PrivateConsumer;
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $cpf = this.getCpf();
    result = result * PRIME + ($cpf == null ? 43 : $cpf.hashCode());
    final Object $typeConsumer = this.getTypeConsumer();
    result = result * PRIME + ($typeConsumer == null ? 43 : $typeConsumer.hashCode());
    return result;
  }

  public String toString() {
    return "PrivateConsumer(cpf="
        + this.getCpf()
        + ", typeConsumer="
        + this.getTypeConsumer()
        + ")";
  }
}
