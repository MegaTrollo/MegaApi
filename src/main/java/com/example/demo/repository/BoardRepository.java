package com.example.demo.repository;

import com.example.demo.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query("update Board tw set tw.name = ?2 where tw.id = ?1")
    Board updateTableWindowNameById(int id, String name);

    Board getBoardById(Long id);

    @Query(value = "select c from Board c where c.userId.id = :ID")
    List<Board> getAllBoardByUserId(@Param("ID") Long ID);
}
