package com.eazybytes.service.implemetation;

import com.eazybytes.model.Contact;
import com.eazybytes.payload.response.ContactResponseDTO;
import com.eazybytes.payload.request.*;
import com.eazybytes.repository.ContactRepository;
import com.eazybytes.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Override
    public ContactResponseDTO saveContactInquiryDetails(ContactRequestDTO contactDTO) {
        Random random = new Random();
        String serviceReqNumber = "SR" + (random.nextInt(999999999 - 9999) + 9999);

        Contact contact = new Contact(
                serviceReqNumber,
                contactDTO.getContactName(),
                contactDTO.getContactEmail(),
                contactDTO.getSubject(),
                contactDTO.getMessage(),
                new Date(System.currentTimeMillis())
        );

        contact = contactRepository.save(contact);

        return new ContactResponseDTO(
                contact.getContactId(),
                contact.getContactName(),
                contact.getContactEmail(),
                contact.getSubject(),
                contact.getMessage()
        );
    }
}
