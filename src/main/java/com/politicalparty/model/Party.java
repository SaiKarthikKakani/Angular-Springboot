package com.politicalparty.model;

import javax.persistence.Column;
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
public class Party {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "partyId")
	private Long partyId;
	private String partyName;	
	private String founderName;	
	private int foundationYear;	
}
