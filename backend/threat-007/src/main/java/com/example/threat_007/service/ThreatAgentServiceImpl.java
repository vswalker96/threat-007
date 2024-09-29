package com.example.threat_007.service;

import com.example.threat_007.model.DocumentContents;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.json.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ThreatAgentServiceImpl implements ThreatAgentService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LucidChartServiceImpl lucidChartService;

    private Logger logger = LoggerFactory.getLogger(ThreatAgentServiceImpl.class);

    @Value("${threatagent.service.url}")
    private String threatAgentUrl;

    private HttpEntity<String> createHttpEntity() {
        HttpHeaders headers = new HttpHeaders();

        headers.set("Content-Type", "application/json");
        return new HttpEntity<>(headers);
    }

    private ResponseEntity<String> performGetRequest(String url) {
        return restTemplate.exchange(url, HttpMethod.GET, createHttpEntity(), String.class);
    }

    private ResponseEntity<String> performPostRequest(String url, String body) {
        return restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(body, createHttpEntity().getHeaders()), String.class);
    }

    public ResponseEntity<String> getThreatAnalysisByDocumentById(String documentId) throws ParseException {
        ResponseEntity<String> response = new ResponseEntity<>(HttpStatus.OK);

        ResponseEntity<String> documentContents = this.lucidChartService.getDocumentContentsById(documentId);

        String jsonString = documentContents.getBody();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            DocumentContents document = objectMapper.readValue(jsonString, DocumentContents.class);
            List<DocumentContents.Page> pages = document.getPages();
            // send items object to Agent

            DocumentContents.Items items = pages.get(0).getItems();
            // Send response to the threat agent service.
            String url = threatAgentUrl + "/threat_analysis";

            ResponseEntity<String> reportResponse = performPostRequest(url, documentContents.getBody());

            if (reportResponse.getStatusCode() == HttpStatus.OK) {
                // Save the report to the database
                // Return the Report ID or status to the client
                response = new ResponseEntity<>(HttpStatus.OK);
            } else {
                response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            // how long does it take to generate the report?
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

}
