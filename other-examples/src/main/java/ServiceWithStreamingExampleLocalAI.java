import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.chat.StreamingChatLanguageModel;
import dev.langchain4j.model.localai.LocalAiChatModel;
import dev.langchain4j.model.localai.LocalAiStreamingChatModel;
import dev.langchain4j.model.localai.LocalAiStreamingChatModel.LocalAiStreamingChatModelBuilder;
import dev.langchain4j.model.openai.OpenAiStreamingChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.TokenStream;

public class ServiceWithStreamingExampleLocalAI {

    interface Assistant {

        TokenStream chat(String message);
    }

    public static void main(String[] args) {

        // Create an instance of a model
        StreamingChatLanguageModel model = LocalAiStreamingChatModel.builder()
                .baseUrl("https://ia.e-citiz.com/localai/")
                .modelName("codellama-7b-instruct-gguf")
                .logRequests(true)
                .build();
        Assistant assistant = AiServices.create(Assistant.class, model);

        TokenStream tokenStream = assistant.chat("Show me a PlantUML example");

        tokenStream.onNext(System.out::print)
                .onComplete(() -> System.out.println("\nStreaming completed"))
                .onError(Throwable::printStackTrace)
                .start();
    }
}
