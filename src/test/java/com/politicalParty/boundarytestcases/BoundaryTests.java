package com.politicalParty.boundarytestcases;

import static org.junit.Assert.assertFalse;

import java.io.Serializable;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.politicalParty.testutilities.TestData;
import com.politicalparty.dto.DevelopmentDTO;
import com.politicalparty.dto.PartyDTO;
import com.politicalparty.dto.PartyLeaderDTO;

@SuppressWarnings("deprecation")
@ExtendWith(SpringExtension.class)
@RunWith(JUnitPlatform.class)
class BoundaryTests implements Serializable {

	private static final long serialVersionUID = -6544854658457780865L;
	
	private Validator validator;
	
	@BeforeEach
    public void setUp() {
    	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
	
	/**
	 * Validating the PartyDTO field constraints
	 */
	
	@Test
	void testPartyNameLength() {
		PartyDTO partyDTO = TestData.getPartyDTO();
		partyDTO.setPartyName("TDP");
		Set<ConstraintViolation<PartyDTO>> violations = validator.validate(partyDTO);
		
		assertFalse(violations.isEmpty());
	}
	
	@Test
	void testFounderNameLength() {
		PartyDTO partyDTO = TestData.getPartyDTO();
		partyDTO.setFounderName("NTR");
		Set<ConstraintViolation<PartyDTO>> violations = validator.validate(partyDTO);
		
		assertFalse(violations.isEmpty());
	}
	
	@Test
	void testFounderYearLength() {
		PartyDTO partyDTO = TestData.getPartyDTO();
		partyDTO.setFoundationYear(85);
		Set<ConstraintViolation<PartyDTO>> violations = validator.validate(partyDTO);
		
		assertFalse(violations.isEmpty());
	}
	
	/**
	 * Validate PartyLeaderDTO constraints
	 */
	
	@Test
	void testPartyIdLength() {
		PartyLeaderDTO partyLeaderDTO = TestData.getPartyLeaderDTO();
		partyLeaderDTO.setPartyId(null);
		Set<ConstraintViolation<PartyLeaderDTO>> violations = validator.validate(partyLeaderDTO);
		
		assertFalse(violations.isEmpty());
	}
	
	@Test
	void testLeaderNameLength() {
		PartyLeaderDTO partyLeaderDTO = TestData.getPartyLeaderDTO();
		partyLeaderDTO.setLeaderName("CBN");
		Set<ConstraintViolation<PartyLeaderDTO>> violations = validator.validate(partyLeaderDTO);
		
		assertFalse(violations.isEmpty());
	}
	
	@Test
	void testLeaderStateLength() {
		PartyLeaderDTO partyLeaderDTO = TestData.getPartyLeaderDTO();
		partyLeaderDTO.setLeaderState("AP");
		Set<ConstraintViolation<PartyLeaderDTO>> violations = validator.validate(partyLeaderDTO);
		
		assertFalse(violations.isEmpty());
	}
	
	/**
	 * Validate DevelopmentDTO constraints
	 */
	
	@Test
	void testLederIdLength() {
		DevelopmentDTO developmentDTO = TestData.getPartyLeaderDevelopmentDTO();
		developmentDTO.setLeaderId(null);
		Set<ConstraintViolation<DevelopmentDTO>> violations = validator.validate(developmentDTO);
		
		assertFalse(violations.isEmpty());
	}
	
	@Test
	void testDevelopmentTitleLength() {
		DevelopmentDTO developmentDTO = TestData.getPartyLeaderDevelopmentDTO();
		developmentDTO.setDevelopmentTitle("work");
		Set<ConstraintViolation<DevelopmentDTO>> violations = validator.validate(developmentDTO);
		
		assertFalse(violations.isEmpty());
	}
	
	@Test
	void testActivityLength() {
		DevelopmentDTO developmentDTO = TestData.getPartyLeaderDevelopmentDTO();
		developmentDTO.setActivity("work");
		Set<ConstraintViolation<DevelopmentDTO>> violations = validator.validate(developmentDTO);
		
		assertFalse(violations.isEmpty());
	}
	
	@Test
	void testBudgetLength() {
		DevelopmentDTO developmentDTO = TestData.getPartyLeaderDevelopmentDTO();
		developmentDTO.setBudget(100.1937283);
		Set<ConstraintViolation<DevelopmentDTO>> violations = validator.validate(developmentDTO);
		
		assertFalse(violations.isEmpty());
	}
	
	@Test
	void testStateLength() {
		DevelopmentDTO developmentDTO = TestData.getPartyLeaderDevelopmentDTO();
		developmentDTO.setState("AP");
		Set<ConstraintViolation<DevelopmentDTO>> violations = validator.validate(developmentDTO);
		
		assertFalse(violations.isEmpty());
	}
	
	@Test
	void testActivityMonth() {
		DevelopmentDTO developmentDTO = TestData.getPartyLeaderDevelopmentDTO();
		developmentDTO.setActivityMonth(0);
		Set<ConstraintViolation<DevelopmentDTO>> violations = validator.validate(developmentDTO);
		
		assertFalse(violations.isEmpty());
	}
	
	@Test
	void testActivityYear() {
		DevelopmentDTO developmentDTO = TestData.getPartyLeaderDevelopmentDTO();
		developmentDTO.setActivityYear(2019);
		Set<ConstraintViolation<DevelopmentDTO>> violations = validator.validate(developmentDTO);
		
		assertFalse(violations.isEmpty());
	}

}
