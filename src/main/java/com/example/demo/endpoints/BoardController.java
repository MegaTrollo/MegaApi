package com.example.demo.endpoints;

import com.example.demo.entity.Board;
import com.example.demo.services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/table")
public class BoardController {

    private BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/all")
    ResponseEntity<List<Board>> getAllTables() {
        return ResponseEntity.ok(boardService.getAll());
    }

    @GetMapping("/allbyUserId/{userId}")
    ResponseEntity<List<Board>> getAllByUserId(@PathVariable (value = "userId") Long userId){
        return ResponseEntity.ok(boardService.getAllByUserId(userId));
    }

    @GetMapping("/{id}")
    ResponseEntity<Board> getBoardById(@PathVariable Long id) {
        return ResponseEntity.ok(boardService.getBoardById(id));
    }

    @PostMapping("/rename/{id}/{name}")
    ResponseEntity<Board> changeNameById(@PathVariable Long id, @PathVariable String name) {
        return ResponseEntity.ok(boardService.changeNameById(id, name));
    }

    @PostMapping("/add/{userId}")
    ResponseEntity<Board> add(@PathVariable (value = "userId") Long userId,@RequestBody Board board) {
        return ResponseEntity.ok(boardService.save(board,userId));
    }
}
