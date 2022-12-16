package com.eurogreen.hackathon.hackathonbackend.service;

import com.eurogreen.hackathon.hackathonbackend.dto.GiftSuggestion;
import com.eurogreen.hackathon.hackathonbackend.dto.Item;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class SearchService {

    public List<GiftSuggestion> search(List<String> suggestions, int maxPrice) {
        return null;
    }
}
