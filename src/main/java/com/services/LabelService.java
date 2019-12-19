package com.services;

import com.entity.Label;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LabelService {
    List<Label> getLabelsByCardId(String cardId);
    void addNewLabelToCard(String cardId, Label label);
    boolean deleteLabelById(Long labelId);
}
