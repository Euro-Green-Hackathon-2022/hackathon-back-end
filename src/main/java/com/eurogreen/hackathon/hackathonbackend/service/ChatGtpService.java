package com.eurogreen.hackathon.hackathonbackend.service;

import com.eurogreen.hackathon.hackathonbackend.client.ChatGpt;
import com.eurogreen.hackathon.hackathonbackend.dto.Choices;
import com.eurogreen.hackathon.hackathonbackend.dto.ChatGptRequest;
import com.eurogreen.hackathon.hackathonbackend.dto.ChatGptResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class ChatGtpService {
    private final ChatGpt chatGpt;

    public List<String> getGiftSuggestions(String relation, int age, String keywords, int maxPrice) {
        String query = String.format("Suggest Christmas gifts for a %s aged %s, who likes %s, under %s euro as single words", relation, age, keywords, maxPrice);
        ChatGptRequest request = ChatGptRequest.builder()
                .model("text-davinci-003")
                .prompt(query).temperature(0).max_tokens(20).build();

        try {
            Response<ChatGptResponse> response = chatGpt.getSuggestions(request).execute();
            ChatGptResponse chatGptResponse = response.body();
            List<Choices> chatGptChoices = chatGptResponse.getChoices();
            return formatChoices(chatGptChoices.get(0).getText());
        } catch (IOException e) {
            log.error(e.getMessage());
        }


        return new ArrayList<>();
    }

    private List<String> formatChoices(String response) {
        if (response.charAt(response.length()-1) == '.') {
            response = response.substring(0, response.length()-1);
        }
        String[] choices = response.trim().split(",");
        List<String> list = Arrays.asList(choices);
        return list.stream().limit(3).collect(Collectors.toList());
    }
}
