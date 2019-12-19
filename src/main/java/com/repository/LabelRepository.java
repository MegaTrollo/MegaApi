package com.repository;

import com.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LabelRepository extends JpaRepository<Label, Long> {
    List<Label> getLabelsByCardId(String cardId);
    void deleteById(Long id);
}
