package com.example.java.metrics.infrastructure.web.controller;

import com.example.java.metrics.infrastructure.aspect.Timer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Timer(metric = "http.request.get.all.courses.duration", action = "http_request_find_all_courses")
    @GetMapping
    public ResponseEntity<Object> courses() {
        return ResponseEntity.ok().build();
    }

    @Timer(metric = "http.request.get.specific.course.duration", action = "http_request_find_specific_course")
    @GetMapping("/{id}")
    public ResponseEntity<Object> course(@PathVariable(name = "id") final String id) {
        return ResponseEntity.ok().build();
    }

}
