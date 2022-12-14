package com.eurogreen.hackathon.hackathonbackend.service;

import com.eurogreen.hackathon.hackathonbackend.dto.GiftSuggestion;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class CoordinationService {

    final ChatGtpService openAiService;
    final SearchService searchService;

    public List<GiftSuggestion> getSuggestions(String relation, int age, String keywords, int maxPrice) {
        List<String> giftSuggestions = openAiService.getGiftSuggestions(relation, age, keywords, maxPrice);

        return searchService.search(giftSuggestions, maxPrice);
    }

}
