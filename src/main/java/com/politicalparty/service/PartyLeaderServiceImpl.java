package com.politicalparty.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.politicalparty.dto.PartyLeaderDTO;
import com.politicalparty.exception.NoPartyFoundException;
import com.politicalparty.exception.NoPartyLeaderFoundException;
import com.politicalparty.model.Party;
import com.politicalparty.model.PartyLeader;
import com.politicalparty.repository.PartyLeaderRepository;
import com.politicalparty.repository.PartyRepository;
import com.politicalparty.utils.PoliticalPartyUtility;

@Service
public class PartyLeaderServiceImpl implements PartyLeaderService {

	@Autowired
	private PartyLeaderRepository partyLeaderRepository;

	@Autowired
	private PartyRepository partyRepository;

	@Override
	public PartyLeaderDTO registerLeader(PartyLeaderDTO partyLeaderDTO) {

		Party partyDetail = this.partyRepository.findById(partyLeaderDTO.getPartyId())
				.orElseThrow(() -> new NoPartyFoundException(
						"No Party Found with partyId: " + partyLeaderDTO.getPartyId() + ". Add the valid party."));

		if (partyDetail != null)
			this.partyLeaderRepository.save(PoliticalPartyUtility.convertToPartyLeaderDetails(partyLeaderDTO));

		return partyLeaderDTO;
	}

	@Override
	public List<PartyLeaderDTO> getAllLeadersForParty(Long partyId) {

		Party partyInfo = this.partyRepository.findById(partyId)
				.orElseThrow(() -> new NoPartyFoundException("No party found with partyId: " + partyId));

		List<PartyLeader> partyLeaders = new ArrayList<>();
		
		if(partyInfo != null)
			partyLeaders = this.partyLeaderRepository.findAllByPartyId(partyId);
	
		return PoliticalPartyUtility.convertToPartyLeaderDetailsDtoList(partyLeaders);
		
	}

	@Override
	public PartyLeaderDTO getLeaderById(Long leaderId) {
		PartyLeader partyLeader = this.partyLeaderRepository.findById(leaderId)
				.orElseThrow(() -> new NoPartyLeaderFoundException("No Party Leader found with leaderId: " + leaderId));

		return PoliticalPartyUtility.convertToPartyLeaderDTO(partyLeader);
	}

	@Override
	public List<PartyLeaderDTO> getAllLeaders() {
		
		return PoliticalPartyUtility.convertToPartyLeaderDetailsDtoList(this.partyLeaderRepository.findAll());
	}

}
