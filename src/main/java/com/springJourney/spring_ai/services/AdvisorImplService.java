package com.springJourney.spring_ai.services;

import com.springJourney.spring_ai.advisor.TokenUsageAdvisor;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SafeGuardAdvisor;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.chat.client.advisor.vectorstore.VectorStoreChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.document.Document;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdvisorImplService {

    private final ChatClient chatClient;
    private final VectorStore vectorStore;
    private final ChatMemory chatMemory;

    public String askAiWithAdvisor(String prompt,String userId){

            return chatClient.prompt()
                    .user(prompt)
                    .system("""
                    You are an Ai Assistant called Aron.
                    Greet With users with Name (Aron) and the name if you know their name .
                    Answer in a friendly , conversational tone
                    """)
                    .advisors(
                            MessageChatMemoryAdvisor.builder(chatMemory)
                                    .conversationId(userId)
                                    .build(),

                            VectorStoreChatMemoryAdvisor.builder(vectorStore)
                                    .conversationId(userId)
                                    .defaultTopK(4)
                                    .build()
                    )
                    .call()
                    .content();
    }

    @Value("classpath:caching.pdf")
    Resource pdfFile;

    public void AddCachingDataToVectorStore(){
         PagePdfDocumentReader pagePdfDocumentReader= new PagePdfDocumentReader(pdfFile);

            List<Document> pages=pagePdfDocumentReader.get();

            TokenTextSplitter tokenTextSplitter= TokenTextSplitter.builder()
                    .withChunkSize(200)
                    .build();

            List<Document> chunks=tokenTextSplitter.apply(pages);
            vectorStore.add(chunks);
        }




    public String askAiWithRagAdvisor(String prompt,String userId){

        return chatClient.prompt()
                .user(prompt)
                .system("""
                      You are an AI assistant helping a developer
                      Follow these rules strictly
                      1. Use ONLY the information provided in the <context>.
                      2. You may rephrase, summarize, and explain the information in natural language.
                      3. Do NOT introduce any new facts, assumptions, or external knowledge.
                      4. If multiple context sections are relevant, combine them into a single clear explanation.
                      5. If the answer is not present in the context, respond with: "I don't know".
                      Answer in a friendly, conversational tone.
            
                    """)
                .advisors(
                        new SafeGuardAdvisor(List.of("hacking", "cracking","bypass security","malware", "ransomware")),

                        QuestionAnswerAdvisor.builder(vectorStore)
                                .searchRequest(SearchRequest.builder()
                                        .filterExpression("file_name == 'caching.pdf'")
                                        .topK(4)
                                        .build())
                                .build(),
                        new TokenUsageAdvisor()
                )
                .call()
                .content();
    }



}
