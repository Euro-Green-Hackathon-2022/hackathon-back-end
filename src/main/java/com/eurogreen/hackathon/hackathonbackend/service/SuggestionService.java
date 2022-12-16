package com.eurogreen.hackathon.hackathonbackend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class SuggestionService {


    public List<String> getSuggestions(String suggestion) {
        //call out to api
        List<String> list = new ArrayList();
        list.add("shoes");
        list.add("jumper");
        return list;
    }
}
