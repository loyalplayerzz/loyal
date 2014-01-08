package com.loyal.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.loyal.service.helper.AlgorithmHelper;
import com.loyal.service.pojo.AlgoTotalRoundsOnGame;
import com.loyal.service.pojo.AlgoTotalbetonprovider;
import com.loyal.service.pojo.Algorithm;

@Path("/algorithm")
@Component
@Transactional
public class AlgorithmService {
	
	@Autowired
	public AlgorithmHelper algoHelper;

	public AlgorithmHelper getAlgoHelper() {
		return algoHelper;
	}

	public void setAlgoHelper(AlgorithmHelper algoHelper) {
		this.algoHelper = algoHelper;
	}

	@POST
	@Path("/create/algoTotalBetOnProvider")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addParamAlgoTotalBetOnProvider(AlgoTotalbetonprovider totalBetOnProvider) {
		System.out.println("Total Bet On Provider ID "+totalBetOnProvider.getAlgoTotalBetOnProviderId());
		algoHelper.createTotalBetOnProviders(totalBetOnProvider);
		String s = "success";
		return Response.status(200).entity(s).build();
	}
	
	@POST
	@Path("/create/algoTotalRoundsOnGame")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addParamAlgoTotalRoundsOnGame(AlgoTotalRoundsOnGame totalRoundsOnGame) {
		System.out.println("Total Bet On Provider ID "+totalRoundsOnGame.getTotalRoundsOnGameId());
		algoHelper.createTotalRoundsOnGame(totalRoundsOnGame);
		String s = "success";
		return Response.status(200).entity(s).build();
	}


	/**
	 * This method is used to find ,if the email id provided during registration
	 * already exist in the database.
	 * 
	 * @param AlgorithmID
	 * @return
	 */
	@GET
	@Path("/retrieve/{algorithmID}")
	@Produces("application/json")
	public Response getAlgorithm(@PathParam("algorithmID") String algorithmID) {
		Algorithm algorithm = algoHelper.retrieveAlgorithmDetails(Integer.valueOf(algorithmID));
		Map<String, Object> hsMap = new HashMap<String, Object>();
		hsMap.put("Status", "Success");
		hsMap.put("Algorithm", algorithm);
		return Response.status(200).entity(hsMap).build();
	}
	
	/**
	 * This method is used to find ,if the email id provided during registration
	 * already exist in the database.
	 * 
	 * @param emailID
	 * @return
	 */
	@GET
	@Path("/retrieveAll")
	@Produces("application/json")
	public Response getAllAlgorithms() {
		List<Algorithm> algorithmList = algoHelper.retrieveAllAlgorithmDetails();
		Map<String, Object> hsMap = new HashMap<String, Object>();
		hsMap.put("Status", "Success");
		hsMap.put("Algorithm", algorithmList);
		return Response.status(200).entity(hsMap).build();
	}

}
