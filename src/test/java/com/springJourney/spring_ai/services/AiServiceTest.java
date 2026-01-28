package com.springJourney.spring_ai.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springJourney.spring_ai.dto.ProgramDTO;
import org.junit.jupiter.api.Test;
import org.springframework.ai.document.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AiServiceTest {


    @Autowired
    private AIService aiService;

    @Test
    public void test_poem(){
        String poem=
                aiService.get_Poem("Engineer");
        System.out.println(poem);
    }

    @Test
    public void test_quote(){
        String quote=
                aiService.getQuote("Engineer");
        System.out.println(quote);
    }

    @Test
    public void test_program() throws JsonProcessingException {
        ProgramDTO programDTO=new ProgramDTO("Palindrome","java","optimized","O(n)");
        ProgramDTO programDTO1=   aiService.getProgram(programDTO);
        System.out.println(programDTO1);

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(programDTO1));

    }

    @Test
    public void getEmbedText()
    {
        float[] array=aiService.getEmbeddingText("This is my Big Text..");
        System.out.println(array.length);
        for(float e:array){
            System.out.print(e+" ");
        }

    }

    @Test
    public void putDataToVectorStore(){
        aiService.putMoviesToVectorStore();
    }

    @Test
    public void similaritySearch(){
        List<Document> list=aiService.similaritySearch("Love and romance");
        for(Document e: list){
            System.out.println(e);
        }
    }
}
