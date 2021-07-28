package com.api.resultsapi.api;

import com.api.resultsapi.models.Choice;
import com.api.resultsapi.service.ScheduledDbCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@Controller
public class Result {
    private final ScheduledDbCheck scheduledDbCheck;

    @Autowired
    public Result(ScheduledDbCheck scheduledDbCheck) {
        this.scheduledDbCheck = scheduledDbCheck;
    }

    @Scheduled(fixedRate = 5000)
    @MessageMapping("/result")
    @SendTo("/topic/results")
    public List<Choice> getChoices() throws Exception{
        System.out.println("Scheduled db check: ?");
        return scheduledDbCheck.getChoices();
    }
}
