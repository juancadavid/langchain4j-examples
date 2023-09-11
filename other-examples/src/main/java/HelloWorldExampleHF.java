import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.huggingface.HuggingFaceChatModel;

public class HelloWorldExampleHF {

    public static void main(String[] args) {

        // Create an instance of a model
        ChatLanguageModel model = HuggingFaceChatModel.withAccessToken(ApiKeys.HF_API_KEY);

        // Start interacting
        AiMessage answer = model.sendUserMessage("Hello world! My name is Juanito ");

        System.out.println(answer.text()); // Hello! How can I assist you today?
    }
}
