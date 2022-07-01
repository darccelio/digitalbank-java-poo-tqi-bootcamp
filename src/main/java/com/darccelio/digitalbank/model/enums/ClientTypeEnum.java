package com.darccelio.digitalbank.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ClientTypeEnum {
    PRIVATE_CONSUMER("Private Consumer"),
    BUSINESS_CLIENT("Business Client");

    private String VALUE;
}
