package com.services;

import com.entity.Card;
import com.entity.Label;
import com.repository.CardRepository;
import com.repository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelServiceImpl implements LabelService {
    LabelRepository labelRepository;
    CardRepository cardRepository;

    @Autowired
    public LabelServiceImpl(LabelRepository labelRepository, CardRepository cardRepository) {
        this.labelRepository = labelRepository;
        this.cardRepository = cardRepository;
    }

    @Override
    public List<Label> getLabelsByCardId(String cardId) {
        List<Label> labels = labelRepository.getLabelsByCardId(cardId);
        return labels;
    }

    @Override
    public void addNewLabelToCard(String cardId, Label label) {
        Card card = cardRepository.getById(cardId);
        label.setCard(card);
//        card.getLabels().add(label);
//        cardRepository.save(card);
        labelRepository.save(label);
    }

    @Override
    public boolean deleteLabelById(Long labelId) {
        Label labelToDelete = labelRepository.getOne(labelId);
        if (labelToDelete.equals(null)) {
            return false;
        }

        labelRepository.delete(labelToDelete);
        return true;
    }
}
