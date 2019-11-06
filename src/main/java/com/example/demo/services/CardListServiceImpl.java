package com.example.demo.services;

import com.example.demo.entity.CardList;
import com.example.demo.repository.BoardRepository;
import com.example.demo.repository.CardListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardListServiceImpl implements CardListService{

    private CardListRepository cardListRepository;
    private BoardRepository boardRepository;

    @Autowired
    public CardListServiceImpl(CardListRepository cardListRepository,BoardRepository boardRepository) {
        this.cardListRepository = cardListRepository;
        this.boardRepository = boardRepository;
    }

    public void addCardList(CardList cardList,Long boardId){
        boardRepository.findById(boardId).map( board -> {
            cardList.setBoardId(board);
            return cardListRepository.save(cardList);
        });
    }

    public List<CardList> getAllCardListByBoardId(Long boardId){
        return cardListRepository.findByBoardId(boardId);
    }
}
