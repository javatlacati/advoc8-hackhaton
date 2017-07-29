package com.advoc8.som.hackathon.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.advoc8.som.hackathon.domain.Dummy;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("test")
    public Dummy greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Dummy(counter.incrementAndGet(), String.format(template, name));
    }
    
    @RequestMapping("test")
    public Dummy reportTrafficking(@RequestParam(value="name", defaultValue="World") String name) {
        return new Dummy(counter.incrementAndGet(), String.format(template, name));
    }

}
