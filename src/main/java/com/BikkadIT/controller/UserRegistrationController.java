package com.BikkadIT.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.bindings.UserForm;
import com.BikkadIT.service.UserServiceI;

@RestController
public class UserRegistrationController {
	
	@Autowired
	private UserServiceI userServiceI;
	
	@GetMapping("/countries")
	public ResponseEntity<Map<Integer,String>> countries(){
		Map<Integer,String> countries = userServiceI.getCountries();
		return new ResponseEntity<Map<Integer,String>>(countries,HttpStatus.OK);
		
	}
	
	@GetMapping("/states/{countryId}")
	public ResponseEntity<Map<Integer,String>> states(@PathVariable Integer countryId)
	{
		Map<Integer,String> states = userServiceI.getStates(countryId);
		return new ResponseEntity<Map<Integer,String>>(states,HttpStatus.OK);
		
	}
	
	@GetMapping("/cities/{cityId}")
	public ResponseEntity<Map<Integer,String>>cities(@PathVariable Integer cityId)
	{
		Map<Integer,String> city = userServiceI.getCity(cityId);
		return new ResponseEntity<Map<Integer,String>>(city,HttpStatus.OK);
		
	}
	
	@PostMapping("/saveUser")
	public ResponseEntity<String> saveUser(@RequestBody UserForm userForm)
	{
		String saveUser = userServiceI.saveUser(userForm);
		return new ResponseEntity<String>(saveUser,HttpStatus.OK);
		
		}
		
	}


