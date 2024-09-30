package com.example.threat_007.controller;

import com.example.threat_007.service.ThreatAgentService;
import org.apache.tomcat.util.json.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4200", "http://172.18.0.4:4200", "http://138.197.3.104:4200", "*"})
@RestController
public class ThreatAgentController {

    private Logger logger = LoggerFactory.getLogger(ThreatAgentController.class);

    @Autowired
    private ThreatAgentService threatAgentService;

    @GetMapping("/threatAnalysis/{documentId}")
    public ResponseEntity<String> getThreatAnlysisByDocumentId(@PathVariable String documentId) throws ParseException {
        ResponseEntity<String> response = threatAgentService.getThreatAnalysisByDocumentById(documentId);
        logger.info("Response from Lucidchart API: " + response.getBody());
        return response;
    }
}
