package com.api.resultsapi.api;

import com.api.resultsapi.models.Choice;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class Result {

    @MessageMapping("/result")
    @SendTo("/topic/results")
    public Choice choice(Choice choice) throws Exception {
        return new Choice(choice.getChoice());
    }
}
