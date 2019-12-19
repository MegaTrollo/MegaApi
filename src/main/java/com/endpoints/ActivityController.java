package com.endpoints;

import com.entity.Activity;
import com.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/activity")
public class ActivityController {

    private ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/all/{cardId}")
    ResponseEntity<List<Activity>> getCardActivity(@PathVariable Long cardId) {
        return ResponseEntity.ok(activityService.getActivitysByCardId(cardId));
    }
    @PostMapping("/add/card/{cardId}/user/{userId}")
    ResponseEntity addActivity(@PathVariable String cardId, @PathVariable Long userId,@RequestBody String description){
        activityService.addActivity(cardId, userId,description);
        return new ResponseEntity(HttpStatus.OK);
    }
}
