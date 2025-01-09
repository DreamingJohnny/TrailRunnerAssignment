package com.trailrunnerassignment;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RunSession {
	// TODO: This probably needs a constructor for converting meters and such back
	// and forth
	private float distance;
	// TODO: This should probably be replaced with some var that handles amount of
	// time.
	private Duration time;
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

	public String getTime() {

		return String.format("%d:%02d:%02d",
				time.toHours(),
				time.toMinutesPart(),
				time.toSecondsPart());
	}

	public void setTime(int _time) {
		this.time = Duration.ofSeconds(_time);
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

	public RunSession(String date, float distance, String id, int time) {
		this.date = date;
		this.distance = distance;
		this.id = id;
		this.time = Duration.ofSeconds(time);
	}

	public RunSession(float distance, String id, int time) {
		LocalDate tempDate = LocalDate.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		this.date = tempDate.format(myFormatObj);

		this.distance = distance;
		this.id = id;
		this.time = Duration.ofSeconds(time);
	}

	public String getAverageSpeedPerHour() {

		double hours = time.toSeconds() / 3600.0;

		double temp = distance / hours;

		String answer = String.format("%.2f", temp);
		return answer;
	}

	public String getMinutesPerKilometer() {
		double minutes = time.toSeconds() / 60.0;

		double temp = minutes / distance;

		String answer = String.format("%.2f", temp);
		return answer;
	}

	public float todaysDate() {
		return -1;
	}
}
