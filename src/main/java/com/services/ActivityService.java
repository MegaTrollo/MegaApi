package com.services;

import com.entity.Activity;
import com.entity.Card;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActivityService {
    void addActivity(Long cardId, Long userId, String description);
    List<Activity> getActivitysByCardId(Long cardId);
}
