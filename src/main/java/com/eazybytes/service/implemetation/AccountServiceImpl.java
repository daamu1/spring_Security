package com.eazybytes.service.implemetation;

import com.eazybytes.exception.CustomerNotFoundException;
import com.eazybytes.model.Accounts;
import com.eazybytes.paylaod.response.AccountsResDTO;
import com.eazybytes.repository.AccountsRepository;
import com.eazybytes.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountsRepository accountsRepository;

    @Override
    public AccountsResDTO getAccountByCustomerId(int customerId) {
        Accounts accounts = accountsRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer is not available in this Customer id"));
        return AccountsResDTO
                .builder()
                .accountNumber(accounts.getAccountNumber())
                .accountType(accounts.getAccountType())
                .branchAddress(accounts.getBranchAddress())
                .creationDate(accounts.getCreateDt())
                .customerId(accounts.getCustomerId())
                .build();
    }
}
