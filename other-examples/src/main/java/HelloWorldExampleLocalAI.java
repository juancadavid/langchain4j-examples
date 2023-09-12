import static java.time.Duration.ofMinutes;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.localai.LocalAiChatModel;

public class HelloWorldExampleLocalAI {

    public static void main(String[] args) {

        // Create an instance of a model
        ChatLanguageModel model = LocalAiChatModel.builder()
                .baseUrl("https://ia.e-citiz.com/localai/")
                .modelName("codellama-7b-instruct-gguf")
                .timeout(ofMinutes(30))
                .maxRetries(10)
                .logRequests(true)
                .logResponses(true)
                .build();

        // Start interacting
        AiMessage answer = model.sendUserMessage("Show me a PlantUML example");
        System.out.println(answer.text()); // Hello! How can I assist you today?
    }
}
