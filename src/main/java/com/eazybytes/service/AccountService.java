package com.eazybytes.service;

import com.eazybytes.payload.response.AccountsResDTO;

public interface AccountService {
    AccountsResDTO getAccountByCustomerId(int customerId);
}
