package com.services;

import com.entity.CardList;
import org.springframework.stereotype.Service;

@Service
public interface CardListService {
     void addCardList(CardList cardList, String boardId);
}
