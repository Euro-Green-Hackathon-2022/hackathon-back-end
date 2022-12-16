package com.eurogreen.hackathon.hackathonbackend.google;

import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@RequiredArgsConstructor
public class GoogleSearchConfig {

  @Bean
  @Qualifier("okHttpClient")
  public OkHttpClient okHttpClient() {
    return new OkHttpClient.Builder().readTimeout(30, TimeUnit.SECONDS).connectTimeout(5, TimeUnit.SECONDS).build();
  }

  @Bean
  @Qualifier("jsonMapper")
  public ObjectMapper objectMapper() {
    return new Jackson2ObjectMapperBuilder()
        .timeZone(TimeZone.getDefault())
        .featuresToDisable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
        .serializationInclusion(JsonInclude.Include.NON_NULL)
        .createXmlMapper(false)
        .build();
  }

  @Bean
  public GoogleSearchClient googleSearchClient(@Qualifier("okHttpClient") OkHttpClient okHttpClient,
      @Qualifier("jsonMapper") ObjectMapper objectMapper) {
    return new Retrofit.Builder()
        .baseUrl("https://www.googleapis.com")
        .client(okHttpClient)
        .addConverterFactory(JacksonConverterFactory.create(objectMapper))
        .build()
        .create(GoogleSearchClient.class);
  }
}
