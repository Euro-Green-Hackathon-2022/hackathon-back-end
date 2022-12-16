package com.eurogreen.hackathon.hackathonbackend.dto.google;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class Scrape {

  @JsonProperty("image_link")
  private String imageLink;
}
