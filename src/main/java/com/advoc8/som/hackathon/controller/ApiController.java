package com.advoc8.som.hackathon.controller;

import java.io.UnsupportedEncodingException;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.advoc8.som.hackathon.domain.Dummy;
import com.advoc8.som.hackathon.domain.ProfileRequest;
import com.advoc8.som.hackathon.storage.StorageService;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	private final StorageService storageService;

    @Autowired
    public ApiController(StorageService storageService) {
        this.storageService = storageService;
    }
	
	private static final Logger logger = LoggerFactory.getLogger(ApiController.class.getName());
	
	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("test")
    public Dummy greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Dummy(counter.incrementAndGet(), String.format(template, name));
    }
    
    @RequestMapping("report")
    public Dummy reportTrafficking(@RequestParam(value="name", defaultValue="World") String name) {
        return new Dummy(counter.incrementAndGet(), String.format(template, name));
    }
    
    @RequestMapping(value = "profile", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> getProfile(@RequestParam("appId") String appId, @RequestParam("category") String category, @RequestParam("detail") String detail, @RequestParam("longitude") float longitude, @RequestParam("latitude") float latitude, @RequestParam("file") MultipartFile file) throws UnsupportedEncodingException {

    	
    	String filename = UUID.randomUUID().toString().concat(".jpg");
    	
    	logger.info("category : {} ", category);
    	logger.info("appId : {} ", appId);
    	logger.info("detail : {} ", detail);
    	logger.info("longitude : {} ", longitude);
    	logger.info("latitude : {} ", latitude);
    	logger.info("file : {} ", filename);
    	
    	storageService.store(file, filename);

		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<String>("OK", headers, HttpStatus.OK);
	}
    
    @RequestMapping(value = "trafficking", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ProfileRequest> setTraffickingLevel(@RequestBody ProfileRequest p) throws UnsupportedEncodingException {


		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<ProfileRequest>(p, headers, HttpStatus.OK);
	}

}
