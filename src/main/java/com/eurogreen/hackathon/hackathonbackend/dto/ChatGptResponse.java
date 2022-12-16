package com.eurogreen.hackathon.hackathonbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ChatGptResponse {
    private String id;
    private String object;
    private String created;
    private String model;
    private List<Choices> choices;

}
