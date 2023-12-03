package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
public class DummyController {

    @GetMapping("/dummy-get")
    public String handleDummyGet() {
        // ダミーのGETリクエストを処理するロジック
        String response = "This is a dummy GET response";
        // System.out.println("GET Request: " + response);
        return response;
    }

    @PostMapping("/dummy-post")
    public String handleDummyPost(@RequestBody String requestBody) {
        // ダミーのPOSTリクエストを処理するロジック
        String response = "This is a dummy POST response";
        // System.out.println("POST Request Body: " + requestBody);
        // System.out.println("POST Response: " + response);
        return response;
    }
}
