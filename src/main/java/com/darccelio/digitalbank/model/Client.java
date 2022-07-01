package com.darccelio.digitalbank.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class Client {
    //  private Long id;

    @NotBlank(message = "It's necessary to input a valid name")
    private String nome;

    public Client(String nome) {
        this.nome = nome;
    }
}
