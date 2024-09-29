package com.example.threat_007.service;

import org.apache.tomcat.util.json.ParseException;
import org.springframework.http.ResponseEntity;

public interface ThreatAgentService {

    ResponseEntity<String> getThreatAnalysisByDocumentById(String documentId) throws ParseException;
}
