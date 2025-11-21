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

    public String prompt = "";
    private OpenAIClient client = OpenAIOkHttpClient.fromEnv();

    public Response respond() {

        ResponseCreateParams params = ResponseCreateParams.builder()
                .input(prompt)
                .model(ChatModel.GPT_5)
                .build();


        Response response = client.responses().create(params);
        System.out.println(response.status());

        return response;


    }

    public static OpenAI getInstance(){

        return INSTANCE;

    }

}