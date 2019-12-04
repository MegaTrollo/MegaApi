package com.services;

import com.entity.Card;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CardService {
    void deleteById(Long id);

    List<Card> getAllCardByCardListId(Long cardListId);

    void addCard(Card card, Long cardListId);

    Card changeDescById(Long Id,String desc);

    Card getCardById(Long cardId);

    Card changeArchiveMod(Long cardId,Boolean archiveMod);

    List<Card> getAllArchiveCardByCardListId(Long cardListId);
}
