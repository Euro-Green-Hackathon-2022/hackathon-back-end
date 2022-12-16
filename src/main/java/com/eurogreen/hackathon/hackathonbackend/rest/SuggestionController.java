package com.eurogreen.hackathon.hackathonbackend.rest;

import com.eurogreen.hackathon.hackathonbackend.service.SuggestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SuggestionController {

    private final SuggestionService suggestionService;

    @GetMapping("suggestion/{suggestion}")
    public ResponseEntity<List<String>> getSuggestion(@PathVariable String suggestion){
        return ResponseEntity.ok(suggestionService.getSuggestions(suggestion));
    }
}
