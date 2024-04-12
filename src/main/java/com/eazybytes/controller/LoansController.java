package com.eazybytes.controller;

import com.eazybytes.payload.response.LoanResDTO;
import com.eazybytes.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/loans")
@RequiredArgsConstructor
public class LoansController {

    private final LoanService loanService;

    /**
     * Retrieves loan details for a given customer ID.
     * This method returns an HTTP response entity with either the list of loans or a not found status.
     *
     * @param customerId the ID of the customer
     * @return ResponseEntity containing the list of loans or not found status
     */
    @GetMapping("/{customerId}")
    public ResponseEntity<List<LoanResDTO>> getLoanDetails(@PathVariable int customerId) {
        return Optional.ofNullable(loanService.getLoansByCustomerId(customerId))
                .filter(loans -> !loans.isEmpty())
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
