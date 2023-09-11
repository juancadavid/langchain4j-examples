import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.localai.*;

public class HelloWorldExampleLocalAI {

    public static void main(String[] args) {

        // Create an instance of a model
        ChatLanguageModel model = LocalAiChatModel.builder()
            .baseUrl("https://ia.e-citiz.com/localai/")
            .modelName("codellama-7b-instruct-gguf")
            .build();

        // Start interacting
        AiMessage answer = model.sendUserMessage("Hello world! My name is Juanito ");

        System.out.println(answer.text()); // Hello! How can I assist you today?
    }
}
