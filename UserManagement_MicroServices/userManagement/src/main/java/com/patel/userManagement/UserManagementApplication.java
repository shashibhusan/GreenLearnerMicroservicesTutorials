package com.patel.userManagement;


import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

//@SpringBootApplication
public class UserManagementApplication {
	
	
	static RestTemplate restTemplate=new RestTemplate();
	static String baseUrl="http://localhost:8083/springDataDemo/";

	public static void main(String[] args) {
		//SpringApplication.run(UserManagementApplication.class, args);
		//useExchangeMethodOfRestTemplate();
		
		/*
		 * ForEntityMethodRestTemplateDemo demo=new ForEntityMethodRestTemplateDemo();
		 * demo.derivedMethod();
		 */
		ForObjectMethodRestTemplateDemo demo2=new ForObjectMethodRestTemplateDemo();
		demo2.derivedMethod();
	}
	
	
	private static void useExchangeMethodOfRestTemplate()
	{
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> requestEntity=new HttpEntity<>(headers);
		//getSingleUserByExchangeMethod(requestEntity);
		//getListUserByExchangeMethod(requestEntity);
		
		Person person=new Person();
		person.setFirstName("Arpit");
		person.setLastName("Kumar");
		person.setAddress("Lucknow");
		person.setGender("Male");
		//requestEntity=new HttpEntity<>(person,headers);
		//addUserByExchangeMethod(requestEntity);
		
		updateUserAddress(requestEntity);
	}
	
	private static void updateUserAddress(HttpEntity<Object> requestEntity) {
		 
		 ResponseEntity<String>
		  responseEntity=restTemplate.exchange(baseUrl+"/updateAddress/7/Current Address is Piluee", HttpMethod.PUT,
		  requestEntity, String.class);
		  
		  HttpStatus httpStatus=responseEntity.getStatusCode();
		  System.out.println("Status Code is : "+httpStatus);
		  
		  String userDetail=responseEntity.getBody();
		  System.out.println("Response userDetail : "+userDetail);
		  
		  HttpHeaders responseHeaders=responseEntity.getHeaders();
		  System.out.println("Response Headers : "+responseHeaders);
	}


	private static void addUserByExchangeMethod(HttpEntity<Object> requestEntity) {
		 ResponseEntity<String>
		  responseEntity=restTemplate.exchange(baseUrl+"/user", HttpMethod.POST,
		  requestEntity, String.class);
		  
		  HttpStatus httpStatus=responseEntity.getStatusCode();
		  System.out.println("Status Code is : "+httpStatus);
		  
		  String userDetail=responseEntity.getBody();
		  System.out.println("Response userDetail : "+userDetail);
		  
		  HttpHeaders responseHeaders=responseEntity.getHeaders();
		  System.out.println("Response Headers : "+responseHeaders);
	}


	private static void getListUserByExchangeMethod(HttpEntity<Object> requestEntity)
	{
		  ResponseEntity<List>
		  responseEntity=restTemplate.exchange(baseUrl+"/users", HttpMethod.GET,
		  requestEntity, List.class);
		  
		  HttpStatus httpStatus=responseEntity.getStatusCode();
		  System.out.println("Status Code is : "+httpStatus);
		  
		  List users=responseEntity.getBody();
		  System.out.println("Response Body :::::: "+users);
		  
		  HttpHeaders responseHeaders=responseEntity.getHeaders();
		  System.out.println("Response Headers :::::: "+responseHeaders);
		 
 
	}
	
	private static void getSingleUserByExchangeMethod(HttpEntity<Object> requestEntity)
	{
		  ResponseEntity<String>
		  responseEntity=restTemplate.exchange(baseUrl+"/user/2", HttpMethod.GET,
		  requestEntity, String.class);
		  
		  HttpStatus httpStatus=responseEntity.getStatusCode();
		  System.out.println("Status Code is : "+httpStatus);
		  
		  String user=responseEntity.getBody();
		  System.out.println("Response Body : "+user);
		  
		  HttpHeaders responseHeaders=responseEntity.getHeaders();
		  System.out.println("Response Headers : "+responseHeaders);
		 
		//***********************************
		// Means you can use the different model class to hold the response but properties of the model class should be same
		ResponseEntity<Person> response=restTemplate.exchange(baseUrl+"/user/2", HttpMethod.GET, requestEntity, Person.class);
		Person u1=response.getBody();
		System.out.println("Person object that I am getting is : "+u1);
	}
	
}
