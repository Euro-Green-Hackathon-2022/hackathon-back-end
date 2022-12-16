package com.eurogreen.hackathon.hackathonbackend.service;

import com.eurogreen.hackathon.hackathonbackend.dto.ChatGptResponse;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChatGtpServiceTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    public void test() throws Exception {
        String text = "{\n" +
                "    \"id\": \"cmpl-6O5Popkvqm8wNb7txaJsyyvCMtRHJ\",\n" +
                "    \"object\": \"text_completion\",\n" +
                "    \"created\": 1671198708,\n" +
                "    \"model\": \"text-davinci-003\",\n" +
                "    \"choices\": [\n" +
                "        {\n" +
                "            \"text\": \"\\n\\nFootball, Car, Computer, Watch, Wallet.\",\n" +
                "            \"index\": 0,\n" +
                "            \"logprobs\": null,\n" +
                "            \"finish_reason\": \"stop\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"usage\": {\n" +
                "        \"prompt_tokens\": 24,\n" +
                "        \"completion_tokens\": 12,\n" +
                "        \"total_tokens\": 36\n" +
                "    }\n" +
                "}";
        final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                false);

        ChatGptResponse response = objectMapper.readValue(text, ChatGptResponse.class);
        String txt = response.getChoices().get(0).getText();
        if (txt.charAt(txt.length()-1) == '.') {
            txt = txt.substring(0, txt.length()-1);
        }

        String[] choices = txt.trim().split(",");
        List<String> results = Arrays.asList(choices);



        assertEquals("Football", results.get(0));
    }






}