package com.repository;

import com.entity.Board;
import com.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, String> {

    Board getBoardById(String id);

    List<Board> getAllByUserAndIsArchived(User user, boolean isArchived);

    void deleteById(String id);
}
