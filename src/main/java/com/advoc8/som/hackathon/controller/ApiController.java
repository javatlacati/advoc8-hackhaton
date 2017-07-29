package com.advoc8.som.hackathon.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.multipart.MultipartFile;

import com.advoc8.som.hackathon.domain.Beggar;
import com.advoc8.som.hackathon.domain.Dummy;
import com.advoc8.som.hackathon.domain.Response1;
import com.advoc8.som.hackathon.domain.Result1;
import com.advoc8.som.hackathon.repository.BeggarRepository;
import com.advoc8.som.hackathon.utils.ImageRecognition;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	private ImageRecognition imageRecognition;
	
	@Autowired
	private BeggarRepository beggarRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(ApiController.class.getName());
	
	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("test")
    public Dummy greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Dummy(counter.incrementAndGet(), String.format(template, name));
    }
    
    @RequestMapping(value = "verify", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Response1> getProfile(@RequestParam("appId") String appId, @RequestParam("file") MultipartFile file) throws RestClientException, URISyntaxException, IOException {
    	
    	Result1 ret = imageRecognition.doValidate(file); //Call API recognize
    	    	
    	if (ret.getImages().get(0).getTransaction().getStatus().equals("success")){
    		//TODO: Get object_id from response - return rating from DB
    		
    		String subjectId = ret.getImages().get(0).getTransaction().getSubjectId();
    		
    		List<Beggar> b = beggarRepository.findByObjectId(subjectId);
    		
    		int total = 0;
    		
    		for (int i = 0; i < b.size(); i++) {
    			total = total + b.get(i).getRating();
    		}
    		
    		int average = total / b.size();
    		
    		
    		return new ResponseEntity<Response1>(new Response1(subjectId, average), HttpStatus.OK);
    	}

    	//TODO: Return not found
		return new ResponseEntity<Response1>(new Response1(null, 0), HttpStatus.NOT_FOUND);
	}
    
    
    @RequestMapping(value = "report", method = RequestMethod.POST)
	@ResponseBody
    public	ResponseEntity<String> reportTrafficking(@RequestParam("appId") String appId, @RequestParam("category") String category, @RequestParam("detail") String detail, @RequestParam("longitude") float longitude, @RequestParam("latitude") float latitude,  @RequestParam("file") MultipartFile file, int rating) throws RestClientException, URISyntaxException, IOException {
    	
    	String subjectId = UUID.randomUUID().toString();
    	
    	logger.info("category : {} ", category);
    	logger.info("appId : {} ", appId);
    	logger.info("detail : {} ", detail);
    	logger.info("longitude : {} ", longitude);
    	logger.info("latitude : {} ", latitude);
    	logger.info("rating : {} ", rating);
    	
    	String ret = imageRecognition.doAddBeggar(file, subjectId); //Call API enroll
    	
    	logger.info(ret);
    	
    	Beggar b = new Beggar(appId, subjectId, detail, category, rating);
    	
    	beggarRepository.save(b);
    	
    	if (ret.contains("\"status\":\"success\"")){
    		return new ResponseEntity<String>("OK", HttpStatus.OK);
    	}
    	    	
    	return new ResponseEntity<String>("NOT OK", HttpStatus.BAD_REQUEST);
    }
    
    
    @RequestMapping(value = "rate", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> setTraffickingLevel(@RequestParam("appId") String appId, @RequestParam("objectId")String subjectId, @RequestParam("rating")int rating) {
    	
    	Beggar b = new Beggar(appId, subjectId, "N/A", "Trafficking for Begging", rating);
    	
    	beggarRepository.save(b);

		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<String>("OK", headers, HttpStatus.OK);
	}

}
