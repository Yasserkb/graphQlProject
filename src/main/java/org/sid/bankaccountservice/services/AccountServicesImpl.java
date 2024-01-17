package org.sid.bankaccountservice.services;

import org.sid.bankaccountservice.DTO.BankAccountRequestDTO;
import org.sid.bankaccountservice.DTO.BankAccountResponseDTO;
import org.sid.bankaccountservice.entities.BankAccount;
import org.sid.bankaccountservice.mappers.AccountMapper;
import org.sid.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServicesImpl implements AccountServices {
    private BankAccountRepository bankAccountRepository;
    private AccountMapper accountMapper;
    public AccountServicesImpl(BankAccountRepository bankAccountRepository, AccountMapper accountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = accountMapper.fromBankAccountDTO(bankAccountDTO);
        // Generate id and createdAt before saving
//        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreatedAt(new Date());
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(savedBankAccount);
        return bankAccountResponseDTO;

    }
    @Override
    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO) {
//        BankAccount bankAccount = accountMapper.fromBankAccountDTO(bankAccountDTO);
        // Generate id and createdAt before saving
//        bankAccount.setId(id);
//        bankAccount.setCreatedAt(new Date());
        BankAccount bankAccount = BankAccount.builder()
               .id(id)
               .createdAt(new Date())
               .balance(bankAccountDTO.getBalance())
               .currency(bankAccountDTO.getCurrency())
               .type(bankAccountDTO.getType())
               .build();
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(savedBankAccount);
        return bankAccountResponseDTO;

    }

//        BankAccountResponseDTO bankAccountResponseDTO =  BankAccountResponseDTO.builder()
//               .id(savedBankAccount.getId())
//                .balance(savedBankAccount.getBalance())
//                .createdAt(savedBankAccount.getCreatedAt())
//                .currency(savedBankAccount.getCurrency())
//                .type(savedBankAccount.getType())
//               .build();
//                  return bankAccountResponseDTO;
}
//    BankAccount bankAccount = BankAccount.builder()
//            .id(UUID.randomUUID().toString())
//            .createdAt(new Date())
//            .balance(bankAccountDTO.getBalance())
//            .type(bankAccountDTO.getType())
//            .currency(bankAccountDTO.getCurrency())
//            .build();
