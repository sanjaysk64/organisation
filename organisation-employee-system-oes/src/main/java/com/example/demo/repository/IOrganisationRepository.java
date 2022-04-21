package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Organisation;

@Repository
public interface IOrganisationRepository extends JpaRepository<Organisation, Integer> {
	public List<Organisation> findByDept(String dept);

}
