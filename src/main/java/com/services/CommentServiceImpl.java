package com.services;

import com.entity.Comments;
import com.repository.CardRepository;
import com.repository.CommentRepository;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private CardRepository cardRepository;
    private UserRepository userRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, CardRepository cardRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.cardRepository = cardRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Comments> getAllByCardId(String id) {
        List<Comments> commentsList = commentRepository.getAllCommandByCardId(id);
        for(Comments comment:commentsList){
            comment.getUserId().setPassword("");
            comment.getUserId().setRoles(null);
        }
        return commentsList;
    }

    @Override
    public void addComment(Comments comments, String cardId, Long userId) {
        cardRepository.findById(cardId).map( card -> {
            comments.setCardId(card);
            userRepository.findById(userId).map(user ->{
                comments.setUserId(user);
                return commentRepository.save(comments);
            });
            return commentRepository.save(comments);
        });
    }

    @Override
    public Comments changeCommentById(Long id, String comment) {
        Comments commentsToUpdate = commentRepository.getOne(id);
        commentsToUpdate.setComment(comment);
        return commentRepository.save(commentsToUpdate);
    }

    @Override
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }
}
