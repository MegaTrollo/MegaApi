package com.example.demo.services;

import com.example.demo.entity.Card;
import com.example.demo.entity.CardList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CardService {
    void deleteById(Long id);

    List<Card> getAllCardByCardListId(Long cardListId);

    void addCard(Card card, Long cardListId);

    Card changeDescById(Long Id,String desc);
}
