package org.sid.bankaccountservice.mappers;

import org.sid.bankaccountservice.DTO.BankAccountRequestDTO;
import org.sid.bankaccountservice.DTO.BankAccountResponseDTO;
import org.sid.bankaccountservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount){
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }

    public BankAccount fromBankAccountDTO(BankAccountRequestDTO bankAccountRequestDTO){
        BankAccount bankAccount = new BankAccount();
        BeanUtils.copyProperties(bankAccountRequestDTO, bankAccount);
        return bankAccount;
    }
}
