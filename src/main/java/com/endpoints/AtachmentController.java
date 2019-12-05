package com.endpoints;

import com.entity.Card;
import com.services.CardService;
import com.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/attachment")
public class AtachmentController {


    private CardService cardService;
    private ImageService imageService;

    @Autowired
    public AtachmentController(CardService cardService, ImageService imageService) {
        this.cardService = cardService;
        this.imageService = imageService;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    @ResponseBody
    public ResponseEntity<Card> addCardAtachment(@RequestPart("myFile") MultipartFile[] files, @RequestPart("card") Card card) throws IOException {
        Long cardId = card.getId();
        System.out.println(card);
        Card daoCard = cardService.getCardById(cardId);
        daoCard.setImages(imageService.uploadImageArrayForCard(files,daoCard));

        return ResponseEntity.ok(daoCard);
    }
}
