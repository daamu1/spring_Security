package com.eazybytes.service;


import com.eazybytes.payload.response.LoanResDTO;

import java.util.List;

public interface LoanService {
    List<LoanResDTO> getLoansByCustomerId(int customerId);
}
