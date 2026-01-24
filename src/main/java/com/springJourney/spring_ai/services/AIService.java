package com.springJourney.spring_ai.services;


import com.springJourney.spring_ai.dto.ProgramDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AIService {

    private final ChatClient chatClient;

    // Simple Chat Client
    public String get_Poem(String poem_topic){
        var response=chatClient.prompt()
                .user("create a simple 4 line poem for me for the topic " +
                        ":"+poem_topic)
                .call()
                .chatClientResponse();
        return response.chatResponse().getResult().getOutput().getText();
    }


    // Use of PromptTemplate - to pass variable inside the prompt
    public String getQuote(String quote_msg){

        String systemPrompt = """
                 give me the nice quote of 3 lines having emotions,sadness and
                 meaningful purpose .
                 for the topic : {topic}
                """;

        PromptTemplate promptTemplate=new PromptTemplate(systemPrompt);

        String renderedMessage= promptTemplate.render(Map.of("topic",quote_msg));

        var response= chatClient.prompt()
                .system(renderedMessage)
                .call()
                .chatClientResponse();

        return  response.chatResponse().getResult().getOutput().getText();
    }


    // we can pass the class directly and parse the object in JSON as well
    public ProgramDTO getProgram(ProgramDTO  programDTO){


        String systemPrompt = """
                
                 give me the Program Logic ,
                 and add detail info in the approach field
                 for the name : {name}
                 for the language : {language}
                 for the approach : {approach}
                 for the time_complexity : {time_complexity}
                 returns the JSON format
                 like that
                 {{
                    name: actual response ,
                    language: actual response,
                    approach: actual response ,
                    time_complexity: actual response ,
                 }}
                """;
        PromptTemplate promptTemplate = new PromptTemplate(systemPrompt);

        String renderedMessage= promptTemplate.render(Map.of(
                "name",programDTO.name(),
                "language",programDTO.language(),
                "approach",programDTO.approach(),
                "time_complexity",programDTO.time_complexity()
                    ));

        return chatClient.prompt()
                .system(renderedMessage)
                .call()
                .entity(ProgramDTO.class);
    }



}
