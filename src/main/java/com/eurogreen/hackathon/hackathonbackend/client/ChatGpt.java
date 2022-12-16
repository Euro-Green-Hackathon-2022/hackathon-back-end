package com.eurogreen.hackathon.hackathonbackend.client;

import com.eurogreen.hackathon.hackathonbackend.dto.ChatGptRequest;
import com.eurogreen.hackathon.hackathonbackend.dto.ChatGptResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ChatGpt {

    @Headers({"Content-Type: application/json", "Authorization: Bearer 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"})
    @POST("v1/completions")
    public Call<ChatGptResponse> getSuggestions(@Body ChatGptRequest openAiRequest);
}
