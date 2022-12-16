package com.eurogreen.hackathon.hackathonbackend.dto.google;

import lombok.Data;

@Data
public class SearchResultItem {

  private String title;
  private String link;
  private String snippet;
  private Pagemap pagemap;
}
