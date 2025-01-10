package com.trailrunnerassignment;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class UserInfo {

	private float length;
	private float weight;
	private int age;
	private ArrayList<RunSession> runList = new ArrayList<>();

	private float fitnessScore;

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
		runList = new ArrayList<>();
	}

	public String getFitnessScore() {

		// If the user haven't run anything yet, their fitnessScore should return as
		// zero.
		if (runList.isEmpty()) {
			return "0";
		}

		fitnessScore = (fitnessScore
				+ (getLatestRunSession().getDistance()
						+ Float.parseFloat(getLatestRunSession().getAverageSpeedPerHour())
								/ Float.parseFloat(getLatestRunSession().getMinutesPerKilometer()))
				- (daysSinceLastRun() / 2));

		DecimalFormat decimalFormat = new DecimalFormat();
		decimalFormat.setMaximumFractionDigits(2);
		return decimalFormat.format(fitnessScore);
	}

	public int getRunSessionsAmount() {
		return 0;
	}

	public int daysSinceLastRun() {

		// If user doesn't have any runSessions saved, this function returns zero
		if (runList.isEmpty()) {
			return 0;
		}

		// TODO: Look into moving this code to other function.
		LocalDate today = LocalDate.now();
		long smallestDifference = Long.MAX_VALUE;

		for (RunSession runSession : runList) {

			if (smallestDifference >= Math.abs(ChronoUnit.DAYS.between(runSession.getDate(), today))) {
				smallestDifference = Math.abs(ChronoUnit.DAYS.between(runSession.getDate(), today));
			}
		}

		// Possible loss in casting here, might want to make not of it for later.
		return Math.toIntExact(smallestDifference);
	}

	private RunSession getLatestRunSession() {
		// If user doesn't have any runSessions saved, this function returns zero
		if (runList.isEmpty()) {
			return null;
		}

		RunSession temp = null;
		// TODO: Look into moving this code to other function.
		LocalDate today = LocalDate.now();
		long smallestDifference = Long.MAX_VALUE;

		for (RunSession runSession : runList) {

			if (smallestDifference >= Math.abs(ChronoUnit.DAYS.between(runSession.getDate(), today))) {
				smallestDifference = Math.abs(ChronoUnit.DAYS.between(runSession.getDate(), today));
				temp = runSession;
			}
		}

		// Possible loss in casting here, might want to make not of it for later.
		return temp;
	}

	public void addRunSession(RunSession newRun) {
		runList.add(newRun);

		// TODO: Display the fitness score
	}

}
