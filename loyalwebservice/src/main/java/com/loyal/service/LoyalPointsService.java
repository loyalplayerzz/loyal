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

import com.loyal.service.helper.LoyalPointsHelper;
import com.loyal.service.pojo.LoyalPoints;

@Path("/loyalpoints")
@Component
@Transactional
public class LoyalPointsService {
	
	@Autowired
	public LoyalPointsHelper loyalpointsHelper;

	public LoyalPointsHelper getLoyalPointsHelper() {
		return loyalpointsHelper;
	}

	public void setLoyalPointsHelper(LoyalPointsHelper loyalPointsHelper) {
		this.loyalpointsHelper = loyalPointsHelper;
	}

	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addNewLoyalPoint(LoyalPoints loyalPoints) {
		System.out.println("Loyal Points"+loyalPoints.getLoyalPoints());
		loyalpointsHelper.createLoyalPoints(loyalPoints);
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
	@Path("/retrieve/{loyalPointsID}")
	@Produces("application/json")
	public Response getLoyalPoints(@PathParam("loyalPointsID") String loyalPointsID) {
		LoyalPoints loyalPoints = loyalpointsHelper.retrieveLoyalPoint(Integer.valueOf(loyalPointsID));
		Map<String, Object> hsMap = new HashMap<String, Object>();
		hsMap.put("Status", "Success");
		hsMap.put("LoyalPoints", loyalPoints);
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
	public Response getAllLoyalPoints() {
		List<LoyalPoints> loyalPointsList = loyalpointsHelper.retrieveAllLoyalPoints();
		Map<String, Object> hsMap = new HashMap<String, Object>();
		hsMap.put("Status", "Success");
		hsMap.put("LoyalPoints", loyalPointsList);
		return Response.status(200).entity(hsMap).build();
	}

}
