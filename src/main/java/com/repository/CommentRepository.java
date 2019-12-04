package com.repository;

import com.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comments, Long> {

    @Query(value = "select c from Comments c where c.cardId.id = :ID")
    List<Comments> getAllCommandByCardId(@Param("ID") Long ID);

}
