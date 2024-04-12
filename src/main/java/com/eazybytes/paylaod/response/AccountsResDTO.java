package com.eazybytes.paylaod.response;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class AccountsResDTO {
    private long accountNumber;
    private int customerId;
    private String accountType;
    private String branchAddress;
    private Date creationDate;
}
