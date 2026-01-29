package com.springJourney.spring_ai.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdvisorImplServiceTest {

    @Autowired
    AdvisorImplService advisorImplService;


    @Test
    void addPdfDataToVectorStore() {

        advisorImplService.AddCachingDataToVectorStore();
    }

    @Test
    void askAiWithRAgAdvisor() {

        // for QuestionAnswerAdvisor Advisor Use in RAG
        String msg= advisorImplService
                .askAiWithRagAdvisor("what is hacking" ,"Rahul432");
        System.out.println(msg);
    }

    @Test
    void askAiWithAdvisor() {

        // for MemoryChat Advisor
        String msg= advisorImplService.askAiWithAdvisor("what is my Name By The way" ,"Rahul432");
        System.out.println(msg);
    }
}