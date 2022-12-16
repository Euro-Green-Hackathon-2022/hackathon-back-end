package com.eurogreen.hackathon.hackathonbackend.dto.google;

import java.util.List;

import lombok.Data;

@Data
public class Pagemap {

  private List<Scrape> scraped;
  private List<Metatag> metatags;
}

