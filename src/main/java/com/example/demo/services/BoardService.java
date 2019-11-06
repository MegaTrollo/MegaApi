package com.example.demo.services;

import com.example.demo.entity.Board;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {
    List<Board> getAll();

    Board changeNameById(int id, String name);

    Board save(Board board);
}
