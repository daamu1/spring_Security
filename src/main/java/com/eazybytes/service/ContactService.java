package com.eazybytes.service;


import com.eazybytes.payload.request.ContactRequestDTO;
import com.eazybytes.payload.response.ContactResDTO;

public interface ContactService {
    ContactResDTO saveContactInquiryDetails(ContactRequestDTO contactDTO);
}
