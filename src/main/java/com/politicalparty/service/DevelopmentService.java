package com.politicalparty.service;

import java.util.List;

import com.politicalparty.dto.DevelopmentDTO;

public interface DevelopmentService {
	
	public DevelopmentDTO addDevelopment(DevelopmentDTO developmentDTO);
	public List<DevelopmentDTO> getDevelopmentByLeaderId(Long leaderId);
	public DevelopmentDTO updateDevelopment(DevelopmentDTO developmentDTO, Long leaderId);

}
