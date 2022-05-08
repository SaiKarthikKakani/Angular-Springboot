package com.politicalparty.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Development {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long developmentId;
	private Long leaderId;
	private String developmentTitle;
	private String activity;
	private double budget;
	private String state;
	private int activityMonth;
	private int activityYear;
	
	
}
