package com.politicalparty.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class DevelopmentDTO {
	
	private Long developmentId;

	@NotNull
	private Long leaderId;
	
	@NotNull
	@Size(min = 5, max = 100)
	private String developmentTitle;
	
	@NotNull
	@Size(min = 5, max = 100)
	private String activity;
	
	@Digits(integer = 10, fraction = 2)
	private double budget;
	
	@NotNull
	@Size(min = 5, max = 50)
	private String state;
	
	@Max(value = 12)
	@Min(value = 1)
	private int activityMonth;
	
	@Min(value = 2020)
	@Max(value = 2040)
	private int activityYear;

}
