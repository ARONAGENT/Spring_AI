package com.springJourney.spring_ai.services;


import com.springJourney.spring_ai.dto.ProgramDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AIService {

    private final ChatClient chatClient;
    private final EmbeddingModel embeddingModel;
    private final VectorStore vectorStore;


    // Embedded the Text
    public float[] getEmbeddingText(String text){
        return embeddingModel.embed(text);
    }

    // Helps to store the embedded data into vector store
    public void putDataToVectorStore(String text){
        Document document =new Document(text);
        vectorStore.add(List.of(document));
    }

    // Same but we can store key value pair as well for metadata information to more refinn for semantic search
    public void putMoviesToVectorStore() {

        List<Document> documents = List.of(
                new Document(
                        "Inception is a science fiction thriller where a skilled thief enters people's dreams to steal secrets and is given a task to plant an idea into someone's mind.",
                        Map.of(
                                "title", "Inception",
                                "genre", "Sci-Fi",
                                "year", "2010",
                                "director", "Christopher Nolan"
                        )
                ),

                new Document(
                        "A mind-bending movie about dream invasion, where characters travel through layered dreams to manipulate thoughts and memories.",
                        Map.of(
                                "title", "Inception",
                                "genre", "Sci-Fi",
                                "year", "2010",
                                "director", "Christopher Nolan"
                        )
                ),

                new Document(
                        "Interstellar follows astronauts who travel through a wormhole in space to find a new habitable planet as Earth becomes unlivable.",
                        Map.of(
                                "title", "Interstellar",
                                "genre", "Sci-Fi",
                                "year", "2014",
                                "director", "Christopher Nolan"
                        )
                ),

                new Document(
                        "A space exploration story where a team journeys across galaxies searching for a planet that can support human life.",
                        Map.of(
                                "title", "Interstellar",
                                "genre", "Sci-Fi",
                                "year", "2014",
                                "director", "Christopher Nolan"
                        )
                ),

                new Document(
                        "The Dark Knight is a superhero crime drama where Batman faces the Joker, a criminal mastermind spreading chaos in Gotham City.",
                        Map.of(
                                "title", "The Dark Knight",
                                "genre", "Action",
                                "year", "2008",
                                "director", "Christopher Nolan"
                        )
                ),

                new Document(
                        "A vigilante hero in a dark city battles a psychotic villain who wants to create anarchy and fear among citizens.",
                        Map.of(
                                "title", "The Dark Knight",
                                "genre", "Action",
                                "year", "2008",
                                "director", "Christopher Nolan"
                        )
                ),

                new Document(
                        "Titanic is a romantic disaster film showing the love story of two people aboard a ship that tragically sinks in the ocean.",
                        Map.of(
                                "title", "Titanic",
                                "genre", "Romance",
                                "year", "1997",
                                "director", "James Cameron"
                        )
                ),

                new Document(
                        "A heartbreaking romance unfolds on a luxurious ship that meets a catastrophic fate in icy waters.",
                        Map.of(
                                "title", "Titanic",
                                "genre", "Romance",
                                "year", "1997",
                                "director", "James Cameron"
                        )
                ),

                new Document(
                        "The Matrix is a sci-fi action film where a hacker discovers reality is a simulation and joins a rebellion against machines.",
                        Map.of(
                                "title", "The Matrix",
                                "genre", "Sci-Fi",
                                "year", "1999",
                                "director", "Wachowski Brothers"
                        )
                ),

                new Document(
                        "A computer programmer learns that the world he lives in is artificial and fights against intelligent machines controlling humanity.",
                        Map.of(
                                "title", "The Matrix",
                                "genre", "Sci-Fi",
                                "year", "1999",
                                "director", "Wachowski Brothers"
                        )
                )
        );

        vectorStore.add(documents);
    }

    public List<Document> similaritySearch(String text){
        return vectorStore.similaritySearch(SearchRequest.builder()
                        .query(text)
                        .topK(2)
                        .build());
    }


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
