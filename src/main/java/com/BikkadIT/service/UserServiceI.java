package com.BikkadIT.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.BikkadIT.bindings.LoginForm;
import com.BikkadIT.bindings.UnlockAccountForm;
import com.BikkadIT.bindings.UserForm;
import com.BikkadIT.entities.UserAccount;
@Service
public interface UserServiceI {

	public String login(LoginForm loginForm);
	
	public Map<Integer,String> getCountries();
	
	public Map<Integer, String> getStates(Integer countryId);
	
	public Map<Integer,String> getCity(Integer cityId);
	
	public String saveUser(UserForm userForm);
	
	public boolean unlockAcc(UnlockAccountForm unlockAccountForm);
	
	public String forgotPwd(String email);
	
	
	

}
