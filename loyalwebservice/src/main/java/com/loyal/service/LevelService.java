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

import com.loyal.service.helper.LevelHelper;
import com.loyal.service.pojo.Level;

@Path("/level")
@Component
@Transactional
public class LevelService {
	
	@Autowired
	public LevelHelper levelHelper;

	public LevelHelper getLevelHelper() {
		return levelHelper;
	}

	public void setLevelHelper(LevelHelper levelHelper) {
		this.levelHelper = levelHelper;
	}

	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addNewLevel(Level level) {
		System.out.println("Level ID "+level.getLevelID());
		levelHelper.createLevel(level);
		String s = "success";
		return Response.status(200).entity(s).build();
	}

	/**
	 * This method is used to find ,if the email id provided during registration
	 * already exist in the database.
	 * 
	 * @param emailID
	 * @return
	 */
	@GET
	@Path("/retrieve/{levelID}")
	@Produces("application/json")
	public Response getLevel(@PathParam("levelID") String levelID) {
		Level level = levelHelper.retrieveLevelDetails(Integer.valueOf(levelID));
		Map<String, Object> hsMap = new HashMap<String, Object>();
		hsMap.put("Status", "Success");
		hsMap.put("Level", level);
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
	public Response getAllLevels() {
		List<Level> levelList = levelHelper.retrieveAllLevels();
		Map<String, Object> hsMap = new HashMap<String, Object>();
		hsMap.put("Status", "Success");
		hsMap.put("Level", levelList);
		return Response.status(200).entity(hsMap).build();
	}

}
