package com.eazybytes.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactResponseDTO {
    private String contactId;
    private String contactName;
    private String contactEmail;
    private String subject;
    private String message;
}
