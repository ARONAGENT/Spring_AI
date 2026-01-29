package com.springJourney.spring_ai.services;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.vectorstore.VectorStoreChatMemoryAdvisor;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdvisorImplService {

    private final ChatClient chatClient;
    private final VectorStore vectorStore;

    public String askAiWithAdvisor(String prompt,String userId){

            return chatClient.prompt()
                    .user(prompt)
                    .system("""
                    You are an Ai Assistant called Aron.
                    Greet With users with Name (Aron) and the name if you know their name .
                    Answer in a friendly , conversational tone
                    """)
                    .advisors(
                            VectorStoreChatMemoryAdvisor.builder(vectorStore)
                                    .conversationId(userId)
                                    .defaultTopK(4)
                                    .build()

                    )
                    .call()
                    .content();
    }



}
