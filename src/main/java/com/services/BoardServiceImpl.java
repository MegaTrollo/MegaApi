package com.services;

import com.entity.Board;
import com.entity.User;
import com.repository.BoardRepository;
import com.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BoardServiceImpl implements BoardService {

    private BoardRepository boardRepository;
    private UserRepository userRepository;

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository, UserRepository userRepository) {
        this.boardRepository = boardRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Board> getAll() {
        return boardRepository.findAll();
    }

    @Override
    public Board changeNameById(Long id, String name) {
        Board boardToUpdate = boardRepository.getBoardById(id);
        boardToUpdate.setName(name);
        return boardRepository.save(boardToUpdate);
    }

    @Override
    public Board getBoardById(Long id) {
        return boardRepository.getBoardById(id);
    }

    @Override
    public List<Board> getAllVisibleBoardsByUserId(Long id) {
        User user = userRepository.getById(id);
        return boardRepository.getAllByUserAndIsArchived(user, false);
    }

    @Override
    public List<Board> getAllArchivedBoardsByUserId(Long id) {
        User user = userRepository.getById(id);
        return boardRepository.getAllByUserAndIsArchived(user, true);
    }

    @Override
    public void deleteBoardByBoardId(Long id) {
        boardRepository.deleteById(id);
        log.info("Usuwam tablicę o id:" + id);
    }

    @Override
    public void changeIsArchiveBoardStatus(Long id, boolean isArchived) {
        Board board = boardRepository.getBoardById(id);
        board.setArchived(isArchived);
        boardRepository.save(board);
        log.info("Ustawiam status:" + isArchived + " tablicy o id:" + id);
    }

    @Override
    public Board save(Board board, Long userId) {
        userRepository.findById(userId).map(user -> {
            board.setUser(user);
            return boardRepository.save(board);
        });
        return board;
    }
}
