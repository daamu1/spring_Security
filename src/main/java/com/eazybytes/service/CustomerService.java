package com.eazybytes.service;


import com.eazybytes.payload.request.CustomerRegDTO;
import com.eazybytes.payload.response.CustomerResDTO;

public interface CustomerService {
    CustomerResDTO registerCustomer(CustomerRegDTO customerDto);
}
