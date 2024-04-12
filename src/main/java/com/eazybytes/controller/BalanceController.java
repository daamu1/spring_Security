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

    @GetMapping("/myBalance")
    public ResponseEntity<List<AccountTransactionsResDTO>> getBalanceDetails(@RequestParam int id) {
        return Optional.ofNullable(balanceService.getBalanceDetails(id))
                .filter(notEmpty -> !notEmpty.isEmpty())
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }
}
