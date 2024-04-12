package com.eazybytes.service;

import com.eazybytes.payload.response.AccountTransactionsResDTO;

import java.util.List;

public interface BalanceService {
    List<AccountTransactionsResDTO> getBalanceDetails(int customerId);
}
