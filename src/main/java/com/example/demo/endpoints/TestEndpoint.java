package com.example.demo.endpoints;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestEndpoint {

    @GetMapping("/test")
    public ResponseEntity<String> getCurrentBalance() {
        String str = "gitara siema";
        return new ResponseEntity<String>(str, HttpStatus.OK);
    }

}
