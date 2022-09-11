package com.BikkadIT.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.bindings.LoginForm;
import com.BikkadIT.bindings.UnlockAccountForm;
import com.BikkadIT.bindings.UserForm;
import com.BikkadIT.entities.CitiesMaster;
import com.BikkadIT.entities.CountryMaster;
import com.BikkadIT.entities.StatesMaster;
import com.BikkadIT.entities.UserAccount;
import com.BikkadIT.repositories.CityRepository;
import com.BikkadIT.repositories.CountryRepository;
import com.BikkadIT.repositories.StatesRepository;
import com.BikkadIT.repositories.UserRepository;
@Service
public class UserServiceImpl implements UserServiceI{
	
	private static final String RandomStringUtils = "10";

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private StatesRepository statesRepository;

	@Autowired
	private CityRepository cityRepository;
	
	@Override
	public String login(LoginForm loginForm) {
		UserAccount userAccount = userRepository.findByEmailAndPassword(loginForm.getEmail(), loginForm.getPassword());
		if(userAccount !=null)
		{
			if(userAccount.getAccStatus().equals("Locked"))
			{
				return "your account is locked";
			}
		else {
			return "login Successful..Welcome to BikkadIT";
		}
		}else {
			return "Credentials are invalid";
		}
	}

	@Override
	public Map<Integer, String> getCountries() {
      List<CountryMaster> findAll = countryRepository.findAll();
      Map<Integer,String> countrymap= new HashMap<>();
      for(CountryMaster R:findAll) {
    	  countrymap.put(R.getCountryId(), R.getCountryName());
      }
		return countrymap;
	}

	@Override
	public Map<Integer, String> getStates(Integer countryId) {
		List<StatesMaster> byStateId = statesRepository.findByStateId(countryId);
		Map<Integer,String> statemap=new HashMap<>();
		for(StatesMaster E:byStateId)
		{
			statemap.put(E.getStateId(), E.getStateName());
		}
		return statemap;
	}

	@Override
	public Map<Integer, String> getCity(Integer cityId) {
		List<CitiesMaster> byCityId = cityRepository.findByCityId(cityId);
		Map<Integer,String> citymap=new HashMap<>();
		for(CitiesMaster G:byCityId)
		{
			citymap.put(G.getCityId(), G.getCityName());
		}
		return citymap;
	}

	@Override
	public String saveUser(UserForm userForm) {
		userForm.setAccStatus("LOCKED");
		userForm.setPassword(generateRandomPassword()); // here i am using this math(),becoz RandomString not supporting
		UserAccount userAccount=new UserAccount();
		BeanUtils.copyProperties(userForm, userAccount);
		UserAccount save = userRepository.save(userAccount);
		if(save !=null)
		{
			return "User data saved successfully. check your email to unlock your account";
		}else {
			return "User not saved Successfully";
		}
		
	}



	
	private String generateRandomPassword() {
		                         // here i use formatted instead of randomAlphanumeric
		String randomPassword= RandomStringUtils.formatted(6);
		return randomPassword;
	}

	@Override
	public boolean unlockAcc(UnlockAccountForm unlockAccountForm) {
		
		String email= unlockAccountForm.getEmail();
		String tempPwd= unlockAccountForm.getTempPwd();
		
		
		UserAccount user = userRepository.findByEmailAndPassword(email, tempPwd);
	    if(user !=null)
	    {
	    	user.setAccStatus("UNLOCKED");
	    	user.setPassword(unlockAccountForm.getNewPwd());
	    	userRepository.save(user);
	    	return true;
	    }else
		{
			return false;
		}
		
	}

	@Override
	public String forgotPwd(String email) {
		UserAccount findByEmail = userRepository.findByEmail(email);
		if(findByEmail !=null)
		{
			return "Success";
		}else {
			
			return "failed";
		}		
	}	
	
	
		
	}
	
	

	
	
	

	
	
	
