package com.example.demo.services;

import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    private BoardRepository boardRepository;

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public List<Board> getAll() {
        return this.boardRepository.findAll();
    }

    @Override
    public Board changeNameById(int id, String name) {
        return this.boardRepository.updateTableWindowNameById(id, name);
    }

    @Override
    public Board save(Board board) {
        return this.boardRepository.save(board);
    }

    @Override
    public Board getBoardById(Long id) {
        return this.boardRepository.getBoardById(id);
    }
}
