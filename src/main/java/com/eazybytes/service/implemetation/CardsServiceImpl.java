package com.eazybytes.service.implemetation;

import com.eazybytes.model.Cards;
import com.eazybytes.repository.CardsRepository;
import com.eazybytes.payload.response.CardsResDTO;
import com.eazybytes.service.CardsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardsServiceImpl implements CardsService {
    private final CardsRepository cardsRepository;

    @Override
    public List<CardsResDTO> getCardsByCustomerId(int customerId) {
        List<Cards> cards = cardsRepository.findByCustomerId(customerId);
        return cards.stream().map(card -> new CardsResDTO(
                card.getCardId(),
                card.getCardNumber(),
                card.getCardType(),
                card.getTotalLimit(),
                card.getAmountUsed(),
                card.getAvailableAmount(),
                card.getCreateDt()
        )).collect(Collectors.toList());
    }
}
