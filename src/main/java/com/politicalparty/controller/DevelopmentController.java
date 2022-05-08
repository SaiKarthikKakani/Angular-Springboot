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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.politicalparty.dto.DevelopmentDTO;
import com.politicalparty.exception.InvalidDevelopmentException;
import com.politicalparty.exception.NoDevelopmentFoundException;
import com.politicalparty.service.DevelopmentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/politics/api/v1/development")
public class DevelopmentController {

	@Autowired
	private DevelopmentService developmentService;

	@PostMapping(value = "/add-development")
	public ResponseEntity<DevelopmentDTO> addDevelopment(@Valid @RequestBody DevelopmentDTO developmentDTO,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			throw new InvalidDevelopmentException("Invalid Development Request");
		} else {
			return new ResponseEntity<>(this.developmentService.addDevelopment(developmentDTO), HttpStatus.OK);
		}
	}

	@GetMapping(value = "get-development-by-leader/{leaderId}")
	public ResponseEntity<List<DevelopmentDTO>> getDevelopmentByLeader(@PathVariable("leaderId") Long leaderId) {
		
		List<DevelopmentDTO> developmentDTO = this.developmentService.getDevelopmentByLeaderId(leaderId);
		
		if(developmentDTO == null)
			throw new NoDevelopmentFoundException("No Development Activities found");

		return new ResponseEntity<>(this.developmentService.getDevelopmentByLeaderId(leaderId), HttpStatus.OK);
	}

	@PutMapping(value = "/update-development/{leaderId}")
	public ResponseEntity<DevelopmentDTO> updateDevelopment(@Valid @RequestBody DevelopmentDTO developmentDTO,
			@PathVariable("leaderId") Long leaderId, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			throw new InvalidDevelopmentException("Invalid Development Request");
		} else {
			return new ResponseEntity<>(this.developmentService.updateDevelopment(developmentDTO, leaderId), HttpStatus.OK);
		}

	}

}
