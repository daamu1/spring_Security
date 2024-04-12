package com.eazybytes.controller;

import com.eazybytes.payload.request.ContactRequestDTO;
import com.eazybytes.payload.response.ContactResponseDTO;
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

    @PostMapping("/contact")
    public ResponseEntity<?> saveContactInquiryDetails(@Valid @RequestBody ContactRequestDTO contactDTO) {
        ContactResponseDTO savedContact = contactService.saveContactInquiryDetails(contactDTO);
        return ResponseEntity.ok(savedContact);
    }
}
