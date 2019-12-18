package com.endpoints;

import com.entity.Comments;
import com.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/comment")
public class CommentController {
    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/addComment/{cardId}/{userId}")
    public void addComment(@PathVariable(value = "cardId") String cardId,@PathVariable(value = "userId") Long userId, @Valid @RequestBody Comments comments){
        commentService.addComment(comments,cardId,userId);
    }

    @GetMapping("/getCommentByCardId/{cardId}")
    public ResponseEntity<List<Comments>> getCommentByCardId(@PathVariable String cardId){
        return ResponseEntity.ok(commentService.getAllByCardId(cardId));
    }

    @DeleteMapping("/deleteComment/{id}")
    void deleteCard(@PathVariable Long id) {
        commentService.deleteById(id);
    }

    @PostMapping("/changeComment/{id}/{comment}")
    ResponseEntity<Comments> changeCommentById(@PathVariable Long id, @PathVariable String comment) {
        return ResponseEntity.ok(commentService.changeCommentById(id, comment));
    }
}
