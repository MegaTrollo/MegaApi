package com.services;

import com.entity.Card;
import org.springframework.stereotype.Service;

@Service
public interface ActivityService {
    void addActivity(Card card, Long userId, String description);
}
