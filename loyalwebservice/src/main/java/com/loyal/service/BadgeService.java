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

import com.loyal.service.helper.BadgeHelper;
import com.loyal.service.pojo.Badge;

@Path("/badge")
@Component
@Transactional
public class BadgeService {
	
	@Autowired
	public BadgeHelper badgeHelper;

	public BadgeHelper getBadgeHelper() {
		return badgeHelper;
	}

	public void setBadgeHelper(BadgeHelper badgeHelper) {
		this.badgeHelper = badgeHelper;
	}

	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addNewBadge(Badge badge) {
		badgeHelper.createBadgeDetails(badge);
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
	@Path("/retrieve/{badgeName}")
	@Produces("application/json")
	public Response getLevel(@PathParam("badgeName") String badgeName) {
		Badge badge = badgeHelper.retrieveBadgeDetails(badgeName);
		Map<String, Object> hsMap = new HashMap<String, Object>();
		hsMap.put("Status", "Success");
		hsMap.put("Badge", badge);
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
		List<Badge> badgeList = badgeHelper.retrieveAllBadgeDetails();
		Map<String, Object> hsMap = new HashMap<String, Object>();
		hsMap.put("Status", "Success");
		hsMap.put("BadgeList", badgeList);
		return Response.status(200).entity(hsMap).build();
	}

}
