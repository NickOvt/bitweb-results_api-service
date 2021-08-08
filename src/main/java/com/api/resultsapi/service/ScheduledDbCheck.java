package com.api.resultsapi.service;


import com.api.resultsapi.dao.ChoiceDao;
import com.api.resultsapi.models.Choice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ScheduledDbCheck {
    private final ChoiceDao choiceDao;


    @Autowired
    public ScheduledDbCheck(ChoiceDao choiceDao) {
        this.choiceDao = choiceDao;
    }

    public List<Choice> getChoices() {
        Instant instant = Instant.now();
        long timeStampMillis = instant.toEpochMilli();
        System.out.println("Scheduled db check: " + timeStampMillis);
        return choiceDao.selectAllChoices();
    }
}
