package com.example.threat_007.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LucidChartServiceImpl implements LucidChartService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${lucidchart.api.key}")
    private String apiKey;

    @Value("${lucidchart.api.url}")
    private String apiUrl; // This will be the base URL for Lucidchart API


    private HttpEntity<String> createHttpEntity() {
        HttpHeaders headers = new HttpHeaders();

        headers.set("Lucid-Api-Version", "1");
        headers.set("Authorization", "Bearer " + apiKey);
        headers.set("Content-Type", "application/json");
        return new HttpEntity<>(headers);
    }

    private ResponseEntity<String> performGetRequest(String url) {
        return restTemplate.exchange(url, HttpMethod.GET, createHttpEntity(), String.class);
    }

    private ResponseEntity<String> performPostRequest(String url, String body) {
    return restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(body, createHttpEntity().getHeaders()), String.class);
}

    public ResponseEntity<String> getDocumentById(String documentId) {
        String url = apiUrl + "/documents/" + documentId;
        return performGetRequest(url);
    }

    public ResponseEntity<String> getAllDocuments(String requestBody) {
        String url = apiUrl + "/documents/search";
        return performPostRequest(url, requestBody);
    }

    public ResponseEntity<String> getDocumentContentsById(String documentId) {
        String url = apiUrl + "/documents/" + documentId + "/contents";
        return performGetRequest(url);
    }
}