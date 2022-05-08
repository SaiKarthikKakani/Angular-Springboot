package com.politicalparty.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.politicalparty.model.PartyLeader;

@Repository
public interface PartyLeaderRepository extends JpaRepository<PartyLeader, Long> {
	
	public List<PartyLeader> findAllByPartyId(Long partyId);

}
