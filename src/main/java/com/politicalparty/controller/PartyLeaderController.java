package com.politicalparty.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.politicalparty.dto.PartyLeaderDTO;
import com.politicalparty.exception.InvalidPartyLeaderException;
import com.politicalparty.exception.NoPartyFoundException;
import com.politicalparty.exception.NoPartyLeaderFoundException;
import com.politicalparty.service.PartyLeaderService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/politics/api/v1/leader")
public class PartyLeaderController {
	
	@Autowired
	private PartyLeaderService partyLeaderService;
	
	@PostMapping(value = "/register-leader")
	public ResponseEntity<PartyLeaderDTO> registerPartyLeader(@Valid @RequestBody PartyLeaderDTO partyLeaderDTO, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			throw new InvalidPartyLeaderException("Invalid Party Leader data!!!" + bindingResult.getFieldErrors());
		} else {
			return new ResponseEntity<>(this.partyLeaderService.registerLeader(partyLeaderDTO), HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "/getLeaderById/{leaderId}")
	public ResponseEntity<PartyLeaderDTO> getPartyLeaderById(@PathVariable("leaderId") Long leaderId) {
		
		PartyLeaderDTO partyLeaderDTO = this.partyLeaderService.getLeaderById(leaderId);
		
		if(partyLeaderDTO == null)
			throw new NoPartyLeaderFoundException("No Party Leader found with leaderId: " + leaderId);
		
		return new ResponseEntity<>(partyLeaderDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAllLeadersForParty/{partyId}")
	public ResponseEntity<List<PartyLeaderDTO>> getAllPartyLeaders(@PathVariable("partyId") Long partyId) {
		
		List<PartyLeaderDTO> partyLeaderDTO = this.partyLeaderService.getAllLeadersForParty(partyId);
		
		if(partyLeaderDTO == null)
			throw new NoPartyFoundException("No party found with partyId; " + partyId);
		
		return new ResponseEntity<>(partyLeaderDTO, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/getAllLeaders")
	public ResponseEntity<List<PartyLeaderDTO>> getAllPartyLeader() {
		
		return new ResponseEntity<>(this.partyLeaderService.getAllLeaders(), HttpStatus.OK);
	}
}
