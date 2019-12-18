package com.services;

import com.entity.Card;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CardService {
    void deleteById(String id);

    List<Card> getAllCardByCardListId(Long cardListId);

    void addCard(Card card, Long cardListId);

    Card changeDescById(String Id,String desc);

    Card getCardById(String cardId);

    Card changeArchiveMod(String cardId,Boolean archiveMod);

    List<Card> getAllArchiveCardByCardListId(Long cardListId);
}
