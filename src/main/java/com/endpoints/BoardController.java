package com.endpoints;

import com.entity.Board;
import com.services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/allVisiblebyUserId/{userId}")
    ResponseEntity<List<Board>> getAllByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(boardService.getAllVisibleBoardsByUserId(userId));
    }

    @GetMapping("/allArchivedbyUserId/{userId}")
    ResponseEntity<List<Board>> getAllArchivedByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(boardService.getAllArchivedBoardsByUserId(userId));
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
    ResponseEntity<Board> add(@PathVariable Long userId,@RequestBody Board board) {
        return ResponseEntity.ok(boardService.save(board,userId));
    }

    @PostMapping("/delete/{boardId}")
    ResponseEntity deleteBoardById(@PathVariable Long boardId){
        boardService.deleteBoardByBoardId(boardId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/changeArchiveStatus/{boardId}/{isArchived}")
    ResponseEntity changeIsArchiveStatus(@PathVariable Long boardId, @PathVariable boolean isArchived){
        boardService.changeIsArchiveBoardStatus(boardId, isArchived);
        return new ResponseEntity(HttpStatus.OK);
    }
}
