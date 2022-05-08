package com.politicalParty.testutilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.politicalparty.dto.DevelopmentDTO;
import com.politicalparty.dto.PartyDTO;
import com.politicalparty.dto.PartyLeaderDTO;
import com.politicalparty.model.Development;
import com.politicalparty.model.Party;
import com.politicalparty.model.PartyLeader;

public class TestData {
	
	public static PartyDTO getPartyDTO() {
		PartyDTO partyDTO = new PartyDTO();
		
		partyDTO.setPartyId((long)1);
		partyDTO.setPartyName("Telugu Desam Party");
		partyDTO.setFounderName("Taraka Rama Rao");
		partyDTO.setFoundationYear(1985);
		
		return partyDTO;
	}
	
	public static PartyLeaderDTO getPartyLeaderDTO() {
		PartyLeaderDTO partyLeaderDTO = new PartyLeaderDTO();
		
		partyLeaderDTO.setPartyId((long)1);
		partyLeaderDTO.setLeaderId((long)1);
		partyLeaderDTO.setLeaderName("Chandra Babu Naidu");
		partyLeaderDTO.setLeaderState("Andhra Pradesh");
		
		return partyLeaderDTO;
	}
	
	public static DevelopmentDTO getPartyLeaderDevelopmentDTO() {
		DevelopmentDTO developmentDTO = new DevelopmentDTO();
		
		developmentDTO.setDevelopmentId((long)1);
		developmentDTO.setLeaderId((long)1);
		developmentDTO.setDevelopmentTitle("Cleaning");
		developmentDTO.setActivity("Road Cleaning");
		developmentDTO.setBudget(5000.00);
		developmentDTO.setState("Andhra Pradesh");
		developmentDTO.setActivityMonth(6);
		developmentDTO.setActivityYear(2020);
		
		return developmentDTO;
	}
	
	public static Party getParty() {
		Party party = new Party();
		
		party.setPartyId((long)1);
		party.setPartyName("Telugu Desam Party");
		party.setFounderName("Taraka Rama Rao");
		party.setFoundationYear(1985);
		
		return party;
	}
	
	public static PartyLeader getPartyLeader() {
		PartyLeader partyLeader = new PartyLeader();
		
		partyLeader.setPartyId((long)1);
		partyLeader.setLeaderId((long)1);
		partyLeader.setLeaderName("Chandra Babu Naidu");
		partyLeader.setLeaderState("Andhra Pradesh");
		
		return partyLeader;
	}
	
	public static Development getPartyLeaderDevelopment() {
		Development development = new Development();
		
		development.setDevelopmentId((long)1);
		development.setLeaderId((long)1);
		development.setDevelopmentTitle("Cleaning");
		development.setActivity("Road Cleaning");
		development.setBudget(5000.00);
		development.setState("Andhra Pradesh");
		development.setActivityMonth(6);
		development.setActivityYear(2020);
		
		return development;
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        final ObjectMapper mapper = new ObjectMapper();
	        final String jsonContent = mapper.writeValueAsString(obj);
	        return jsonContent;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}

}
