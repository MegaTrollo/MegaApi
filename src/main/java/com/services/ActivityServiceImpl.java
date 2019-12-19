package com.services;

import com.entity.Activity;
import com.entity.Card;
import com.entity.User;
import com.repository.ActivityRepository;
import com.repository.CardRepository;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ActivityServiceImpl implements ActivityService {

    private ActivityRepository activityRepository;
    private UserRepository userRepository;
    private CardRepository cardRepository;

    @Autowired
    public ActivityServiceImpl(ActivityRepository activityRepository, UserRepository userRepository, CardRepository cardRepository) {
        this.activityRepository = activityRepository;
        this.userRepository = userRepository;
        this.cardRepository = cardRepository;
    }

    @Override
    public void addActivity(String cardId, Long userId, String description) {
        Optional<User> userOptional = userRepository.findById(userId);
        Card card = cardRepository.getById(cardId);
        if (userOptional.isPresent()) {
            Activity activity = new Activity(userOptional.get(), card, description, new Date());
            activityRepository.save(activity);
        }
    }

    @Override
    public List<Activity> getActivitysByCardId(Long cardId) {
        return activityRepository.getActivitiesByCard_Id(cardId);
    }
}
