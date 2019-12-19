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
    private LabelRepository labelRepository;
    private CardRepository cardRepository;

    @Autowired
    public LabelServiceImpl(LabelRepository labelRepository, CardRepository cardRepository) {
        this.labelRepository = labelRepository;
        this.cardRepository = cardRepository;
    }

    @Override
    public List<Label> getLabelsByCardId(String cardId) {
        return labelRepository.getLabelsByCardId(cardId);
    }

    @Override
    public void addNewLabelToCard(String cardId, Label label) {
        Card card = cardRepository.getById(cardId);
        List<Label> labels = card.getLabels();
        label.setCardId(cardId);
        labels.add(label);
        card.setLabels(labels);
        cardRepository.save(card);
    }

    @Override
    public boolean deleteLabelById(Long labelId) {
        Label labelToDelete = labelRepository.getOne(labelId);
        if (labelToDelete == null) {
            return false;
        }

        labelRepository.delete(labelToDelete);
        return true;
    }
}
