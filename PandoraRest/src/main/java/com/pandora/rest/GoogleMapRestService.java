package com.pandora.rest;

import java.util.Properties;

/**
 * This class is used for Google maps based REST client
 * 
 * @author wppu
 *
 */
public class GoogleMapRestService {
	
	/**
	 * This method is used to get Location based on Latitude
	 * 
	 * @param positionIndex
	 * @return
	 */
	public String getLocationByLatitude(String positionIndex){
		Properties prop = new Properties();
		String baseURL = prop.getProperty("pandora.googlemaps.url");
		baseURL = baseURL+"?bounds="+positionIndex+"&sensor=false&key="+prop.getProperty("pandora.googlemaps.apikey");
		String jsonData = RestClient.getOperation(baseURL);
		return geoCodeMapper(jsonData);
	}
	
	public String getCountyNameBasedOnGeoCode(String geoCode){
		//https://maps.googleapis.com/maps/api/geocode/json?address=Toledo&sensor=false&key=API_KEY
		Properties prop = new Properties();
		String baseURL = prop.getProperty("pandora.googlemaps.url");
		baseURL = baseURL+"?address="+geoCode+"&sensor=false&key="+prop.getProperty("pandora.googlemaps.apikey");
		String jsonData = RestClient.getOperation(baseURL);
		return geoCodeMapper(jsonData);
	}
	
	/**
	 * @return
	 */
	public String geoCodeMapper(String jsonData){
		String location = "";
		// Get the GEOCODE based on latitude
		// return map
		return location;
	}
	
	/**
	 * @return
	 */
	public String countyMapper(String jsonData){
		String county = "";
		// Get the County based on GeoCode
		// return map
		return county;
	}

}
