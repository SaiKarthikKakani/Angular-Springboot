package com.politicalparty.service;

import java.util.List;

import com.politicalparty.dto.PartyLeaderDTO;

public interface PartyLeaderService {
	
	public PartyLeaderDTO registerLeader(PartyLeaderDTO partyLeaderDTO);
	public List<PartyLeaderDTO> getAllLeadersForParty(Long partyId);
	public PartyLeaderDTO getLeaderById(Long leaderId);
	public List<PartyLeaderDTO> getAllLeaders();

}
