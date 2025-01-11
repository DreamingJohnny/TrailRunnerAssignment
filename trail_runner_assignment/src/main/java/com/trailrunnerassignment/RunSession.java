package com.trailrunnerassignment;

import java.time.Duration;
import java.time.LocalDate;

public class RunSession {

	private float distance;

	private Duration time;

	private LocalDate date;

	// TODO: This needs to be unique in some way.
	private String id;

	// TODO: Will need at least two constructors, one for if you don't supply the
	// date

	public RunSession(LocalDate date, float distance, String id, int time) {
		this.date = date;
		this.distance = distance;
		this.id = id;
		this.time = Duration.ofSeconds(time);
	}

	//Constructor for when a run is created without a date being given. The date is then set to the current date.
	public RunSession(float distance, String id, int time) {
		this.date = LocalDate.now();

		this.distance = distance;
		this.id = id;
		this.time = Duration.ofSeconds(time);
	}

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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		//TODO: Add an overload here that takes a String and tries to format it as well.
		this.date = date;
	}

	public String getId() {
		return id;
	}

	//TODO: This function will need to be reworked so that the unique id is set some other way.
	public void setId(String id) {
		this.id = id;
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
		return 0.0f;
	}
}
