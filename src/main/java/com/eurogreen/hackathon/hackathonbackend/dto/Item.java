package com.eurogreen.hackathon.hackathonbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Item {

  private String title;
  private String link;
  private String image;
  private String description;
}
