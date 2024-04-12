package com.eazybytes.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResDTO {
    private int customerId;
    private String name;
    private String email;
    private String mobileNumber;
    private String role;
    private String createDt;
}
