package com.repository;

import com.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LabelRepository extends JpaRepository<Label, Integer> {
    List<Label> getLabelsByCardId(String cardId);
    void deleteById(Integer id);

    Label getLabelById(int labelId);
}
