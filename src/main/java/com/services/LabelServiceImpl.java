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
    public boolean deleteLabelById(int labelId) {
        Label labelToDelete = labelRepository.getOne(labelId);
        if (labelToDelete == null) {
            return false;
        }

        labelRepository.delete(labelToDelete);
        return true;
    }

    @Override
    public Label getLabelByLabelId(int labelId) {
        return labelRepository.getLabelById(labelId);
    }

    @Override
    public void editLabel(Label label) {
        Label lbl = labelRepository.getLabelById(label.getId());
        lbl.setTitle(label.getTitle());
        if (label.getColor() != null) {
            lbl.setColor(label.getColor());
        }
        labelRepository.save(lbl);
    }
}
