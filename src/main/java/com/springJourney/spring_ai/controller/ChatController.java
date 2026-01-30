package com.springJourney.spring_ai.controller;


import com.springJourney.spring_ai.services.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @PostMapping("/chat")
    public String getWeather(@RequestBody String city){
        return chatService.getWeatherFromOpenWeatherMap(city);
    }
}
