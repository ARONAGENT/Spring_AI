# 🚀 Spring AI Comprehensive Guide
[![License](https://img.shields.io/badge/License-Proprietary-red?style=flat-square)](#-license)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=flat-square&logo=spring-boot)](https://spring.io/projects/spring-boot)
[![Spring AI](https://img.shields.io/badge/Spring%20AI-Latest-blue?style=flat-square&logo=spring)](https://docs.spring.io/spring-ai/reference/)
[![Java](https://img.shields.io/badge/Java-17+-orange?style=flat-square&logo=openjdk)](https://www.oracle.com/java/)
[![Docker](https://img.shields.io/badge/Docker-Enabled-2496ED?style=flat-square&logo=docker)](https://www.docker.com/)
[![OpenAI](https://img.shields.io/badge/OpenAI-API-412991?style=flat-square&logo=openai)](https://platform.openai.com/docs)
[![PgVector](https://img.shields.io/badge/PgVector-Extension-336791?style=flat-square&logo=postgresql)](https://github.com/pgvector/pgvector)
![Visitors](https://api.visitorbadge.io/api/visitors?path=https%3A%2F%2Fgithub.com%2FARONAGENT%2FSpring_AI&label=Visitors&countColor=%23263759&style=flat-square)

---
> *"The future of AI is not just about making machines smarter, but about making them more accessible and integrated into our everyday applications."* — Unknown

## 📖 Overview

**Spring AI Guide** is a comprehensive educational project that demystifies the integration of Large Language Models (LLMs) into Spring Boot applications. This repository serves as a complete guide to understanding and implementing AI-powered features using Spring AI framework, covering everything from basic chat implementations to advanced Retrieval-Augmented Generation (RAG) systems, Model Context Protocol (MCP), and intelligent tool calling.

Whether you're a beginner looking to understand how LLMs work internally or an experienced developer wanting to leverage Spring AI's powerful abstractions, this guide provides hands-on examples with real-world implementations using OpenAI, Ollama, and vector databases.

---

## ✨ Features

🤖 **ChatClient Implementation** - Seamless integration with LLM providers (OpenAI, Ollama) for conversational AI  
⚡ **High-Performance Responses** - Optimized implementations for fast model responses  
📝 **Dynamic Prompt Templates** - Variable injection and template-based prompt engineering  
🗄️ **Vector Store Integration** - Embed and store data in PgVector for semantic search  
🔍 **Similarity Search** - Intelligent retrieval based on semantic similarity  
🧠 **RAG Implementation** - Complete Retrieval-Augmented Generation system for context-aware responses  
💾 **Long-Term Memory** - VectorStoreChatMemoryAdvisor for persistent conversation context  
🎯 **Short-Term Memory** - MessageChatMemoryAdvisor for session-based chat history  
💬 **Hybrid Memory Strategy** - Intelligent fallback between memory layers  
📊 **Database-Backed Chat History** - Persistent storage and lookup of conversation data  
❓ **QuestionAnswer Advisor** - Specialized advisor optimized for RAG-based Q&A systems  
🛡️ **SafeGuard Advisor** - Policy enforcement and governance to prevent irrelevant conversations  
📈 **Custom Token Usage Tracking** - Monitor and optimize LLM token consumption  
🔧 **Tool Calling** - External API integration (OpenWeatherMap) with function calling  
🐳 **Dockerized Infrastructure** - Easy setup with Docker for PgVector and dependencies  

---

## 🛠️ Technologies

### Tech Stack

| Technology | Version | Purpose |
|------------|---------|---------|
| **Spring Boot** | 3.x | Application framework and dependency injection |
| **Spring AI** | Latest | AI integration framework for LLMs and vector stores |
| **Java** | 17+ | Primary programming language |
| **PgVector** | Latest | PostgreSQL extension for vector similarity search |
| **Docker** | Latest | Containerization for database services |
| **OpenAI API** | GPT-4o-mini | Cloud-based LLM provider |
| **Ollama** | Latest | Local LLM runtime |
| **PostgreSQL** | Latest | Relational database with vector support |
| **DBeaver** | Latest | Database management and visualization |
| **Postman** | Latest | API testing and development |
| **Lombok** | Latest | Java boilerplate code reduction |

---

## 📸 Screenshots

#### 1. ChatClient Successfully Implemented - Basic ChatClient integration with Spring AI framework
<img width="1912" alt="1 ChatClient successfully implemented" src="https://github.com/user-attachments/assets/eb52cedb-04e7-4992-97ea-9d9bee383298" />

---

#### 2. Fast Response with OpenAI - Performance demonstration with OpenAI models showing rapid response times
<img width="1917" alt="2 Fast Response when using model Like Open Ai" src="https://github.com/user-attachments/assets/a3fd5f42-56b7-4a28-a5e8-6a965ee9434e" />

---

#### 3. PromptTemplate Variables -Dynamic variable injection into prompts for flexible prompt engineering
<img width="1918" alt="3 PromptTemplate - we can pass variables to prompt" src="https://github.com/user-attachments/assets/32b0fe87-155c-47a8-8d79-49d6e53372d8" />

---

#### 4. Vector Store Embedding - Data storage in embedded format using PgVector database
<img width="1918" alt="4 Data Store in Vector Store in Embedded Format" src="https://github.com/user-attachments/assets/45a10eea-eea4-481b-9978-b83df53eaba6" />

---

#### 5. Similarity Search - Semantic search from vector store based on input text queries
<img width="1918" alt="5 Similarity Search from Vector Store from Input Text" src="https://github.com/user-attachments/assets/8c1ea8db-d831-4b5f-9449-dc1a3b72189b" />

---

#### 6. RAG Implementation - Custom vector store search integration for Retrieval-Augmented Generation
<img width="1918" alt="6 Implement Rag and search for own vector Store" src="https://github.com/user-attachments/assets/b8d77771-a46b-429e-9bee-e678e229801d" />

---

#### 7. VectorStoreChatMemoryAdvisor - Long-term conversation memory persistence using vector storage
<img width="1917" alt="7 VectorStoreChatMemoryAdvisor that Stores Long Term Data" src="https://github.com/user-attachments/assets/e0b2b97d-bca0-47d2-8d42-262f5d92f462" />

---

#### 8. VectorMemory Response - LLM answers using GPT-4o-mini model with vector memory context
<img width="1918" alt="8 Answer From VectorStoreChatMemoryAdvisor via LLM chatgpt 4o mini model" src="https://github.com/user-attachments/assets/a17b2975-09a7-469b-9b76-4f9bae17dcf5" />

---

#### 9. MessageChatMemoryAdvisor - Short-term session memory implementation for active conversations
<img width="1918" alt="9 MessageChatMemoryAdvisor that stores Short Term Memory" src="https://github.com/user-attachments/assets/46d2c05f-4906-40f0-bfe2-7b715a7f8bcf" />

---

#### 10. Hybrid Memory Response - Intelligent fallback between memory layers (MessageChatMemory → VectorStore)
<img width="1918" alt="10 Response From Model Answers Varies which one is take if not in MessageChatMemory then take from VectorStore" src="https://github.com/user-attachments/assets/9e0db28c-8806-47cc-b402-c5d7d9c11c90" />

---

#### 11. Chat Memory in Database - Persistent conversation storage and lookup in database
<img width="1918" alt="11 Chat Memory Stored in DB for Lookup" src="https://github.com/user-attachments/assets/7f615b65-c2e7-4682-9685-f9ad33e2033d" />

---

#### 12. QuestionAnswer Advisor - Specialized advisor optimized for RAG-based Q&A systems
<img width="1915" alt="12 QuestionAnswerAdvisor Best for RAG system" src="https://github.com/user-attachments/assets/e573d836-06c7-4b12-9e46-da0d405a94ac" />

---

#### 13. SafeGuard Advisor - Policy enforcement and governance to prevent irrelevant conversations
<img width="1918" alt="12 SafeGuardAdvisor for Policies and Governance for prevent disrelevant chats" src="https://github.com/user-attachments/assets/160db13c-5c5e-47e0-98e2-7373101bccd3" />

---

#### 14. Custom Token Usage Advisor - Token tracking and usage monitoring for cost optimization
<img width="1918" alt="13 Custom TokenUsage Advisor" src="https://github.com/user-attachments/assets/a380695c-01c7-4bc9-913c-ed411f9b1817" />

---

#### 15. Tool Calling with OpenWeatherMap - External API integration using function calling capabilities
<img width="1455" alt="14 Tool Calling with Open Weather Map" src="https://github.com/user-attachments/assets/75912a28-d7cc-4854-b803-32463008ef48" />

---

---

## 🚀 Installation

### Prerequisites

- Java 17 or higher
- Docker and Docker Compose
- Maven 3.8+
- OpenAI API Key (or Ollama for local models)
- Git

### Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/ARONAGENT/Spring_AI.git
   cd Spring_AI
   ```

2. **Set up PgVector with Docker**
   ```bash
   docker-compose up -d
   ```

3. **Configure environment variables**
   
   Create an `application.properties` or `application.yml` file:
   ```properties
   spring.ai.openai.api-key=${OPENAI_API_KEY}
   spring.datasource.url=jdbc:postgresql://localhost:5432/vectordb
   spring.datasource.username=postgres
   spring.datasource.password=postgres
   ```

4. **Build the project**
   ```bash
   mvn clean install
   ```

5. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

6. **Access the application**
   
   The application will be available at `http://localhost:8080`

---

## 💡 Usage

### Basic ChatClient Example

```java
@Autowired
private ChatClient chatClient;

public String chat(String userMessage) {
    return chatClient.prompt()
            .user(userMessage)
            .call()
            .content();
}
```

### PromptTemplate with Variables

```java
PromptTemplate promptTemplate = new PromptTemplate(
    "Tell me about {topic} in {style} style"
);
Map<String, Object> model = Map.of(
    "topic", "Spring AI",
    "style", "professional"
);
Prompt prompt = promptTemplate.create(model);
```

### Vector Store and RAG

```java
// Store documents
vectorStore.add(List.of(
    new Document("Spring AI is a framework...", metadata)
));

// Similarity search
List<Document> results = vectorStore.similaritySearch(
    SearchRequest.query("What is Spring AI?").withTopK(5)
);
```

### Tool Calling

```java
@Bean
public FunctionCallback weatherFunction() {
    return FunctionCallback.builder()
        .function("getCurrentWeather", this::getWeather)
        .description("Get current weather for a location")
        .build();
}
```

For detailed examples and implementation guides, please refer to the source code and inline documentation.

---

## 🤝 Contributing

Contributions are welcome! However, since this is a proprietary educational project, please follow these guidelines:

1. **Fork the repository** for personal learning and experimentation
2. **Open an issue** to discuss proposed changes before submitting
3. **Submit pull requests** with detailed descriptions of your improvements
4. **Follow the code style** and conventions used in the project
5. **Add tests** for new features when applicable

Please note that all contributions will be subject to the project's proprietary license.

---

## 📄 License

**Copyright (c) 2024 ROHAN UKE**
``` 
This project and its source code are the exclusive property of the author.
**Unauthorized copying, modification, distribution, or commercial use is strictly prohibited.**
Limited use is granted for learning, reviewing, and non-commercial demonstration purposes only.
No warranties are provided; use at your own risk.
```
For permissions beyond this notice, contact: **rohanuke1@example.com**

---

## 🙏 Acknowledgments

This project was made possible thanks to:

- **Spring AI Team** at Pivotal for creating an excellent framework for AI integration
- **OpenAI** for providing powerful and accessible LLM APIs
- **PgVector** maintainers for the PostgreSQL vector similarity search extension
- **Ollama** team for making local LLM deployment simple and efficient
- **The open-source community** for continuous innovation and knowledge sharing
- **Docker** for simplifying development environment setup
- **All contributors** who have helped improve this educational resource

Special thanks to the broader Java and Spring ecosystem for their invaluable tools and resources.

---

## 📬 Contact

For questions, feedback, or permissions, please reach out:

- **Email**: rohanuke1@example.com
- **GitHub**: [@ARONAGENT](https://github.com/ARONAGENT)
- **Repository**: [Spring_AI](https://github.com/ARONAGENT/Spring_AI)

---

## ⭐ Show Your Support

🌟 **Star this repo if you find it helpful!** ⭐
[![GitHub Stars](https://img.shields.io/github/stars/ARONAGENT/Spring_AI?style=social)](https://github.com/ARONAGENT/Spring_AI/stargazers)

Your support motivates continued development and helps others discover this resource.


---

<div align="center">

**Built with ❤️ by [ARONAGENT](https://github.com/ARONAGENT)**

*Making AI accessible, one Spring application at a time.*

</div>
