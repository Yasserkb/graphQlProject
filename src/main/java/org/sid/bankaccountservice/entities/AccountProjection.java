package org.sid.bankaccountservice.entities;

import org.sid.bankaccountservice.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class, name = "p1")
public interface AccountProjection {
    String getId();
    AccountType getType();
    Double getBalance();
}

/**
 * with this method i could easaly specify the fealds that i could send using my REST_API like it's a graphql application
 * but i think it's not ideal for an app to be like this in a production level maybe on a early testing phase
 */