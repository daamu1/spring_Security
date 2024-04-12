package com.eazybytes.controller;

import com.eazybytes.paylaod.response.CardsResDTO;
import com.eazybytes.service.CardsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cards")
public class CardsController {

    private final CardsService cardsService;

    public CardsController(CardsService cardsService) {
        this.cardsService = cardsService;
    }

    /**
     * Retrieves card details for a given customer ID using functional programming for better efficiency.
     * @param customerId the ID of the customer
     * @return ResponseEntity with either the list of cards or not found status
     */
    @GetMapping("/{customerId}")
    public ResponseEntity<List<CardsResDTO>> getCardDetails(@PathVariable int customerId) {
        return Optional.ofNullable(cardsService.getCardsByCustomerId(customerId))
                .filter(cards -> !cards.isEmpty())
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
