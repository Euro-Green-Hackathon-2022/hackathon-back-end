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
