package com.eazybytes.service;

import com.eazybytes.paylaod.response.AccountTransactionsResDTO;

import java.util.List;

public interface BalanceService {
    List<AccountTransactionsResDTO> getBalanceDetails(int customerId);
}
