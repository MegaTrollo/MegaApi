package com.repository;

import com.entity.Board;
import com.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    Board getBoardById(Long id);

    List<Board> getAllByUserAndIsArchived(User user, boolean isArchived);

    void deleteById(Long id);
}
