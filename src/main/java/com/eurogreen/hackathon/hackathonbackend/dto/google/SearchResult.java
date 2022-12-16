package com.eurogreen.hackathon.hackathonbackend.dto.google;


import java.util.List;

import lombok.Data;

import com.eurogreen.hackathon.hackathonbackend.dto.Item;

@Data
public class SearchResult {

  private List<SearchResultItem> items;
}
