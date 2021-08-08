package com.api.resultsapi.api;

import com.api.resultsapi.service.ScheduledDbCheck;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class Result {
    private final ScheduledDbCheck scheduledDbCheck;

    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    public Result(ScheduledDbCheck scheduledDbCheck) {
        this.scheduledDbCheck = scheduledDbCheck;
    }

    @Scheduled(fixedRate = 2500)
    // @SendTo("/topic/results")
    public void getChoices() throws Exception {
        template.convertAndSend("/topic/results", scheduledDbCheck.getChoices());
    }
}
