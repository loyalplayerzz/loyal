package com.pandora.objects;

public class SongDetail {
	
	private String songName;
	
	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getNoOfTimes() {
		return noOfTimes;
	}

	public void setNoOfTimes(String noOfTimes) {
		this.noOfTimes = noOfTimes;
	}

	private String artistName;
	
	private String location;
	
	private String noOfTimes;

}
