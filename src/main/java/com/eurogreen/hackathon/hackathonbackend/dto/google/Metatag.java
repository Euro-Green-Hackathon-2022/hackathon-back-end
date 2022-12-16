package com.eurogreen.hackathon.hackathonbackend.dto.google;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class Metatag {

  @JsonProperty("og:image")
  private String image;
  @JsonProperty("og:title")
  private String title;
  @JsonProperty("og:url")
  private String url;
  @JsonProperty("og:description")
  private String description;
}

