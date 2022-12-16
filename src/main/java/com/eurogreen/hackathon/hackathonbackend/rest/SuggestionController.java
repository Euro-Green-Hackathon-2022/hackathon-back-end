package com.eurogreen.hackathon.hackathonbackend.rest;

import com.eurogreen.hackathon.hackathonbackend.dto.GiftSuggestion;
import com.eurogreen.hackathon.hackathonbackend.service.CoordinationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SuggestionController {

    private final CoordinationService suggestionService;

    //const request = `Suggest Christmas gifts for a ${relation} aged ${age}, who likes ${keywords}, under ${maxPrice} euro as single words`;
    @GetMapping("suggestion")
    @CrossOrigin("*")
    public ResponseEntity<List<GiftSuggestion>> getSuggestion(@RequestParam String relation, @RequestParam int age, @RequestParam String keywords, @RequestParam int maxPrice){
        return ResponseEntity.ok(suggestionService.getSuggestions(relation, age, keywords, maxPrice));
    }
}
