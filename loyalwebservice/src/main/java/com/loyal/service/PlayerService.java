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
import com.loyal.service.helper.PlayerHelper;
import com.loyal.service.pojo.AlgoTotalRoundsOnGame;
import com.loyal.service.pojo.AlgoTotalbetonprovider;
import com.loyal.service.pojo.Algorithm;
import com.loyal.service.pojo.Player;

@Path("/player")
@Component
@Transactional
public class PlayerService {
	
	@Autowired
	public PlayerHelper playerHelper;

	public PlayerHelper getPlayerHelper() {
		return playerHelper;
	}

	public void setPlayerHelper(PlayerHelper playerHelper) {
		this.playerHelper = playerHelper;
	}

	@POST
	@Path("/create/player")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPlayer(Player player) {
		playerHelper.createPlayer(player);
		String s = "success";
		return Response.status(200).entity(s).build();
	}
		
	/**
	 * input username, output player name, associated badges, level and loyalty points.  
     * Badges, Level, Loyalty Points should be returned with date and time when they were awarded.
	 * @param userID
	 * @return
	 */
	@GET
	@Path("/retrieve/{userID}")
	@Produces("application/json")
	public Response getUserDetails(@PathParam("userID") String userID) {
		Player player = playerHelper.getPlayerDetails(userID);
		Map<String, Object> hsMap = new HashMap<String, Object>();
		hsMap.put("Status", "Success");
		hsMap.put("Player", player);
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
	@Path("/retrieveAll/{limit}")
	@Produces("application/json")
	public Response getAllAlgorithms(@PathParam("userID")String limit) {
		List<Player> playerList = playerHelper.retrieveAllPlayers(Integer.valueOf(limit));
		Map<String, Object> hsMap = new HashMap<String, Object>();
		hsMap.put("Status", "Success");
		hsMap.put("Players", playerList);
		return Response.status(200).entity(hsMap).build();
	}

}
