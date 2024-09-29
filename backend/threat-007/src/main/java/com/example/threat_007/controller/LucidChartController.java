package com.example.threat_007.controller;

import com.example.threat_007.service.LucidChartService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LucidChartController {

    private Logger logger = LoggerFactory.getLogger(LucidChartController.class);

    @Autowired
    private LucidChartService lucidchartService;

    @GetMapping("/documents/{documentId}")
    public ResponseEntity<String> getDocument(@PathVariable String documentId) {
        ResponseEntity<String> response = lucidchartService.getDocumentById(documentId);
        logger.info("Response from Lucidchart API: " + response.getBody());
        return lucidchartService.getDocumentById(documentId);
    }

    @GetMapping("/documents/{documentId}/contents")
    public ResponseEntity<String> getDocumentContents(@PathVariable String documentId) {
        ResponseEntity<String> response = lucidchartService.getDocumentContentsById(documentId);
        logger.info("Response from Lucidchart API: " + response.getBody());
        return response;
    }

    @PostMapping("/documents/search")
    public ResponseEntity<String> getAllDocuments(@RequestBody String requestBody) {

        ResponseEntity<String> response = lucidchartService.getAllDocuments(requestBody);
        logger.info("Response from Lucidchart API: " + response.getBody());
        return response;
    }
}

