package com.trailrunnerassignment;

import java.text.DecimalFormat;

public class UserInfo {

	private float length;
	private float weight;
	private int age;

	private final RunSessionManager runSessionManager;
	private double fitnessScore;

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public UserInfo(float length, float weight, int age) {
		this.length = length;
		this.weight = weight;
		this.age = age;

		this.fitnessScore = 0;
		runSessionManager = new RunSessionManager();
	}

	public String getFitnessScore() {

		// If the user haven't run anything yet, their fitnessScore should return as
		// zero.
		if (runSessionManager.isHashMapEmpty()) {
			return "0.00";
		}

		fitnessScore = (fitnessScore
				+ (getLatestRunSession().getDistance()
						+ getLatestRunSession().getAverageSpeedPerHour()
								/ getLatestRunSession().getMinutesPerKilometer())
				- (daysSinceLastRun() / 2));

		fitnessScore = Math.max(fitnessScore, 0.00f);
		DecimalFormat decimalFormat = new DecimalFormat();
		decimalFormat.setMaximumFractionDigits(2);
		return decimalFormat.format(fitnessScore);
	}

	public int getRunSessionsAmount() {
		return 0;
	}

	public int daysSinceLastRun() {

		return runSessionManager.daysSinceLastRun();
	}

	private RunSession getLatestRunSession() {
		return runSessionManager.getLastestRunSession();
	}

	public void addRunSession(RunSession newRun) {
		runSessionManager.addRunSession(newRun);
	}

	public Float getTotalDistanceRun() {

		return runSessionManager.getTotalDistanceRun();
	}

	public Float getAverageDistanceOfRunSession() {
		return runSessionManager.getAverageDistanceOfRunSession();
	}
}
