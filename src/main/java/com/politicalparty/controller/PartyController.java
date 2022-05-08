package com.politicalparty.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.politicalparty.dto.PartyDTO;
import com.politicalparty.exception.InvalidPartyException;
import com.politicalparty.exception.NoPartyFoundException;
import com.politicalparty.service.PartyService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/politics/api/v1/party")
public class PartyController {

	@Autowired
	private PartyService partyService;

	@PostMapping(value = "/addParty")
	public ResponseEntity<PartyDTO> addNewParty(@Valid @RequestBody PartyDTO partyDto, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			throw new InvalidPartyException("Invalid Party Data Entered!!!" + bindingResult.getAllErrors());
		} else {
			return new ResponseEntity<>(this.partyService.savePartyInformation(partyDto), HttpStatus.OK);
		}
	}

	@DeleteMapping(value = "/deletePartyById/{partyId}")
	public ResponseEntity<PartyDTO> deleteParty(@PathVariable("partyId") Long partyId) {
		
		PartyDTO deletedPartyInfo = this.partyService.deleteParty(partyId);
		
		if(deletedPartyInfo == null)
			throw new NoPartyFoundException("No Party Found with the id: " + partyId);

		return new ResponseEntity<>(deletedPartyInfo, HttpStatus.OK);
	}

	@GetMapping(value = "/getPartyById/{partyId}")
	public ResponseEntity<PartyDTO> getPartyById(@PathVariable("partyId") Long partyId) {

		PartyDTO partyInfo = this.partyService.getPartyByPartyId(partyId);
		
		if(partyInfo == null)
			throw new NoPartyFoundException("No Party Found with the id: " + partyId);

		return new ResponseEntity<>(partyInfo, HttpStatus.OK);
	}

	@GetMapping(value = "/get/all")
	public ResponseEntity<List<PartyDTO>> getAllParties() {

		List<PartyDTO> allPartiesInfo = this.partyService.getAllParties();

		return new ResponseEntity<>(allPartiesInfo, HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{leaderId}")
	public String deletePartyLeaderFromParty(@PathVariable("leaderId") Long leaderId) {

		this.partyService.deletePartyLeaderFromParty(leaderId);
		
		return "The party leader with id: " + leaderId + " had been removed from the Party";
	}

}
