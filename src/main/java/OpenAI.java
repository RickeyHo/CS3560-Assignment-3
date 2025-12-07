import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.responses.Response;
import com.openai.models.responses.ResponseCreateParams;
import com.openai.models.responses.ResponseStatus;


import java.util.Optional;

import static java.lang.Character.getType;

public enum OpenAI {

    INSTANCE();



    private String prompt = "";
    private OpenAIClient client = OpenAIOkHttpClient.fromEnv();

    public Response respond() throws RuntimeException {

        ResponseCreateParams params = ResponseCreateParams.builder()
                .input(prompt)
                .model(ChatModel.GPT_5)
                .build();


        Response response = client.responses().create(params);
        System.out.println(response.status());
        if (response.status().equals(Optional.of(ResponseStatus.COMPLETED))) {
            return response;

        } else {

            throw new RuntimeException("Request failed. Error: " + "CHINA");

        }

    }

    public static OpenAI getInstance(){

        return INSTANCE;

    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

}