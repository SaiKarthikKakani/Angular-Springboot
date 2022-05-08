package com.politicalparty.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class PartyDTO {

	private Long partyId;

	@NotNull
	@Size(min = 5, max = 100)
	private String partyName;

	@NotNull
	@Size(min = 5, max = 100)
	private String founderName;

	@Digits(integer = 4, fraction = 0)
	@Min(value = 1000)
	@Max(value = 9999)
	private int foundationYear;
}
