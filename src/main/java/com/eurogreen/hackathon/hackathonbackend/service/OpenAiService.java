package com.eurogreen.hackathon.hackathonbackend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class OpenAiService {

    public List<String> getGiftSuggestions(String relation, int age, String keywords, int maxPrice) {
        String query = String.format("Suggest Christmas gifts for a %s aged %s, who likes %s, under %s euro as single words", relation, age, keywords, maxPrice);

        return new ArrayList<>();
    }
}
