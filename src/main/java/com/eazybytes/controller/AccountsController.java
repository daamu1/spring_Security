package com.eazybytes.controller;

import com.eazybytes.payload.response.AccountsResDTO;
import com.eazybytes.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountsController {

    private final AccountService accountService;

    /**
     * Retrieves account details by customer ID.
     * @param customerId the ID of the customer
     * @return ResponseEntity containing the account details
     */
    @GetMapping("/{customerId}")
    public ResponseEntity<AccountsResDTO> getAccountDetails(@PathVariable int customerId) {
        AccountsResDTO accountDetails = accountService.getAccountByCustomerId(customerId);
        return ResponseEntity.ok(accountDetails);
    }
}
