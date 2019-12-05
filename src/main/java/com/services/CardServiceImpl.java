package com.services;

import com.entity.Card;
import com.repository.CardListRepository;
import com.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    private CardRepository cardRepository;
    private CardListRepository cardListRepository;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository, CardListRepository cardListRepository) {
        this.cardRepository = cardRepository;
        this.cardListRepository = cardListRepository;
    }

    @Override
    public void deleteById(Long id) {
        cardRepository.deleteById(id);
    }

    @Override
    public List<Card> getAllCardByCardListId(Long cardListId) {
        List<Card> cardList = cardRepository.getAllCardByCardListId(cardListId);
        List<Card> cardListToSend = new ArrayList<>();
        for(Card card : cardList){
            if(card.getIsArchive() == null || !card.getIsArchive()){
                cardListToSend.add(card);
            }
        }
        return cardListToSend;
    }

    @Override
    public void addCard(Card card, Long cardListId) {
        cardListRepository.findById(cardListId).map( listCard -> {
            card.setCardListId(listCard);
            return cardRepository.save(card);
        });
    }

    @Override
    public Card changeDescById(Long id, String desc) {
        Card cardToUpdate = cardRepository.getOne(id);
        cardToUpdate.setDescription(desc);
        return cardRepository.save(cardToUpdate);
    }

    @Override
    public Card getCardById(Long cardId) {
        return cardRepository.getById(cardId);
    }

    @Override
    public Card changeArchiveMod(Long cardId, Boolean archiveMod) {
        Card card = cardRepository.getOne(cardId);
        card.setIsArchive(archiveMod);
        return cardRepository.save(card);
    }

    @Override
    public List<Card> getAllArchiveCardByCardListId(Long cardListId) {
        List<Card> cardList = cardRepository.getAllCardByCardListId(cardListId);
        List<Card> cardListToSend = new ArrayList<>();
        for(Card card : cardList){
            if(card.getIsArchive()){
               cardListToSend.add(card);
            }
        }
        return cardListToSend;
    }
}
