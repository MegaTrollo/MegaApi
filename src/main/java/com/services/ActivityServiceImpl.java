package com.services;

import com.entity.Activity;
import com.entity.Card;
import com.entity.User;
import com.repository.ActivityRepository;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ActivityServiceImpl implements ActivityService {

    private ActivityRepository activityRepository;
    private UserRepository userRepository;

    @Autowired
    public ActivityServiceImpl(ActivityRepository activityRepository, UserRepository userRepository) {
        this.activityRepository = activityRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void addActivity(Card card, Long userId, String description) {

        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            Activity activity = new Activity(userOptional.get(), card, description, new Date());
            activityRepository.save(activity);
        }
    }
}
