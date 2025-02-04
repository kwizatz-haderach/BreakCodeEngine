package org.barkancanerdogdu.breakcodeengine.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
public class ExternalIntegrationController {

    @GetMapping("/fetch")
    public String fetchData(@RequestParam int numOfParag, Model model) {
        String url = "https://loripsum.net/api/" + numOfParag + "/paragraphs/medium";

        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return ResponseEntity.ok(response.body()).toString();

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage()).toString();
        }
    }

    @PostMapping("/upload-xml")
    public ResponseEntity<String> uploadXml(@RequestBody String xmlData) {
//        try {
//            // XML verisini bir Document olarak parse et (GÜVENSİZ!)
//            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder builder = factory.newDocumentBuilder();
//            builder.parse(new InputSource(new StringReader(xmlData)));
//
//            return ResponseEntity.ok("XML processed successfully");
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
//        }

        try {
            // XXE'ye açık DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//            factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", false);
//            factory.setFeature("http://xml.org/sax/features/external-general-entities", true);
//            factory.setFeature("http://xml.org/sax/features/external-parameter-entities", true);

            DocumentBuilder builder = factory.newDocumentBuilder();
            org.w3c.dom.Document document = builder.parse(new InputSource(new StringReader(xmlData)));

            // XML içindeki veriyi String olarak döndür
            String extractedValue = document.getElementsByTagName("name").item(0).getTextContent();

            return ResponseEntity.ok("Extracted Value: " + extractedValue);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }
}
