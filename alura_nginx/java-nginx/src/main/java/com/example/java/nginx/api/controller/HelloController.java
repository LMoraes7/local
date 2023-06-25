package com.example.java.nginx.api.controller;

import com.example.java.nginx.api.response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/macaco")
public class HelloController {

    @GetMapping
    public ResponseEntity<Response> hello() {
        return ResponseEntity.ok(new Response("Hello World"));
    }
}
