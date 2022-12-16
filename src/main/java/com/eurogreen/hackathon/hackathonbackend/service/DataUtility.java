package com.eurogreen.hackathon.hackathonbackend.service;

import com.eurogreen.hackathon.hackathonbackend.dto.GiftSuggestion;
import com.eurogreen.hackathon.hackathonbackend.dto.Item;

import java.util.ArrayList;
import java.util.List;

public class DataUtility {

    public static List<GiftSuggestion> getData() {
        Item item1 = createItem("Mug 1", "http://mugshop.com/mug1", "https://m.media-amazon.com/images/I/61ze-hRiTFL._AC_SX679_.jpg", "20");
        Item item2 = createItem("Mug 2", "http://mugshop.com/mug2", "https://m.media-amazon.com/images/I/61ze-hRiTFL._AC_SX679_.jpg", "15");
        Item item3 = createItem("Mug 3", "http://mugshop.com/mug3", "https://m.media-amazon.com/images/I/61ze-hRiTFL._AC_SX679_.jpg", "20");


        ArrayList<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        GiftSuggestion giftSuggestion1 = GiftSuggestion.builder().keyword("mug").items(items).build();


        GiftSuggestion giftSuggestion2 = GiftSuggestion.builder().keyword("football").items(items).build();
        ArrayList<GiftSuggestion> giftSuggestions = new ArrayList<>();
        giftSuggestions.add(giftSuggestion1);
        giftSuggestions.add(giftSuggestion2);

        return giftSuggestions;
    }

    private static Item createItem(String title, String link, String image, String price ) {
        return Item.builder().title(title).link(link).image(image).build();
    }
}
