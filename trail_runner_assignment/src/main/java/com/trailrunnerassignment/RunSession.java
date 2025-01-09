package com.trailrunnerassignment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RunSession {
	// TODO: This probably needs a constructor for converting meters and such back
	// and forth
	private float distance;
	// TODO: This should probably be replaced with some var that handles amount of
	// time.
	private float time;
	// TODO: This needs to be changed to be a var for handling dates, pretty sure
	// there is one of those already.
	private String date;

	// TODO: This needs to be unique in some way.
	private String id;

	// TODO: Will need at least two constructors, one for if you don't supply the
	// date

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public RunSession(String date, float distance, String id, float time) {
		this.date = date;
		this.distance = distance;
		this.id = id;
		this.time = time;
	}

	public RunSession(float distance, String id, float time) {
		LocalDate tempDate = LocalDate.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		this.date = tempDate.format(myFormatObj);

		this.distance = distance;
		this.id = id;
		this.time = time;
	}

	public float getAverageSpeedPerHour() {
		return -1;
	}

	public float getMinutesPerKilometer() {
		return -1;
	}

	public float todaysDate() {
		return -1;
	}

}
