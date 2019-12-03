package com.services;

import com.entity.Board;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {
    List<Board> getAll();

    List<Board> getAllByUserId(Long id);

    Board changeNameById(Long id, String name);

    Board save(Board board,Long userId);

    Board getBoardById(Long id);
}
