package com.pandora.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.pandora.objects.SongDetail;

/**
 * This class is used to create REST client request for Twitter based applications
 * 
 * @author wppu
 *
 */
public class TwitterRestService {

	/**
	 * This method is used to get the list of all mentions that needs on twitter for #NowPlaying
	 * 
	 * @return
	 */
	public List<SongDetail> getMentionsOfNowPlaying(){
		Properties prop = new Properties();
		String baseURL = prop.getProperty("pandora.twitter.hashtag.url");
		baseURL = baseURL+"?q="+prop.getProperty("pandora.twitter.hashtag.query")+"&result_type=mixed&count="+prop.getProperty("pandora.twitter.hashtag.count");
		String jsonData = RestClient.getOperation(baseURL);
		return songCountMapper(jsonData);
	}
	
	/**
	 * THis method is going to do the mapper based on Location/Count/Artist-Song
	 * 
	 * @return
	 */
	public List<SongDetail> songCountMapper(String jsonData){
		List<SongDetail> songDetailList = new ArrayList<SongDetail>();
		// *** Algorithm for retrieving the count from the JSON data ***//
		// Get the JSON data and parse the values for tag attribute 
		// Prepare a List holding the values for Song Name and no of times being played.
		// return list
		return songDetailList;
	}
}
