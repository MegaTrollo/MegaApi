package com.example.demo.services;

import com.example.demo.entity.CardList;
import org.springframework.stereotype.Service;

@Service
public interface CardListService {
     void addCardList(CardList cardList, Long boardId);
}
