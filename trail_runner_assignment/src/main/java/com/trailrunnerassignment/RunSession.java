package com.trailrunnerassignment;

public class RunSession {
	// TODO: This probably needs a constructor for converting meters and such back
	// and forth
	private float distance;
	// TODO: This should probably be replaced with some var that handles amount of
	// time.
	private float time;
	// TODO: This needs to be changed to be a var for handling dates, pretty sure
	// there is one of those already.
	private float date;
	// TODO: All of these will need getters and setters.

	//TODO: This needs to be unique in some way.
	private String id;

	// TODO: Will need at least two constructors, one for if you don't supply the
	// date
	
	//TODO: Add methods below for getting the various stats

    public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	public float getTime() {
		return time;
	}

	public void setTime(float time) {
		this.time = time;
	}

	public float getDate() {
		return date;
	}

	public void setDate(float date) {
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public RunSession(float date, float distance, String id, float time) {
        this.date = -1;
        this.distance = -1;
        this.id =null;
        this.time = -1;
    }

	public RunSession(float distance, String id, float time) {
        this.date = -1;
        this.distance = -1;
        this.id =null;
        this.time = -1;
    }

	public float getAverageSpeedPerHour()
	{
		return-1;
	}
	
	public float getMinutesPerKilometer()
	{
		return-1;
	}

	public float todaysDate()
	{
		return -1;
	}

}
