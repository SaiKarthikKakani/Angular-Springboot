package com.politicalparty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.politicalparty.dto.PartyDTO;
import com.politicalparty.exception.NoPartyFoundException;
import com.politicalparty.exception.NoPartyLeaderFoundException;
import com.politicalparty.model.Party;
import com.politicalparty.model.PartyLeader;
import com.politicalparty.repository.PartyLeaderRepository;
import com.politicalparty.repository.PartyRepository;
import com.politicalparty.utils.PoliticalPartyUtility;

@Service
public class PartyServiceImpl implements PartyService {

	@Autowired
	private PartyRepository partyRepository;

	@Autowired
	private PartyLeaderRepository partyLeaderRepository;

	@Override
	public PartyDTO savePartyInformation(PartyDTO partyDto) {
		this.partyRepository.save(PoliticalPartyUtility.convertToPartyDetails(partyDto));

		return partyDto;
	}

	@Override
	public PartyDTO deleteParty(Long id) {
		PartyDTO partyDetails = this.getPartyByPartyId(id);

		this.partyRepository.deleteById(id);

		return partyDetails;
	}

	@Override
	public List<PartyDTO> getAllParties() {
		List<Party> partiesList = this.partyRepository.findAll();

		return PoliticalPartyUtility.convertToPartyDetailsDtoList(partiesList);
	}

	@Override
	public PartyDTO getPartyByPartyId(Long id) {
		Party partyDetail = this.partyRepository.findById(id)
				.orElseThrow(() -> new NoPartyFoundException("No Party found with partyId: " + id));

		return PoliticalPartyUtility.convertToPartyDTO(partyDetail);
	}

	@Override
	public String deletePartyLeaderFromParty(Long leaderId) {
		String returnString = "";
		
		PartyLeader partyLeaderInfo = this.partyLeaderRepository.findById(leaderId)
				.orElseThrow(() -> new NoPartyLeaderFoundException("No Party Leader Found with leaderId: " + leaderId));

		Long partyId = partyLeaderInfo.getPartyId();

		PartyDTO partyInfo = this.getPartyByPartyId(partyId);
		
		if (partyInfo != null) {
			this.partyLeaderRepository.deleteById(leaderId);
			returnString = "Leader with Id: " + leaderId + " deleted from party";
		}
		
		return returnString;

	}

}
