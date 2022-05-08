package com.politicalparty.utils;

import java.util.ArrayList;
import java.util.List;

import com.politicalparty.dto.DevelopmentDTO;
import com.politicalparty.dto.PartyDTO;
import com.politicalparty.dto.PartyLeaderDTO;
import com.politicalparty.model.Development;
import com.politicalparty.model.Party;
import com.politicalparty.model.PartyLeader;

public class PoliticalPartyUtility {
	
	private PoliticalPartyUtility() {
		
	}

	//=================================================================================================================================
	//				1. Party Conversion : Model to DTO - AND - DTO to Model
	//=================================================================================================================================
	public static Party convertToPartyDetails(PartyDTO partyDTO)	{
		
		Party newParty = new Party();

		newParty.setPartyId(partyDTO.getPartyId());
		newParty.setPartyName(partyDTO.getPartyName());
		newParty.setFounderName(partyDTO.getFounderName());
		newParty.setFoundationYear(partyDTO.getFoundationYear());

        return newParty;	
	}
	//---------------------------------------------------------------------------------------------------------------------------------
	public static PartyDTO convertToPartyDTO(Party party)	{
		
		PartyDTO newStock = new PartyDTO();

		newStock.setPartyId(party.getPartyId());
		newStock.setPartyName(party.getPartyName());
		newStock.setFounderName(party.getFounderName());
		newStock.setFoundationYear(party.getFoundationYear());

        return newStock;		
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------
    public static List<PartyDTO> convertToPartyDetailsDtoList(List<Party> partyDetailsList) {
    	
        List<PartyDTO> list = new ArrayList<>();
        
        for(Party eachParty : partyDetailsList) {
            list.add(convertToPartyDTO(eachParty));
        }
        
        return list;
    }
    
    public static PartyLeader convertToPartyLeaderDetails(PartyLeaderDTO partyLeaderDTO)	{
		
    	PartyLeader newParty = new PartyLeader();

    	newParty.setLeaderId(partyLeaderDTO.getLeaderId());
		newParty.setPartyId(partyLeaderDTO.getPartyId());
		newParty.setLeaderName(partyLeaderDTO.getLeaderName());
		newParty.setLeaderState(partyLeaderDTO.getLeaderState());

        return newParty;	
	}
	//---------------------------------------------------------------------------------------------------------------------------------
	public static PartyLeaderDTO convertToPartyLeaderDTO(PartyLeader partyLeader)	{
		
		PartyLeaderDTO newStock = new PartyLeaderDTO();

		newStock.setLeaderId(partyLeader.getLeaderId());
		newStock.setPartyId(partyLeader.getPartyId());
		newStock.setLeaderName(partyLeader.getLeaderName());
		newStock.setLeaderState(partyLeader.getLeaderState());

        return newStock;		
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------
    public static List<PartyLeaderDTO> convertToPartyLeaderDetailsDtoList(List<PartyLeader> partyLeaderDetailsList) {
    	
        List<PartyLeaderDTO> list = new ArrayList<>();
        
        for(PartyLeader eachPartyLeader : partyLeaderDetailsList) {
            list.add(convertToPartyLeaderDTO(eachPartyLeader));
        }
        
        return list;
    }
    
  //=================================================================================================================================
  	//				1. Party Conversion : Model to DTO - AND - DTO to Model
  	//=================================================================================================================================
  	public static Development convertToDevelopmentDetails(DevelopmentDTO developmentDTO)	{
  		
  		Development newDevelopment = new Development();

  		newDevelopment.setDevelopmentId(developmentDTO.getDevelopmentId());
  		newDevelopment.setLeaderId(developmentDTO.getLeaderId());
  		newDevelopment.setDevelopmentTitle(developmentDTO.getDevelopmentTitle());
  		newDevelopment.setActivity(developmentDTO.getActivity());
  		newDevelopment.setBudget(developmentDTO.getBudget());
  		newDevelopment.setState(developmentDTO.getState());
  		newDevelopment.setActivityMonth(developmentDTO.getActivityMonth());
  		newDevelopment.setActivityYear(developmentDTO.getActivityYear());

          return newDevelopment;
  	}
  	//---------------------------------------------------------------------------------------------------------------------------------
  	public static DevelopmentDTO convertToDevelopmentDTO(Development development)	{
  		
  		DevelopmentDTO newDevelopment = new DevelopmentDTO();

  		newDevelopment.setDevelopmentId(development.getDevelopmentId());
  		newDevelopment.setLeaderId(development.getLeaderId());
  		newDevelopment.setDevelopmentTitle(development.getDevelopmentTitle());
  		newDevelopment.setActivity(development.getActivity());
  		newDevelopment.setBudget(development.getBudget());
  		newDevelopment.setState(development.getState());
  		newDevelopment.setActivityMonth(development.getActivityMonth());
  		newDevelopment.setActivityYear(development.getActivityYear());

         return newDevelopment;		
  	}  	
  	//---------------------------------------------------------------------------------------------------------------------------------
      public static List<DevelopmentDTO> convertToDevelopmentDetailsDtoList(List<Development> developmentDetailsList) {
      	
          List<DevelopmentDTO> list = new ArrayList<>();
          
          for(Development eachDevelopment : developmentDetailsList) {
              list.add(convertToDevelopmentDTO(eachDevelopment));
          }
          
          return list;
      }
}