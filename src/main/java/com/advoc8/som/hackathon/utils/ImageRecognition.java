package com.advoc8.som.hackathon.utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.advoc8.som.hackathon.Constants;
import com.advoc8.som.hackathon.domain.EnrollRequest;
import com.advoc8.som.hackathon.domain.RecognizeRequest;
import com.advoc8.som.hackathon.domain.Result1;
import com.advoc8.som.hackathon.domain.Result2;
import com.advoc8.som.hackathon.storage.StorageService;

@Component
public class ImageRecognition {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private final StorageService storageService;
	
	private static final Logger logger = LoggerFactory.getLogger(ImageRecognition.class.getName());

    @Autowired
    public ImageRecognition(StorageService storageService) {
        this.storageService = storageService;
    }
	
    
	/*
	 * Check if beggar is exist in our record
	 */
	public Result1 doValidate(MultipartFile file) throws IOException, RestClientException, URISyntaxException{
		
		byte[] encoded = Base64.encode(file.getBytes());
    	
    	String imageBased64 = new String(encoded);
    			
    	RecognizeRequest er = new RecognizeRequest(imageBased64 , Constants.KAIRUS_GALLERY_NAME);
    	
    	HttpHeaders headers = new HttpHeaders();
    	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    	headers.add("app_id", "62d56877");
    	headers.add("app_key", "33ff2f392393dab0f9f0bbe262aa7eb7");

    	HttpEntity<RecognizeRequest> entity = new HttpEntity<RecognizeRequest>(er, headers);
    	
    	Result1 ret = restTemplate.postForObject(new URI(Constants.KAIRUS_URL_RECOGNIZE), entity, Result1.class);
    	
    	logger.info("Return : " + ret.getImages().get(0).getTransaction().getStatus());
    	
		return ret;
	}
	
	/*
	 * Add new beggar in our record
	 */
	public Result2 doAddBeggar(MultipartFile file, String subjectId) throws RestClientException, URISyntaxException, IOException{
		
		byte[] encoded = Base64.encode(file.getBytes());
    	
    	String imageBased64 = new String(encoded);
    	
    	String filename = subjectId.concat(".jpg");
		
		EnrollRequest er = new EnrollRequest(imageBased64, subjectId , Constants.KAIRUS_GALLERY_NAME);
		
		HttpHeaders headers = new HttpHeaders();
    	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    	headers.add("app_id", "62d56877");
    	headers.add("app_key", "33ff2f392393dab0f9f0bbe262aa7eb7");

    	HttpEntity<EnrollRequest> entity = new HttpEntity<EnrollRequest>(er, headers);
    	
    	Result2 ret = restTemplate.postForObject(new URI(Constants.KAIRUS_URL_ENROLL), entity, Result2.class);
    	
    	logger.info("Return : " + ret);

    	storageService.store(file, filename);
    	
		return ret;
	}

}
