package com.eazybytes.service.implemetation;

import com.eazybytes.model.AccountTransactions;
import com.eazybytes.payload.response.AccountTransactionsResDTO;
import com.eazybytes.repository.AccountTransactionsRepository;
import com.eazybytes.service.BalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BalanceServiceImpl implements BalanceService {

    private final AccountTransactionsRepository accountTransactionsRepository;

    @Override
    public List<AccountTransactionsResDTO> getBalanceDetails(int customerId) {
        List<AccountTransactions> transactions = accountTransactionsRepository.findByCustomerIdOrderByTransactionDtDesc(customerId);
        return transactions.stream()
                .map(transaction -> new AccountTransactionsResDTO(
                        transaction.getTransactionId(),
                        transaction.getAccountNumber(),
                        transaction.getCustomerId(),
                        transaction.getTransactionDt(),
                        transaction.getTransactionSummary(),
                        transaction.getTransactionType(),
                        transaction.getTransactionAmt(),
                        transaction.getClosingBalance(),
                        transaction.getCreateDt()
                ))
                .collect(Collectors.toList());
    }
}
