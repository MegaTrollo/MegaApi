package com.services;

import com.entity.Board;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {
    List<Board> getAll();

    List<Board> getAllVisibleBoardsByUserId(Long id);

    List<Board> getAllArchivedBoardsByUserId(Long id);

    void deleteBoardByBoardId(String id);

    void changeIsArchiveBoardStatus(String id, boolean isArchived);

    Board changeNameById(String id, String name);

    void save(Board board,Long userId);

    Board getBoardById(String id);
}
