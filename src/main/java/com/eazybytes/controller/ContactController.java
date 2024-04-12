package com.eazybytes.controller;

import com.eazybytes.payload.request.ContactRequestDTO;
import com.eazybytes.payload.response.ContactResDTO;
import com.eazybytes.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@Validated
public class ContactController {

    @Autowired
    private ContactService contactService;

    /**
     * Receives a contact inquiry request, validates it, and saves it to the database.
     * Returns the saved contact inquiry details along with an appropriate HTTP status.
     *
     * @param contactDTO Data Transfer Object containing the contact inquiry details.
     * @return ResponseEntity containing the saved contact details or an error message.
     */
    @PostMapping("/contact")
    public ResponseEntity<ContactResDTO> saveContactInquiryDetails(@Valid @RequestBody ContactRequestDTO contactDTO) {
        ContactResDTO savedContact = contactService.saveContactInquiryDetails(contactDTO);
        return ResponseEntity.ok(savedContact);
    }
}
