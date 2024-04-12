package com.eazybytes.service;

import com.eazybytes.model.Accounts;
import com.eazybytes.paylaod.response.AccountsResDTO;

public interface AccountService {
    AccountsResDTO getAccountByCustomerId(int customerId);
}
