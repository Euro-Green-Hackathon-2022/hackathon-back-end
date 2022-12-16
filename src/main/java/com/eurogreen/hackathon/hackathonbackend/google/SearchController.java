package com.eurogreen.hackathon.hackathonbackend.google;

import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eurogreen.hackathon.hackathonbackend.dto.GiftSuggestion;
import com.eurogreen.hackathon.hackathonbackend.service.SearchService;

@RestController
@RequiredArgsConstructor
public class SearchController {

  private final SearchService searchService;

  @GetMapping("search")
  public List<GiftSuggestion> searchTest() throws Exception {
    return this.searchService.search(List.of("Surfboard", "Mug", "Guitar"), 500);
  }
}
