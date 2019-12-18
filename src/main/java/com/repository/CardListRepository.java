package com.repository;

import com.entity.CardList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CardListRepository extends JpaRepository<CardList, Long> {
    @Query(value = "select c from CardList c where c.boardId.id = :ID")
    List<CardList> findByBoardId(@Param("ID") String ID);
}
