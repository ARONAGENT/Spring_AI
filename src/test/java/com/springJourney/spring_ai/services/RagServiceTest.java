package com.springJourney.spring_ai.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RagServiceTest {

    @Autowired
    RagService ragService;

    @Test
    public void putPdfDataToVectorStore(){
        ragService.putPdfDataToVectorStore();
    }

    @Test
    void askAi() {
        String ans=ragService.askAi("what is Mockito ");
        System.out.println(ans);
    }
}
