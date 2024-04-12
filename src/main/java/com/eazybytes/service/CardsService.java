package com.eazybytes.service;

import com.eazybytes.paylaod.response.CardsResDTO;
import java.util.List;

public interface CardsService {
    List<CardsResDTO> getCardsByCustomerId(int customerId);
}

