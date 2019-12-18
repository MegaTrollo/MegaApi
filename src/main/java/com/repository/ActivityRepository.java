package com.repository;

import com.entity.Activity;
import com.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository  extends JpaRepository<Activity, Long> {

    List<Activity>  getActivitiesByCard_Id(Long cardId);
}
