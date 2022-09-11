package com.BikkadIT.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BikkadIT.entities.CitiesMaster;

@Repository
public interface CityRepository extends JpaRepository<CitiesMaster,Serializable>{

	public List<CitiesMaster> findByCityId(Integer cityId);
}
