package com.endpoints;

import com.entity.CardList;
import com.services.CardListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/cardList")
public class CardListController {

    private CardListServiceImpl cardListService;

    @Autowired
    public CardListController(CardListServiceImpl cardListService) {
        this.cardListService = cardListService;
    }

    @PostMapping("/addListCard/{boardId}")
    public void addListCard(@PathVariable (value = "boardId") String boardId,@Valid @RequestBody CardList cardList){
        cardListService.addCardList(cardList,boardId);
    }

    @GetMapping("/getAllCardListByBoardId/{boardId}")
    public ResponseEntity<List<CardList>> getAllCardListByBoardId(@PathVariable (value = "boardId") String boardId){
        return ResponseEntity.ok(cardListService.getAllCardListByBoardId(boardId));
    }


}
