package com.politicalparty.service;

import java.util.List;

import com.politicalparty.dto.PartyDTO;

public interface PartyService {
	
	public PartyDTO savePartyInformation(PartyDTO partyDto);
	public PartyDTO deleteParty(Long id);
	public List<PartyDTO> getAllParties();
	public PartyDTO getPartyByPartyId(Long id);
	public String deletePartyLeaderFromParty(Long leaderId);

}
