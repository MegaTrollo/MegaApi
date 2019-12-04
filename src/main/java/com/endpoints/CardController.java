package com.endpoints;


import com.entity.Card;
import com.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/card")
public class CardController {
    private CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/addCard/{cardListId}")
    public void addCard(@PathVariable(value = "cardListId") Long cardListId, @Valid @RequestBody Card card){
        cardService.addCard(card,cardListId);
    }

    @GetMapping("/getAllCardByCardListId/{cardListId}")
    public ResponseEntity<List<Card>> getAllCardByCardListId(@PathVariable Long cardListId){
        return ResponseEntity.ok(cardService.getAllCardByCardListId(cardListId));
    }

    @GetMapping("/getAllArchiveCardByCardListId/{cardListId}")
    public ResponseEntity<List<Card>> getAllArchiveCardByCardListId(@PathVariable Long cardListId){
        return ResponseEntity.ok(cardService.getAllArchiveCardByCardListId(cardListId));
    }

    @DeleteMapping("/deleteCard/{id}")
    void deleteCard(@PathVariable Long id) {
        cardService.deleteById(id);
    }

    @PostMapping("/changeDesc/{id}/{description}")
    ResponseEntity<Card> changeDescById(@PathVariable Long id, @PathVariable String description) {
        return ResponseEntity.ok(cardService.changeDescById(id, description));
    }

    @GetMapping("/getCardById/{cardId}")
    public ResponseEntity<Card> getCardById(@PathVariable Long cardId){
        return ResponseEntity.ok(cardService.getCardById(cardId));
    }

    @PostMapping("/changeArchiveMode/{cardId}/{archiveMod}")
    public ResponseEntity<Card> changeArchiveMode(@PathVariable Long cardId,@PathVariable Long archiveMod){
        return ResponseEntity.ok(cardService.changeArchiveMod(cardId,archiveMod==0));
    }
}
