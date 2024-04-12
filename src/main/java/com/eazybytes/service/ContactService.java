package com.eazybytes.service;


import com.eazybytes.payload.response.ContactResponseDTO;

public interface ContactService {
    ContactResponseDTO saveContactInquiryDetails(com.eazybytes.payload.request.ContactRequestDTO contactDTO);
}
