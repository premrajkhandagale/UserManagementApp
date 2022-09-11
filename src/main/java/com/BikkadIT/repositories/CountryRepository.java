package com.BikkadIT.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BikkadIT.entities.CountryMaster;
import com.BikkadIT.entities.StatesMaster;

@Repository
public interface CountryRepository extends JpaRepository<CountryMaster,Serializable>{

	public List<StatesMaster> findByCountryId(Integer countryId);
}
