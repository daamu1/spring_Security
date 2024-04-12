package com.eazybytes.service.implemetation;

import com.eazybytes.model.Customer;
import com.eazybytes.payload.request.CustomerRegDTO;
import com.eazybytes.payload.response.CustomerResDTO;
import com.eazybytes.repository.CustomerRepository;
import com.eazybytes.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public CustomerResDTO registerCustomer(CustomerRegDTO customerDto) {
        Customer customer = Customer.builder()
                .name(customerDto.getName())
                .email(customerDto.getEmail())
                .mobileNumber(customerDto.getMobileNumber())
                .pwd(passwordEncoder.encode(customerDto.getPwd()))
                .build();

        customer = customerRepository.save(customer);
        return new CustomerResDTO(
                customer.getCustomerId(),
                customer.getName(),
                customer.getEmail(),
                customer.getMobileNumber(),
                customer.getRole(),
                customer.getCreateDt()
        );
    }
}
