package com.patel.userManagement;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ForEntityMethodRestTemplateDemo {

	private String baseUrl="http://localhost:8083/springDataDemo/";
	RestTemplate restTemplate=new RestTemplate();
	
	public void derivedMethod()
	{
		System.out.println("ForEntity Example of Rest Template demo");
		//getSingleObject();
		//getListOfObject();
		 addUser();
		//deleteUser();
		//updateUser();
	}

	private void updateUser() {
		String url=baseUrl+"updateAddress/1/village-Piluee,Post-bahadura,District-Ballia Up 277207";	 
		restTemplate.put(url, null);
		System.out.println("User Updated ");
	}

	private void deleteUser() {
		String url=baseUrl+"user/9";
		restTemplate.delete(url);
		System.out.println("User Deleted ");
	}

	private void addUser() {
		
		Person person=new Person();
		person.setFirstName("Navneet");
		person.setLastName("Kumar");
		person.setAddress("Currently in Piluee");
		person.setGender("Male");
		
		String url=baseUrl+"user";
		
		URI completePath=restTemplate.postForLocation(url,person, String.class);
		
		System.out.println("Location of the created Entity : "+completePath);
		
		/*
		 * ResponseEntity<String> responseEntity=restTemplate.postForEntity(url,person,
		 * String.class);
		 * 
		 * HttpStatus httpStatus=responseEntity.getStatusCode();
		 * System.out.println("ForEntityMethodRestTemplateDemo.Status Code is Three : "
		 * +httpStatus);
		 * 
		 * String userDetail=responseEntity.getBody(); System.out.
		 * println("ForEntityMethodRestTemplateDemo.Response userDetail Three : "
		 * +userDetail);
		 * 
		 * HttpHeaders responseHeaders=responseEntity.getHeaders(); System.out.
		 * println("ForEntityMethodRestTemplateDemo.Response Headers Three : "
		 * +responseHeaders);
		 */
		
	}

	private void getListOfObject() {
		String url=baseUrl+"users";
		ResponseEntity<List> responseEntity=restTemplate.getForEntity(url, List.class);
		  HttpStatus httpStatus=responseEntity.getStatusCode();
		  System.out.println("ForEntityMethodRestTemplateDemo.Status Code is Two: "+httpStatus);
		  
		  List userDetail=responseEntity.getBody();
		  System.out.println("ForEntityMethodRestTemplateDemo.Response userDetail Two: "+userDetail);
		  
		  HttpHeaders responseHeaders=responseEntity.getHeaders();
		  System.out.println("ForEntityMethodRestTemplateDemo.Response Headers Two: "+responseHeaders);
		
	}

	private void getSingleObject() {
		String url=baseUrl+"user/7";
		ResponseEntity<String> responseEntity=restTemplate.getForEntity(url, String.class);
		  HttpStatus httpStatus=responseEntity.getStatusCode();
		  System.out.println("ForEntityMethodRestTemplateDemo.Status Code is One : "+httpStatus);
		  
		  String userDetail=responseEntity.getBody();
		  System.out.println("ForEntityMethodRestTemplateDemo.Response userDetail One : "+userDetail);
		  
		  HttpHeaders responseHeaders=responseEntity.getHeaders();
		  System.out.println("ForEntityMethodRestTemplateDemo.Response Headers One : "+responseHeaders);
		
	}
	
}
