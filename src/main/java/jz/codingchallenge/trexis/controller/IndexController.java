package jz.codingchallenge.trexis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public Map<String, Object> greeting() {
        return Collections.singletonMap("message", "Hello, World");
    }

}
