package com.eurogreen.hackathon.hackathonbackend.google;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import com.eurogreen.hackathon.hackathonbackend.dto.google.SearchResult;

public interface GoogleSearchClient {

  @GET("/customsearch/v1")
  Call<SearchResult> getRetailOrder(@Query("cx") String context, @Query("key") String key, @Query("q") String query);
}
