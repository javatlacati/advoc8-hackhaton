package com.advoc8.som.hackathon.controller;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.advoc8.som.hackathon.domain.Dummy;
import com.advoc8.som.hackathon.domain.ProfileRequest;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/test")
//    @RequestMapping(value = "test", method = RequestMethod.POST)
    public Dummy greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Dummy(counter.incrementAndGet(), String.format(template, name));
    }
    
    @RequestMapping("report")
    public Dummy reportTrafficking(@RequestParam(value="name", defaultValue="World") String name) {
        return new Dummy(counter.incrementAndGet(), String.format(template, name));
    }
    
    @RequestMapping(value = "profile", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> getProfile(@RequestBody ProfileRequest p) throws UnsupportedEncodingException {

		/*
		 * Image processing
		 */
		String x = p.getName();

		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<String>(x, headers, HttpStatus.OK);
	}

}
