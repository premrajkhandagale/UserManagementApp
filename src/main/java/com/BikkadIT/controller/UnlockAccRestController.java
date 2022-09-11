package com.BikkadIT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.bindings.UnlockAccountForm;
import com.BikkadIT.service.UserServiceI;

@RestController
public class UnlockAccRestController {
	
	@Autowired
	private UserServiceI userServiceI;
	
	@PostMapping("/unlock")
	public String unlockAcc(@RequestBody UnlockAccountForm unlockAccountForm)
	{
		boolean unlockAcc = userServiceI.unlockAcc(unlockAccountForm);
		if(unlockAcc)
		{
			return "Account unlock";
		}
		return "Failed to unlock";
		
	}

}
