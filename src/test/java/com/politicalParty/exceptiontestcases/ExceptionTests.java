package com.politicalParty.exceptiontestcases;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
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

@WebMvcTest({PartyController.class, PartyLeaderController.class, DevelopmentController.class})
@AutoConfigureMockMvc
class ExceptionTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PartyService partyService;

	@MockBean
	private PartyLeaderService partyLeaderService;
	
	@MockBean
	private DevelopmentService developmentService;
	
	/**
	 * Exceptions regarding Party Service
	 */
	
	@Test
	void testPartyForExceptionUponAddingNewPartyWithPartyNameNull() throws Exception
	{
		PartyDTO partyDto = TestData.getPartyDTO();
		partyDto.setPartyName(null);
		
		Mockito.when(partyService.savePartyInformation(partyDto)).thenReturn(partyDto);
				
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/politics/api/v1/party/addParty")
				.content(TestData.asJsonString(partyDto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		assertTrue(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? true : false);
	}
	
	@Test
	void testPartyForExceptionUponAddingNewPartyWithFounderNameNull() throws Exception
	{
		PartyDTO partyDto = TestData.getPartyDTO();
		partyDto.setFounderName(null);
		
		Mockito.when(partyService.savePartyInformation(partyDto)).thenReturn(partyDto);
				
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/politics/api/v1/party/addParty")
				.content(TestData.asJsonString(partyDto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		assertTrue(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? true : false);
	}
	
	@Test
	void testPartyForExceptionUponAddingNewPartyWithIncorrectPartyId() throws Exception
	{
		Mockito.when(partyService.getPartyByPartyId(2L)).thenReturn(null);
				
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/politics/api/v1/party/getPartyById/2")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		assertTrue(result.getResponse().getStatus() == HttpStatus.NOT_FOUND.value() ? true : false);
	}
	
	@Test
	void testPartyForExceptionUponDeletingNewPartyWithIncorrectPartyId() throws Exception
	{
		Mockito.when(partyService.deleteParty(2L)).thenReturn(null);
				
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/politics/api/v1/party/deletePartyById/2")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		assertTrue(result.getResponse().getStatus() == HttpStatus.NOT_FOUND.value() ? true : false);
	}
	
	/**
	 * Exceptions regarding PartyLeaderDTO
	 */
	@Test
	void testPartyLeaderForExceptionUponAddingNewPartyLeaderWithNullPartyId() throws Exception
	{
		PartyLeaderDTO partyLeaderDTO = TestData.getPartyLeaderDTO();
		partyLeaderDTO.setPartyId(null);
		
		Mockito.when(partyLeaderService.registerLeader(partyLeaderDTO)).thenReturn(partyLeaderDTO);
				
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/politics/api/v1/leader/register-leader")
				.content(TestData.asJsonString(partyLeaderDTO))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		assertTrue(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? true : false);
	}
	
	@Test
	void testPartyLeaderForExceptionUponAddingNewPartyLeaderWithNullLeaderName() throws Exception
	{
		PartyLeaderDTO partyLeaderDTO = TestData.getPartyLeaderDTO();
		partyLeaderDTO.setLeaderName(null);
		
		Mockito.when(partyLeaderService.registerLeader(partyLeaderDTO)).thenReturn(partyLeaderDTO);
				
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/politics/api/v1/leader/register-leader")
				.content(TestData.asJsonString(partyLeaderDTO))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		assertTrue(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? true : false);
	}
	
	@Test
	void testPartyLeaderForExceptionUponAddingNewPartyLeaderWithNullPartyLeaderState() throws Exception
	{
		PartyLeaderDTO partyLeaderDTO = TestData.getPartyLeaderDTO();
		partyLeaderDTO.setLeaderState(null);
		
		Mockito.when(partyLeaderService.registerLeader(partyLeaderDTO)).thenReturn(partyLeaderDTO);
				
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/politics/api/v1/leader/register-leader")
				.content(TestData.asJsonString(partyLeaderDTO))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		assertTrue(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? true : false);
	}
	
	@Test
	void testPartyLeaderForExceptionUponFetchingNewPartyLeaderWithIncorrectLeaderId() throws Exception
	{
		Mockito.when(partyLeaderService.getLeaderById(2L)).thenReturn(null);
				
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/politics/api/v1/leader/getLeaderById/2")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		assertTrue(result.getResponse().getStatus() == HttpStatus.NOT_FOUND.value() ? true : false);
	}
	
	@Test
	void testPartyLeaderForExceptionUponFetchingNewPartyLeaderWithIncorrectPartyId() throws Exception
	{
		Mockito.when(partyLeaderService.getAllLeadersForParty(3L)).thenReturn(null);
				
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/politics/api/v1/leader/getAllLeadersForParty/3")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		assertTrue(result.getResponse().getStatus() == HttpStatus.NOT_FOUND.value() ? true : false);
	}
	
	/**
	 * Exceptions regarding DevelopmentDTO
	 */
	@Test
	void testDevelopmentForExceptionUponAddingNewDevelopmentWithNullLeaderId() throws Exception
	{
		DevelopmentDTO developmentDTO = TestData.getPartyLeaderDevelopmentDTO();
		developmentDTO.setLeaderId(null);
		
		Mockito.when(developmentService.addDevelopment(developmentDTO)).thenReturn(developmentDTO);
				
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/politics/api/v1/development/add-development")
				.content(TestData.asJsonString(developmentDTO))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		assertTrue(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? true : false);
	}
	
	@Test
	void testDevelopmentForExceptionUponAddingNewDevelopmentWithNullDevelopmentTitle() throws Exception
	{
		DevelopmentDTO developmentDTO = TestData.getPartyLeaderDevelopmentDTO();
		developmentDTO.setDevelopmentTitle(null);
		
		Mockito.when(developmentService.addDevelopment(developmentDTO)).thenReturn(developmentDTO);
				
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/politics/api/v1/development/add-development")
				.content(TestData.asJsonString(developmentDTO))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		assertTrue(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? true : false);
	}
	
	@Test
	void testDevelopmentForExceptionUponAddingNewDevelopmentWithNullActivity() throws Exception
	{
		DevelopmentDTO developmentDTO = TestData.getPartyLeaderDevelopmentDTO();
		developmentDTO.setActivity(null);
		
		Mockito.when(developmentService.addDevelopment(developmentDTO)).thenReturn(developmentDTO);
				
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/politics/api/v1/development/add-development")
				.content(TestData.asJsonString(developmentDTO))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		assertTrue(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? true : false);
	}
	
	@Test
	void testDevelopmentForExceptionUponAddingNewDevelopmentWithNullState() throws Exception
	{
		DevelopmentDTO developmentDTO = TestData.getPartyLeaderDevelopmentDTO();
		developmentDTO.setState(null);
		
		Mockito.when(developmentService.addDevelopment(developmentDTO)).thenReturn(developmentDTO);
				
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/politics/api/v1/development/add-development")
				.content(TestData.asJsonString(developmentDTO))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		assertTrue(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? true : false);
	}
	
	@Test
	void testDevelopmentForExceptionUponFetchingDevelopmentWithNullLeaderId() throws Exception
	{
		Mockito.when(developmentService.getDevelopmentByLeaderId(3L)).thenReturn(null);
				
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/politics/api/v1/development/get-development-by-leader/3")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		assertTrue(result.getResponse().getStatus() == HttpStatus.NOT_FOUND.value() ? true : false);
	}
	
	@Test
	void testDevelopmentForExceptionUponUpdatingDevelopmentWithIncorrectActivity() throws Exception
	{
		DevelopmentDTO developmentDTO = TestData.getPartyLeaderDevelopmentDTO();
		developmentDTO.setActivity("ABC");
		
		Mockito.when(developmentService.updateDevelopment(developmentDTO, 1L)).thenReturn(developmentDTO);
				
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/politics/api/v1/development/update-development/1")
				.content(TestData.asJsonString(developmentDTO))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		assertTrue(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? true : false);
	}

}
