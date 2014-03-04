package com.pandora.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pandora.mapper.LocationBasedDataMapper;
import com.pandora.objects.SongDetail;

@Path("/mashup")
@Component
public class PandoraService {
	
	@Autowired
	public LocationBasedDataMapper locationBasedDataMapper;

	public LocationBasedDataMapper getLocationBasedDataMapper() {
		return locationBasedDataMapper;
	}

	public void setLocationBasedDataMapper(
			LocationBasedDataMapper locationBasedDataMapper) {
		this.locationBasedDataMapper = locationBasedDataMapper;
	}

	/**
	 * This method is used to find best songs based on location
	 * 
	 * @param emailID
	 * @return
	 */
	@GET
	@Path("/retrieve/{location}")
	@Produces("application/json")
	public Response getLevel(@PathParam("location") String location) {
		List<SongDetail> songDetailList = locationBasedDataMapper.dataByPosition(location);
		Map<String, Object> hsMap = new HashMap<String, Object>();
		hsMap.put("Status", "Success");
		hsMap.put("SongDetails", songDetailList);
		return Response.status(200).entity(hsMap).build();
	}
	
	/**
	 * This method is used to retrieve the favorite songs based on city name
	 * 
	 * @param emailID
	 * @return
	 */
	@GET
	@Path("/retrieve/{city}")
	@Produces("application/json")
	public Response getAllLevels(@PathParam("city") String city) {
		List<SongDetail> songDetailList = locationBasedDataMapper.dataByCity(city);
		Map<String, Object> hsMap = new HashMap<String, Object>();
		hsMap.put("Status", "Success");
		hsMap.put("SongDetails", songDetailList);
		return Response.status(200).entity(hsMap).build();
	}

}
