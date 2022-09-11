package com.BikkadIT.repositories;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BikkadIT.entities.StatesMaster;


@Repository
public interface StatesRepository extends JpaRepository<StatesMaster,Serializable>{

	public List<StatesMaster> findByStateId(Integer countrId);
}
