package com.springJourney.spring_ai.tool;


import com.springJourney.spring_ai.Client.WeatherClient;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class WeatherTool {

    private final WeatherClient weatherClient;

    @Tool(description = "Get the Weather From the City")
    public String getWeather(@ToolParam(description = "From which City the Weather find") String city){
        return weatherClient.getWeather(city);
    }

}
