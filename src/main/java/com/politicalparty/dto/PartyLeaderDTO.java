package com.politicalparty.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class PartyLeaderDTO {
	
	private Long leaderId;

	@NotNull
	private Long partyId;
	
	@NotNull
	@Size(min = 5, max = 100)
	private String leaderName;
	
	@NotNull
	@Size(min = 5, max = 100)
	private String leaderState;	
}
