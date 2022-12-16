package com.eurogreen.hackathon.hackathonbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ChatGptRequest {
    private String model;
    private String prompt;
    private int temperature;
    private int max_tokens;
}
