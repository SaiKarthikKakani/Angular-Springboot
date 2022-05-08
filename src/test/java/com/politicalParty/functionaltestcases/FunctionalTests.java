package com.politicalParty.functionaltestcases;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.politicalParty.testutilities.TestData;
import com.politicalparty.controller.DevelopmentController;
import com.politicalparty.controller.PartyController;
import com.politicalparty.controller.PartyLeaderController;
import com.politicalparty.dto.DevelopmentDTO;
import com.politicalparty.dto.PartyDTO;
import com.politicalparty.dto.PartyLeaderDTO;
import com.politicalparty.service.DevelopmentService;
import com.politicalparty.service.PartyLeaderService;
import com.politicalparty.service.PartyService;



@AutoConfigureMockMvc
@WebMvcTest({PartyController.class, PartyLeaderController.class, DevelopmentController.class})
class FunctionalTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PartyService partyService;
	
	@MockBean
	private PartyLeaderService partyLeaderService;
	
	@MockBean
	private DevelopmentService developmentService;
	
	/**
	 * Validating Party API's
	 */
	@Test
	void testAddParty() throws Exception 
	{ 
        PartyDTO partyDTO = TestData.getPartyDTO();
	
        Mockito.when(partyService.savePartyInformation(partyDTO)).thenReturn(partyDTO);
		
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/politics/api/v1/party/addParty")
				.content(TestData.asJsonString(partyDTO))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        
        assertTrue(result.getResponse().getContentAsString().contentEquals(TestData.asJsonString(partyDTO))? true : false);
	}
	
	@Test
	void testSearchPartyById() throws Exception 
	{ 
        PartyDTO partyDTO = TestData.getPartyDTO();
        Long partyId = partyDTO.getPartyId();
	
        Mockito.when(partyService.getPartyByPartyId(partyId)).thenReturn(partyDTO);
		
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/politics/api/v1/party/getPartyById/" + partyId)
				.content(TestData.asJsonString(partyDTO))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        
        assertTrue(result.getResponse().getContentAsString().contentEquals(TestData.asJsonString(partyDTO))? true : false);
	}
	
	@Test
	void testDeletePartyById() throws Exception 
	{ 
        PartyDTO partyDTO = TestData.getPartyDTO();
        Long partyId = partyDTO.getPartyId();
	
        Mockito.when(partyService.deleteParty(partyId)).thenReturn(partyDTO);
		
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/politics/api/v1/party/deletePartyById/" + partyId)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        
        assertTrue(result.getResponse().getContentAsString().contentEquals(TestData.asJsonString(partyDTO))? true : false);
	}
	
	@Test
	void testSearchAllParties() throws Exception 
	{ 
        List<PartyDTO> partyDTOList = new ArrayList<>();
        partyDTOList.add(TestData.getPartyDTO());
	
        Mockito.when(partyService.getAllParties()).thenReturn(partyDTOList);
		
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/politics/api/v1/party/get/all")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        
        assertTrue(result.getResponse().getContentAsString().contentEquals(TestData.asJsonString(partyDTOList))? true : false);
	}
	
	@Test
	void testDeletePartyLeader() throws Exception 
	{ 
        PartyLeaderDTO partyLeaderDTO = TestData.getPartyLeaderDTO();
        Long leaderId = partyLeaderDTO.getLeaderId();
	
        Mockito.when(partyService.deletePartyLeaderFromParty(leaderId)).thenReturn("Deleted");
		
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/politics/api/v1/party/delete/" + leaderId)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        
        assertTrue(result.getResponse().getContentAsString().contentEquals("The party leader with id: 1 had been removed from the Party")? true : false);
	}
	
	/**
	 * Validate PartyLeader API's
	 */
	@Test
	void testRegisterPartyLeader() throws Exception
	{
		PartyLeaderDTO partyLeaderDTO = TestData.getPartyLeaderDTO();
		
		Mockito.when(partyLeaderService.registerLeader(partyLeaderDTO)).thenReturn(partyLeaderDTO);
		
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/politics/api/v1/leader/register-leader")
				.content(TestData.asJsonString(partyLeaderDTO))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        
        assertTrue(result.getResponse().getContentAsString().contentEquals(TestData.asJsonString(partyLeaderDTO))? true : false);
	}
	
	@Test
	void testSearchPartyLeaderByLeaderId() throws Exception
	{
		PartyLeaderDTO partyLeaderDTO = TestData.getPartyLeaderDTO();
		Long leaderId = partyLeaderDTO.getLeaderId();
		
		Mockito.when(partyLeaderService.getLeaderById(leaderId)).thenReturn(partyLeaderDTO);
		
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/politics/api/v1/leader/getLeaderById/" + leaderId)
				.content(TestData.asJsonString(partyLeaderDTO))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        
        assertTrue(result.getResponse().getContentAsString().contentEquals(TestData.asJsonString(partyLeaderDTO))? true : false);
	}
	
	@Test
	void testSearchAllPartyLeadersUnderParty() throws Exception
	{
		List<PartyLeaderDTO> partyLeaderDTOList = new ArrayList<>();
		partyLeaderDTOList.add(TestData.getPartyLeaderDTO());
		Long partyId = TestData.getPartyLeaderDTO().getPartyId();
		
		Mockito.when(partyLeaderService.getAllLeadersForParty(partyId)).thenReturn(partyLeaderDTOList);
		
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/politics/api/v1/leader/getAllLeadersForParty/" + partyId)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        
        assertTrue(result.getResponse().getContentAsString().contentEquals(TestData.asJsonString(partyLeaderDTOList))? true : false);
	}
	
	@Test
	void testSearchAllPartyLeaders() throws Exception
	{
		List<PartyLeaderDTO> partyLeaderDTOList = new ArrayList<>();
		partyLeaderDTOList.add(TestData.getPartyLeaderDTO());
		
		Mockito.when(partyLeaderService.getAllLeaders()).thenReturn(partyLeaderDTOList);
		
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/politics/api/v1/leader/getAllLeaders")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        
        assertTrue(result.getResponse().getContentAsString().contentEquals(TestData.asJsonString(partyLeaderDTOList))? true : false);
	}
	
	/**
	 * Validate DevelopmentDTO API's
	 */
	@Test
	void testDevelopment() throws Exception
	{
		DevelopmentDTO developmentDTO = TestData.getPartyLeaderDevelopmentDTO();
		
		Mockito.when(developmentService.addDevelopment(developmentDTO)).thenReturn(developmentDTO);
		
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/politics/api/v1/development/add-development")
				.content(TestData.asJsonString(developmentDTO))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        
        assertTrue(result.getResponse().getContentAsString().contentEquals(TestData.asJsonString(developmentDTO))? true : false);
	}
	
	@Test
	void testSearchDevelopmentByLeader() throws Exception
	{
		List<DevelopmentDTO> developmentDTOList = new ArrayList<>();
		developmentDTOList.add(TestData.getPartyLeaderDevelopmentDTO());
		Long leaderId = TestData.getPartyLeaderDevelopmentDTO().getLeaderId();
		
		Mockito.when(developmentService.getDevelopmentByLeaderId(leaderId)).thenReturn(developmentDTOList);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/politics/api/v1/development/get-development-by-leader/" + leaderId)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        
        assertTrue(result.getResponse().getContentAsString().contentEquals(TestData.asJsonString(developmentDTOList))? true : false);
	}
	
	@Test
	void testUpdateDevelopment() throws Exception
	{
		DevelopmentDTO developmentDTO = TestData.getPartyLeaderDevelopmentDTO();
		Long leaderId = developmentDTO.getLeaderId();
		
		Mockito.when(developmentService.updateDevelopment(developmentDTO, leaderId)).thenReturn(developmentDTO);
		
        RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/politics/api/v1/development/update-development/" + leaderId)
				.content(TestData.asJsonString(developmentDTO))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        
        assertTrue(result.getResponse().getContentAsString().contentEquals(TestData.asJsonString(developmentDTO))? true : false);
	}

}
