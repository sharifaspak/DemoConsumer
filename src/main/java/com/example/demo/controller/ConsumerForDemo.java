/**
 * 
 */
package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.domain.Student;

/**
 * @author aspak.avesh.sharif
 *
 */
@RestController
@RequestMapping (value = "aspak")
public class ConsumerForDemo {
	

	@Autowired
	Student student;
	

	
	@RequestMapping(value = "service",method = RequestMethod.GET)
	public List<Student> myControllerMethod() {
		RestTemplate restTemplate = new RestTemplate();
		Student[] studList;
		studList = restTemplate.getForObject("http://localhost:8081/api/v1/student", Student[].class);
		System.out.println("Code change is reflecting");
				return Arrays.asList(studList);
		
	}
	
	@PostMapping(path = "newBakra")
	public String newAdmission (@RequestBody Student s) {
		RestTemplate restTemplate = new RestTemplate();
		//student = restT.
				
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		

		HttpEntity<?> request = new HttpEntity<>(s, headers);

		ResponseEntity<String> response = restTemplate.postForEntity( "http://localhost:8081/api/v2/newStudent", request , String.class );
		return response.getBody();
		
	}

}
