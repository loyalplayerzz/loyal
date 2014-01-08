package com.loyal.service.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.loyal.persistence.dao.AlgoTotalbetonproviderDAO;
import com.loyal.persistence.dao.AlgoTotalroundsongameDAO;
import com.loyal.persistence.dao.AlgorithmDAO;
import com.loyal.persistence.dto.AlgoTotalbetonproviderDTO;
import com.loyal.persistence.dto.AlgoTotalroundsongameDTO;
import com.loyal.persistence.dto.AlgorithmDTO;
import com.loyal.service.pojo.AlgoTotalRoundsOnGame;
import com.loyal.service.pojo.AlgoTotalbetonprovider;
import com.loyal.service.pojo.Algorithm;

public class AlgorithmHelper {

	@Autowired
	public AlgorithmDAO algorithmDAO;
	
	@Autowired
	public AlgoTotalbetonproviderDAO algoTotalbetonproviderDAO;
	
	@Autowired
	public AlgoTotalroundsongameDAO algoTotalRoundsOnGameDAO;

	public AlgoTotalroundsongameDAO getAlgoTotalRoundsOnGameDAO() {
		return algoTotalRoundsOnGameDAO;
	}

	public void setAlgoTotalRoundsOnGameDAO(
			AlgoTotalroundsongameDAO algoTotalRoundsOnGameDAO) {
		this.algoTotalRoundsOnGameDAO = algoTotalRoundsOnGameDAO;
	}

	public AlgoTotalbetonproviderDAO getAlgoTotalbetonproviderDAO() {
		return algoTotalbetonproviderDAO;
	}

	public void setAlgoTotalbetonproviderDAO(
			AlgoTotalbetonproviderDAO algoTotalbetonproviderDAO) {
		this.algoTotalbetonproviderDAO = algoTotalbetonproviderDAO;
	}

	public AlgorithmDAO getAlgorithmDAO() {
		return algorithmDAO;
	}

	public void setAlgorithmDAO(AlgorithmDAO algorithmDAO) {
		this.algorithmDAO = algorithmDAO;
	}

	public Algorithm retrieveAlgorithmDetails(Integer algorithmID){
		AlgorithmDTO algorithmDTO = algorithmDAO.findById(algorithmID);
		return convertDTOToObject(algorithmDTO);
		
	}
	
	public void createTotalBetOnProviders(AlgoTotalbetonprovider totalBetOnProvider){
		AlgoTotalbetonproviderDTO totalBetOnProviderDTO = null;
		totalBetOnProviderDTO = convertObjToDTO(totalBetOnProvider);
		algoTotalbetonproviderDAO.save(totalBetOnProviderDTO);
	}
	
	public void createTotalRoundsOnGame(AlgoTotalRoundsOnGame totalRoundOnGames){
		AlgoTotalroundsongameDTO totalRoundOnGamesDTO = null;
		totalRoundOnGamesDTO = convertObjToDTO(totalRoundOnGames);
		algoTotalRoundsOnGameDAO.save(totalRoundOnGamesDTO);
	}
	
	public List<Algorithm> retrieveAllAlgorithmDetails(){
		List<Algorithm> algorithmList = new ArrayList<Algorithm>();
		
		for(AlgorithmDTO algoDTO : algorithmDAO.findAll()){
			algorithmList.add(convertDTOToObject(algoDTO));
		} 
		return algorithmList;
	}
	
	public Algorithm convertDTOToObject(AlgorithmDTO algorithmDTO){
		Algorithm algorithm = new Algorithm();
		algorithm.setAlgorithmDescription(algorithmDTO.getDescription());
		algorithm.setAlgorithmID(algorithmDTO.getId());
		algorithm.setAlgorithmMappingTable(algorithmDTO.getParamTable());
		return algorithm;
	}
	
	public AlgoTotalbetonproviderDTO convertObjToDTO(AlgoTotalbetonprovider algoTotalBetOnProvider){
		AlgoTotalbetonproviderDTO algoTotalBetOnProviderDTO = new AlgoTotalbetonproviderDTO();
		algoTotalBetOnProviderDTO.setBetAmt(algoTotalBetOnProvider.getBetAmt());
		algoTotalBetOnProviderDTO.setNoOfDays(algoTotalBetOnProviderDTO.getNoOfDays());
		algoTotalBetOnProviderDTO.setProviderId(algoTotalBetOnProviderDTO.getProviderId());
		algoTotalBetOnProviderDTO.setId(algoTotalBetOnProviderDTO.getId());
		return algoTotalBetOnProviderDTO;
	}
	
	public AlgoTotalroundsongameDTO convertObjToDTO(AlgoTotalRoundsOnGame algoTotalRoundOnGame){
		AlgoTotalroundsongameDTO algoTotalRoundOnGameDTO = new AlgoTotalroundsongameDTO();
		algoTotalRoundOnGameDTO.setBadgeId(algoTotalRoundOnGame.getTotalRoundsOnGameId());
		algoTotalRoundOnGameDTO.setNameOfGames(algoTotalRoundOnGame.getNameOfGame());
		algoTotalRoundOnGameDTO.setNoOfRounds(algoTotalRoundOnGame.getNoOfRounds());
	
		return algoTotalRoundOnGameDTO;
	}
	
	public AlgoTotalbetonprovider convertDTOToObject(AlgoTotalbetonproviderDTO algoBetOnProviderDTO){
		AlgoTotalbetonprovider algoBetonProvider = new AlgoTotalbetonprovider();
		algoBetonProvider.setAlgoTotalBetOnProviderId(algoBetonProvider.getAlgoTotalBetOnProviderId());
		algoBetonProvider.setBetAmt(algoBetonProvider.getBetAmt());
		algoBetonProvider.setNoOfDays(algoBetonProvider.getNoOfDays());
		algoBetonProvider.setProviderId(algoBetonProvider.getProviderId());
		return algoBetonProvider;
	}


}
