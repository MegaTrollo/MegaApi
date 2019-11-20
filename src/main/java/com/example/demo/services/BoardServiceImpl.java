package com.example.demo.services;

import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        return this.boardRepository.findAll();
    }

    @Override
    public Board changeNameById(Long id, String name) {
        Board boardToUpdate = boardRepository.getBoardById(id);
        boardToUpdate.setName(name);
        return boardRepository.save(boardToUpdate);
    }

    @Override
    public Board getBoardById(Long id) {
        return this.boardRepository.getBoardById(id);
    }

    @Override
    public List<Board> getAllByUserId(Long id) {
        return this.boardRepository.getAllBoardByUserId(id);
    }

    @Override
    public Board save(Board board, Long userId) {
        userRepository.findById(userId).map( user -> {
            board.setUserId(user);
            return boardRepository.save(board);
        });
        return board;
    }
}
