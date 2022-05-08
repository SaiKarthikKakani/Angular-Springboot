package com.politicalparty.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.politicalparty.model.Development;

@Repository
public interface DevelopmentRepository extends JpaRepository<Development, Long>{
	
	public List<Development> findDevelopmentActivitiesByLeaderId(Long leaderId);

}
