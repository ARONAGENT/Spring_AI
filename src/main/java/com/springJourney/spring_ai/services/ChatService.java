package com.springJourney.spring_ai.services;

import com.springJourney.spring_ai.tool.WeatherTool;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final WeatherTool weatherTool;
    private final ChatClient chatClient;

    public String getWeatherFromOpenWeatherMap(String city){
        return chatClient.prompt()
                .user(city)
                .tools(weatherTool)
                .call()
                .content();
    }

}
