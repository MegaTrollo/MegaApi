package com.services;


import com.entity.Comments;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    List<Comments> getAllByCardId(Long id);
    void addComment(Comments comments, Long cardId, Long userId);
    Comments changeCommentById(Long Id, String comment);
    void deleteById(Long id);
}
