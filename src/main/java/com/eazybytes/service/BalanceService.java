package com.eazybytes.service;

import com.eazybytes.paylaod.response.AccountTransactionsDTO;

import java.util.List;

public interface BalanceService {
    List<AccountTransactionsDTO> getBalanceDetails(int customerId);
}
