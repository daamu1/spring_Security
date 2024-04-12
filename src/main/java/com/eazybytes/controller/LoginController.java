package com.eazybytes.controller;

import com.eazybytes.payload.request.CustomerRegDTO;
import com.eazybytes.payload.response.CustomerResDTO;
import com.eazybytes.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@Validated
@RestController
@RequiredArgsConstructor
public class LoginController {
    private CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody CustomerRegDTO customerDTO) {
        CustomerResDTO savedCustomer = customerService.registerCustomer(customerDTO);
        return ResponseEntity.ok(savedCustomer);
    }



}
