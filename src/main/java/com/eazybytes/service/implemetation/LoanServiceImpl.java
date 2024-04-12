package com.eazybytes.service.implemetation;


import com.eazybytes.payload.response.LoanResDTO;
import com.eazybytes.repository.LoanRepository;
import com.eazybytes.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;

    @Override
    public List<LoanResDTO> getLoansByCustomerId(int customerId) {
        return loanRepository.findByCustomerIdOrderByStartDtDesc(customerId)
                .stream()
                .map(loan -> new LoanResDTO(
                        loan.getLoanNumber(),
                        loan.getCustomerId(),
                        loan.getStartDt(),
                        loan.getLoanType(),
                        loan.getTotalLoan(),
                        loan.getAmountPaid(),
                        loan.getOutstandingAmount(),
                        loan.getCreateDt()
                ))
                .collect(Collectors.toList());
    }
}
