package com.eurogreen.hackathon.hackathonbackend.service;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.eurogreen.hackathon.hackathonbackend.dto.GiftSuggestion;
import com.eurogreen.hackathon.hackathonbackend.dto.Item;
import com.eurogreen.hackathon.hackathonbackend.dto.google.Metatag;
import com.eurogreen.hackathon.hackathonbackend.dto.google.SearchResult;
import com.eurogreen.hackathon.hackathonbackend.dto.google.SearchResultItem;
import com.eurogreen.hackathon.hackathonbackend.google.GoogleSearchClient;

@Log4j2
@Service
@RequiredArgsConstructor
public class SearchService {

  //The identifier of the Programmable Search Engine.
  public static final String GOOGLE_CONTEXT = "f6a0c8015587643be";
  public static final String GOOGLE_KEY = "AIzaSyDDWqw_3n7v1xRG5S9N7_p-yNV-r8M920k";
  private static final String AMAZON_SITE = "amazon.com";

  private final GoogleSearchClient googleSearchClient;

  public List<GiftSuggestion> search(List<String> suggestions, int maxPrice) {
    log.info("Suggestions: {}", suggestions);

    return suggestions.stream().map(s -> getSuggestion(s, maxPrice)).toList();
  }

  private GiftSuggestion getSuggestion(String suggestion, int maxPrice) {
    String query = String.format("\"%s\" $0...$%s site:%s", suggestion, maxPrice, AMAZON_SITE);

    try {
      SearchResult response = googleSearchClient.getRetailOrder(GOOGLE_CONTEXT, GOOGLE_KEY, query).execute().body();
      if (response == null) {
        return null;
      }

      List<Item> items = response.getItems().stream().map(this::mapToItem).filter(nullItemPredicate()).toList();

      return GiftSuggestion.builder().keyword(suggestion).items(items).build();
    }
    catch (IOException e) {
      throw new RuntimeException("Exception calling GoogleSearchAPI", e);
    }
  }

  private Predicate<Item> nullItemPredicate() {
    return item -> StringUtils.isNotEmpty(item.getTitle()) && StringUtils.isNotEmpty(item.getLink())
        && StringUtils.isNotEmpty(item.getDescription()) && StringUtils.isNotEmpty(item.getImage());
  }

  private Item mapToItem(SearchResultItem searchResultItem) {
    //Only 1 Metatag per search result
    List<Metatag> metatags = searchResultItem.getPagemap().getMetatags();
    Metatag metatag = metatags != null ? metatags.get(0) : null;

    String title = determineTitle(searchResultItem, metatag);
    String description = determineDescription(searchResultItem, metatag);
    String link = determineLink(searchResultItem, metatag);
    String image = determineImageLink(searchResultItem, metatag);

    return Item.builder().title(title).description(description).link(link).image(image).build();
  }

  private String determineTitle(SearchResultItem searchResultItem, Metatag metatag) {
    String titleDelimiter = " ... - Amazon.com";
    if (metatag != null && metatag.getTitle() != null) {
      return metatag.getTitle().replace(titleDelimiter, "");
    }

    return searchResultItem.getTitle().replace(titleDelimiter, "");
  }

  private String determineDescription(SearchResultItem searchResultItem, Metatag metatag) {
    String descriptionDelimiter = "Amazon.com: ";
    if (metatag != null && metatag.getDescription() != null) {
      return metatag.getDescription().replace(descriptionDelimiter, "");
    }

    return searchResultItem.getSnippet().replace(descriptionDelimiter, "");
  }

  private String determineLink(SearchResultItem searchResultItem, Metatag metatag) {
    if (metatag != null && metatag.getUrl() != null) {
      return metatag.getUrl();
    }

    return searchResultItem.getLink();
  }

  private String determineImageLink(SearchResultItem searchResultItem, Metatag metatag) {
    if (metatag != null && metatag.getImage() != null) {
      return metatag.getImage();
    }

    //Only 1 scrape field
    return searchResultItem.getPagemap().getScraped() != null ?
        searchResultItem.getPagemap().getScraped().get(0).getImageLink() :
        "";
  }
}
