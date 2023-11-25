package com.kot.getaway;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
public class TestController {

    @GetMapping()
    public ResponseEntity<?> test() {
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }

    @GetMapping("/hello2")
    @PreAuthorize("hasRole('ROLE_FFD_ADMIN')")
    public String hello() {
        return "new Hello world";
    }
}
