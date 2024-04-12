package com.eazybytes.controller;

import com.eazybytes.payload.response.AccountTransactionsResDTO;
import com.eazybytes.service.BalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class BalanceController {

    private final BalanceService balanceService;

    /**
     * Retrieves the transaction details of an account based on the customer ID.
     * This method returns a list of transactions if they exist, or a 204 No Content status if no transactions are found.
     *
     * @param id The customer ID for whom to retrieve transaction details.
     * @return ResponseEntity containing either the list of transactions or a No Content status
     */
    @GetMapping("/myBalance")
    public ResponseEntity<List<AccountTransactionsResDTO>> getBalanceDetails(@RequestParam int id) {
        return Optional.ofNullable(balanceService.getBalanceDetails(id))
                .filter(notEmpty -> !notEmpty.isEmpty())
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }
}
