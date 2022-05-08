package com.politicalparty.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.politicalparty.dto.DevelopmentDTO;
import com.politicalparty.exception.NoDevelopmentFoundException;
import com.politicalparty.exception.NoPartyLeaderFoundException;
import com.politicalparty.model.Development;
import com.politicalparty.model.PartyLeader;
import com.politicalparty.repository.DevelopmentRepository;
import com.politicalparty.repository.PartyLeaderRepository;
import com.politicalparty.utils.PoliticalPartyUtility;

@Service
public class DevelopmentServiceImpl implements DevelopmentService {

	@Autowired
	private DevelopmentRepository developmentRepository;

	@Autowired
	private PartyLeaderRepository partyLeaderRepository;

	@Override
	public DevelopmentDTO addDevelopment(DevelopmentDTO developmentDTO) {
		PartyLeader partyLeaderInfo = this.partyLeaderRepository.findById(developmentDTO.getLeaderId())
				.orElseThrow(() -> new NoPartyLeaderFoundException("No Party Leader Found with leaderID: "
						+ developmentDTO.getLeaderId() + ". Hence add valid leaderId"));

		if (partyLeaderInfo != null)
			this.developmentRepository.save(PoliticalPartyUtility.convertToDevelopmentDetails(developmentDTO));

		return developmentDTO;
	}

	@Override
	public List<DevelopmentDTO> getDevelopmentByLeaderId(Long leaderId) {
		PartyLeader partyLeaderInfo = this.partyLeaderRepository.findById(leaderId)
				.orElseThrow(() -> new NoPartyLeaderFoundException("No Party Leader Found with leaderID: " + leaderId));

		List<Development> developmentInfoList = new ArrayList<>();

		if (partyLeaderInfo != null) {
			developmentInfoList = this.developmentRepository.findDevelopmentActivitiesByLeaderId(leaderId);
		}

		return PoliticalPartyUtility.convertToDevelopmentDetailsDtoList(developmentInfoList);
	}

	@Override
	public DevelopmentDTO updateDevelopment(DevelopmentDTO developmentDTO, Long leaderId) {
		List<DevelopmentDTO> allDevelopmentInfo = this.getDevelopmentByLeaderId(leaderId);

		Development developmentInfo = this.developmentRepository.findById(developmentDTO.getDevelopmentId())
				.orElseThrow(() -> new NoDevelopmentFoundException(
						"No Development found with the developmentId: " + developmentDTO.getDevelopmentId()));
		
		if(allDevelopmentInfo != null && developmentInfo != null) {
			this.developmentRepository.save(PoliticalPartyUtility.convertToDevelopmentDetails(developmentDTO));
		}
		
		return developmentDTO;
	}

}
