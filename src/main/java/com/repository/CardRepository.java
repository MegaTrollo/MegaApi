package com.repository;

import com.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {
    @Query(value = "select c from Card c where c.cardListId.id = :ID")
    List<Card > getAllCardByCardListId(@Param("ID") Long ID);

    Card getById(Long cardId);
}
