package com.darccelio.digitalbank.model;

import com.darccelio.digitalbank.service.ClientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PrivateConsumerTest {

  private ClientService client;

  @Test
  void Creating_PrivateConsumer_WhenPassingNameAndCpf_Exped_Client() {

    PrivateConsumer clientPrivateConsumerTest =
        new PrivateConsumer("Edson Bernardo Kauê de Paula", "088.941.538-27");

    Assertions.assertEquals("Edson Bernardo Kauê de Paula", clientPrivateConsumerTest.getNome());
    Assertions.assertEquals("088.941.538-27", clientPrivateConsumerTest.getCpf());
  }

  @Test
  void Creating_PrivateConsumer_WhenPassingBlancksOrNullFilds_Expected_TrowExcepction() {
    Assertions.assertThrows(NullPointerException.class, () -> client.createPrivateConsumer("", ""));
  }
}
