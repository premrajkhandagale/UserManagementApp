package com.BikkadIT.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BikkadIT.entities.UserAccount;
@Repository
public interface UserRepository extends JpaRepository<UserAccount,Serializable>{

	public UserAccount findByEmailAndPassword(String email, String password);
	
	public UserAccount findByEmail(String email);
	
}
