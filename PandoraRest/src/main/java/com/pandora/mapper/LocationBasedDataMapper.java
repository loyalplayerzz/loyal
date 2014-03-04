package com.pandora.mapper;

import java.util.ArrayList;
import java.util.List;

import com.pandora.objects.SongDetail;
import com.pandora.rest.GoogleMapRestService;
import com.pandora.rest.TwitterRestService;

/**
 * This method is used to map between the location and songs played that you received from Twitter
 * 
 * @author wppu
 *
 */
public class LocationBasedDataMapper {
	
	/**
	 * This method is used to get the list based on Position received
	 * 
	 * @return
	 */
	public List<SongDetail> dataByPosition(String positionIndex){
		//TODO change to Spring Bean
		GoogleMapRestService gmapService = new GoogleMapRestService();
		
		//TODO change to Spring Bean
		TwitterRestService twitterService = new TwitterRestService();
		
		List<SongDetail> locationSongDetail = new ArrayList<SongDetail>();
		
		String location = gmapService.getLocationByLatitude(positionIndex);
		for(SongDetail songDetail : twitterService.getMentionsOfNowPlaying()){
			if(gmapService.getCountyNameBasedOnGeoCode(location) !=null && gmapService.getCountyNameBasedOnGeoCode(location).equalsIgnoreCase(songDetail.getLocation()))
				locationSongDetail.add(songDetail);
		}
		return locationSongDetail;
	}
	
	/**
	 * This method is used to get the list based on city passed
	 * 
	 * @return
	 */
	public List<SongDetail> dataByCity(String cityName){
		
		//TODO change to Spring Bean
		GoogleMapRestService gmapService = new GoogleMapRestService();
		
		//TODO change to Spring Bean
		TwitterRestService twitterService = new TwitterRestService();
		
		List<SongDetail> locationSongDetail = new ArrayList<SongDetail>();
				
		for(SongDetail songDetail : twitterService.getMentionsOfNowPlaying()){
			if(gmapService.getCountyNameBasedOnGeoCode(cityName) !=null && gmapService.getCountyNameBasedOnGeoCode(cityName).equalsIgnoreCase(songDetail.getLocation()))
				locationSongDetail.add(songDetail);
		}
		
		return locationSongDetail;
	}

}
