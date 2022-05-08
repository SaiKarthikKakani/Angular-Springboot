package com.politicalParty.functionaltestcases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.politicalParty.testutilities.TestData;
import com.politicalparty.dto.DevelopmentDTO;
import com.politicalparty.dto.PartyDTO;
import com.politicalparty.dto.PartyLeaderDTO;
import com.politicalparty.model.Development;
import com.politicalparty.model.Party;
import com.politicalparty.model.PartyLeader;
import com.politicalparty.utils.PoliticalPartyUtility;

@SuppressWarnings("deprecation")
@ExtendWith(SpringExtension.class)
@RunWith(JUnitPlatform.class)
class UtilityTests {
	
	/**
	 * Validating the PartyUtility methods
	 */
	@Test
	void testConvertToPartyDetails() throws Exception
	{
		PartyDTO partyDTO = TestData.getPartyDTO();
		
		Party partyDetails = PoliticalPartyUtility.convertToPartyDetails(partyDTO);
		
		assertEquals(TestData.asJsonString(partyDTO), TestData.asJsonString(partyDetails));
	}
	
	@Test
	void testConvertToPartyDTODetails() throws Exception
	{
		Party party = TestData.getParty();
		
		PartyDTO partyDetailsDTO = PoliticalPartyUtility.convertToPartyDTO(party);
		
		assertEquals(TestData.asJsonString(party), TestData.asJsonString(partyDetailsDTO));
	}
	
	@Test
	void testConvertToPartyDTOList() throws Exception
	{
		List<Party> partyList = new ArrayList<>();
		
		Party party = TestData.getParty();
		partyList.add(party);
		
		List<PartyDTO> partyDetailsDTOList = PoliticalPartyUtility.convertToPartyDetailsDtoList(partyList);
		
		assertEquals(TestData.asJsonString(partyList), TestData.asJsonString(partyDetailsDTOList));
	}
	
	/**
	 * Validating the PartyLeaderUtility methods
	 */
	@Test
	void testConvertToPartyLeaderDetails() throws Exception
	{
		PartyLeaderDTO partyLeaderDTO = TestData.getPartyLeaderDTO();
		
		PartyLeader partyLeaderDetails = PoliticalPartyUtility.convertToPartyLeaderDetails(partyLeaderDTO);
		
		assertEquals(TestData.asJsonString(partyLeaderDTO), TestData.asJsonString(partyLeaderDetails));
	}
	
	@Test
	void testConvertToPartyLeaderDTODetails() throws Exception
	{
		PartyLeader partyLeader = TestData.getPartyLeader();
		
		PartyLeaderDTO partyLeaderDetailsDTO = PoliticalPartyUtility.convertToPartyLeaderDTO(partyLeader);
		
		assertEquals(TestData.asJsonString(partyLeader), TestData.asJsonString(partyLeaderDetailsDTO));
	}
	
	@Test
	void testConvertToPartyLeaderDTOList() throws Exception
	{
		List<PartyLeader> partyLeaderList = new ArrayList<>();
		
		PartyLeader partyLeader = TestData.getPartyLeader();
		partyLeaderList.add(partyLeader);
		
		List<PartyLeaderDTO> partyLeaderDetailsDTOList = PoliticalPartyUtility.convertToPartyLeaderDetailsDtoList(partyLeaderList);
		
		assertEquals(TestData.asJsonString(partyLeaderList), TestData.asJsonString(partyLeaderDetailsDTOList));
	}
	
	/**
	 * Validating the DevelopmentUtility methods
	 */
	@Test
	void testConvertToDevelopmentDetails() throws Exception
	{
		DevelopmentDTO developmentDTO = TestData.getPartyLeaderDevelopmentDTO();
		
		Development developmentDetails = PoliticalPartyUtility.convertToDevelopmentDetails(developmentDTO);
		
		assertEquals(TestData.asJsonString(developmentDTO), TestData.asJsonString(developmentDetails));
	}
	
	@Test
	void testConvertToDevelopmentDTODetails() throws Exception
	{
		Development development = TestData.getPartyLeaderDevelopment();
		
		DevelopmentDTO developmentDTO = PoliticalPartyUtility.convertToDevelopmentDTO(development);
		
		assertEquals(TestData.asJsonString(development), TestData.asJsonString(developmentDTO));
	}
	
	@Test
	void testConvertToDevelopmentDTOList() throws Exception
	{
		List<Development> developmentList = new ArrayList<>();
		
		Development development = TestData.getPartyLeaderDevelopment();
		developmentList.add(development);
		
		List<DevelopmentDTO> developmentDTOList = PoliticalPartyUtility.convertToDevelopmentDetailsDtoList(developmentList);
		
		assertEquals(TestData.asJsonString(developmentList), TestData.asJsonString(developmentDTOList));
	}

}
