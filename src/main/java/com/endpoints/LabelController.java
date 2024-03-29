package com.endpoints;

import com.entity.Card;
import com.entity.Label;
import com.services.LabelService;
import com.services.LabelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/label")
public class LabelController {

    private LabelService labelService;

    @Autowired
    public LabelController(LabelService labelService) {
        this.labelService = labelService;
    }

    @PostMapping("/addLabel/{cardId}")
    public void addLabelToCard(@PathVariable(value = "cardId") String cardId, @RequestBody Label label) {
        labelService.addNewLabelToCard(cardId, label);
    }

    @GetMapping("/getLabelsByCardId/{cardId}")
    public ResponseEntity<List<Label>> getLabelsByCardId(@PathVariable String cardId) {
        return ResponseEntity.ok(labelService.getLabelsByCardId(cardId));
    }

    @DeleteMapping("/deleteLabelById/{id}")
    void deleteLabelById(@PathVariable Long id) {
        labelService.deleteLabelById(id);
    }


}
