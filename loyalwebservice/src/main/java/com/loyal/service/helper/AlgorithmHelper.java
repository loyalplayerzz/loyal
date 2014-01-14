package com.loyal.service.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.loyal.persistence.dao.AlgoTotalbetonproviderDAO;
import com.loyal.persistence.dao.AlgoTotalroundsongameDAO;
import com.loyal.persistence.dao.AlgorithmMasterDAO;
import com.loyal.persistence.dto.AlgoTotalbetonproviderDTO;
import com.loyal.persistence.dto.AlgoTotalroundsongameDTO;
import com.loyal.persistence.dto.AlgorithmMasterDTO;
import com.loyal.service.pojo.AlgoTotalRoundsOnGame;
import com.loyal.service.pojo.AlgoTotalbetonprovider;
import com.loyal.service.pojo.Algorithm;

public class AlgorithmHelper {

	@Autowired
	public AlgorithmMasterDAO algorithmMasterDAO;
	
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

	public AlgorithmMasterDAO getAlgorithmMasterDAO() {
		return algorithmMasterDAO;
	}

	public void setAlgorithmMasterDAO(AlgorithmMasterDAO AlgorithmMasterDAO) {
		this.algorithmMasterDAO = AlgorithmMasterDAO;
	}

	public Algorithm retrieveAlgorithmDetails(Integer algorithmID){
		AlgorithmMasterDTO algorithmDTO = algorithmMasterDAO.findById(algorithmID);
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
		
		for(AlgorithmMasterDTO algoDTO : algorithmMasterDAO.findAll()){
			algorithmList.add(convertDTOToObject(algoDTO));
		} 
		return algorithmList;
	}
	
	public Algorithm convertDTOToObject(AlgorithmMasterDTO algorithmDTO){
		Algorithm algorithm = new Algorithm();
		algorithm.setAlgorithmDescription(algorithmDTO.getDescription());
		algorithm.setAlgorithmID(algorithmDTO.getId());
		algorithm.setAlgorithmMappingTable(algorithmDTO.getParamTable());
		return algorithm;
	}
	
	public AlgoTotalbetonproviderDTO convertObjToDTO(AlgoTotalbetonprovider algoTotalBetOnProvider){
		AlgoTotalbetonproviderDTO algoTotalBetOnProviderDTO = new AlgoTotalbetonproviderDTO();
		algoTotalBetOnProviderDTO.setBetAmount(algoTotalBetOnProvider.getBetAmt());
		algoTotalBetOnProviderDTO.setNoOfDays(algoTotalBetOnProvider.getNoOfDays());
		algoTotalBetOnProviderDTO.setProviders(algoTotalBetOnProviderDTO.getProviders());
		algoTotalBetOnProviderDTO.setId(algoTotalBetOnProviderDTO.getId());
		return algoTotalBetOnProviderDTO;
	}
	
	public AlgoTotalroundsongameDTO convertObjToDTO(AlgoTotalRoundsOnGame algoTotalRoundOnGame){
		AlgoTotalroundsongameDTO algoTotalRoundOnGameDTO = new AlgoTotalroundsongameDTO();
		//algoTotalRoundOnGameDTO.setBadgeId(algoTotalRoundOnGame.getTotalRoundsOnGameId());
		algoTotalRoundOnGameDTO.setNoOfGameRounds(algoTotalRoundOnGame.getNoOfRounds());
		algoTotalRoundOnGameDTO.setProviders(algoTotalRoundOnGame.getProviders());
	
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
