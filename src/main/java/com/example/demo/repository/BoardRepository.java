package com.example.demo.repository;

import com.example.demo.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query("update Board tw set tw.name = ?2 where tw.id = ?1")
    Board updateTableWindowNameById(int id, String name);

    Board getBoardById(Long id);
}
