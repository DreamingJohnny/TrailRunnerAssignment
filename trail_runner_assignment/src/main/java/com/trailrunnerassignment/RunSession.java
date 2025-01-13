package com.trailrunnerassignment;

import java.time.Duration;
import java.time.LocalDate;

public class RunSession {
	// TODO: This probably needs a constructor for converting meters and such back
	// and forth
	private float distance;
	// TODO: This should probably be replaced with some var that handles amount of
	// time.
	private Duration time;
	// TODO: This needs to be changed to be a var for handling dates, pretty sure
	// there is one of those already.
	private LocalDate date;

	// TODO: This needs to be unique in some way.
	private int id;

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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		//TODO: Add an overload here that takes a String and tries to format it as well.
		this.date = date;
	}

	public int getId() {
		return id;
	}

	//TODO: This function will need to be reworked so that the unique id is set some other way.
	public void setId(int id) {
		this.id = id;
	}

	public RunSession(LocalDate date, float distance,int time) {
		this.date = date;
		this.distance = distance;
		this.time = Duration.ofSeconds(time);

	}

	public RunSession(float distance,int time) {
		this.date = LocalDate.now();

		this.distance = distance;
		this.time = Duration.ofSeconds(time);
	}

	public double getAverageSpeedPerHour() {

		double hours = time.toSeconds() / 3600.0;

		double temp = distance / hours;

		//String answer = String.format("%.2f", temp);
		return temp;
	}

	public double getMinutesPerKilometer() {
		double minutes = time.toSeconds() / 60.0;

		double temp = minutes / distance;

		//String answer = String.format("%.2f", temp);
		return temp;
	}

	public float todaysDate() {
		return 0.0f;
	}
}
