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
    void askAiWithAdvisor() {

        String msg= advisorImplService.askAiWithAdvisor("It is Good Day by the Way I want To Ask you i want ask you whats my name and can u tell me about spring ai in 2 lines" ,"Rohan123");
        System.out.println(msg);
    }
}