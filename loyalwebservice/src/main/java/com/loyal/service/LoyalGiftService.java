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

import com.loyal.service.helper.LoyalGiftsHelper;
import com.loyal.service.pojo.LoyalGifts;

@Path("/loyalgift")
@Component
@Transactional
public class LoyalGiftService {
	
	@Autowired
	public LoyalGiftsHelper loyalGiftHelper;

	public LoyalGiftsHelper getLoyalGiftHelper() {
		return loyalGiftHelper;
	}

	public void setLoyalGiftHelper(LoyalGiftsHelper loyalGiftHelper) {
		this.loyalGiftHelper = loyalGiftHelper;
	}

	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addNewLevel(LoyalGifts loyalGifts) {
		System.out.println("Loyal Gifts "+loyalGifts.getName());
		loyalGiftHelper.createLoyalGifts(loyalGifts);
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
	@Path("/retrieve/{name}")
	@Produces("application/json")
	public Response getLevel(@PathParam("name") String name) {
		LoyalGifts loyalGifts = loyalGiftHelper.retrieveLoyalGift(name);
		Map<String, Object> hsMap = new HashMap<String, Object>();
		hsMap.put("Status", "Success");
		hsMap.put("LoyalGifts", loyalGifts);
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
		List<LoyalGifts> loyalGiftList = loyalGiftHelper.retrieveAllLoyalGifts();
		Map<String, Object> hsMap = new HashMap<String, Object>();
		hsMap.put("Status", "Success");
		hsMap.put("Level", loyalGiftList);
		return Response.status(200).entity(hsMap).build();
	}

}
