package com.example.demo.endpoints;

import com.example.demo.entity.Board;
import com.example.demo.entity.CardList;
import com.example.demo.services.CardListService;
import com.example.demo.services.CardListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/card")
public class CardController {

    private CardListServiceImpl cardListService;

    @Autowired
    public CardController(CardListServiceImpl cardListService) {
        this.cardListService = cardListService;
    }

    @PostMapping("/addListCard/{boardId}")
    public void addListCard(@PathVariable (value = "boardId") Long boardId,@Valid @RequestBody CardList cardList){
        cardListService.addCardList(cardList,boardId);
    }

    @GetMapping("/getAllCardListByBoardId/{boardId}")
    public ResponseEntity<List<CardList>> getAllCardListByBoardId(@PathVariable (value = "boardId") Long boardId){
        return ResponseEntity.ok(cardListService.getAllCardListByBoardId(boardId));
    }
}
