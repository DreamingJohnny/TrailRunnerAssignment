package com.trailrunnerassignment;

import java.time.Duration;
import java.time.LocalDate;

public class RunSession {

	private float distance;

	private Duration time;

	private LocalDate date;

	private int id;

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
		this.date = date;
	}

	public int getId() {
		return id;
	}

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

		return temp;
	}

	public double getMinutesPerKilometer() {
		double minutes = time.toSeconds() / 60.0;

		double temp = minutes / distance;

		return temp;
	}

	public float todaysDate() {
		return 0.0f;
	}
}
