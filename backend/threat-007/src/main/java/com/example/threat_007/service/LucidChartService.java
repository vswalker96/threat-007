package com.example.threat_007.service;

import org.springframework.http.ResponseEntity;

public interface LucidChartService {
    ResponseEntity<String> getDocumentById(String documentId);
    ResponseEntity<String> getDocumentContentsById(String documentId);
    ResponseEntity<String> getAllDocuments(String requestBody);
}